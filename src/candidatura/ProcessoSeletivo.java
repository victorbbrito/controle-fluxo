package candidatura;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    
    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        ArrayList<Candidato> selecionados = selecaoCandidatos();

        for (int i = 0; i < selecionados.size(); i++){
            entrarEmContato(selecionados.get(i));
        }
    }

    static void entrarEmContato(Candidato candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }
            else{
                System.out.println("Contato Realizado com "+ candidato.nome);
            }
        }while(continuarTentando && tentativasRealizadas <3);
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    public static ArrayList<Candidato> selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","PEDRO","RODRIGO","AMANDA","JORGE","BEATRIZ"};

        // declarando um novo array de candidatos.
        ArrayList<Candidato> selecionados = new ArrayList<Candidato>();

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);

            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                Candidato candidatoSelecioando = new Candidato(candidato, salarioPretendido);
                selecionados.add(candidatoSelecioando);
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }

        System.out.println("\nLista de Selecionados:");
        for (int i = 0; i < selecionados.size(); i++){
            System.out.println(selecionados.get(i));
        }
        System.out.println();

        return selecionados;
        
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        else if (salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
