package com.droar.kafkaex.api.service;

/**
 * The Interface StreamingClientService.
 *
 * @author droar
 */
public interface StreamingClientService {

  /**
   * Send message.
   *
   * @param message the message
   * @param topicName the topic name
   */
  void sendMessage(String topicName, String message);

  /**
   * Send message with callback.
   *
   * @param message the message
   */
  void sendMessageWithCallback(String topicName, String message);
}
