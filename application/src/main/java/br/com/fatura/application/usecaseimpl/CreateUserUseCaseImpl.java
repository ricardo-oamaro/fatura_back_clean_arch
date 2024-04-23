package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.CreateUserGateway;
import br.com.fatura.core.domain.User;
import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.core.exception.enums.ErrorCodeEnum;
import br.com.fatura.usecase.CreateUserUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user) throws InternalServerErrorException {
        if(!createUserGateway.create(user)){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        }
    }
}
