package br.com.sesse.quebradoflix.principal;
import br.com.sesse.quebradoflix.model.Filme;
import br.com.sesse.quebradoflix.model.Serie;
import br.com.sesse.quebradoflix.model.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso Chefão", 1970,"José");
        meuFilme.avalia(9);

        var filme3 = new Filme("DogVille", 2003, "Maria José");
        filme3.avalia(6);

        Serie lost = new Serie("Lost", 2000,10);
        lost.avalia(10);

        Filme outroFilme = new Filme("Avatar", 2023,"Maria");
        outroFilme.avalia(10);

        Filme f1 = filme3;

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(filme3);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista){
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2){
            System.out.println("Classificação " +((Filme) item).getClassificacao());
            }
        }
    }
}
