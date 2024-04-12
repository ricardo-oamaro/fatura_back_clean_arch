package br.com.fatura.infrastructure.controller;

import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.infrastructure.dto.request.CreateUserRequest;
import br.com.fatura.infrastructure.dto.respose.BaseResponse;
import br.com.fatura.infrastructure.dto.respose.UserResponse;
import br.com.fatura.infrastructure.mapper.UserEntityMapper;
import br.com.fatura.infrastructure.mapper.UserMapper;
import br.com.fatura.usecase.CreateUserUseCase;
import br.com.fatura.usecase.GetAllUsersUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
@Slf4j
@Document(collection = "users")
public class UserController {
    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private GetAllUsersUseCase getAllUsersUseCase;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserEntityMapper userEntityMapper;


    @PostMapping("/register")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws InternalServerErrorException {
        log.info("Inicio da criação do usuário::UserController");
        createUserUseCase.create(userMapper.toUser(request));
        log.info("Usuário criado com sucesso::UserController");
        return BaseResponse.<String>builder().success(true).message("Usuário criado com sucesso").build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() throws InternalServerErrorException {
        log.info("Buscando todos os usuários::UserController");
        var users = getAllUsersUseCase.findAll();
        var userResponse = users.stream().map(user -> userEntityMapper.toUserResponse(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userResponse);
    }
}
