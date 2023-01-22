## 起動方法
```sh
$ cd ./prayground
$ docker network create -d bridge sandbox
$ git pull https://github.com/daisuzz/opensearch-playground
$ cd ./playground/opensearch-playground
$ git switch jenkins-playground
$ docker-compose up -d
$ cd ../playground/jenkins-playground
$ git switch opensearch-playground
$ docker-compose up -d
```
