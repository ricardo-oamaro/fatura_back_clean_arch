package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.CreateItemGateway;
import br.com.fatura.core.domain.Item;
import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.core.exception.enums.ErrorCodeEnum;
import br.com.fatura.usecase.CreateItemUseCase;

public class CreateItemUseCaseImpl implements CreateItemUseCase {

    private final CreateItemGateway createItemGateway;

    public CreateItemUseCaseImpl(CreateItemGateway createItemGateway) {
        this.createItemGateway = createItemGateway;
    }


    @Override
    public void create(Item item) throws InternalServerErrorException {
        if(!createItemGateway.create(item)) {
            throw new InternalServerErrorException(ErrorCodeEnum.ITM0001.getMessage(), ErrorCodeEnum.ITM0001.getCode());
        }
    }
}
