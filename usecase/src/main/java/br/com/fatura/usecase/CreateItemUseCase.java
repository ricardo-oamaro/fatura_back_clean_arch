package br.com.fatura.usecase;

import br.com.fatura.core.domain.Item;
import br.com.fatura.core.exception.InternalServerErrorException;

public interface CreateItemUseCase {

    void create(Item item) throws InternalServerErrorException;
}
