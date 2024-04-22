package br.com.fatura.infrastructure.config;

import br.com.fatura.application.gateway.CreateItemGateway;
import br.com.fatura.application.usecaseimpl.CreateItemUseCaseImpl;
import br.com.fatura.usecase.item.CreateItemUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    public CreateItemUseCase createItemUseCase(CreateItemGateway createItemGateway) {
        return new CreateItemUseCaseImpl(createItemGateway);
    }
}