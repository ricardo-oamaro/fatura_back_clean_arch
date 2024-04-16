package br.com.fatura.core.domain;

import br.com.fatura.core.domain.enums.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @Test
    public void testConstructorWithAllParameters() {
        user = new User("1", "John Doe", "john@example.com", "password", "password", UserRole.USER) ;
        assertEquals("1", user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals("password", user.getConfirmPassword());
        assertEquals(UserRole.USER, user.getRole());
    }

    @Test
    public void testConstructorWithoutId() {
        user = new User("John Doe", "john@example.com", "password", "password", UserRole.USER) ;
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals("password", user.getConfirmPassword());
        assertEquals(UserRole.USER, user.getRole());
    }

    @Test
    public void testEmptyConstructor() {
        user = new User();
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        assertNull(user.getConfirmPassword());
    }


}