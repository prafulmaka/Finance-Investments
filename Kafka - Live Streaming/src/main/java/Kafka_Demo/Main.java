package Kafka_Demo;
import java.lang.management.ManagementFactory;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.sun.management.OperatingSystemMXBean;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;

public class Main {
    public static void main(String[] args) {
        System_Metrics get_metric = new System_Metrics();
        get_metric.sys_metrics();
    }

    public void print(String metric) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        ProducerRecord producerRecord = new ProducerRecord("MetricsChannel", "name", metric);

        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        kafkaProducer.send(producerRecord);

        kafkaProducer.close();
    }
}