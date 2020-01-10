# SpringBoot_HBase
### 简介
当数据量过大的时候，关系性数据库会出现性能瓶颈，这时候我们就可以用NoSql，比如Hbase就是一个不错的解决方案。这个项目是Spring整合Hbase的实际案例，且在最后会给出整合中可能会出现的问题，以及解决方案。这里我是用本地Windows的IDEA，与局域网的伪分布Hbase集群做的连接，其中Hbase集群包括的组件有：Jdk1.8、Hadoop2.7.6、ZooKeeper3.4.10、Hbase2.0.1，因为这里只是开发环境，所以做一个伪分布的就好，之后部署的时候再按生产环境要求来即可
###  整合步骤
#####  目录结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200110132034581.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIyMTM2NDM5,size_16,color_FFFFFF,t_70)
#####  pom.xml
这里要导入Hbase连接所需要包，需要找和你Hbase版本一致的包
#####  hbase-site.xml
我是用的配置文件连接方法，这个配置文件你在hbase的安装目录下的conf目录就可以找到，然后你直接把它复制到项目的resources目录下就好，当然你也可以用application.properties配置文件外加注入和代码的方式代替这个配置文件
#####  HBaseConfig.java
这里因为只需连接Hbase就没连接Hadoop，如果要连接Hadoop，Windows下还要下载winutils.exe工具，后面会介绍
#####  HBaseService.java
这是做连接后的一些操作
#####  HBaseApplicationTests.java
单元测试
#####  运行结果
**Hbase数据库查询结果**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200110133613576.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIyMTM2NDM5,size_16,color_FFFFFF,t_70)
**IDEA的遍历结果**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200110133739344.png)
###  报错与解决方案
##### 报错一
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200110134206127.png)
###### 解决方案：
这是参数配置的有问题，如果你是用hbase-site.xml配置文件配置的参数，那么检查它，用代码配置就检查代码参数
#####  报错二
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200110134424996.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIyMTM2NDM5,size_16,color_FFFFFF,t_70)
###### 解决方案：
更改windows本地hosts文件，C:\Windows\System32\drivers\etc\hosts,添加Hbase服务所在主机地址与主机名称，这里你如果保存不了hosts文件，把它拉出到桌面改好再拉回即可
#####  报错三
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200110134727378.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIyMTM2NDM5,size_16,color_FFFFFF,t_70)
###### 解决方案：
这是因为在Windows下连接Hadoop需要一个叫Winutils.exe的工具，并且从源代码可知，它会去读你Windows下的环境变量，如果你不想在本地设置，可以用方法System.setProperty()设置实时环境变量，另外，如果你只用Hbase，其实这个报错并不影响你使用Hbase服务
### 博客地址
https://blog.csdn.net/qq_22136439/article/details/103922627
