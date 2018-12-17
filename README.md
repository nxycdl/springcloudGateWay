# springcloudGateWay
## 听说springcloudGateWay的性能是zuul的1.6倍,学习一下GateWay
## 只是简单的路由转发没有任何的filter的DEMO
* 开始
    *  直接在你的项目pom引入
    ```
    <dependency>
        		<groupId>org.springframework.cloud</groupId>
    			<artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
    ```
    * 基于Spring WebFlux(?)所以项目里面不能有starter-web 依赖
    ```
    * Route Predicate Factory 一个时间参数代表
    spring:
      cloud:
        gateway:
          routes:
          - id: between_route
            uri: http://example.org
            predicates:
            # 匹配datetime1之后和datetime2之前发生的请求
            - Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]
            # 匹配当前日期时间之后发生的请求
            - After=2017-01-20T17:42:47.789-07:00[America/Denver]
             # 匹配当前日期时间之后发生的请求
            - Before=2017-01-20T17:42:47.789-07:00[America/Denver]
    ```
    * 里面存在若干和匹配规则 时间、cook、method ...... 查官网
    * 主要看下路由匹配
    ```
    spring:
      cloud:
        gateway:
          routes:
          - id: host_route
            uri: http://example.org
            predicates:
            #如果请求路径是，则此路由将匹配，例如：/foo/1或/foo/bar或/bar/baz。
            - Path=/foo/{segment},/bar/{segment}
    ```
    * 另外需要结合注册中心使用否则在uri 里面使用lb 的时候就不知道具体是哪个服务了;
    * 效率问题是否有提高不知道
    * 只是简单的路由转发没有任何的filter的DEMO
## curl cmd
```
    ###使用服务名访问
    http://127.0.0.1:5602/user/getUserById?userId=1234
    http://127.0.0.1:5602/order/getOrder?username=12345
    http://127.0.0.1:5602/order/getPayDetailList?id=1544954618
    http://127.0.0.1:5602/pay/getPayDetail?id=12456
    ###使用http请求访问
    http://127.0.0.1:5602/user2/getUserById?userId=1234
```
