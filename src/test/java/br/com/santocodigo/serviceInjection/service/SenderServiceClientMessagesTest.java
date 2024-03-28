package br.com.santocodigo.serviceInjection.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.santocodigo.serviceInjection.model.RestClient;
import br.com.santocodigo.serviceInjection.model.RestClientMessage;
import br.com.santocodigo.serviceInjection.model.RestMessage;

@ExtendWith( MockitoExtension.class )
class SenderServiceClientMessagesTest
{

    private static final String NAME = "NAME";
    private static final String EMAIL = "EMAIL";
    private static final String PHONE = "PHONE";
    private static final String SUBJECT = "SUBJECT";
    private static final String MESSAGE = "MESSAGE";

    private SenderServiceClientMessages subject;
    @Mock
    private SenderService whatsAppSenderService;
    @Mock
    private SenderService emailSenderService;

    @Test
    void shouldThrowsRunTimeExceptionWhenRestClientMessageIsNull()
    {
        assertThrows( RuntimeException.class, () -> {
            subject.send( null );
        } );
    }

    @Test
    void shouldCallSenderServicesTwoTimes()
    {
        subject = new SenderServiceClientMessages( List.of( whatsAppSenderService, emailSenderService ) );

        final RestClient restClient = new RestClient( NAME, EMAIL, PHONE );
        final RestMessage restMessage = new RestMessage( SUBJECT, MESSAGE );

        final RestClientMessage restClientMessage = new RestClientMessage( restClient, restMessage );
        subject.send( restClientMessage );

        verify( whatsAppSenderService ).send( restClientMessage );
        verify( emailSenderService ).send( restClientMessage );
    }

}
