package org.acme.proxy;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.proxy.dto.SendMessageDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.telegram.telegrambots.meta.api.objects.Update;


@RegisterRestClient(configKey="telegram-api")
public interface TelegramClient {
    @POST
    @Path("/sendMessage")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<Response> sendMessage(SendMessageDTO sendMessageDTO);

}
