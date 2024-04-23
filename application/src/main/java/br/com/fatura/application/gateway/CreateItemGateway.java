package br.com.fatura.application.gateway;

import br.com.fatura.core.domain.Item;

public interface CreateItemGateway {

    Boolean create(Item item);
}
