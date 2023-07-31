const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

// module.exports = {
//     outputDir: "../todolist_api_spr/src/main/resources/static", //빌드 타깃 디렉터리
//     // indexPath: "../static/index.html", //index.html 파일 생성 위치
//     devServer: {
//         //프록시 설정
//         proxy: "http://localhost:3000",
//         changeOrigin:true,
//     },
//     // chainWebpack: config =>{
//     //     const svgRule = config.module.rule("svg");
//     //     svgRule.uses.clear();
//     //     svgRule.use("vue-svg-loader").loader("vue-svg-loader");
//     // }
// };