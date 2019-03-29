### docker-compose demo
---
#### 运行步骤
1. centOS 安装 docker 和 docker-compose
2. 将项目复制到centOS某个文件夹
3. 进入项目文件夹 输入命令docker-compose up
4. 项目运行,docker-compose up -d 可后台运行, docker-compose down 关闭
5. docker ps 查看运行镜像
6. 输入ip/helloworld 可访问

#### tips
1. nginx/conf.d/app.conf 是nginx 配置 将80端口映射到8080端口
2. Dockerfile里只有 ‘FROM maven:3.5-jdk-8’ 一行 ，其余构建命令在docker-compose-yaml里已经有了
3. **docker-compose.yaml**
```
version: '3'
services:
  nginx:
    container_name: v-nginx
    image: nginx:1.13
    restart: always
    ports:
      - 80:80
      - 443:443
    volumes:
      - ./nginx/conf.d:/etc/nginx/conf.d

  app:
    restart: always
    build: ./
    working_dir: /app
    volumes:
      - ./:/app
      - ~/.m2:/root/.m2
    expose:
      - "8080"
    depends_on:
      - nginx



```
- `version: '3'`： 表示使用第三代语法来构建 docker-compose.yaml 文件。
- `services`: 用来表示 compose 需要启动的服务，我们可以看出此文件中有三个服务分别为：nginx、mysql、app。
- `container_name`: 容器名称
- `environment`: 此节点下的信息会当作环境变量传入容器，此示例中 mysql 服务配置了数据库、密码和权限信息。
- `ports`: 表示对外开放的端口
- `restart`: always 表示如果服务启动不成功会一直尝试。
- `volumes`: 加载本地目录下的配置文件到容器目标地址下
- `depends_on`：可以配置依赖服务，表示需要先启动 depends_on 下面的服务后，再启动本服务。
- `command`: mvn clean spring-boot:run -Dspring-boot.run.profiles=docker: 表示以这个命令来启动项目，-Dspring-boot.run.profiles=docker表示使用 application-docker.properties文件配置信息进行启动。
