package com.droar.kafkaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.droar.kafkaex.api.dto.PostMessagesProduceDTO;
import com.droar.kafkaex.api.service.MessagingService;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class MessageController.
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/messages")
public class MessageController {

  /** The kafka sender. */
  @Autowired
  private MessagingService messageService;

  /**
   * Producer.
   *
   * @param message the message
   * @return the string
   */
  @PostMapping(value = "/produce")
  public ResponseEntity<String> producer(@RequestBody(required = true) PostMessagesProduceDTO postProduceMessage) {
    log.info("[API MESSAGES]: [POST] /produce: Producing message into message procesor (kafka)");

    String response = this.messageService.sendMessageToStream(postProduceMessage.getTopicName(), postProduceMessage.getMessage());
    return ResponseEntity.ok(response);
  }

  /**
   * Consume.
   *
   * @return the string
   */
  @GetMapping(value = "/consume")
  public ResponseEntity<?> consume(@RequestParam(required = true) String topicName) {
    // this.messageService.consume(topicName);

    return ResponseEntity.ok("Message retrieved to the Kafka Topic java_in_use_topic Successfully");
  }

}
