import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Process {
    private final AgendamentoNew agenda4;
    private final dadosPessoa dadosPesso4;

    public Process(AgendamentoNew agenda4, dadosPessoa dadosPesso4) {
        this.agenda4 = agenda4;
        this.dadosPesso4 = dadosPesso4;
    }

    public static Process inserirProcesso(List<dadosPessoa> dadosP, List<AgendamentoNew> agenda) {
        Scanner sc = new Scanner(System.in);

        dadosPessoa dadoSelecionado = null;
        Boolean rodando = false;

        while (!rodando) {
            System.out.println("Adicione usuário: ");
            for (int i = 0; i < dadosP.size(); i++) {
                System.out.println((i + 1) + ". " + dadosP.get(i).getNome());
            }

            while (dadoSelecionado == null) {
                int escolhaDado = sc.nextInt();
                sc.nextLine();
                if (escolhaDado >= 1 && escolhaDado <= dadosP.size()) {
                    dadoSelecionado = dadosP.get(escolhaDado - 1);
                    rodando = true;
                } else {
                    System.out.println("Error. Try again.");
                }
            }
        }
        // Verificação de login e senha
        String login = null;
        int senha = 0;

        sc.nextLine();
        System.out.println("Digite o login: ");
        login = sc.nextLine();
        System.out.println("Digite a senha");
        senha = sc.nextInt();

        if (dadosP.equals(login) && dadosP.equals(senha)) {
            System.out.println("Acesso com sucesso!");

            // Adição da agenda caso login e senha feito com sucesso
            System.out.println("Adicione agenda: ");
            for (int i = 0; i < agenda.size(); i++) {
                System.out.println((i + 1) + ". " + agenda.get(i).getMotivo());
            }

            AgendamentoNew agendaSelecionada = null;
            while (agendaSelecionada == null) {
                int escolhaAgenda = sc.nextInt();
                sc.nextLine();
                if (escolhaAgenda >= 1 && escolhaAgenda <= agenda.size()) {
                    agendaSelecionada = agenda.get(escolhaAgenda - 1);

                    return new Process(agendaSelecionada,dadoSelecionado);
                } else {
                    System.out.println("Error. Try again.");
                    return null;
                }
            }

        } else {
            System.out.println("Error. Try again.");
        }

        return null;
    }

}




