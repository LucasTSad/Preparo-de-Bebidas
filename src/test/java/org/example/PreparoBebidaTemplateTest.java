package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PreparoBebidaTemplateTest {

    // -- Passos comuns a todas as bebidas ----------------------------------

    @Test
    void chaContemPassoFerverAgua() {
        PreparoBebida bebida = new PreparoCha(false);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Fervendo agua"));
    }

    @Test
    void cafeContemPassoFerverAgua() {
        PreparoBebida bebida = new PreparoCafe(false);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Fervendo agua"));
    }

    @Test
    void chocolateContemPassoFerverAgua() {
        PreparoBebida bebida = new PreparoChocolateQuente(false);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Fervendo agua"));
    }

    @Test
    void chaContemPassoServirNaXicara() {
        PreparoBebida bebida = new PreparoCha(false);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Servindo na xicara"));
    }

    // -- Passos especificos de cada bebida --------------------------------

    @Test
    void chaAdicionaSacheDeCha() {
        PreparoBebida bebida = new PreparoCha(false);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Colocando sache de cha na agua"));
    }

    @Test
    void cafeAdicionaCafeNoFiltro() {
        PreparoBebida bebida = new PreparoCafe(false);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Colocando cafe no filtro e coando"));
    }

    @Test
    void chocolateDissolveChocolateEmPo() {
        PreparoBebida bebida = new PreparoChocolateQuente(false);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Dissolvendo chocolate em po na agua"));
    }

    // -- Hook: adicionais opcionais ---------------------------------------

    @Test
    void chaComLimaoAdicionaLimao() {
        PreparoBebida bebida = new PreparoCha(true);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Adicionando limao"));
    }

    @Test
    void chaSemLimaoNaoAdicionaLimao() {
        PreparoBebida bebida = new PreparoCha(false);
        bebida.preparar();
        assertFalse(bebida.getPassos().contains("Adicionando limao"));
    }

    @Test
    void cafeComAcucarAdicionaAcucar() {
        PreparoBebida bebida = new PreparoCafe(true);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Adicionando acucar"));
    }

    @Test
    void cafeSemAcucarNaoAdicionaAcucar() {
        PreparoBebida bebida = new PreparoCafe(false);
        bebida.preparar();
        assertFalse(bebida.getPassos().contains("Adicionando acucar"));
    }

    @Test
    void chocolateComChantillyAdicionaChantilly() {
        PreparoBebida bebida = new PreparoChocolateQuente(true);
        bebida.preparar();
        assertTrue(bebida.getPassos().contains("Adicionando chantilly"));
    }

    @Test
    void chocolateSemChantillyNaoAdicionaChantilly() {
        PreparoBebida bebida = new PreparoChocolateQuente(false);
        bebida.preparar();
        assertFalse(bebida.getPassos().contains("Adicionando chantilly"));
    }

    // -- Ordem dos passos -------------------------------------------------

    @Test
    void primeiroPassoEFerverAgua() {
        PreparoBebida bebida = new PreparoCafe(false);
        bebida.preparar();
        assertEquals("Fervendo agua", bebida.getPassos().get(0));
    }

    @Test
    void ultimoPassoEServirNaXicaraSemAdicionais() {
        PreparoBebida bebida = new PreparoCha(false);
        bebida.preparar();
        var passos = bebida.getPassos();
        assertEquals("Servindo na xicara", passos.get(passos.size() - 1));
    }

    @Test
    void adicionaisVemDepoisDeServirNaXicara() {
        PreparoBebida bebida = new PreparoCha(true);
        bebida.preparar();
        var passos = bebida.getPassos();
        int idxServir  = passos.indexOf("Servindo na xicara");
        int idxLimao   = passos.indexOf("Adicionando limao");
        assertTrue(idxLimao > idxServir);
    }

    // -- Nome das bebidas -------------------------------------------------

    @Test
    void nomeDoChECha() {
        assertEquals("Cha", new PreparoCha(false).getNome());
    }

    @Test
    void nomeDoCafeECafe() {
        assertEquals("Cafe", new PreparoCafe(false).getNome());
    }

    @Test
    void nomeDoChocolateEChocolateQuente() {
        assertEquals("Chocolate Quente", new PreparoChocolateQuente(false).getNome());
    }
}