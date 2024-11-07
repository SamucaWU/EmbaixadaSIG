public abstract class Abstrata {

/* classe que será usada para poder puxar dados para outras
 classes */

    private String nome;
    private int idade;
    private String rg;
    private String cpf;
    private String login;
    private String senha;

    // Informações adicionais
    private String nacionalidade;
    private String dataDeNascimento;
    private String codigo;
    private int numeroTelefone;



    public Abstrata(String nome, int idade, String rg, String cpf,String login, String senha,String nacionalidade,String dataDeNascimento,String codigo,int numeroTelefone) {
        this.nome = nome;
        this.idade = idade;
        this.rg = rg;
        this.cpf = cpf;
        this.login = login;

        // Adicionados
        this.nacionalidade = nacionalidade;
        this.dataDeNascimento = dataDeNascimento;
        this.codigo = codigo;
        this.numeroTelefone = numeroTelefone;


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Métodos getters
    public String getLogin() {
        return login;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }
}
