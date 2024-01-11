const { defineConfig } = require('@vue/cli-service')

module.exports =defineConfig({
    outputDir: "../vue_chat_sever/src/main/resources/static", //빌드 타깃 디렉터리
    devServer: {
        //프록시 설정
        proxy:{
            '^/api': { 
                target: "http://localhost:8088",
                changeOrigin:true,
                ws:false,
            },
            '^/access': { 
                target: "http://localhost:8088",
                changeOrigin:true,
                ws:false,
            },
        }
    },
}) ;