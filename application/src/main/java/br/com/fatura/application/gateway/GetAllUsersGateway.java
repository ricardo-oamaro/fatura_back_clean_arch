package br.com.fatura.application.gateway;

import br.com.fatura.core.domain.User;

import java.util.List;

public interface GetAllUsersGateway {
    List<User> findAll();
}
