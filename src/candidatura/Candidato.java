package candidatura;

public class Candidato {
    public String nome;
    public double salario;

    public Candidato(){
        
    }

    public Candidato(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public String toString(){
        return this.nome + " com salario de R$" + String.format("%.2f",this.salario);
    }
}
