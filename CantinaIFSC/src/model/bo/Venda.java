package model.bo;

import java.util.List;

public class Venda {

    private int id;
    private String dataHoraVenda;
    private float valorDesconto;
    private float valorDescontoPorc;
    private String observacao;
    private float valorTotal;

    private List<Produto> produtos;
    private Carteirinha carteirinha;
    private Funcionario funcionario;

    public Venda() {
    }

    public Venda(int id, String dataHoraVenda, float valorDesconto, float valorDescontoPorc, String observacao, float valorTotal, List<Produto> produtos, Carteirinha carteirinha, Funcionario funcionario) {
        this.id = id;
        this.dataHoraVenda = dataHoraVenda;
        this.valorDesconto = valorDesconto;
        this.valorDescontoPorc = valorDescontoPorc;
        this.observacao = observacao;
        this.valorTotal = valorTotal;
        this.produtos = produtos;
        this.carteirinha = carteirinha;
        this.funcionario = funcionario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(String dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorDescontoPorc() {
        return valorDescontoPorc;
    }

    public void setValorDescontoPorc(float valorDescontoPorc) {
        this.valorDescontoPorc = valorDescontoPorc;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return this.getId() + ", "
                + this.getDataHoraVenda() + ", "
                + this.getValorDesconto() + ", "
                + this.getValorDescontoPorc() + ", "
                + this.getObservacao() + ", "
                + this.getValorTotal();
    }
}
