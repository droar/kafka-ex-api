package com.droar.kafkaex.api.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The Class GetMessagesConsumeDTO.
 *
 * @author droar
 */
@Data
public class GetMessagesConsumeDTO implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 590476756482003276L;

  /** The name. */
  @JsonProperty(value = "topicName")
  private String topicName;
}
