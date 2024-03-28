package br.com.santocodigo.serviceInjection.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.santocodigo.serviceInjection.model.RestClient;
import br.com.santocodigo.serviceInjection.model.RestClientMessage;
import br.com.santocodigo.serviceInjection.model.RestMessage;

class ClientMessageValidatorTest
{

    @Test
    void shouldAssertFalseWhenRestClientMessageIsNull()
    {
        assertFalse( ClientMessageValidator.isValid( null ) );
    }

    @Test
    void shouldAssertFalseWhenRestClientAndRestMessageIsNull()
    {
        assertFalse( ClientMessageValidator.isValid( new RestClientMessage( null, null ) ) );
    }

    @Test
    void shouldAssertFalseWhenRestMessageIsNull()
    {
        assertFalse( ClientMessageValidator.isValid( new RestClientMessage( new RestClient( null, null, null ), null ) ) );
    }

    @Test
    void shouldAssertFalseWhenRestClientIsNull()
    {
        assertFalse( ClientMessageValidator.isValid( new RestClientMessage( null, new RestMessage( null, null ) ) ) );
    }

    @Test
    void shouldAssertTrueWhenRestClientMessageIsFilled()
    {
        assertTrue( ClientMessageValidator.isValid( new RestClientMessage(
            new RestClient( null, null, null ),
            new RestMessage( null, null ) ) ) );
    }

}
