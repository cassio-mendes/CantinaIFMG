
package objetos;

public class Cliente {

    private String CPF;
    private String nome;
    private String cargo; //Valores de débito diferentes para alunos e professores
    private String telefone;
    private double saldo;
    private String endereco;

    public Cliente(String CPF, String nome, String cargo, String telefone, String endereco) {
        this.CPF = CPF;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.saldo = 200;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void realizaPagamento(double valor) {
        this.saldo -= valor;
    }
    
}
