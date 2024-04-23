package br.com.fatura.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Houve um erro na criação do usuário", "ON-0001"),
    ON0002("Houve um erro retornar os usuários", "ON-0002"),
    AUTH0001("Usuário ou senha inválidos", "AUTH-0001"),
    ITM0001( "Houve um erro na criação do item", "ITM-0001"),
    ITEM_ERROR01("Houve um erro ao buscar os itens", "ITEM-ERROR-01"),;

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
