/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package premiersoft;

/**
 *
 * @author Lucas
 */
public class Candidato {

    private String nome;
    private String Idade;
    private String vaga;
    private String estado;

    public Candidato(String nome, String Idade, String vaga, String estado) {
        this.nome = nome;
        this.Idade = Idade;
        this.vaga = vaga;
        this.estado = estado;
    }

    public Candidato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String Idade) {
        this.Idade = Idade;
    }

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String resultado = "";
        //Candidato atual = 
        resultado += getNome() + ";" + getIdade() + ";" + getVaga() + ";" + getEstado();
        return resultado;
    }

}
