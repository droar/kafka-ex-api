package com.droar.kafkaex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import com.droar.kafkaex.api.service.StreamingClientService;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class KafkaSender.
 *
 * @author droar
 */
@Component
@Slf4j
public class KafkaClientImpl implements StreamingClientService {

  /** The kafka template. */
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void sendMessage(String topicName, String message) {
    this.kafkaTemplate.send(topicName, message);
  }

  @Override
  public void sendMessageWithCallback(String topicName, String message) {
    ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(topicName, message);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
      @Override
      public void onSuccess(SendResult<String, String> result) {
        log.info("Message [{}] delivered with offset {}", message, result.getRecordMetadata().offset());
      }

      @Override
      public void onFailure(Throwable ex) {
        log.warn("Unable to deliver message [{}]. {}", message, ex.getMessage());
      }
    });
  }
}
