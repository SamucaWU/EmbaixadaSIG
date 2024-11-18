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
    public dadosPessoa(String nome, int idade, String rg, String cpf,String login,String senha,String nacionalidade,String dataDeNascimento, String codigo,int numeroTelefone, String entrada) {
//        Atributos da outra classe
        super(nome, idade, rg, cpf,login,senha,nacionalidade,dataDeNascimento,codigo,numeroTelefone,entrada);
        setSenha(senha);  // Cria o hash e salt para a senha

        // Formato de data
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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

        // Adição nova 17/11/2024
        Boolean first = false;
        Boolean second = false;

        String rg = "";
        String cpf = "";

        while(!first) {
            System.out.println("Digite seu número de RG:(7 caracteres)");

            rg = sc.nextLine();
            if (rg.length() == 7) {
                System.out.println("RG: " + rg);
                first = true;
                rg = rg.substring(0,1)+ "." + rg.substring(1,4)+ "." + rg.substring(4,7);

            } else {
                System.out.println("Error. Try again.\n");

            }
        }

        while(!second) {
            System.out.println("Digite seu CPF:(11 caracteres)");

            cpf = sc.nextLine();
            if (cpf.length() == 11) {
                System.out.println("CPF: " + cpf);
                second = true;
                cpf = cpf.substring(0,3) + "." +cpf.substring(3,6)+ "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
            } else {
                System.out.println("Error. Try again\n");

            }
        }


        System.out.println("Digite seu login:");
        String login = sc.nextLine();

        // Adição 17/11/2024
        Boolean senhaValida = false;

        while(!senhaValida) {

            System.out.println("Digite sua senha: (Only numbers)");
            if(sc.hasNextInt()) {
                 senha = sc.nextLine();
                senhaValida = true;
            } else {
                System.out.println("Error. Try again.");
                sc.next();
            }

        }
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

        sc.nextLine();

        // Adições novas 11/11/2024
        System.out.println("Sexo:");
        System.out.println("1.Masculino");
        System.out.println("2.Feminino");
        System.out.println("3.Outro");
        System.out.println("4.Prefiro não dizer");

        // Adição de Switch case e Scanner para sexo

        String sexo = sc.nextLine();

        switch(sexo) {
            case "1":
            System.out.println("\nSexo masculino");
            sexo = "Masculino";

            break;



            case "2":
                System.out.println("\nSexo feminino");
                sexo = "Feminino";

                break;


                case "3":
                    System.out.println("Digite seu sexo: ");
                    String sexo1 = sc.nextLine();
                    sexo = sexo1;
                    break;

            case "4":
                System.out.println("\nprefiro não dizer");
                sexo = "Prefiro não dizer";

            default:
                System.out.println("Error. Try again.");
                return;
        }

        // Código do País residente
        System.out.println("País Residente: ");
        String paisResidente = sc.nextLine();

        // Estado civíl
        System.out.println("Digite seu estado civíl: ");
        System.out.println("1. Solteiro");
        System.out.println("2. Casado");
        System.out.println("3. União estável");
        System.out.println("4. Divorciado");
        System.out.println("5. Viúvo");

        String estadoCivil = sc.nextLine();
        // Switch case de estado civíl
        switch (estadoCivil) {
            case "1":
                System.out.println("Solteiro");
                estadoCivil = "Solteiro";
                break;

            case "2":
                System.out.println("Casado");
                estadoCivil = "Casado";
                break;

            case "3":
                System.out.println("União estável");
                estadoCivil = "União estável";
                break;

            case "4":
                System.out.println("Divorciado");
                estadoCivil = "Divorciado";
                break;

            case "5":
                System.out.println("Viúvo");
                estadoCivil = "Viúvo";
                break;

            default:
                System.out.println("Error. Try again.");
                return;
        }


        System.out.println("Adicionado com Sucesso!");


        // forma de adicionar pessoas na classe dadosPessoas
        dadosPessoa ds = new dadosPessoa(nome,idade,rg,cpf,login,senha,nacionalidade,dataDeNascimento,codigo,numeroTelefone,"");
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


                    System.out.println("Serviços:\n"); // MOdificado 18/11/2024
                    System.out.println("1.");
                    System.out.println("2. Marcar Agendamento"); //adicionado 11/11/2024
                    System.out.println("3. Visualizar agendamento"); //adicionado 11/11/2024
                    System.out.println("4.");
                    System.out.println("0. Return");

                    int escolha = sc.nextInt();

                    switch (escolha) {
//                        1. Services
                        case 1:
                            System.out.println("Veja nossos serviços:");
                            System.out.println("alguma coisa");
                            System.out.println("Alguma coisa também");
                            System.out.println("Alguma outra coisa");
                            System.out.println("Dificil pensar ouvindo trippie redd aaaaaa");

                            System.out.println("\nQual serviço deseja acionar?");
                            break;
//                            Marcar Agendamento
                        case 2:
                            sc.nextLine();
                            if(dadosP.isEmpty()) {
                                System.out.println("Don´t have information.");
                                return;
                            }
                            System.out.println("Escreva o motivo do agendamento:(600 caracteres)");
                            String entrada = sc.nextLine();

                            // Se a entrada for maior que 600 caracteres, limita a 600
                            if (entrada.length() > 600) {
                                entrada = entrada.substring(0, 600);
                                System.out.println("Entrada foi limitada a 600 caracteres.");
                            }

                            System.out.println("Entrada final (máximo 600 caracteres):");
                            System.out.println(ds.getEntrada());
                            ds.setEntrada(entrada);

                            break;

                        case 3:
//                            ver agendamentos
                            System.out.println("\n Agendamento: ");
                            System.out.println("------------------");
                            System.out.println(ds.getEntrada());
                            System.out.println("------------------\n");
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
