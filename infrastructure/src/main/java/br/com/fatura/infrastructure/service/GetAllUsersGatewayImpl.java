package br.com.fatura.infrastructure.service;

import br.com.fatura.application.gateway.GetAllUsersGateway;
import br.com.fatura.core.domain.User;
import br.com.fatura.infrastructure.mapper.UserEntityMapper;
import br.com.fatura.infrastructure.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetAllUsersGatewayImpl implements GetAllUsersGateway {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public List<User> findAll() {
        var userEntityList = userEntityRepository.findAll();
        return userEntityList.stream().map(entity -> userEntityMapper.toUser(entity)).collect(Collectors.toList());
    }
}
