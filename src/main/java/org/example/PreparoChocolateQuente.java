package org.example;

public class PreparoChocolateQuente extends PreparoBebida {

    private final boolean comChantilly;

    public PreparoChocolateQuente(boolean comChantilly) {
        this.comChantilly = comChantilly;
    }

    @Override
    protected void adicionar() {
        passos.add("Dissolvendo chocolate em po na agua");
    }

    @Override
    protected boolean clienteQuerAdicionais() {
        return comChantilly;
    }

    @Override
    protected void adicionarExtras() {
        passos.add("Adicionando chantilly");
    }

    @Override
    public String getNome() {
        return "Chocolate Quente";
    }
}