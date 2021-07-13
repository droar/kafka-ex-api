package com.droar.kafkaex.app.config.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class KafkaListeners - configure all listeners here for topics and groups
 *
 * @author droar
 */
@Component
@Slf4j
class KafkaListeners {

  @KafkaListener(topics = "droa-topics-1", groupId = "developerIDE")
  public void listenGroupDevelopers(String message) {
    log.info("Received Message in group developerIDE: " + message);
  }

  @KafkaListener(topics = "droa-topics-2")
  public void listenWithHeaders(
      @Payload String message, 
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
    log.info("Received Message: " + message + " from partition: " + partition);
  }
}
