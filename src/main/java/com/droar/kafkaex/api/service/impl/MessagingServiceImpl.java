package com.droar.kafkaex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.droar.kafkaex.api.service.MessagingService;
import com.droar.kafkaex.api.service.StreamingClientService;

@Service
public class MessagingServiceImpl implements MessagingService {

  /** The streaming client service. */
  @Autowired
  private StreamingClientService streamingClientService;

  @Override
//  @HystrixCommand(fallbackMethod = "defaultHighTrafficMessage")
  public String sendMessageToStream(String topicName, String message) {
    this.streamingClientService.sendMessageWithCallback(topicName, message);

    return "Message sent correctly to topic: " +topicName;
  }

  /**
   * Default high traffic message for circuit breaking
   *
   * @param topicName the topic name
   * @param message the message
   * @return the boolean
   */
  String defaultHighTrafficMessage(String topicName, String message) {
    return "Message could NOT be delivered to: " +topicName + " extremely irradiated sun interferences were detected";
  }
}
