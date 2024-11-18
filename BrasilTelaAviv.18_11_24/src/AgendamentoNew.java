import java.util.Scanner;

public class AgendamentoNew {

    private final String motivo;

    //Construtor
    public AgendamentoNew(String motivo) {
        this.motivo = motivo;
    }

    //Getter
    public String getMotivo() {
        return motivo;
    }

    public static AgendamentoNew adicionarAgendamento() {
        Scanner sc = new Scanner(System.in);
        String motivo = null;
        Boolean motivoAutenticado = false;

        sc.nextLine();
        while (!motivoAutenticado) {
            System.out.println("Escreva o motivo do agendamento:(600 caracteres)");
            motivo = sc.nextLine();

            // Se a entrada for maior que 600 caracteres, limita a 600
            if (motivo.length() > 600) {
                motivo = motivo.substring(0, 600);
                System.out.println("Entrada foi limitada a 600 caracteres.");
                System.out.println("Try again.");
            } else {
                System.out.println("Motivo: " + motivo + "\n");
                System.out.println("Adicionado com sucesso!");
                motivoAutenticado = true;
                return new AgendamentoNew(motivo);
            }
        }
        return null;
    }

    public String showInformations() {
        System.out.println("Motivo: " + getMotivo());
        return null; // Sempre terá que retornar a valor nulo
    }

    public void cadastrar() {
        AgendamentoNew agenda = AgendamentoNew.adicionarAgendamento();
        Search.cadastrarAgendamento(agenda);
    }
}
