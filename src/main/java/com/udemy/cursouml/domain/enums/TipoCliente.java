package com.udemy.cursouml.domain.enums;

import java.util.Arrays;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private int codigo;
    private String descricao;

    TipoCliente(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer codigo) {
        return codigo == null ? null : Arrays.stream(TipoCliente.values())
                .filter(tipoCliente -> tipoCliente.codigo == codigo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Codigo invalido : " + codigo));
    }
}
