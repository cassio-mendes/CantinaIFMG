
package objetos;

import java.util.Date;
import java.util.Vector;

public class Pedido {
    private Cliente fregues;
    private Vector<Salgado> salgados;
    private Vector<Bebida> bebidas;
    private double precoTotal;
    private Date diaPedido;
    private Funcionario atendente;

    public Pedido(Cliente fregues, Funcionario atendente) {
        this.fregues = fregues;
        this.atendente = atendente;
        this.precoTotal = 0.0;
        this.salgados = new Vector<>();
        this.bebidas = new Vector<>();
        this.diaPedido = new Date();  //Requere o dia, a hora, os minutos e os segundos atuais do SO
    }
    
    public void addSalgado(Salgado novo) {
        if(this.fregues.getSaldo() >= (this.precoTotal + novo.getPreço())) {  //Avaliando se o cliente possui saldo suficiente para o salgado:
            this.salgados.add(novo);
            this.precoTotal += novo.getPreço();
            novo.atualizaQuant1Venda(); 
        } else {
            System.err.println("Voce nao possui mais saldo para add. esse salgado");
        }  
    }
    
    public void addBebida(Bebida nova) {
        if(this.fregues.getSaldo() >= (this.precoTotal + nova.getPreco())) {  //Avaliando se o cliente possui saldo suficiente para a bebida:
            this.bebidas.add(nova);
            this.precoTotal += nova.getPreco();
        } else {
            System.err.println("Voce nao possui mais saldo para add. essa bebida");
        }
    }
    
    public void imprimePedido() {
        System.out.println("\nProdutos comprados: ");
        System.out.println(this.salgados);
        System.out.println(this.bebidas);
        System.out.println("Valor total do pedido: R$" + this.precoTotal);
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
    
}