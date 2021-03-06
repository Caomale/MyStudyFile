SpringBoot应用部署docker一般有两种操作：
1.使用dockerfile文件格式：
​ 新建dockerfile 文件（文件名必须是：dockerfile）内容如下：

# 该镜像需要依赖的基础镜像
FROM java:8
# 将当前目录下的jar包复制到docker容器的/目录下
ADD demos-0.0.1-SNAPSHOT.jar /demos.jar
# 运行过程中创建一个demos.jar文件
RUN bash -c 'touch /demos.jar'
# 声明服务运行在8099端口
EXPOSE 8099
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/demos.jar"]
# 指定维护者的名字
MAINTAINER caoxb
Maven下Lifecycle执行package -- 生成jar包

将dockerfile和jar包上传到Linux

启动docker

在dockerfile所在目录执行以下命令（生成应用镜像）：

# -t 表示指定镜像仓库名称/镜像名称:镜像标签 .表示使用当前目录下的Dockerfile
docker build -t demos/demos:0.0.1-SNAPSHOT .
启动应用相关的镜像（前提是先docker里pull了这些）

2. pom.xml配置模式
```java
<plugin>    
	<groupId>com.spotify</groupId>    
	<artifactId>docker-maven-plugin</artifactId>    
	<version>1.1.0</version>    
	<executions>        
		<execution>           
        	<id>build-image</id>            
        	<phase>package</phase>            
        	<goals>               
            	<goal>build</goal>           
            </goals>        
        </execution>    
    </executions>    
    <configuration>        
    	<imageName>demos/${project.artifactId}:${project.version}</imageName>        		 
      <dockerHost>http://Linux的ip:2375</dockerHost>        			  					
      <baseImage>java:8</baseImage>        
    	<entryPoint>["java", "-jar","/${project.build.finalName}.jar"]        				
      </entryPoint>        
      <resources>           
     	<resource>                
            <targetPath>/</targetPath>
            <directory>${project.build.directory}</directory>
            <include>${project.build.finalName}.jar</include>            
     	</resource>        
       </resources>    
	</configuration>
</plugin>
```

