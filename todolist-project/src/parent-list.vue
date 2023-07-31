<style>
.background{
  background-color: #E8F5FF;
  text-align: center;
}

</style>

<template>
<div class="background">
  <h1 v-on:click="listselect()">Todo it!</h1>
  <input-list @addTodoList="addList"></input-list>
  <child-list v-for="(todo , index) in todos"  :key="todo.id"  :todo="todo" :index="index" @deleteTodoList="deleteList" @checkedTodoList="checkedList"></child-list>
  <remove-list @removeTodoList="removeList"></remove-list>
</div>
</template>

<script>
import childList from "./components/child-list.vue";
import inputList from "./components/input-list.vue";
import removeList from "./components/remove-list.vue";

export default {
  name: "todoAPP",
  components: {
    childList,
    inputList,
    removeList
  },
  data() {
     return {
    work:'',
    // todos: [{ content: "list1" }, { content: "list2" }, { content: "list3" }],
    todos: [],
    styleObject: {
      'content-decoration':'line-through'
      }

    }
  },
  created () { 

        //api용 get 함수
    //     this.axios.get('/api/parent_list')
    //     .then((response) => {
    //       this.todos = response.data;
    //       console.log(response);
    //     }).catch(err => alert(err))
    // .finally(() => {
    //       console.log("/api/parent_list 실행");
    //     }); 

// api용 post 함수
        this.axios({
          method: 'post',
          url: '/api/parent_list',
          data: {
            // "todo_seq":this.todo_seq,
            // "content":content
          }
        })
        .then((response) => {
          for(var i= 0; i<response.data.length; i++){
              this.todos.push(response.data[i]);
          }
          // // this.todos = response.data;
          console.log(response.data);
        }).catch(err => alert(err))
    .finally(() => {
          console.log("/api/parent_list 실행");
        }); 



  },
  methods : {
        listselect(){
        this.axios({
          method: 'post',
          url: '/api/parent_list',
          data: {
            // "todo_seq":this.todo_seq,
            // "content":content
          }
        })
        .then((response) => {
          for(var i= 0; i<response.data.length; i++){
              this.todos.push(response.data[i]);
          }
          // // this.todos = response.data;
          console.log(response.data);
        }).catch(err => alert(err))
    .finally(() => {
          console.log("/api/parent_list 실행");
        }); 

        },
        addList(todo){
          if(todo.todo_seq != 0){
            alert('등록하였습니다'); 
            this.todos.push(todo);
          }else{
            alert('저장에 실패하였습니다');
          }
          console.log(this.todos)
        },
        deleteList( index){
          console.log(index);
          this.todos.splice(index,1);
          // this.$delete(this.todos, index); //동작안함
        },
        checkedList( todo , index){
          console.log("todo" , todo.checked);
          console.log("index" , index);
          if(todo.todo_seq != 0){
          this.todos[index].checked = todo.checked;
          }else{
            alert('수정에 실패하였습니다');
          }
        },
        removeList(todo){
            // this.todos.splice(0,this.todos.length);

            //api용 get 함수
            this.todos = todo;
        }
  }
};
</script>
