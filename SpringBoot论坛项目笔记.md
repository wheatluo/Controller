# SpringBoot论坛项目笔记

* springboot封装了tancat
* pom.xml是maven管理依赖的仓库
* main 用来放置.java文件
* resources
  * static放置静态文件，css，js
  * templates放置web文件，html，这里用spring语法来写
  * application.properties放置项目配置文件，啥都有
    * server.port=xxx  改端口号
* 在templates里多个url第一个用？区分，然后都用&区分
### 注解
* Controller:控制器，要前端可以访问
    * GetMaping("/xx""):设置访问路径
* Autowired 自动把spring容器已经写好实例化的实例加载到我当前使用的上下文