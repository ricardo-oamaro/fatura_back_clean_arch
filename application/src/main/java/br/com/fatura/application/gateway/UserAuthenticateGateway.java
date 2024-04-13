package br.com.fatura.application.gateway;

public interface UserAuthenticateGateway {
    String authenticate(String email, String password);
}
