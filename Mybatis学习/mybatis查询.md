 ## 模糊查询

1 使用concat 内建函数

2 可以从外部入参处理

3  使用里面的参数重新绑定

```xml
 <bind name="newUserName" value="'%'+userName+'%'"/>
select *
from smbms_user where userName like #{newUserName}
```



## 参数问题

### 单参数

如果传入的是单个参数的话，mybatis解析参数没有任何问题。写啥都可以得到结果，但是最好还是有语义。



### 如果参数的参数是多个

那么默认的处理方式是arg0 arg1  param1 param2这种模式

由于没有语义，不推荐使用，我们最好使用注解@param来指定参数。

```java
List<User> queryByUserNameUserRole(@Param("userName") String userName, @Param("userRole") Integer userRole);
```

### pojo形式

```java
    List<User> queryByUserNameUserRole(User user);
```

都是将参数封装成Map形式





