package com.udemy.cursouml.domain.enums;

import java.util.Arrays;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int codigo;
    private String descricao;

    EstadoPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer codigo) {
        return codigo == null ? null : Arrays.stream(EstadoPagamento.values())
                .filter(estadoPagamento -> estadoPagamento.codigo == codigo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Codigo invalido : " + codigo));
    }
}
