package br.com.fatura.infrastructure.entity;

import br.com.fatura.core.domain.enums.UserRole;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class UserEntity {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 30, message = "O campo deve ter entre 3 e 30 caracteres")
    private String name;

    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "Por favor, forneça um endereço de e-mail válido")
    private String email;

    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A senha não pode ser vazio")
    private String password;

    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "Confirme a senha")
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserEntity(String name, String email, String password, String confirmPassword, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public UserEntity(String id, String name, String email, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }
}


