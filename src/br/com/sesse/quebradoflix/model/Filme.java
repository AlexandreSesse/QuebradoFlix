package br.com.sesse.quebradoflix.model;

import br.com.sesse.quebradoflix.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento, String diretor) {
        super(nome, anoDeLancamento);
        this.diretor = diretor;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao(){
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" +this.getAnoDeLancamento() + ")";
    }
}