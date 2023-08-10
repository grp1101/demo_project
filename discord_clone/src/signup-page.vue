<template>
<div>
    <h2>회원가입</h2>
        <div>
            <input type="text" v-model="id" placeholder="id"/>
        </div>
        <div>
            <input type="text" v-model="username" placeholder="*Username"/>
        </div>
        <div>
            <input type="text" v-model="email" placeholder="*Email"/>
        </div>
        <div>
            <input type="password" v-model="password" placeholder="Password"/>
        </div>
        <div>
            <input type="text" v-model="address"  placeholder="Address"/>
        </div>
        <div>
            <input type="text" v-model="phone" placeholder="Phone"/>
        </div>
        <!-- <div>
            <input type="text" v-model="website" placeholder="Website"/>
        </div>
        <div>
            <input type="text" v-model="company" placeholder="Company"/>
        </div> -->

        <button type="button" v-on:click="sign_up_input()">회원가입</button>

</div>
</template>

<script>

export default {
  name: 'signUp',
  components: {
  },
    data() {
     return {
      id:'',
      username:'',
      email:'',
      password:'',
      address:'',
      phone:'',
      website:'',
      company:'',

    }
  },
  methods: {
    sign_up_input(){

        // api용 post 함수
          this.axios({
          method: 'post',
          url: '/api/signup',
          data: {
            "id":this.id,
            "username":this.username,
            "email":this.email,
            "password":this.password,
            "address":this.address,
            "phone":this.phone
          }
  }, { withCredentials : true })
        .then((response) => {
          console.log("response.data = " , response.data);
        //   this.$emit("addTodoList", response.data);
        //   this.content='';


        //not_sec용
        if(response.data == 1){
          this.$router.push('/');
        }
        }).catch(err => alert(err))
        .finally(() => {
          console.log("/api/signup 실행");
        }); 

    },
}
}
</script>

<style>

</style>