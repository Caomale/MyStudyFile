# 该镜像需要依赖的基础镜像
FROM java:8
# 将当前目录下的jar包复制到docker容器的/目录下
ADD demos-0.0.1-SNAPSHOT.jar /demos.jar
# 运行过程中创建一个mall-tiny-docker-file.jar文件
RUN bash -c 'touch /demos.jar'
# 声明服务运行在8099端口
EXPOSE 8099
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/demos.jar"]
# 指定维护者的名字
MAINTAINER caoxb