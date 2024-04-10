package br.com.fatura.infrastructure.service;

import br.com.fatura.application.gateway.CreateUserGateway;
import br.com.fatura.core.domain.User;
import br.com.fatura.infrastructure.mapper.UserMapper;
import br.com.fatura.infrastructure.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateUserGatewayImpl implements CreateUserGateway {

    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean create(User user) {
        log.info("Creating user: {}", user);
        try {
            userEntityRepository.save(userMapper.toUserEntity(user));
            return true;
        } catch (Exception e) {
            log.error("Error creating user: {}", user, e);
            return false;
        }
    }
}
