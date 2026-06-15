<template>
  <div class="search">
    <div class="search_box">
      <input
        ref="search_text"
        type="text"
        name=""
        id=""
        class="search_text"
        placeholder="Search for user"
        v-model="searchText"
        @keydown="KeysearchBtn"
      />
      <button class="search_btn" @click="searchBtn">搜索</button>
      <div class="clear"></div>
      <transition-group name="search_title_active" appear>
        <h3
          v-if="users.length == 0 && isLoading == false && isError == false"
          class="search_news"
          key="1"
        >
          Welcome to search
        </h3>
        <h3
          v-if="users.length != 0 && isLoading == false && isError == false"
          class="search_news"
          key="2"
        >
          search is success
        </h3>

        <h3 v-if="isError == true" class="search_news_error" key="3">
          is a Error!!!
          <span class="error_text">{{ errorText }}</span>
        </h3>
      </transition-group>
      <h3 v-if="isLoading == true" class="search_news_loading">
        is Loading...
      </h3>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Search",
  props: ["users"],
  data() {
    return {
      searchText: "",
      isLoading: false,
      isError: false,
      errorText: "",
    };
  },
  mounted() {
    this.$refs.search_text.focus();
  },
  watch: {
    users() {
      this.isLoading = false;
    },
  },
  methods: {
    KeysearchBtn(e) {
      if (e.key == "Enter") {
        this.searchBtn();
      }
    },
    searchBtn() {
      this.isLoading = true;
      this.isError = false;
      axios({
        url: `https://api.github.com/search/users?q=${this.searchText}`,
      }).then(
        (result) => {
          this.$bus.$emit("changeUsers", result.data.items);
        },
        (error) => {
          this.$bus.$emit("changeUsers", []);
          console.log("@", error.message);
          this.isError = true;
          this.errorText = error.message;
        }
      );
    },
  },
};
</script>

<style>
.search_box {
  width: 500px;
  height: 40px;
  border-radius: 10px;
  border: 1px solid #d8d8d8;
  box-shadow: 0px 0px 3px 1px #d8d8d8;
  margin: 0px auto;
  margin-top: 50px;
}
.search_text {
  float: left;
  width: 452px;
  height: 38px;
  border-radius: 10px;
  border: none;
  outline: none;
  text-indent: 5px;
}
.error_text {
  float: right;
}
.search_box:focus-within {
  box-shadow: 0px 0px 3px 1px #898989;
}
.search_btn {
  height: 40px;
  width: 45px;
  border: #b8b8b8;
  border-radius: 10px;
  background-color: #b8b8b8;
  box-shadow: 0px 0px 3px 1px #b8b8b8;
  float: right;
  margin-top: -1px;
  transition: all 0.3s;
  color: rgb(237, 237, 237);
}
.search_btn:hover {
  background-color: #7c7c7c;
  color: rgb(255, 255, 255);
}
.clear {
  clear: both;
}
.search_title_active-enter-active {
  animation: search_title1 1s;
}

@keyframes search_title1 {
  from {
    transform: translateX(-600px);
    opacity: 0;
  }
  to {
    transform: translateX(0px);
    opacity: 1;
  }
}

.search_news_loading {
  color: rgb(83, 175, 255);
}
.search_news_error {
  color: rgb(147, 0, 0);
}
</style>