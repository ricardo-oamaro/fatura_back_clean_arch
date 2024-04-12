package br.com.fatura.infrastructure.dto.request;

public record AuthenticateUserRequest(String email, String password) {
}
