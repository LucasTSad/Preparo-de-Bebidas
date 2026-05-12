package org.example;

public class PreparoCha extends PreparoBebida {

    private final boolean comLimao;

    public PreparoCha(boolean comLimao) {
        this.comLimao = comLimao;
    }

    @Override
    protected void adicionar() {
        passos.add("Colocando sache de cha na agua");
    }

    @Override
    protected boolean clienteQuerAdicionais() {
        return comLimao;
    }

    @Override
    protected void adicionarExtras() {
        passos.add("Adicionando limao");
    }

    @Override
    public String getNome() {
        return "Cha";
    }
}