package br.com.fatura.infrastructure.controller;

import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.infrastructure.dto.request.CreateUserRequest;
import br.com.fatura.infrastructure.dto.respose.BaseResponse;
import br.com.fatura.infrastructure.mapper.UserMapper;
import br.com.fatura.usecase.CreateUserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Slf4j
@Document(collection = "users")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws InternalServerErrorException {
        log.info("Inicio da criação do usuário::UserController");
        createUserUseCase.create(userMapper.toUser(request));
        log.info("Usuário criado com sucesso::UserController");
        return BaseResponse.<String>builder().success(true).message("Usuário criado com sucesso").build();
    }
}
