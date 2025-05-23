package br.com.sesse.quebradoflix.principal;

import br.com.sesse.quebradoflix.excecao.ErroDeConversaoDeAnoException;
import br.com.sesse.quebradoflix.model.Titulo;
import br.com.sesse.quebradoflix.model.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        ArrayList<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equals("Sair")){

            System.out.println("Digite o nome de um filme: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("Sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t="+busca.replace(" ", "+")+"&apikey=aa3d317a";

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo convertido");
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);

            }catch (NumberFormatException e){
                System.out.println("Aconteceu um erro");
                System.out.println(e.getMessage());
            }catch (ErroDeConversaoDeAnoException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("Finalizado corretamente");
    }
}