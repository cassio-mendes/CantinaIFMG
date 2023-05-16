
package objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class FakeBD {
    
    //Tentativa de emular um banco de dados para a aplicação
    
    private Vector<Cliente> tabelaCliente;
    private Vector<Salgado> tabelaSalgados;
    private Vector<Bebida> tabelaBebidas;
    private Vector<Funcionario> tabelaFuncionarios;
    private Vector<Pedido> tabelaPedidos;
    
    public FakeBD() {
        this.tabelaCliente = new Vector<>();
        this.tabelaSalgados = new Vector<>();
        this.tabelaBebidas = new Vector<>();
        this.tabelaFuncionarios = new Vector<>();
        this.tabelaPedidos = new Vector<>();
        
        addProdutosTeste();
        addClientes();
        addFuncionarios();
    }
    
    private void addProdutosTeste() {
        this.tabelaSalgados.add(new Salgado(5, "O melhor pastel de carne", "Pastel de carne", "Frito", 3, 'M'));
        this.tabelaSalgados.add(new Salgado(9, "Hamb. sensacional!", "Hamburguer", "Assado", 2, 'G'));
        this.tabelaSalgados.add(new Salgado(3, "Feito na hora", "Pao de queijo", "Assado", 10, 'M'));
        this.tabelaBebidas.add(new Bebida("Cafe P", 200, 1, 1, 6));
        this.tabelaBebidas.add(new Bebida("Cafe M", 400, 2, 1, 5));
                
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/YYYY");
        
        try{
            this.tabelaBebidas.add(new Bebida("Coca-Cola", 175, 2.5, formatadorData.parse("18/05/2025"), 0));
        }catch(ParseException ex) {
            System.err.println("Data fora do padrão definido na aplicação");
        }
    }
    
    private void addClientes() {
        this.tabelaCliente.add(new Cliente("12345678910", "Saulo", "Professor", "999999999", "Rua A"));
        this.tabelaCliente.add(new Cliente("00000000001", "Jose", "Diretor", "000000002", "Rua B"));
    }
    
    private void addFuncionarios() {
        this.tabelaFuncionarios.add(new Funcionario("Atendente", "Karina", "12121212121", "diurno", 2000));
        this.tabelaFuncionarios.add(new Funcionario("gerente", "Dona Ana", "34343434343", "noturno", 10000));
    }

    public Cliente buscaClienteCPF(String qrCode) {
        for(int i = 0; i < this.tabelaCliente.size(); i++) {
            if(qrCode.equals(this.tabelaCliente.get(i).getCPF())) {
                return this.tabelaCliente.get(i);
            }
        }
        return null;
    }
    
    public Funcionario selecionaAtendente() {
        Calendar calendarioAgora = Calendar.getInstance();
        int horaAtual = calendarioAgora.get(Calendar.HOUR);
        
        if(horaAtual >= 7 && horaAtual <= 17) {
            //Diurno
            return this.tabelaFuncionarios.get(0);
        } else {
            //Noturno
            return this.tabelaFuncionarios.get(1);
        }
    }

    public Vector<Salgado> buscaTodosSalgados() {
        Vector<Salgado> salgadosDisponiveis = new Vector<>();
        
        for(int i = 0; i < this.tabelaSalgados.size(); i++) {
            if(this.tabelaSalgados.get(i).getQuantiLote() > 0) {
                salgadosDisponiveis.add(this.tabelaSalgados.get(i));
            }
        }
        return salgadosDisponiveis;
    }
    
    public Vector<Bebida> buscaTodasBebidas() {
        Vector<Bebida> bebidasDisponiveis = new Vector<>();
        
        for(int i = 0; i < this.tabelaBebidas.size(); i++) {
            if(this.tabelaBebidas.get(i).getQuantDisponivel() > 0) {
                bebidasDisponiveis.add(this.tabelaBebidas.get(i));
            }
        }
        return bebidasDisponiveis;
    }
    
}