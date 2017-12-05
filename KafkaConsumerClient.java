package com.exilant;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class KafkaConsumerClient {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("key.deserializer", StringDeserializer.class.getName());
		properties.setProperty("value.deserializer", StringDeserializer.class.getName());
		properties.setProperty("group.id", "Group1");
		properties.setProperty("session.timeout.ms", "300000");
		properties.setProperty("auto.offset.reset", "earliest");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		consumer.subscribe(Arrays.asList("exitopic1"));
		while (true) {
			ConsumerRecords<String, String> consumerRecords = consumer.poll(1000l);
			System.out.println("Number of messages got : " + consumerRecords.count());

			for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
				System.out.println("____________________________");
				System.out.println("Offset value is : " + consumerRecord.offset());
				System.out.println("Topic is : " + consumerRecord.topic());
				System.out.println("Time Stamp : " + consumerRecord.timestamp());
				System.out.println("Patition which reads from : " + consumerRecord.partition());
				System.out.println("Key : " + consumerRecord.key());
				System.out.println("Value : " + consumerRecord.value());

			}
		}
	}

}
