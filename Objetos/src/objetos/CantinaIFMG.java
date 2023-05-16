
package objetos;

import java.util.Scanner;
import java.util.Vector;

public class CantinaIFMG {

    private static FakeBD bancoDados;
    private Scanner leitor = new Scanner(System.in);
    
    private Salgado imprimeMenuSalgados() { // tbm auxilia na escolha do cliente
        Vector<Salgado> salgadosPraVenda = bancoDados.buscaTodosSalgados();
        
        for(int i = 0; i < salgadosPraVenda.size(); i++) {
            System.out.println((i + 1) + " - " + salgadosPraVenda.get(i));
        }
        
        System.out.println("\nSelecione: ");
        int opSalgado = leitor.nextInt();
        leitor.skip("\n");
        
        if(opSalgado >= 1 && opSalgado <= salgadosPraVenda.size()) {
            return salgadosPraVenda.get(opSalgado - 1);
        } else {
            System.out.println("Opcao escolhida invalida");
            return null;
        }
    }
    
    private Bebida imprimeMenuBebidas() {
        Vector<Bebida> bebidasPraVenda = bancoDados.buscaTodasBebidas();
        
        for(int i = 0; i < bebidasPraVenda.size(); i++) {
            System.out.println((i + 1) + " - " + bebidasPraVenda.get(i));
        }
        
        System.out.println("\nSelecione: ");
        int opBebida = leitor.nextInt();
        leitor.skip("\n");
        
        if(opBebida >= 1 && opBebida <= bebidasPraVenda.size()) {
            return bebidasPraVenda.get(opBebida - 1);
        } else {
            System.out.println("Opcao escolhida invalida");
            return null;
        }
        
    }
    
    public void realizaVenda() {
            
        //qual Cliente
        Cliente fregues = carregaCliente();
        
        //Código do cliente inválido/inexistente
        if(fregues == null) {
            System.err.println("O código informado é inválido");
        } else {
            
            Pedido pedidoDoCliente = new Pedido(fregues, bancoDados.selecionaAtendente());
            
            while(true) {
                //Cliente ENCONTRADO
                System.out.println("\n" + fregues.getNome() + ", voce deseja um salgado ou uma bebida?");
                String opcao = leitor.nextLine();

                //Aqui terminamos o pedido
                if(opcao.equalsIgnoreCase("terminar")) {
                    break;
                }

                //Atendendo salgado
                if(opcao.equalsIgnoreCase("Salgado")) {

                    Salgado salgEscolhido = imprimeMenuSalgados();
                    pedidoDoCliente.addSalgado(salgEscolhido);

                } else {
                    
                    //Atendendo bebida
                    Bebida bebiEscolhida = imprimeMenuBebidas();
                    pedidoDoCliente.addBebida(bebiEscolhida);
                    
                }
            }
            
            //Aqui o cliente não quer mais comprar
            pedidoDoCliente.imprimePedido();
            fregues.realizaPagamento(pedidoDoCliente.getPrecoTotal());
            
        }
        
    }
    
    private Cliente carregaCliente() {
        
        System.out.println("...leitura QR-Code");
        String qrCode = leitor.nextLine();
        
        //qrCode = CPF do usuário
        Cliente fregues = bancoDados.buscaClienteCPF(qrCode);
        return fregues;
        
    }
    
    public static void main(String[] args) {
        
        bancoDados = new FakeBD();
        CantinaIFMG cantina = new CantinaIFMG();
        cantina.realizaVenda();
        
    }
    
}