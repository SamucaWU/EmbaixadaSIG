import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*        -------MENU-------  */
        System.out.println("Welcome to the Mato\n");

        // Intanciando a classe dadosPessoa
        dadosPessoa dp = new dadosPessoa("",0,"","");

        // loop de boolean e while
        Scanner sc = new Scanner(System.in);
        boolean real = true;
        while (real) {
            System.out.println("\nMake your choose: ");
            System.out.println("1.Add your information");
            System.out.println("2.Show your informations");
            System.out.println("0.Exit");

            int escolha = sc.nextInt();

            switch (escolha) {

                case 1:
                    dp.adicionarInformacoes();
                    break;
                case 2:
                    dp.mostrarInformacoes();
                    break;
                case 0:
                    System.out.println("Saindo do Sistema...");
                    real = false;
                    sc.close();

                    break;

                default:
                    System.out.println("Don´t worked. Try again");
                    return;

            } // switch

        } // while
    } // psvm
} // main