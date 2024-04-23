package br.com.fatura.usecase;

import br.com.fatura.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    String authenticate(String email, String password) throws AuthenticateException;
}
