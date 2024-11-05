import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


// Extendendo da classe abstrata seus atributos
public class dadosPessoa extends Abstrata{

    // ArrayList de dadoPessoa
    List<dadosPessoa> dadosP = new ArrayList<>();

// construtor
    public dadosPessoa(String nome, int idade, String rg, String cpf) {
//        Atributos da outra classe
        super(nome, idade, rg, cpf);
    }

    public void adicionarInformacoes() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite seu número de RG:");
        String rg = sc.nextLine();

        System.out.println("Digite seu CPF:");
        String cpf = sc.nextLine();

        // forma de adicionar pessoas na classe dadosPessoas
        dadosPessoa ds = new dadosPessoa(nome,idade,rg,cpf);
        dadosP.add(ds);

    }

    public void show() {
        System.out.println("----- Informations -----");
        System.out.format("Name: %s\n", getNome());System.out.format("Age: %d\n", getIdade());
        System.out.format("RG: %s\n", getRg());
        System.out.format("CPF: %s\n", getCpf());
    }
    public void mostrarInformacoes() {
        if(dadosP.isEmpty()) {
            System.out.println("Nobody added. Try again.");
            return;
        }
        for (dadosPessoa ds: dadosP){
            ds.show();

        }

    }


}
