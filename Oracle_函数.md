# 1.  git 

git：分布式版本管理工具。



>```shell
>git init; # 初始化本地仓库
># 新建了md文件
>git add 文件名 # 添加
>
>git status # 查看当前状态
>
>git commit -m "my first add file" # 提交到本地库  -m 后面的是提交的文本说明
>
>git remote add origin https://gitee.com/mazheng34340237/dl2190.git # 添加远程仓库位置
>
>git push -u origin master # 推送到 远端 的 主分支上。
>
>--------
># 第一次需要克隆
>git clone https://gitee.com/mazheng34340237/dl2190.git
>cd dl2190
># 第一次之后
>git pull  # 看最新的
>```
>
>



# 2. docker ： 虚拟化工具

VMWARE:   工具，可以装系统例如：win10,xp,centos,redhat.....

​			1.安装vmware, 2.安装centos 3.在centos上安装oracle

docker:   1.下载oracle镜像， 2.根据镜像启动容器。

----

阿里云服务器： 47.93.34.175  root  1qaz@WSX

> ```shell
> docker search oracle # 查找镜像
> docker -v # 查看版本
> docker pull 镜像名 # 下载镜像
> docker images # 查看所有的镜像 
> 
> # 根据镜像 创建 容器roacl_mazheng
> docker run -d -p 1521:1521 --name oracl_mazheng registry.cn-hangzhou.aliyuncs.com/helowin/oracle_11g
> 
> # 查看开启的容器
> docker ps 
> 
> 
> ```
>
> 

- 镜像： 系统盘
- 容器； 系统

----

# mysql: 

```SHELL
docker pull mysql:5.6 # 拉取镜像
# 创建容器
docker run -d -p 3306:3306 --name mysql_mazheng -e MYSQL_ROOT_PASSWORD=123456 mysql:5.6
# 进入容器
docker exec -it mysql_mazheng /bin/bash

# mysql连接
mysql -u root -p # 输入123456

use mysql # 进入mysql数据库

grant all privileges  on *.* to root@'%' identified by "123456";
flush privileges;



```























