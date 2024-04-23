package br.com.fatura.application.gateway;

import br.com.fatura.core.domain.Item;
import br.com.fatura.core.domain.User;
import br.com.fatura.core.exception.InternalServerErrorException;

import java.util.List;

public interface GetItemsGateway {
    List<Item> findAll();
}
