package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.GetAllUsersGateway;
import br.com.fatura.core.domain.User;
import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.core.exception.enums.ErrorCodeEnum;
import br.com.fatura.usecase.GetAllUsersUseCase;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private final GetAllUsersGateway getAllUsersGateway;

    public GetAllUsersUseCaseImpl(GetAllUsersGateway getAllUsersGateway) {
        this.getAllUsersGateway = getAllUsersGateway;
    }


    @Override
    public List<User> findAll() throws InternalServerErrorException {
        if(!getAllUsersGateway.findAll().isEmpty()){
            return getAllUsersGateway.findAll();
        }else{
            throw new InternalServerErrorException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }
    }
}
