import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class marcarAgendamento extends Abstrata{
    List<dadosPessoa> dadosP = new ArrayList<>();
//   Construtor
    public marcarAgendamento(String nome, int idade, String rg, String cpf,String login,String senha,String nacionalidade,String dataDeNascimento, String codigo,int numeroTelefone, String entrada) {
        super(nome, idade, rg, cpf,login,senha,nacionalidade,dataDeNascimento,codigo,numeroTelefone,entrada);
    }
//    Classe feita para a adição de agendamento do usuário

    // Adicionado 11/11/2024
    public void agendamentoUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escreva o motivo do agendamento:(600 caracteres)");
        String entrada = sc.nextLine();

        // Se a entrada for maior que 600 caracteres, limita a 600
        if (entrada.length() > 600) {
            entrada = entrada.substring(0, 600);
            System.out.println("Entrada foi limitada a 600 caracteres.");
        }

        System.out.println("Entrada final (máximo 600 caracteres):");
        System.out.println(entrada);

        // Adicionar informações
        dadosPessoa ds = new dadosPessoa("",0,"","", "","","","","",0,entrada);
        dadosP.add(ds);
    }

    public void show() {
        System.out.println("Entrada");
        System.out.println(getEntrada());
    }


}
