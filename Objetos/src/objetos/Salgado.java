
package objetos;

public class Salgado {
    
    //Propriedades
    private double preço;
    private String descricao;
    private String nome;
    private String tipo;
    private int minutosExposição = 0;
    private int quantiLote;
    private char tamanho;
    
    //Construtor
    public Salgado(double preço, String descricao, String nome, String tipo, int quantiLote, char tamanho) {
        this.preço = preço;
        this.descricao = descricao;
        this.nome = nome;
        this.tipo = tipo;
        this.quantiLote = quantiLote;
        this.tamanho = tamanho;
    }
    
    //Encapsulamento
    public double getPreço() {
        return preço;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getMinutosExposição() {
        return minutosExposição;
    }

    public char getTamanho() {
        return tamanho;
    }
    
    public int getQuantiLote() {
        return quantiLote;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public void setMinutosExposição(int minutosExposição) {
        this.minutosExposição = minutosExposição;
    }

    public void setQuantiLote(int quantiLote) {
        this.quantiLote = quantiLote;
    }
    
    //Método toString
    public String toString() {
        return this.nome + ": R$" + this.preço;
    }
    
    public void atualizaQuant1Venda() {
        this.quantiLote--;
    }
    
}