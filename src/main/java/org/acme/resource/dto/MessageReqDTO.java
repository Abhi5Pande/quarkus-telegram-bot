package org.acme.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageReqDTO {
    private String name;
    private String email;
    private String message;
}
