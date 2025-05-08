package br.com.sesse.quebradoflix.calculos;

import com.sun.security.jgss.GSSUtil;

public class FiltroRecomendacao {
    private String recomendacao;


    public void filtra (Classificavel classificavel){
        if(classificavel.getClassificacao() >= 4){
            System.out.println("Está entre os preferidos do momento");
        } else if (classificavel.getClassificacao() >= 2){
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Adicione na sua lista para assistir depois");
        }
    }
}
