package com.brmsconnector.entity;

public class ValidacionOrden {
    private int idCategoriaCliente;
    private Long monto;

    public ValidacionOrden() {
    }

    public int getIdCategoriaCliente() {
        return idCategoriaCliente;
    }

    public void setIdCategoriaCliente(int idCategoriaCliente) {
        this.idCategoriaCliente = idCategoriaCliente;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }
}
