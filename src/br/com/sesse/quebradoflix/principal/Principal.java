package br.com.sesse.quebradoflix.principal;

import br.com.sesse.quebradoflix.calculos.CalculadoraDeTempo;
import br.com.sesse.quebradoflix.calculos.FiltroRecomendacao;
import br.com.sesse.quebradoflix.model.Epsodio;
import br.com.sesse.quebradoflix.model.Filme;
import br.com.sesse.quebradoflix.model.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso Chefão", 1970,"José");
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());
        //meuFilme.somaDasAvaliacoes = 10;
        //meuFilme.totalDeAvaliacoes = 1;
        //System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost", 2000,10);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2023,"Maria");
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Epsodio epsodio = new Epsodio();
        epsodio.setNumero(1);
        epsodio.setSerie(lost);
        epsodio.setTotalVisualizacoes(300);
        filtro.filtra(epsodio);

        var filme3 = new Filme("DogVille", 2003, "Maria José");
        filme3.setDuracaoEmMinutos(200);
        filme3.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho da lista "+ listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());

        System.out.println(listaDeFilmes);
    }
}