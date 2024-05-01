package org.acme.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@RegisterForReflection
public class MessageReqDTO {
    private String name;
    private String email;
    private String message;
}
