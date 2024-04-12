package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.UserAuthenticateGateway;
import br.com.fatura.core.exception.AuthenticateException;
import br.com.fatura.core.exception.enums.ErrorCodeEnum;
import br.com.fatura.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private UserAuthenticateGateway userAuthenticateGateway;
    @Override
    public Boolean authenticate(String email, String password) throws AuthenticateException {
        if (!userAuthenticateGateway.authenticate(email, password)) {
            throw new AuthenticateException(ErrorCodeEnum.AUTH0001.getMessage(), ErrorCodeEnum.AUTH0001.getCode());
        }
        return true;
    }
}
