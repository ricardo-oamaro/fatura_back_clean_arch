package br.com.fatura.infrastructure.config;

import br.com.fatura.application.gateway.CreateUserGateway;
import br.com.fatura.application.usecaseimpl.CreateUserUseCaseImpl;
import br.com.fatura.usecase.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(createUserGateway);
    }
}
