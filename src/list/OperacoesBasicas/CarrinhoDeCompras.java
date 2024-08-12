package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;




public class CarrinhoDeCompras {

    private List<Itens> compras = new ArrayList<>();

    public CarrinhoDeCompras() {
        this.compras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        compras.add(new Itens(nome, preco, quantidade));   
    }

    public void removerItem(String nome) {
        List<Itens> itensParaRemover = new ArrayList<>();
        if (!compras.isEmpty()) {
            for (Itens i : compras) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            compras.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal(){
        double somaTotal = 0d;
        if (!compras.isEmpty()) {
            for(Itens i : compras){
                double valorItem = i.getPreco() * i.getQuantidade();
                somaTotal += valorItem;
            }
            return somaTotal;
        }
        else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        compras.stream().forEach(i->System.out.println(iformacaoDoItem(i)));
    }

    public String iformacaoDoItem(Itens item) {
        return String.format("""
                ---------------------
                Nome: %s
                Preço: R$ %.2f
                Quantidade: %d
                ---------------------
                """, item.getNome(), item.getPreco(), item.getQuantidade());
    }

    public static void main(String[] args) {

        CarrinhoDeCompras compras = new CarrinhoDeCompras();

        compras.adicionarItem("Feijão", 9.8, 2);
        compras.adicionarItem("Arroz", 17, 3);

       System.out.println("O valor total do carrinho é: "+compras.calcularValorTotal());
    
       compras.exibirItens();
    }
}
