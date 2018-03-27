#!/bin/bash

# Output Directory
hdfs dfs -rm -r /user/hadoop/output/weather

# Submit
export HADOOP_CLASSPATH=/home/hadoop/code/hadoop/build/libs/myhadoop.jar
hadoop com.rueggerllc.hadoop.weather.MaxTemperatureApp \
       hdfs://captain:9000/user/hadoop/input/1901.txt \
       hdfs://captain:9000/user/hadoop/output/weather

#Show Results
hdfs dfs -cat /user/hadoop/output/weather/part-r-00000
