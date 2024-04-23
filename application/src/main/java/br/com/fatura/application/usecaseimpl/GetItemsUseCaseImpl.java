package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.GetItemsGateway;
import br.com.fatura.core.domain.Item;
import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.core.exception.enums.ErrorCodeEnum;
import br.com.fatura.usecase.GetItemsUseCase;

import java.util.List;

public class GetItemsUseCaseImpl implements GetItemsUseCase {

    private final GetItemsGateway getItemsGateway;

    public GetItemsUseCaseImpl(GetItemsGateway getItemsGateway) {
        this.getItemsGateway = getItemsGateway;
    }

    @Override
    public List<Item> findAll() throws InternalServerErrorException {
        if(!getItemsGateway.findAll().isEmpty()) {
            return getItemsGateway.findAll();
        } else {
            throw new InternalServerErrorException(ErrorCodeEnum.ITEM_ERROR01.getMessage(), ErrorCodeEnum.ITEM_ERROR01.getCode());
        }
    }
}
