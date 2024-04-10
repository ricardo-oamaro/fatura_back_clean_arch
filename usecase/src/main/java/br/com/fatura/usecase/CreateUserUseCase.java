package br.com.fatura.usecase;

import br.com.fatura.core.domain.User;
import br.com.fatura.core.exception.InternalServerErrorException;

public interface CreateUserUseCase {

    void create(User user) throws InternalServerErrorException;
}
