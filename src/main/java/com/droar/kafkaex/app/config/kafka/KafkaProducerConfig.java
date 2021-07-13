package com.droar.kafkaex.app.config.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class KafkaProducerConfig.
 */
@Configuration
@Slf4j
class KafkaProducerConfig {

  /** The bootstrap servers. */
  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;


  /**
   * Kafka template.
   *
   * @return the kafka template
   */
  @Bean
  KafkaTemplate<String, String> kafkaTemplate() {
    KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory());
    kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
      @Override
      public void onSuccess(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata) {
        log.info("ACK from ProducerListener message: {} offset:  {}", producerRecord.value(), recordMetadata.offset());
      }
    });
    return kafkaTemplate;
  }

  /**
   * Producer configs.
   *
   * @return the map
   */
  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return props;
  }

  /**
   * Producer factory.
   *
   * @return the producer factory
   */
  @Bean
  public ProducerFactory<String, String> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }
}
