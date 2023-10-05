import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        
        int parametroUm = terminal.nextInt();
        int parametroDois = terminal.nextInt();

        terminal.close();
        
        try{
            contar(parametroUm,parametroDois);
        }
        catch ( ParametrosInvalidosException e){
            System.err.println(e.getMessage());
        }
    }

    static void contar(int num1, int num2) throws ParametrosInvalidosException{
        if(num2 > num1){
            int contagem = num2 - num1;

            for (int i=1; i < contagem; i++){
                System.out.println("Imprimindo o número "+ i);
            }
        }
        else{
           throw new ParametrosInvalidosException();
        }

    }
}
