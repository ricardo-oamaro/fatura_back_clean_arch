package br.com.fatura.usecase;

import br.com.fatura.core.domain.User;
import br.com.fatura.core.exception.InternalServerErrorException;

import java.util.List;

public interface GetAllUsersUseCase {

    List<User> findAll() throws InternalServerErrorException;

}
