package br.com.fatura.application.gateway;

import br.com.fatura.core.domain.item.Item;

public interface CreateItemGateway {

    Boolean create(Item item);
}
