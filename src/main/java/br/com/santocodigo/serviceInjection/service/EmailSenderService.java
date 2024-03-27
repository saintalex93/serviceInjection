package br.com.santocodigo.serviceInjection.service;

import static org.apache.logging.log4j.util.Strings.isEmpty;

import org.springframework.stereotype.Service;

import br.com.santocodigo.serviceInjection.model.RestClient;
import br.com.santocodigo.serviceInjection.model.RestClientMessage;
import br.com.santocodigo.serviceInjection.model.RestMessage;

@Service
public class EmailSenderService
    extends
        AbstractSenderService
{

    @Override
    protected boolean isValidClient(
        final RestClient restClient )
    {
        return isEmpty( restClient.name() ) || isEmpty( restClient.email() );

    }

    @Override
    protected String getMessage(
        final RestClientMessage restClientMessage )
    {
        final RestClient restClient = restClientMessage.restClient();
        final RestMessage restMessage = restClientMessage.restMessage();

        return "Email sended to: %s, in email: %s. Message: [Subject: %s, Message: %s]".formatted(
            restClient.name(), restClient.email(), restMessage.subject(), restMessage.message() );
    }

}
