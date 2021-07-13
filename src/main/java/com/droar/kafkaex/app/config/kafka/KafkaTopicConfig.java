package com.droar.kafkaex.app.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * The Class KafkaTopicConfig.
 *
 * @author droar
 */
@Configuration
class KafkaTopicConfig {

  /**
   * Topic 1.
   *
   * @return the new topic
   */
  @Bean
  public NewTopic topic1() {
    return TopicBuilder.name("droa-topics-1").build();
  }

  /**
   * Topic 2.
   *
   * @return the new topic
   */
  @Bean
  public NewTopic topic2() {
    return TopicBuilder.name("droa-topics-2").build();
  }
}
