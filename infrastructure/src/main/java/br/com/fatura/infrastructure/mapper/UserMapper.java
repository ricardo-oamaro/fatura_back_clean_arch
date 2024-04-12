package br.com.fatura.infrastructure.mapper;

import br.com.fatura.core.domain.User;
import br.com.fatura.infrastructure.dto.request.CreateUserRequest;
import br.com.fatura.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper{

    public UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getRole()
        );
    }

    public User toUser(CreateUserRequest request) {
        return new User(
                request.name(),
                request.email(),
                request.password(),
                request.confirmPassword(),
                request.role()
        );
    }

}
