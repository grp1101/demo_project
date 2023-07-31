<template>
    <div class='body_background'>
        <div id="section1"></div>
        <div id="section2"></div>
        <div id="section3"></div>
        <div id="section4">
            <div>이제 시작해볼까요?</div>
            <button type="button" class="btn" style="background-color: #5882FA; border-radius: 20px; color:white;">Windows용 다운로드</button>
        </div>

    </div>
</template>

<script>
export default {
name:'body-content',
data() {
    return {
        
    }
},
methods: {
    
},
}
</script>

<style>
.body_background{
color: white;
/* background-image: url('@/assets/image1.jpg'); */
height: 100%;
}

#section1{
  height: 500px;  
}

#section2{
  height: 500px;  
}


#section3{
  height: 500px;  
}


#section4{
  height: 500px;  
}



</style>