/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package premiersoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Tarefas {

    public void porcentagemPorVaga(List<Candidato> listaCandidatos) {
        HashMap<String, Integer> candidatosVaga = new HashMap<String, Integer>();

        for (Candidato candidatoAtual : listaCandidatos) {
            if (!candidatosVaga.containsKey(candidatoAtual.getVaga())) {
                candidatosVaga.put(candidatoAtual.getVaga(), 1);
            } else {
                int count = candidatosVaga.get(candidatoAtual.getVaga());
                candidatosVaga.put(candidatoAtual.getVaga(), count + 1);
            }
        }

        int totalCandidatos = listaCandidatos.size();

        for (String vaga : candidatosVaga.keySet()) {
            int count = candidatosVaga.get(vaga);
            double porcentagem = (double) count / totalCandidatos * 100;
            System.out.println(vaga + " - " + String.format("%.2f", porcentagem) + "% dos candidatos");

        }
    }

    public String idadeMediaPorVaga(List<Candidato> listaCandidatos) {
        HashMap<String, Integer> candidatosVaga = new HashMap<String, Integer>();
        int countQA = 0;
        int countMobile = 0;
        int countWEB = 0;

        for (Candidato candidatoAtual : listaCandidatos) {
            if (candidatoAtual.getVaga().equals("QA")) {
                countQA++;
            } else {
                if (candidatoAtual.getVaga().equals("Web")) {
                    countWEB++;
                } else {
                    countMobile++;
                }
            }

            if (!candidatosVaga.containsKey(candidatoAtual.getVaga())) {
                candidatosVaga.put(candidatoAtual.getVaga(), Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
            } else {
                int somaIdades = candidatosVaga.get(candidatoAtual.getVaga());
                candidatosVaga.put(candidatoAtual.getVaga(), somaIdades + Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
            }
        }
        String resultado = "";
        for (String vaga : candidatosVaga.keySet()) {
            int count = 0;
            if (vaga.equals("QA")) {
                count = countQA;
            } else {
                if (vaga.equals("Web")) {
                    count = countWEB;
                } else {
                    count = countMobile;
                }
            }
            int somaIdades = candidatosVaga.get(vaga);
            double idadeMedia = (double) somaIdades / count;

            resultado += vaga + " - Idade média: " + String.format("%.2f", idadeMedia) + "\n";
        }
        return resultado;
    }

    public String candidatoMaisVelho(List<Candidato> listaCandidatos) {
        String resultado = "";
        HashMap<String, Integer> candidatosVaga = new HashMap<String, Integer>();

        for (Candidato candidatoAtual : listaCandidatos) {
            if (!candidatosVaga.containsKey(candidatoAtual.getVaga())) {
                candidatosVaga.put(candidatoAtual.getVaga(), Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
            } else {
                if (Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)) > candidatosVaga.get(candidatoAtual.getVaga())) {
                    candidatosVaga.put(candidatoAtual.getVaga(), Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
                }
            }
        }

        int totalCandidatos = listaCandidatos.size();

        for (String vaga : candidatosVaga.keySet()) {
            int maiorIdade = candidatosVaga.get(vaga);
            resultado += vaga +" - Maior idade: " + maiorIdade + " anos \n";

        }

        return resultado;
    }

    public String candidatoMaisNovo(List<Candidato> listaCandidatos) {
        String resultado = "";
        HashMap<String, Integer> candidatosVaga = new HashMap<String, Integer>();

        for (Candidato candidatoAtual : listaCandidatos) {
            if (!candidatosVaga.containsKey(candidatoAtual.getVaga())) {
                candidatosVaga.put(candidatoAtual.getVaga(), Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
            } else {
                if (Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)) < candidatosVaga.get(candidatoAtual.getVaga())) {
                    candidatosVaga.put(candidatoAtual.getVaga(), Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
                }
            }
        }

        int totalCandidatos = listaCandidatos.size();

        for (String vaga : candidatosVaga.keySet()) {
            int menorIdade = candidatosVaga.get(vaga);
            resultado += vaga + " - Menor idade: " + menorIdade + " anos \n";

        }

        return resultado;
    }

    public String somaIdadesPorVaga(List<Candidato> listaCandidatos) {
        HashMap<String, Integer> candidatosVaga = new HashMap<String, Integer>();

        for (Candidato candidatoAtual : listaCandidatos) {
            if (!candidatosVaga.containsKey(candidatoAtual.getVaga())) {
                candidatosVaga.put(candidatoAtual.getVaga(), Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
            } else {
                int somaIdades = candidatosVaga.get(candidatoAtual.getVaga());
                candidatosVaga.put(candidatoAtual.getVaga(), somaIdades + Integer.parseInt(candidatoAtual.getIdade().substring(0, 2)));
            }
        }
        String resultado = "";
        for (String vaga : candidatosVaga.keySet()) {

            int somaIdades = candidatosVaga.get(vaga);

            resultado += vaga + " - Soma idades: " + somaIdades + "\n";
        }
        return resultado;
    }

    public String qtdEstados(List<Candidato> listaCandidatos) {
        HashMap<String, Integer> candidatosVaga = new HashMap<String, Integer>();
        String result = "";
        int countEstados = 0;
        for (Candidato candidatoAtual : listaCandidatos) {
            if (!candidatosVaga.containsKey(candidatoAtual.getEstado())) {
                candidatosVaga.put(candidatoAtual.getEstado(), 1);
                countEstados++;
            }
        }
        result += "Existem " + countEstados + " Estados na lista.";
        return result;
    }

    public String descobrirQA(List<Candidato> listaCandidatos) {
        String result = "";

        for (Candidato candidato : listaCandidatos) {
            if (candidato.getVaga().equalsIgnoreCase("QA") && candidato.getEstado().equalsIgnoreCase("SC") && isQuadradoPerfeito(Integer.parseInt(candidato.getIdade().substring(0, 2)))
                    && isPalindromo(candidato.getNome().split(" ")[0])) {
                return candidato.getNome();        
            }
             
        }

        return result;
    }
    
    
    public String descobrirMobile(List<Candidato> listaCandidatos) {
        String result = "";

        for (Candidato candidato : listaCandidatos) {
            if (candidato.getVaga().equalsIgnoreCase("Mobile") && candidato.getEstado().equalsIgnoreCase("PI") && isPar(Integer.parseInt(candidato.getIdade().substring(0, 2)))
                    && inicialSobrenome(candidato.getNome().split(" ")[1])) {
                return candidato.getNome();        
            }
             
        }

        return result;
    }
    
    public boolean isPar(int idade){
        if (idade % 2 == 0 && idade >= 30 && idade <= 40){
            return true;
        }
        return false;
    }
    
    public boolean inicialSobrenome(String nome){
        String primeiraLetra = nome.substring(0,1);
        if (primeiraLetra.equalsIgnoreCase("C")){
            return true;
        }
            return false;
    }

    public static boolean isQuadradoPerfeito(int idade) {
        int raiz = (int) Math.sqrt(idade);
        return raiz * raiz == idade && idade >= 18 && idade <= 30;
    }

    public boolean isPalindromo(String nomeOriginal) {
        //nome = nome.split(" ")[0];
        String nomeInvertido = new StringBuilder(nomeOriginal).reverse().toString();
        return nomeInvertido.equalsIgnoreCase(nomeOriginal);
    }
}
