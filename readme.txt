Kafka Depends on Zookeeper 

Step 1: Start Zookeeper zookeeper-server-start.bat
(may need additional configuration) passing configuration is mandatory 

.zookeeper-server-start.bat ....configzookeeper.properties

**************************************************************************************

Step 2: Start kafka server (if needed change the properties, and you may have to 
change the time out from 6000 to 60000) 

.kafka-server-start.bat ....configserver.properties

// for clustering referring to new properties file 

.kafka-server-start.bat ....configserver-1.properties
.kafka-server-start.bat ....configserver-2.properties
**************************************************************************************


Step 3: create a topic  (You can create multiple topics ) 
	.kafka-topics.bat --create --zookeeper localhost:2181 --topic exitopic1 --partitions 3 --replication-factor 1

	.kafka-topics.bat --create --zookeeper localhost:2181 --topic exitopic2 --partitions 3 --replication-factor 1

// creating topics for clustering 
.kafka-topics.bat --create --zookeeper localhost:2181 --topic server1topic1 --partitions 3 --replication-factor 1
.kafka-topics.bat --create --zookeeper localhost:2181 --topic server1topic2 --partitions 3 --replication-factor 1

.kafka-topics.bat --create --zookeeper localhost:2181 --topic server2topic1 --partitions 3 --replication-factor 1
.kafka-topics.bat --create --zookeeper localhost:2181 --topic server2topic2 --partitions 3 --replication-factor 1


**************************************************************************************


Step 4: to list the topics which are created 

.kafka-topics.bat --zookeeper localhost:2181 --list
**************************************************************************************
Step 5: to describe the topic 
.kafka-topics.bat --zookeeper localhost:2181 --topic exitopic1 --describe
**************************************************************************************

Step 6: Create a producer 
.kafka-console-producer.bat --topic exitopic1 --broker-list localhost:9092

//for multiple cluster 
.kafka-console-producer.bat --topic server1topic1 --broker-list localhost:9093

.kafka-console-producer.bat --topic server2topic1 --broker-list localhost:9094
**************************************************************************************
Step 7: Create a consumer ( you can create multiple consumers for the same producer) 

.kafka-console.consumer.bat --topic server1topic1 --bootstrap-server localhost:9093
**************************************************************************************




MINE 
:: 

DOCUMENTATION : http://kafka.apache.org/documentation/#producerapi

STEP 1: 
cd  /Users/training/Desktop/kafka_2.11-1.0.0/bin

./zookeeper-server-start.sh  ../config/zookeeper.properties 

STEP 2:

Open config/server.properties file and increase the zookeeper timeout from 6k to 60k.

STEP 3 :
Open second terminal and run

./kafka-server-start.sh ../config/server.properties

STEP 4 :

./kafka-topics.sh 

STEP 5 :

./kafka-topics.sh --create --zookeeper localhost:2181 --topic exitopic1 --partitions 3 --replication-factor 1
Created topic "exitopic1".

./kafka-topics.sh --create --zookeeper localhost:2181 --topic exitopic2 --partitions 3 --replication-factor 1
Created topic "exitopic1".


STEP 6 :  Just for listing the created topics in particular zookeeper

./kafka-topics.sh --zookeeper localhost:2181 --list



STEP 7 : Description of any topic 


./kafka-topics.sh --zookeeper localhost:2181 --topic exitopic1 --describe
Topic:exitopic1	PartitionCount:3	ReplicationFactor:1	Configs:
	Topic: exitopic1	Partition: 0	Leader: 0	Replicas: 0   Isr: 0
	Topic: exitopic1	Partition: 1	Leader: 0	Replicas: 0   Isr: 0
	Topic: exitopic1	Partition: 2	Leader: 0	Replicas: 0   Isr: 0


STEP 8 : Create a producer :

./kafka-console-producer.sh --topic exitopic1  --broker-list localhost:9092 
>started kafka
>hi how are you? 
>where have u been?
>


STEP 9 : Create a consumer

./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic exitopic1 --from-beginning
