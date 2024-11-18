import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*        -------MENU-------  */
        System.out.println("Welcome to the Mato\n");

        // Intanciando a classe dadosPessoa

        AgendamentoNew agenda = new AgendamentoNew("");
        dadosPessoa dp = new dadosPessoa("",0,"","", "","","","","",0,"");

        // loop de boolean e while
        Scanner sc = new Scanner(System.in);
        boolean real = true;
        while (real) {
            System.out.println("\nMake your choose: ");
            System.out.println("1.Add your information");
            System.out.println("2.Show your informations and services");
            System.out.println("0.Exit");

            int escolha = sc.nextInt();

            switch (escolha) {

                case 1:
                    dp.adicionarInformacoes();
                    break;
                case 2:
                    dp.mostrarInformacoes(dp.getLogin(), dp.getSalt());
                    break;
                case 3:
                    agenda.cadastrar();
                    break;
                case 4:
                    Search.listarAgendamentos();
                    break;
                case 5:
                    Process processo = Process.inserirProcesso(Search.dadosP,Search.agenda);
                    Search.cadastrarProcessos(processo);
                    break;
                case 0:
                    // Adicional meu msm
                    System.out.println("Antes de ir, gostariamos de ter sua avaliação");
                    System.out.print(" 1.★ ");
                    System.out.print(" 2.★★ ");
                    System.out.print(" 3.★★★ ");
                    System.out.print(" 4.★★★★ ");
                    System.out.print(" 5.★★★★★ ");

                    sc.nextLine();
                    String estrelinha = sc.nextLine();
                    switch (estrelinha) {
                        case "0":
                            System.out.println("Obrigado pela avaliação!");
                            break;
                        case "1":
                            System.out.println("★ - Muito ruim");
                            System.out.println("Obrigado pela avaliação!");
                            break;
                        case "2":
                            System.out.println("★★ - Ruim");
                            System.out.println("Obrigado pela avaliação!");
                            break;
                        case "3":
                            System.out.println("★★★ - Ok");
                            System.out.println("Obrigado pela avaliação!");
                            break;
                        case "4":
                            System.out.println("★★★★ - Bom");
                            System.out.println("Obrigado pela avaliação!");
                            break;
                        case "5":
                            System.out.println("★★★★★ - Muito bom");
                            System.out.println("Obrigado pela avaliação!");
                            break;

                        default:
                            System.out.println("Obrigado pela avaliação.");
                            break;
                    }

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