<style>
#childTodoList {
  width: 500px;
  margin: auto;
  border-radius: 5px;
  background-color: aliceblue;
  margin-bottom: 10px; 
}

.listBox {
  background: white;
  height: 30px;
  line-height: 30px;
  border-radius: 5px;
}
.listBox input {
  border-style: none;
  font-size: 0.9rem;
  float: left;
}

.removeBtn {
  margin-left: auto;
  /* color: #de4343; */
     color:#1E90FF;
     float: right;
}
</style>



<template>
  <div id="childTodoList">
    <!-- <div>        
      <ul id="TodoList">
      <li v-for="(todo , index) in todos" v-bind:key="index" >

        <input type="checkbox" v-model="checked" @click="childCheckedList(checked , index)"/>
 
        <span :style="checkedObject">{{ todo.content }}</span>

        <button v-on:click="childDeleteList(index)">X</button>
      </li> 
    </ul>
    </div>  -->

    <div  class="listBox">        
        <!-- 체크박스 -->
        <input type="checkbox" :checked ="this.todo.checked" @click="childCheckedList(todo.todo_seq , todo.content , todo.checked , index)"/>
        <!-- <span class="checkBtn material-icons" type="checkbox" v-model="checked" @click="childCheckedList(checked , index)"/> -->
        <!-- 내용 -->
        <!-- 1번 방법 -->
        <span :style=" checkedObject">{{ todo.content }}</span>

        <!-- 2번 방법 -->
        <!-- 조회 시 삼항연산자로 수정가능해 지지만 반대로 체크할때 ,  클래스 바인딩을 못해주게됨 -->
        <!-- <span ref="todoContent" :style="todo.checked == 1 ? checkedObject :uncheckedObject ">{{ todo.content }}</span> -->

        <!-- 3번 방법 -->
        <!-- 안먹힘... -->
        <!-- <span :style=" { checkedObject : todo.checked === 1 ,  uncheckedObject : todo.checked === 0} ">{{ todo.content }}</span> -->


        <!-- 삭제버튼 -->
        <span class="removeBtn" v-on:click="childDeleteList(todo.todo_seq , todo.content , index)"><i class="checkBtn material-icons" >delete</i></span>
    </div> 

  </div>
</template>

<script>
export default {
  name: "todoAPP",
  props : {
        todo : Object,
        index: Number
    },
  data() {
     return {
          checked:0,
          checkedObject: {
              textDecorationLine:'none',
              color: 'black',
          }

    }
  },
  mounted() {
    if(this.todo.checked === 1){
        this.checkedObject.textDecorationLine = 'line-through';
        this.checkedObject.color = "#b3adad";
      }else{
        this.checkedObject.textDecorationLine = 'none';
        this.checkedObject.color = 'black';
      }
  },
  // // 방법2 : todo 데이터 변경을 감지
  // beforeUpdate() { 
  //   console.log("beforeUpdate index : ", this.index);
  //   console.log("beforeUpdate checkedObject : ", this.checkedObject);
    
  //   if(this.todo.checked === 1){
  //             this.checkedObject.textDecorationLine = 'line-through';
  //             this.checkedObject.color = "#b3adad";
  //   }else{
  //             this.checkedObject.textDecorationLine = 'none';
  //             this.checkedObject.color = 'black';
  //   }
  // },
  // // 방법2 : todo 데이터 변경을 감지
  // updated() { 
  //   console.log("updateed index : ", this.index);
  //   console.log("updateed checkedObject : ", this.checkedObject);
    
  //   // if(this.todo.checked === 1){
  //   //           this.checkedObject.textDecorationLine = 'line-through';
  //   //           this.checkedObject.color = "#b3adad";
  //   // }else{
  //   //           this.checkedObject.textDecorationLine = 'none';
  //   //           this.checkedObject.color = 'black';
  //   // }
  // },

  // Destrucion
  beforeUnmount(){
      console.log("beforeUnmount index : ", this.index);
      console.log("beforeUnmount checkedObject : ", this.checkedObject);
  },  
  unmounted(){
      console.log("unmounted index : ", this.index);
      console.log("unmounted checkedObject : ", this.checkedObject);
  } ,  
  // 방법3 : todo 데이터 변경을 감지
  // watch: {
  //   todo(){
  //     if(this.todo.checked === 1){
  //       this.checkedObject.textDecorationLine = 'line-through';
  //       this.checkedObject.color = "#b3adad";
  //     }else{
  //       this.checkedObject.textDecorationLine = 'none';
  //       this.checkedObject.color = 'black';
  //     }
  //   }
  // },
  methods : {
        childDeleteList(todo_seq , content ,index){
          // console.log(index);
          // this.$emit("deleteTodoList", index);

        // api용 get 함수
        // this.axios({
        //   method: 'get',
        //   url: '/api/child_list_delete',
        //   params: {
        //     "work":work,
        //     "index" : index
        //   }})
        // .then((response) => {
        //   console.log(response);
        //   this.$emit("deleteTodoList", response.data.index , response.data.work);

        // }).catch(err => alert(err))
        // .finally(() => {
        //   console.log("/api/child_list_delete 실행");
        // }); 


        // api용 post 함수
        this.axios({
          method: 'post',
          url: '/api/child_list_delete',
          data: {
            "content":content,
            "todo_seq":todo_seq,
            "index":index
          }})
        .then((response) => {
          console.log(response.data);
          // this.$emit("deleteTodoList",  response.data[1].index ); //node.js 용
          this.$emit("deleteTodoList",  response.data[0].index );

        }).catch(err => alert(err))
        .finally(() => {
          console.log("/api/child_list_delete 실행");
        }); 


        },
        childCheckedList( todo_seq , content , checked ,index){
          // chekced값이 변경되기 이전값을 바인딩해서 가져오는 것 같음

          // console.log("todoContent =" , this.$refs.todoContent.style);

            if(checked === 0){
              checked = 1;
              // $("#todo_content").css("style", this.checkedObject);
              // this.$refs.todoContent.style.cssText = this.checkedObject;
              this.checkedObject.textDecorationLine = 'line-through';
              this.checkedObject.color = '#b3adad';
            }else if(checked === 1){
              checked = 0;
              // this.$id.todoContent.style = this.uncheckedObject;
              this.checkedObject.textDecorationLine = 'none';
              this.checkedObject.color = 'black';
            }

        // api용 get 함수
        // this.axios({
        //   method: 'get',
        //   url: '/api/child_list_checked',
        //   params: {
        //     "checked":checked
        //   }})
        // .then((response) => {
        //   console.log(response);

        // }).catch(err => alert(err))
        // .finally(() => {
        //   console.log("/api/child_list_delete 실행");
        // }); 

          // api용 post 함수
                this.axios({
          method: 'post',
          url: '/api/child_list_checked',
          data: {
            "todo_seq" : todo_seq,
            "content" : content,
            "checked":checked,
            "index" :index
          }})
        .then((response) => {
          console.log("response.data",response.data);
          // this.$emit("checkedTodoList",  response.data[0] , response.data[1].index ); //node.js 용
          this.$emit("checkedTodoList",  response.data , response.data.index );

        }).catch(err => alert(err))
        .finally(() => {
          console.log("/api/child_list_checked 실행");
        }); 



        //data로 선언해서 변수 삽입하면 body로 
        //params로 선언해서 변수 삽입하면 query로 

        }
  }
};
</script>