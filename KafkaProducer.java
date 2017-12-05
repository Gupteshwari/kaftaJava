/**
refer : http://kafka.apache.org/documentation/#api
3.3 Producer Configs
 * 
 */
package com.exilant;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * @author training
 *
 */
public class KafkaProducer {
	public static void main(String[] args) {
		// First lets list the properties

		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		properties.setProperty("acks", "1");
		properties.setProperty("retries", "3");

		Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(
				properties);

		ProducerRecord<String, String> record1 = new ProducerRecord<String, String>("exitopic1", "1",
				"Hello from java");
		ProducerRecord<String, String> record2 = new ProducerRecord<String, String>("exitopic1", "2",
				"Hello from java-2");
		producer.send(record1);
		producer.send(record2);

		producer.flush();
		producer.close();
		System.out.println("Sent....");

	}
}
