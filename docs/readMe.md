# 1.rabbit安装流程（windows）
  1.RabbitMQ服务端代码是使用并发式语言Erlang编写的，安装Rabbit MQ的前提是安装Erlang环境
   -下载地址：http://www.erlang.org/downloads
   -安装流程：一直点击下一步安装完成。
   -配置环境变量：1.ERLANG_HOME = 安装目录（bin所在目录）
               2.变量加入path：%ERLANG_HOME%\bin
   -测试安装是否成功：windows键+R键，输入cmd，再输入erl，看到版本号就说明erlang安装成功
  2.安装RabbitMQ
   -下载地址：http://www.rabbitmq.com/download.html
   -安装流程：双击下载后的.exe文件，安装过程与erlang的安装过程相同
            进入安装目录sbin目录安装命令：rabbitmq-plugins enable rabbitmq_management
            查看是否安装成功命令：rabbitmqctl status（会显示rabbit现在状态）
   -开启rabbit：打开sbin目录，双击rabbitmq-server.bat
   -访问：http://localhost:15672 用户名和密码都是guest
   3.web mqtt插件安装：
    -安装流程：进入 rabbit 安装目录sbin  执行   rabbitmq-plugins enable rabbitmq_web_mqtt
            访问：http://localhost:15672 查看端口15675是否开启（有则安装成功）
            
# 2.工程创建
   1.相关依赖
     <!--Spring AMQP依赖-->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-amqp</artifactId>
      </dependency>
     <!--Spring MQTT依赖-->
     <dependency>
         <groupId>org.springframework.integration</groupId>
         <artifactId>spring-integration-mqtt</artifactId>
     </dependency>
     
   2.配置
     -AMQP配置
       spring:
         rabbitmq:
           host: localhost
           port: 5672
           virtual-host: /songxl #虚拟主机
           username: songxl
           password: songxl
           publisher-confirms: true #消息发送到交换器确认
           publisher-returns: true #消息发送到队列确认
     -MQTT配置
       rabbitmq:
         mqtt:
           url: tcp://localhost:1883 #mqtt长连接地址
           username: songxl
           password: songxl
           mqtt_url: ws://localhost:15675/ws #前端连接地址
           defaultTopic: testTopic