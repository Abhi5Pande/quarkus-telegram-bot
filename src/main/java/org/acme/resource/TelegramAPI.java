package org.acme.resource;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.proxy.TelegramClient;
import org.acme.proxy.dto.SendMessageDTO;
import org.acme.resource.dto.MessageReqDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api")
public class TelegramAPI {

    @RestClient
    TelegramClient telegramClient;

    @ConfigProperty(name = "chat")
    String chatId;

    @POST
    @Path("/send")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Uni<Response> sendMessage(MessageReqDTO req) {
        SendMessageDTO sendMessageDTO = new SendMessageDTO();
        sendMessageDTO.chat_id = chatId;
        sendMessageDTO.text = String.format("-------------- \nName: %s \n\n Email: %s \n\n Message: %s \n\n\n\n", req.getName(),req.getEmail(),req.getMessage());
        return telegramClient.sendMessage(sendMessageDTO);
    }
}
