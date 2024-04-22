package br.com.fatura.infrastructure.validation;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SecurityConfigurationTest {

    @Mock
    HttpSecurity httpSecurity;
    @Mock
    SecurityFilter securityFilter;
    @InjectMocks
    SecurityConfiguration securityConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        securityConfiguration = new SecurityConfiguration();
    }


    @Test
    void corsConfigurationSource() {
        CorsConfigurationSource corsConfigurationSource = securityConfiguration.corsConfigurationSource();

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader(any())).thenReturn("http://localhost:8080");

        CorsConfiguration corsConfiguration = corsConfigurationSource.getCorsConfiguration(request);

        assertNotNull(corsConfiguration);
        assertEquals(List.of("http://localhost:8080"), corsConfiguration.getAllowedOrigins());
        assertEquals(List.of("GET", "POST", "PUT", "DELETE"), corsConfiguration.getAllowedMethods());
        assertEquals(List.of("Authorization", "Content-Type"), corsConfiguration.getAllowedHeaders());
    }

    @Test
    void authenticationManager() {
    }

    @Test
    void passwordEncoder() {
    }
}