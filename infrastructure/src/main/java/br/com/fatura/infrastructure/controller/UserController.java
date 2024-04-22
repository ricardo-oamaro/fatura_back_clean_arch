package br.com.fatura.infrastructure.controller;

import br.com.fatura.core.exception.AuthenticateException;
import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.infrastructure.dto.request.AuthenticateUserRequest;
import br.com.fatura.infrastructure.dto.request.CreateUserRequest;
import br.com.fatura.infrastructure.dto.respose.BaseResponse;
import br.com.fatura.infrastructure.dto.respose.UserResponse;
import br.com.fatura.infrastructure.mapper.UserEntityMapper;
import br.com.fatura.infrastructure.mapper.UserMapper;
import br.com.fatura.infrastructure.repository.UserEntityRepository;
import br.com.fatura.usecase.user.CreateUserUseCase;
import br.com.fatura.usecase.user.GetAllUsersUseCase;
import br.com.fatura.usecase.item.auth.UserAuthenticateUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
@Slf4j
@CrossOrigin
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
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private UserAuthenticateUseCase userAuthenticateUseCase;


    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest request) throws InternalServerErrorException {
        log.info("Inicio da criação do usuário::UserController");
        createUserUseCase.create(userMapper.toUser(request));
        log.info("Usuário criado com sucesso::UserController");
        return ResponseEntity.ok().body("Usuário criado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticateUserRequest request) throws AuthenticateException {
        JSONObject jsonResponse = new JSONObject();
        log.info("Autenticando usuário::UserController");
        var user = userEntityRepository.findByEmail(request.email());
        String userId = user.getId();
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        String token = userAuthenticateUseCase.authenticate(email, password);
        return ResponseEntity.ok().body(
                jsonResponse.put("message", "Login realizado com sucesso")
                        .put("userId", userId)
                        .put("name", name)
                        .put("token", token)
                        .toString()
        );
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() throws InternalServerErrorException {
        log.info("Buscando todos os usuários::UserController");
        var users = getAllUsersUseCase.findAll();
        var userResponse = users.stream().map(user -> userEntityMapper.toUserResponse(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userResponse);
    }
}
