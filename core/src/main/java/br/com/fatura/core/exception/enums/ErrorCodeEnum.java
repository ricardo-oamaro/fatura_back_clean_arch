package br.com.fatura.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Houve um erro na criação do usuário", "ON-0001"),
    ON0002("Houve um erro retornar os usuários", "ON-0002");

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
