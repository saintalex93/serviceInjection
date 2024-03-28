package br.com.santocodigo.serviceInjection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.santocodigo.serviceInjection.model.RestClientMessage;

@Service
public class SenderServiceClientMessages
{

    private final List<SenderService> senderServices;

    @Autowired
    public SenderServiceClientMessages(
        final List<SenderService> senderServices )
    {
        this.senderServices = senderServices;
    }

    public List<String> send(
        final RestClientMessage restClientMessage )
    {
        if( ! ClientMessageValidator.isValid( restClientMessage ) ) {
            throw new RuntimeException( "ClientMessage is invalid." );
        }
        return senderServices.stream().map( service -> service.send( restClientMessage ) ).toList();
    }

}
