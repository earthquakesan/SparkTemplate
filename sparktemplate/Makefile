test:
	sbt test

test-spark-example:
	sbt "test:testOnly *SparkExampleSpec"

build:
	sbt assembly
	docker build -t wordcount .

deploy:
	docker run -it --rm -e SPARK_APPLICATION_ARGS=/input/alice_wonderland.txt -e SPARK_MASTER_NAME=spark-master -e SPARK_MASTER_PORT=7077 -e HDFS_URI=hdfs://namenode:8020 --network hadoop --name wordcount wordcount
