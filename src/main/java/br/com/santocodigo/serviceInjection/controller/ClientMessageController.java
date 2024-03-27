package br.com.santocodigo.serviceInjection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santocodigo.serviceInjection.model.RestClientMessage;
import br.com.santocodigo.serviceInjection.service.SenderServiceClientMessages;

@RestController
@RequestMapping( "client-message" )
public class ClientMessageController
{
    @Autowired
    private SenderServiceClientMessages senderServiceClientMessages;

    @PostMapping
    public List<String> sendMessage(
        @RequestBody final RestClientMessage restClientMessage )
    {
        return senderServiceClientMessages.send( restClientMessage );
    }

}
