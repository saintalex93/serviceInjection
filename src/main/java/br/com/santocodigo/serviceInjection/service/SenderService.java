package br.com.santocodigo.serviceInjection.service;

import br.com.santocodigo.serviceInjection.model.RestClientMessage;

public interface SenderService
{

    String send(
        RestClientMessage restClientMessage );
}
