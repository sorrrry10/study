<template>
  <div class="search_user">
    <Search :users="users"></Search>
    <List :users="users"></List>
    <div class="clear"></div>
    <div class="bottom"></div>
  </div>
</template>

<script>
import List from "./components/List.vue";
import Search from "./components/Search.vue";
export default {
  name: "App",
  data() {
    return {
      users: [],
    };
  },
  components: {
    Search,
    List,
  },
  mounted() {
    this.$bus.$on("changeUsers", this.changeUsers);
  },
  methods: {
    changeUsers(value) {
      this.users = value;
    },
  },
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.bottom {
  height: 200px;
  background-color: rgb(225, 225, 225);
  margin-top: 10px;
}
</style>