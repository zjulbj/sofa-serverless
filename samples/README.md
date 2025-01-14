## SOFAServerless 模块中间件使用样例清单

| 框架         | 中间件                    | 说明           | 代码样例                                                                                                                                            |
|------------|------------------------|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| sprintboot | spring context manager | 跨模块bean调用    | [samples/springboot-samples/service](https://github.com/sofastack/sofa-serverless/tree/master/samples/springboot-samples/service)               |  
| springboot | tomcat                 | 单host模式      | [samples/springboot-samples/web/tomcat/](https://github.com/sofastack-guides/springboot-samples/tree/master/samples/web/tomcat)                 | 
| springboot | log4j2                 | 基座与模块独立日志目录  | [samples/springboot-samples/logging/log4j2](https://github.com/sofastack/sofa-serverless/tree/master/samples/springboot-samples/logging/log4j2) |
| springboot | kafka                  | 模块独立使用 kafka | [samples/springboot-samples/msg/kafka](https://github.com/sofastack/sofa-serverless/tree/master/samples/springboot-samples/msg/kafka/)          |
| springboot | mybatis                | 模块使用独立数据源    | [samples/springboot-samples/db/mybatis](https://github.com/sofastack/sofa-serverless/tree/master/samples/springboot-samples/db/mybatis)                    |
| springboot | slimming               | 模块瘦身         | [samples/springboot-samples/slimming/log4j2](https://github.com/sofastack/sofa-serverless/tree/master/samples/springboot-samples/slimming/log4j2)               |
| springboot | redis                  | 模块使用 redis   | [samples/springboot-samples/redis](https://github.com/sofastack/sofa-serverless/tree/master/samples/springboot-samples/redis)               |
| dubbo      | dubbo + grpc           | 模块使用 grpc    | [samples/dubbo-samples/rpc/grpc](https://github.com/sofastack/sofa-serverless/tree/master/samples/dubbo-samples/rpc/grpc)             |
| sofaboot   | sofarpc/tomcat         | 基座调用模块、中台模式  | [samples/sofaboot-samples/dynamic-stock](https://github.com/sofastack/sofa-serverless/tree/master/samples/sofaboot-samples/dynamic-stock)       |                                                                                                    |
### 注意请在编译器单独导入对应 samples 工程，例如 sofa-serverless/samples/springboot-samples 工程，否则会出现 BizRuntieContext Not found 的报错。
![biz runtime context not found](bizruntimecontext_not_found.png)
原因：samples 工程与 sofa-serverless-runtime 在一个工程目录里，会优先使用本地的 sofa-serverless-runtime，而不是 maven 依赖的 sofa-serverless-runtime，导致找不到 BizRuntimeContext 类。
