package br.com.fatura.infrastructure.dto.respose;

import java.util.List;

public record ErrorResponse(String code, String messge, List<ValidationError> validitions){}
