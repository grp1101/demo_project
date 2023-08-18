<template>
<div>
    <h2>회원가입</h2>
        <div>
            <input type="text" v-model="id" placeholder="id"/>
        </div>
        <div>
            <input type="text" v-model="username" placeholder="* Username"/>
        </div>
        <div>
            <input type="text" v-model="email" placeholder="* Email"/>
        </div>
        <div>
            <input type="password" v-model="password" placeholder="* Password"/>
        </div>
        <div>
            <input type="text" v-model="address"  placeholder="Address"/>
        </div>
        <div>
            <input type="text" v-model="phone" placeholder="Phone"/>
        </div>
        <div>
            <input type="text" v-model="website" placeholder="Website"/>
        </div>
        <div>
            <input type="text" v-model="company" placeholder="Company"/>
        </div>

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

if(this.username == '' || this.email == '' || this.password == ''){
alert("필수항목을 입력하세요");
return;
}


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
            "phone":this.phone,
            "website":this.website,
            "company":this.company,
          }
  }, { withCredentials : true })
        .then((response) => {
          console.log("response.data = " , response.data);

        //api_ver1
        if(response.data.result == 1){
          alert(response.data.username +"님 회원가입에 성공하셨습니다.");
          this.$router.push('/login_page');
        }else{
          alert("회원가입에 실패하셨습니다.");
        }



        //not_sec
        // if(response.data == 1){
        //   this.$router.push('/');
        // }


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