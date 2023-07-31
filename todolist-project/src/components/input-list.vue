<style>
#childinputList {
  width: 500px;
  margin: auto;
  border-radius: 5px;
  background-color: aliceblue; 
  padding: auto;
  margin-bottom: 10px;
}
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 30px;
  line-height: 30px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #62EAC6, #32CEE6);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>

<template>
<div id="childinputList">
  <div class="inputBox shadow">
    <input type="text" v-model="content" />
    <span class="addContainer" type="button" v-on:click="childAddList(content)"><i class="material-icons addBtn">+</i></span>
  </div>
</div>

</template>

<script>
import {router}  from '../routes/index.js'



export default {
  name: "todoAPP",
  props : {

    },
  router,
  data() {
     return {
      content:'',
      todo_seq:''

    }
  },
  methods : {
        childAddList(content){
          // this.$emit("addTodoList", work);
          // this.work='';


        // api용 get 함수
  //       this.axios({
  //         method: 'get',
  //         url: '/api/input_list',
  //         params: {
  //           "work":work
  //         }
  // }, { withCredentials : true })
  //       .then((response) => {
  //         this.$emit("addTodoList", response.data);
  //         console.log(response)
  //         this.work='';
  //       }).catch(err => alert(err))
  //       .finally(() => {
  //         console.log("/api/input_list 실행");
  //       }); 


// api용 post 함수
                this.axios({
          method: 'post',
          url: '/api/input_list',
          data: {
            "todo_seq":this.todo_seq,
            "content":content,
            "checked":0
          }
  }, { withCredentials : true })
        .then((response) => {
          console.log("response.data = " , response.data);
          this.$emit("addTodoList", response.data);
          this.content='';
        }).catch(err => alert(err))
        .finally(() => {
          console.log("/api/input_list 실행");
        }); 

        }
  }
};
</script>