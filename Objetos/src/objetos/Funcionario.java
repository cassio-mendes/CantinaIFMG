
package objetos;

public class Funcionario {
    
    private String funcao;
    private String nome;
    private String CPF;
    private String turno;
    private double salario;

    public Funcionario(String funcao, String nome, String CPF, String turno, double salario) {
        this.funcao = funcao;
        this.nome = nome;
        this.CPF = CPF;
        this.turno = turno;
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTurno() {
        return turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
