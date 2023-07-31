<style scoped>
.clearAllContainer {
  width: 8.5rem;
  height: 30px;
  line-height: 30px;
  background-color: white;
  border-radius: 5px;
  margin: 0 auto;
}
.clearAllBtn {
  color: #e20303;
  display: block;
}
</style>

<template>
  <div class="clearAllContainer">
    <span class="clearAllBtn"  type="button" v-on:click="childRemoveList()">Clear All</span>
  </div>

</template>

<script>
export default {
  name: "todoAPP",
  props : {

    },
  data() {
     return {

    }
  },
  methods : {
        childRemoveList(){

          // this.$emit("removeTodoList");

//api용 get 함수
        // this.axios.get('/api/remove_list')
        // .then((response) => {
        //   this.$emit("removeTodoList", response.data);
        //   console.log(response);
        // }).catch(err => alert(err))
        // .finally(() => {
        //   console.log("/api/remove_list 실행");
        // }); 


// api용 post 함수
        this.axios({
          method: 'post',
          url: '/api/remove_list',
          data: {
            // "todo_seq":this.todo_seq,
            // "content":content
          }
        })
        .then((response) => {
          this.$emit("removeTodoList", response.data);
          console.log(response.data);
        }).catch(err => alert(err))
        .finally(() => {
          console.log("/api/remove_list 실행");
        }); 

        }
  }
};
</script>