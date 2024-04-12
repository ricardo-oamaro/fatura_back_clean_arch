package br.com.fatura.infrastructure.mapper;

import br.com.fatura.core.domain.User;
import br.com.fatura.infrastructure.dto.respose.UserResponse;
import br.com.fatura.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toUser(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "confirmPassword", ignore = true)
    default List<UserResponse> toUserResponseList(List<User> user) {
        return user.stream().map(this::toUserResponse).collect(Collectors.toList());
    }

    UserResponse toUserResponse(User user);
}
