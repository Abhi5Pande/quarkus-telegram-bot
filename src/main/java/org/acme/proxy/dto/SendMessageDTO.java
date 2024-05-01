package org.acme.proxy.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterForReflection
public class SendMessageDTO {
    public String chat_id;
    public String text;


}
