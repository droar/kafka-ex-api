package com.droar.kafkaex.api.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The Class PostMessagesProduceDTO.
 *
 * @author droar
 */
@Data
public class PostMessagesProduceDTO implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 590476756482003276L;

  /** The topic name. */
  @JsonProperty(value = "topicName")
  private String topicName;
  
  /** The name. */
  @JsonProperty(value = "message")
  private String message;
}
