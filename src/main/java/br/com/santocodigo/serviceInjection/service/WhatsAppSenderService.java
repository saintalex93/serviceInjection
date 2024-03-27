package br.com.santocodigo.serviceInjection.service;

import static org.apache.logging.log4j.util.Strings.isEmpty;

import org.springframework.stereotype.Service;

import br.com.santocodigo.serviceInjection.model.RestClient;
import br.com.santocodigo.serviceInjection.model.RestClientMessage;
import br.com.santocodigo.serviceInjection.model.RestMessage;

@Service
public class WhatsAppSenderService
    extends
        AbstractSenderService
{

    @Override
    protected boolean isValidClient(
        final RestClient restClient )
    {
        return isEmpty( restClient.name() ) || isEmpty( restClient.phone() );
    }

    @Override
    protected String getMessage(
        final RestClientMessage restClientMessage )
    {
        final RestClient restClient = restClientMessage.restClient();
        final RestMessage restMessage = restClientMessage.restMessage();

        return "WhatsApp sended to: %s, in phone: %s. Message: [Subject: %s, Message: %s]"
            .formatted( restClient.name(), restClient.phone(), restMessage.subject(), restMessage.message() );
    }

}
