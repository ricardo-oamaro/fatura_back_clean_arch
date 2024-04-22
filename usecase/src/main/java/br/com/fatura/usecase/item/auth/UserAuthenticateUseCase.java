package br.com.fatura.usecase.item.auth;

import br.com.fatura.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    String authenticate(String email, String password) throws AuthenticateException;
}
