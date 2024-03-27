package br.com.santocodigo.serviceInjection.service;

import static org.apache.logging.log4j.util.Strings.isEmpty;

import br.com.santocodigo.serviceInjection.model.RestClientMessage;
import br.com.santocodigo.serviceInjection.model.RestMessage;

public class ClientMessageValidator
{

    public static boolean isValid(
        final RestClientMessage restClientMessage )
    {
        return restClientMessage != null &&
            restClientMessage.restClient() != null &&
            restClientMessage.restMessage() != null;
    }

    public static boolean isValidMessage(
        final RestMessage restMessage )
    {
        return isEmpty( restMessage.subject() ) || isEmpty( restMessage.message() );

    }

}
