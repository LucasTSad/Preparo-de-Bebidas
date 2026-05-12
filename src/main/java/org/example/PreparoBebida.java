package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class PreparoBebida {

    protected final List<String> passos = new ArrayList<>();

    public final void preparar() {
        passos.clear();
        ferver();
        adicionar();
        servirNaXicara();
        if (clienteQuerAdicionais()) {
            adicionarExtras();
        }
    }

    // -- Passos comuns a todas as bebidas ----------------------------------

    private void ferver() {
        passos.add("Fervendo agua");
    }

    private void servirNaXicara() {
        passos.add("Servindo na xicara");
    }

    // -- Passos abstratos (obrigatorios nas subclasses) --------------------

    protected abstract void adicionar();

    // -- Hook: subclasses podem sobrescrever (opcional) -------------------

    protected boolean clienteQuerAdicionais() {
        return false;
    }

    protected void adicionarExtras() {}

    // -- Consulta ---------------------------------------------------------

    public List<String> getPassos() {
        return passos;
    }

    public abstract String getNome();
}