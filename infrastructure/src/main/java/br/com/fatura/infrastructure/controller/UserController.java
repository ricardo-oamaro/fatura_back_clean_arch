package br.com.fatura.infrastructure.controller;

import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.infrastructure.dto.request.AuthenticateUserRequest;
import br.com.fatura.infrastructure.dto.request.CreateUserRequest;
import br.com.fatura.infrastructure.dto.respose.UserResponse;
import br.com.fatura.infrastructure.mapper.UserEntityMapper;
import br.com.fatura.infrastructure.mapper.UserMapper;
import br.com.fatura.infrastructure.repository.UserEntityRepository;
import br.com.fatura.infrastructure.service.util.JwtUtil;
import br.com.fatura.usecase.CreateUserUseCase;
import br.com.fatura.usecase.GetAllUsersUseCase;
import br.com.fatura.usecase.UserAuthenticateUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    JwtUtil jwtUtil;
    @Autowired
    private UserEntityMapper userEntityMapper;
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private UserAuthenticateUseCase userAuthenticateUseCase;


    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) throws InternalServerErrorException {
        log.info("Inicio da criação do usuário::UserController");
        createUserUseCase.create(userMapper.toUser(request));
        log.info("Usuário criado com sucesso::UserController");
        return ResponseEntity.ok().body("Usuário criado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticateUserRequest request) throws JSONException {
        JSONObject jsonResponse = new JSONObject();
        try {
            log.info("Autenticando usuário::UserController");
            var user = userEntityRepository.findByEmail(request.email());
            String userId = user.getId();
            String name = user.getName();
            String token = jwtUtil.generateToken(user);
            return ResponseEntity.ok().body(
                    Map.of(
                            "_id", userId,
                            "name", name,
                            "token", token
                    )
            );

        } catch (Exception e) {
            log.error("Erro ao autenticar usuário::UserController");
            return ResponseEntity.badRequest().body("Erro ao autenticar usuário");
        }

    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() throws InternalServerErrorException {
        log.info("Buscando todos os usuários::UserController");
        var users = getAllUsersUseCase.findAll();
        var userResponse = users.stream().map(user -> userEntityMapper.toUserResponse(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userResponse);
    }
}
