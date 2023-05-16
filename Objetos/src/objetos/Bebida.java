
package objetos;

import java.util.Calendar;
import java.util.Date;

public class Bebida {
    
    //Propriedades
    private String nome;
    private double volume;
    private double preco;
    private String descricao;
    private Date validade;
    private String temperatura;
    private int quantDisponivel;

    //Construtores
    public Bebida(String nome, double volume, double preco, Date validade, int quantDisponivel) {
        this.nome = nome;
        this.volume = volume;
        this.preco = preco;
        this.validade = validade;
        this.quantDisponivel = quantDisponivel;
    }

    public Bebida(String nome, double volume, double preco, String descricao, Date validade, String temperatura, int quantDisponivel) {
        this.nome = nome;
        this.volume = volume;
        this.preco = preco;
        this.descricao = descricao;
        this.validade = validade;
        this.temperatura = temperatura;
        this.quantDisponivel = quantDisponivel;
    }
    
    public Bebida(String nome, double volume, double preco, int quantDias, int quantDisponivel) {
        this.nome = nome;
        this.volume = volume;
        this.preco = preco;
        
        //Calculando a data de vencimento da bebida
        Calendar calendario = Calendar.getInstance(); //11/05/2023 07:57:00
        calendario.add(Calendar.DAY_OF_MONTH, quantDias);
        
        this.validade = calendario.getTime();
        this.quantDisponivel = quantDisponivel;
    }

    //Encapsulamento
    public String getNome() {
        return nome;
    }

    public double getVolume() {
        return volume;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getValidade() {
        return validade;
    }

    public String getTemperatura() {
        return temperatura;
    }
    
    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setQuantDisponivel(int quantDisponivel) {
        this.quantDisponivel = quantDisponivel;
    }
    
    public String toString() {
        return this.nome + ": R$" + this.preco;
    }
    
}