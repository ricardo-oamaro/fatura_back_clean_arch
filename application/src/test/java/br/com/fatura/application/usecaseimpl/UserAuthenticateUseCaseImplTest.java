package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.UserAuthenticateGateway;
import br.com.fatura.core.exception.AuthenticateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserAuthenticateUseCaseImplTest {

    private UserAuthenticateUseCaseImpl userAuthenticateUseCaseImpl;
    private UserAuthenticateGateway userAuthenticateGateway;


    @BeforeEach
    void setUp() {
        userAuthenticateGateway = mock(UserAuthenticateGateway.class);
        userAuthenticateUseCaseImpl = new UserAuthenticateUseCaseImpl(userAuthenticateGateway);
    }

    @Test
    void shouldAuthenticateSuccessfully() {
        String email = "user@teste.com";
        String password = "123";
        String result = "User found";
        when(userAuthenticateGateway.authenticate(email, password)).thenReturn(result);

        assertDoesNotThrow(() -> userAuthenticateUseCaseImpl.authenticate(email, password));
    }

    @Test
    void shouldThrowAuthenticateExceptionWhenUserNotFound() {
        String email = "user@teste.com";
        String password = "123";
        String result = "User not found";
        when(userAuthenticateGateway.authenticate(email, password)).thenReturn(result);

        assertThrows(AuthenticateException.class, () -> userAuthenticateUseCaseImpl.authenticate(email, password));
    }





}