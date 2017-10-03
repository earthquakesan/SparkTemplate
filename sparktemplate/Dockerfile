FROM bde2020/spark-submit:2.1.0-hadoop2.8-hive-java8

ADD target/scala-2.11/Hello-assembly-0.0.1.jar /app/application.jar

ENV SPARK_MASTER_NAME spark-master
ENV SPARK_MASTER_PORT 7077
ENV SPARK_APPLICATION_MAIN_CLASS example.WordCountMain
ENV SPARK_APPLICATION_ARGS /input/readme.txt
