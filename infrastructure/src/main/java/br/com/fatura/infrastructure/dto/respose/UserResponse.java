package br.com.fatura.infrastructure.dto.respose;

import br.com.fatura.core.domain.enums.UserRole;
import lombok.Data;

@Data
public class UserResponse {

    private String name;
    private String email;
    private UserRole role;
}
