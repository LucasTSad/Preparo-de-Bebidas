package org.example;

public class PreparoCafe extends PreparoBebida {

    private final boolean comAcucar;

    public PreparoCafe(boolean comAcucar) {
        this.comAcucar = comAcucar;
    }

    @Override
    protected void adicionar() {
        passos.add("Colocando cafe no filtro e coando");
    }

    @Override
    protected boolean clienteQuerAdicionais() {
        return comAcucar;
    }

    @Override
    protected void adicionarExtras() {
        passos.add("Adicionando acucar");
    }

    @Override
    public String getNome() {
        return "Cafe";
    }
}