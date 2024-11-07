import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

// Importação adicionada
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Random;

// Extendendo da classe abstrata seus atributos
public class dadosPessoa extends Abstrata{

    // ArrayList de dadoPessoa
    List<dadosPessoa> dadosP = new ArrayList<>();

    // Atributos para login e senha com hash e salt
    private String salt;
    private String senhaHash;

// construtor
    public dadosPessoa(String nome, int idade, String rg, String cpf,String login,String senha,String nacionalidade,String dataDeNascimento, String codigo,int numeroTelefone) {
//        Atributos da outra classe
        super(nome, idade, rg, cpf,login,senha,nacionalidade,dataDeNascimento,codigo,numeroTelefone);
        setSenha(senha);  // Cria o hash e salt para a senha

        // Formato de data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    }

    // Método para gerar o hash e salt da senha
    public void setSenha(String senha) {
        this.salt = gerarSalt();  // Gera o salt
        this.senhaHash = gerarHash(senha, this.salt);  // Cria o hash da senha com o salt
    }

    // Método para gerar um salt aleatório
    private String gerarSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];  // Salt com 16 bytes
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);  // Codifica o salt para Base64
    }

    // Método para gerar o hash da senha com o salt
    private String gerarHash(String senha, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());  // Aplica o salt
            byte[] hashedBytes = md.digest(senha.getBytes());  // Gera o hash da senha
            return Base64.getEncoder().encodeToString(hashedBytes);  // Retorna o hash em Base64
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar o hash", e);
        }
    }

    // Método para verificar se a senha fornecida bate com o hash armazenado
    public boolean verificarSenha(String senha) {
        String senhaHashTeste = gerarHash(senha, this.salt);  // Gera o hash para a senha fornecida com o salt
        return this.senhaHash.equals(senhaHashTeste);  // Compara os hashes
    }

    public void adicionarInformacoes() {

        // Importações em uso
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Random aleatorio = new Random();

        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite seu número de RG:");
        String rg = sc.nextLine();

        System.out.println("Digite seu CPF:");
        String cpf = sc.nextLine();

        System.out.println("Digite seu login:");
        String login = sc.nextLine();

        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();

        // Adicionados
        System.out.println("Digite sua nacionalidade:");
        String nacionalidade = sc.nextLine();

        System.out.println("Digite sua data de nascimento:");
        System.out.println("in these format(dd/MM/yyyy)");
        String dataDeNascimento = sc.nextLine();


        int cod = aleatorio.nextInt(9000) + 1000;
        String codigo = Integer.toString(cod);

        System.out.format("Esse é seu código: %s\n", codigo);

        System.out.println("Digite seu número de telefone:");
        int numeroTelefone = sc.nextInt();

        System.out.println("Adicionado com Sucesso!");


        // forma de adicionar pessoas na classe dadosPessoas
        dadosPessoa ds = new dadosPessoa(nome,idade,rg,cpf,login,senha,nacionalidade,dataDeNascimento,codigo,numeroTelefone);
        dadosP.add(ds);

    }

    public void show() {
        System.out.println("----- Informations -----");
        System.out.format("Name: %s\n", getNome());System.out.format("Age: %d\n", getIdade());
        System.out.format("RG: %s\n", getRg());
        System.out.format("CPF: %s\n", getCpf());
        System.out.format("Login: %s\n",getLogin());
        System.out.format("Nationality: %s\n", getNacionalidade());
        System.out.format("date of birth: %s\n",getDataDeNascimento());
        System.out.format("Code: %s\n", getCodigo());
        System.out.format("Phone: %d\n",getNumeroTelefone());
        System.out.println("------------------------");
    }

    // Método para mostrar as informações de um usuário autenticado
    public void mostrarInformacoes(String loginInput, String senhaInput) {
        Scanner sc = new Scanner(System.in);
        boolean autenticado = false;
        if(dadosP.isEmpty()) {
            System.out.println("Nobody added. Try again.");
            return;
        }

        System.out.println("Digite seu login:");
        loginInput = sc.nextLine();
        System.out.println("Digite sua senha:");
        senhaInput =sc.nextLine();

        for (dadosPessoa ds: dadosP){
            if (ds.getLogin().equals(loginInput) && ds.verificarSenha(senhaInput)) {
                autenticado = true;
                ds.show();  // Exibe as informações se o usuário for autenticado

                // Adicional Serviços para esse método
                boolean comeBack = true;
                while(comeBack) {

                    System.out.println("How can we help you?\n");
                    System.out.println("1. Services");
                    System.out.println("2. ");
                    System.out.println("3.");
                    System.out.println("4.");
                    System.out.println("0. Return");

                    int escolha = sc.nextInt();

                    switch (escolha) {
                        case 1:
                            System.out.println("Veja nossos serviços:");
                            System.out.println("alguma coisa");
                            System.out.println("Alguma coisa também");
                            System.out.println("Alguma outra coisa");
                            System.out.println("Dificil pensar ouvindo trippie redd aaaaaa");

                            System.out.println("\nQual serviço deseja acionar?");
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 0:
                            System.out.println("Returning...");
                            comeBack = false;

                            break;

                            default:
                            System.out.println("Something went wrong. Try again.");
                            break;
                    }
                }



                break;
            }

        }
        if (!autenticado) {
            System.out.println("Login ou senha incorretos. Tente novamente.");
            return;
        }

    }

    // Getters de hash e salt
    public String getSenhaHash() {
        return senhaHash;
    }

    public String getSalt() {
        return salt;
    }


}
