package br.com.fatura.application.gateway;

import br.com.fatura.core.domain.User;

public interface CreateUserGateway {

    Boolean create(User user);
}
