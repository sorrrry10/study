<template>
  <div class="List">
    <div class="user_infor" v-for="user in users" :key="user.id">
      <a :href="user.html_url"
        ><img :src="user.avatar_url" alt="" class="touxiang" />
        <h3 class="user_name">{{ user.login }}</h3></a
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "List",
  props: ["users"],
};
</script>

<style>
a {
  color: black;
  text-decoration: none;
}
.List {
  margin: 35px auto;
  width: 900px;
  /* background-color: aqua; */
}
.user_infor {
  width: 300px;
  height: 200px;
  margin-left: -1px;
  margin-top: 10px;

  border: 1px solid rgb(207, 207, 207);
  float: left;
}
.touxiang {
  width: 150px;
  height: 150px;
  margin-left: 75px;
  margin-top: 10px;
}
.user_name {
  font-size: 15px;
  font-weight: 400;
  text-align: center;
}
</style>