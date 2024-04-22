package br.com.fatura.usecase.item;

import br.com.fatura.core.domain.item.Item;
import br.com.fatura.core.exception.InternalServerErrorException;

public interface CreateItemUseCase {

    void create(Item item) throws InternalServerErrorException;
}
