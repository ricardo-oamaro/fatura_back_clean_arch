package br.com.fatura.infrastructure.service;

import br.com.fatura.application.gateway.UserAuthenticateGateway;
import br.com.fatura.core.domain.User;
import br.com.fatura.infrastructure.entity.UserEntity;
import br.com.fatura.infrastructure.mapper.UserEntityMapper;
import br.com.fatura.infrastructure.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticateGatewayImpl implements UserAuthenticateGateway {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Boolean authenticate(String email, String password) {
        User user = userEntityRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
