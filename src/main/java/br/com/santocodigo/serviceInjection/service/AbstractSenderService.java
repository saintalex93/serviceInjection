package br.com.santocodigo.serviceInjection.service;

import static br.com.santocodigo.serviceInjection.service.ClientMessageValidator.isValidMessage;

import br.com.santocodigo.serviceInjection.model.RestClient;
import br.com.santocodigo.serviceInjection.model.RestClientMessage;
import br.com.santocodigo.serviceInjection.model.RestMessage;

public abstract class AbstractSenderService
    implements
        SenderService
{

    @Override
    public String send(
        final RestClientMessage restClientMessage )
    {

        final RestClient restClient = restClientMessage.restClient();
        if( isValidClient( restClient ) ) {
            throw new RuntimeException( "Client is invalid." );

        }
        final RestMessage restMessage = restClientMessage.restMessage();
        if( isValidMessage( restMessage ) ) {
            throw new RuntimeException( "Message is invalid." );
        }

        return getMessage( restClientMessage );

    }

    protected abstract boolean isValidClient(
        final RestClient restClient );

    protected abstract String getMessage(
        RestClientMessage restClientMessage );

}
