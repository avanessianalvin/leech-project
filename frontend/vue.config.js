const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 3000, // your frontend port
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // backend server
        changeOrigin: true,
        //pathRewrite: { '^/api': '' } // optional, removes /api prefix
      }
    }
  }
})
