/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package premiersoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class PremierSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        Importador imp = new Importador();
        Tarefas tarefa = new Tarefas();
        String caminhoCSV;
        //String caminhoCSV = "C:\\Users\\Lucas\\Desktop\\Faculdade\\Academy_Candidates.csv";
        List<Candidato> listaCandidatos = new ArrayList<Candidato>();
        List<Candidato> listaCandidatosOrdenados = new ArrayList<>(listaCandidatos);

        System.out.println("Informe o caminho do CSV que deve ser lido:");
        System.out.println("Ex.: C:\\Users\\Lucas\\Desktop\\Faculdade\\Academy_Candidates.csv ");
        caminhoCSV = teclado.nextLine();
        listaCandidatos = imp.carregarDados(caminhoCSV);

        System.out.println("Porcentagem Candidatos por vaga: \n");
        tarefa.porcentagemPorVaga(listaCandidatos);
        System.out.println("------------------------");

        
        String retorno = tarefa.idadeMediaPorVaga(listaCandidatos);
        String[] linhas = retorno.split("\n");
        System.out.println("Idade média dos candidatos de QA: \n");
        for (String linha : linhas) {
            if (linha.startsWith("QA")) {
                System.out.println(linha);
            }
        }
        System.out.println("------------------------");

        
        retorno = tarefa.candidatoMaisVelho(listaCandidatos);
        linhas = retorno.split("\n");
        System.out.println("Idade do candidato mais velho de Mobile: \n");
        for (String linha : linhas) {
            if (linha.startsWith("Mobi")) {
                System.out.println(linha);
            }
        }
        System.out.println("------------------------");

        
        
        retorno = tarefa.candidatoMaisNovo(listaCandidatos);
        linhas = retorno.split("\n");
        System.out.println("Idade do candidato mais novo de Web: \n");
        for (String linha : linhas) {
            if (linha.startsWith("Web")) {
                System.out.println(linha);
            }
        }
        System.out.println("------------------------");
 
        
        retorno = tarefa.somaIdadesPorVaga(listaCandidatos);
        linhas = retorno.split("\n");
        System.out.println("Soma das idades dos candidatos de QA: \n");
        for (String linha : linhas) {
            if (linha.startsWith("QA")) {
                System.out.println(linha);
            }
        }
        System.out.println("------------------------");

        
        System.out.println("Quantidade de Estados distintos: \n");
        System.out.println(tarefa.qtdEstados(listaCandidatos));
        System.out.println("------------------------");

        //Método que ordena o array e cria um arquivo CSV:
        imp.ordenarCriarCSV(listaCandidatos);
        
        
        System.out.println("Nome do Instrutor de QA: \n");
        System.out.println(tarefa.descobrirQA(listaCandidatos));
        System.out.println("------------------------");

        
        System.out.println("Nome do Instrutor de Mobile: \n");
        System.out.println(tarefa.descobrirMobile(listaCandidatos));
        System.out.println("------------------------");

    }
}
