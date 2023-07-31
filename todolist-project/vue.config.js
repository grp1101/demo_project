const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true,
//   lintOnSave:false
// })

module.exports =defineConfig({
    outputDir: "../todolist_api_spr/src/main/resources/static", //빌드 타깃 디렉터리
    // indexPath: "../static/index.html", //index.html 파일 생성 위치
    devServer: {
        //프록시 설정
        proxy:{
            '/': {
                target: "http://localhost:8088",
                changeOrigin:true,
            }
        }
    },
    // chainWebpack: config =>{
    //     const svgRule = config.module.rule("svg");
    //     svgRule.uses.clear();
    //     svgRule.use("vue-svg-loader").loader("vue-svg-loader");
    // }
}) ;
