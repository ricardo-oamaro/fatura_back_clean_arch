package br.com.fatura.application.usecaseimpl;

import br.com.fatura.application.gateway.CreateUserGateway;
import br.com.fatura.core.domain.User;
import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.core.exception.enums.ErrorCodeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateUserUseCaseImplTest {

    private CreateUserGateway createUserGateway;
    private CreateUserUseCaseImpl createUserUseCaseImpl;

    @BeforeEach
    void setUp() {
        createUserGateway = mock(CreateUserGateway.class);
        createUserUseCaseImpl = new CreateUserUseCaseImpl(createUserGateway);
    }

    @Test
    void shouldCreateUserSuccessfully() throws InternalServerErrorException {
        User user = new User();
        when(createUserGateway.create(user)).thenReturn(true);

        assertDoesNotThrow(() -> createUserUseCaseImpl.create(user));
        verify(createUserGateway, times(1)).create(user);
    }

    @Test
    void shouldThrowInternalServerErrorExceptionWhenGatewayReturnsFalse() {
        User user = new User();
        when(createUserGateway.create(user)).thenReturn(false);

        InternalServerErrorException exception = assertThrows(InternalServerErrorException.class, () -> createUserUseCaseImpl.create(user));
        assertEquals(ErrorCodeEnum.ON0001.getMessage(), exception.getMessage());
        assertEquals(ErrorCodeEnum.ON0001.getCode(), exception.getCode());
        verify(createUserGateway, times(1)).create(user);
    }




}