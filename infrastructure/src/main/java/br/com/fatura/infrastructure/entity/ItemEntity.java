package br.com.fatura.infrastructure.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "items")
public class ItemEntity {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String date;
    @NotBlank(message = "A descrição não pode ser vazio")
    private String description;
    @NotBlank(message = "O valor não pode ser vazio")
    private double value;

    public ItemEntity(String date, String description, double value) {
        this.date = date;
        this.description = description;
        this.value = value;
    }
}
