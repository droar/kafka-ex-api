package com.droar.kafkaex.api.service;

/**
 * The Interface MessagingService.
 *
 * @author droar
 */
public interface MessagingService {

  /**
   * Send message.
   *
   * @param topicName the topic name
   * @param message the message
   * @return the string response
   */
  String sendMessageToStream(String topicName, String message);
  
}
