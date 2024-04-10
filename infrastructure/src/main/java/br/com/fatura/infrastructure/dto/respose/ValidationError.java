package br.com.fatura.infrastructure.dto.respose;

public record ValidationError(String field, String message) {
}
