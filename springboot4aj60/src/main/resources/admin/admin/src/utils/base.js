const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot4aj60/",
            name: "springboot4aj60",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot4aj60/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园二手交易平台的的设计与实现"
        } 
    }
}
export default base
