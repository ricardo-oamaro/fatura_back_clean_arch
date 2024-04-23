package br.com.fatura.usecase;

import br.com.fatura.core.domain.Item;
import br.com.fatura.core.exception.InternalServerErrorException;

import java.util.List;

public interface GetItemsUseCase {

    List<Item> findAll() throws InternalServerErrorException;
}
