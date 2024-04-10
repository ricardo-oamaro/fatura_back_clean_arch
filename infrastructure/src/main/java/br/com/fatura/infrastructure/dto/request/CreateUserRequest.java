package br.com.fatura.infrastructure.dto.request;

import br.com.fatura.core.domain.enums.UserRole;


public record CreateUserRequest(String name, String email, String password, String confirmPassword, UserRole role) {
}
