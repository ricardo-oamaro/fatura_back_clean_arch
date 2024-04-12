package br.com.fatura.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String email, String password);
}
