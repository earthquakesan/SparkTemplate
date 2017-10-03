create-new-project:
	sbt new sbt/scala-seed.g8

start-stack:
	docker-compose up -d

create-network:
	docker network create --attachable hadoop

copy-sample-data:
	docker run -it --rm --network hadoop --env-file hadoop.env bde2020/hadoop-namenode:1.1.0-hadoop2.8-java8 hdfs dfs -mkdir -p /input
	docker run -it --rm --network hadoop --volume $(shell pwd)/sample-data:/data --env-file hadoop.env bde2020/hadoop-namenode:1.1.0-hadoop2.8-java8 hdfs dfs -copyFromLocal /data/alice_wonderland.txt /input
