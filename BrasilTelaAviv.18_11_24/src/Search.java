import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

public class Search {
    /* ArrayList´s das classes*/
    public static List<dadosPessoa> dadosP = new ArrayList<>();
    public static List<AgendamentoNew> agenda = new ArrayList<>();
    public static List<Process> processos = new ArrayList<>();


    // void´s de adicionar informações
    public static void cadastrarDadosPessoa(dadosPessoa dadosPesso4) {
        dadosP.add(dadosPesso4);
    }

    public static void cadastrarAgendamento(AgendamentoNew agenda4) {
        agenda.add(agenda4);
    }

    public static void cadastrarProcessos(Process processo) {
        processos.add(processo);
    }

    /**
     * Método para buscar o primeiro objeto que corresponde ao predicado fornecido.
     *  list      Lista de objetos a ser pesquisada.
     *  predicate Condição para a busca.
     *  <T>       Tipo dos objetos na lista.
     *  Um Optional contendo o objeto encontrado, ou um Optional vazio se não for encontrado.
     */

    public static <T> Optional<T> findFirst(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst();
    }

    public static void listarAgendamentos() {
        System.out.println("Agendamentos: ");
        System.out.println("=============");
        for(int i = 0; i < Search.agenda.size();i++) {
            System.out.println((i + 1) + " - " + Search.agenda.get(i).getMotivo());
        }
        System.out.println("=============");
    }

}
