package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.UserAuthenticateGateway;
import br.com.fatura.core.exception.AuthenticateException;
import br.com.fatura.core.exception.enums.ErrorCodeEnum;
import br.com.fatura.usecase.item.auth.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private final UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public String authenticate(String email, String password) throws AuthenticateException {
        String result = userAuthenticateGateway.authenticate(email, password);
        if (result.equals("User not found")) {
            throw new AuthenticateException(ErrorCodeEnum.AUTH0001.getMessage(), ErrorCodeEnum.AUTH0001.getCode());
        }
        return result;
    }
}
