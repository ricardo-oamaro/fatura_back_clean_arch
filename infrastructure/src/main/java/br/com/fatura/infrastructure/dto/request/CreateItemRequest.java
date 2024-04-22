package br.com.fatura.infrastructure.dto.request;

public record CreateItemRequest(String date, String description, Double value) {
}
