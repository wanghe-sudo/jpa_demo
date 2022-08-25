# jpa+aop项目学习

## jpa配置上的心得
为什么要使用jpa?国内的99%的项目都在使用mybatis,jpa又有什么优势和不足呢?

在我看来,mybatis作为一个半orm的框架,它更注重于开发者自己编写查询sql,这样可以比较灵活的一次性查出想要的结果(谁叫sql这么强大呢),特别是在处理多表联查时,可以任由自己发挥

而jpa作为完全的orm框架,本身就做到了对持久层的完美封装,开发者以对象的思想查询数据,再加上复杂逻辑可以使用注解的方式增加自定义sql,这也使得jpa变得比较灵活

在我看来,mybatis更适合业务简单的使用场景,而jpa可能更加适合业务复杂的使用场景(为什么你和网上说的是相反的?)

这里我们先定义好,什么叫业务简单的场景,什么又是业务复杂的场景?

那我要问的是,假如所有逻辑都可以通过sql一把查出结果,你认为这样的项目,它的业务逻辑复杂吗?又假如,项目需求不定,因此表字段不定,业务行为复杂多变,判断逻辑层层叠叠,这样的场景,再使用mybatis是否能发挥出它独特的优势呢?

所以,这里再问一句,为什么说mybatis适用于业务复杂的场景?假如有人非要在sql层增加层层叠叠的sql判断,从而完成了复杂的逻辑,那么谁来维护这样的项目?恐怕3天以后的自己都看不下去了.

那么我们还是得返回来,通过业务代码来处理层层逻辑,同时减少查询的复杂度,这样的代码,在维护层面,将会非常方便.这时,使用mybatis或者jpa反而显得不那么重要了,都可以使用较为简单的sql,顶多3表联查,即可产生一个中间结果,来支撑业务逻辑.这时,mybatis的优势就完全发挥不出来了.如果项目需求多变,表变动频繁,那么mybatis反而成为维护的噩梦(每一个sql都需要增加或者减少响应的字段)

因此,可以得出结论,jpa是被忽略的优秀的解决方案.

jpa的配置在springboot中变得十分简单:
1. 增加依赖
```xml
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
2. application.properties增加配置
这里使用了mysql8,没有发现有什么问题
```properties
#通过 jpa 自动生成数据库中的表
# 数据库连接的配置
spring.datasource.url=jdbc:mysql:///jpa?useSSL=false
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```
3. 配置类和dao,service层
## aop使用上的心得
aop的配置有xml方式，注解方式，其实掌握其中一种即可
适当的aop,可以减少开发工作量,但是不建议过多的使用,在适当的场景下,画龙点睛,才会有灵性

使用注解方式,也可以分为两种方式,自定义注解方式,原始方式
两种方式,都分为3步:
1. 定义切点
2. 定义切面
3. 将切面放入spring容器

