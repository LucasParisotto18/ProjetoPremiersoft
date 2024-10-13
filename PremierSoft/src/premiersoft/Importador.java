/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package premiersoft;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

/**
 *
 * @author Lucas
 */
public class Importador  {

    public List<Candidato> carregarDados(String caminhoArquivo) {
        List<Candidato> listaCandidatos = new ArrayList<>();

        File arquivo = new File(caminhoArquivo);

        try (Scanner sc = new Scanner(arquivo, "UTF-8")) {

            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            while (sc.hasNextLine()) {
                Candidato candidatoAtual = new Candidato();
                String linha = sc.nextLine();
                String[] dados = linha.split(";");

                candidatoAtual.setNome(dados[0]);
                candidatoAtual.setIdade(dados[1]);
                candidatoAtual.setVaga(dados[2]);
                candidatoAtual.setEstado(dados[3]);

                listaCandidatos.add(candidatoAtual);
            }
        } catch (Exception e) {
            System.err.println("Erro ao importar os dados do Arquivo CSV. \n" + e);
        }

        return listaCandidatos;
    }

    public static void ordenarCriarCSV(List<Candidato> candidatos) {
        candidatos.sort(Comparator.comparing(Candidato::getNome));

        try (FileWriter wr = new FileWriter("Sorted_Academy_Candidates.csv")) {
            wr.write("Nome;Vaga;Idade;Estado\n");
            for (Candidato c : candidatos) {
                wr.write(c.getNome() + "," + c.getVaga() + "," + c.getIdade() + "," + c.getEstado() + "\n");
            }
            System.out.println("Arquivo CSV ordenado e criado.");
            System.out.println("------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

}
