##30分钟快速搭建springcloud分布式基础架构
 
该示例包含了<br /> 
配置管理、服务注册与发现、断路器、路由、负载均衡等，适合于快速搭建微服务整体框架，并易于扩展。


整体结构如下<br /> 

git配置文件仓库configserver...<br /> 
通过负载均衡为以下服务提供配置文件
  
                      客户--->   负载均衡服务器
                                      | 
                                 zuulserver...                                     ---- eurekaserver...  
                                      |                                                /   /
                    sericefeign1...   sericefeign2...                              ---/   /
                                      |                                                  /
       eurekaclient1...  eurekaclient2...    eurekaclient3...                      -----/


说明如下<br /> 
configserver用于提供统一配置参数服务于zuulserver、sericefeign、eurekaclient1和eurekaserver应用。<br /> 
eurekaserver提供服务注册与发现，服务于zuulserver、sericefeign、eurekaclient。<br /> 
zuulserver主要功能是路由转发和过滤器。路由功能：比如/api/xx1转发到到xx1服务，/api/xx2转发到到xx2服务。<br /> 
sericefeign是核心应用服务器，通过Feign去消费服务，Feign默认集成了Ribbon，并和Eureka结合，默认实现了消费负载均衡效果。<br /> 
eurekaclient典型的微服务应用。<br /> 

各项目在本地运行起来后可以输入http://localhost:10001/api-1/hi?name=Greatest<br />  试试，修改eurekaclient的port并新开启一个服务，重新多使用几次链接，看看效果。<br /> 


##参考链接如下:<br /> 
http://spring.io/guides/gs/service-registration-and-discovery/<br /> 
http://blog.csdn.net/forezp/article/details/70148833<br /> 
http://cloud.spring.io/spring-cloud-config/single/spring-cloud-config.html<br /> 
https://github.com/spring-cloud/spring-cloud-config<br /> 
https://github.com/spring-projects/spring-boot<br /> 

