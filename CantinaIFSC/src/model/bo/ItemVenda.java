package model.bo;

public class ItemVenda {

    private int id;
    private float qtdProduto;
    private char status;

    private Produto produto;
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(int id, float qtdProduto, char status, Produto produto, Venda venda) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.status = status;
        this.produto = produto;
        this.venda = venda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(float qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return this.getId() + ", "
                + this.getQtdProduto() + ", "
                + this.getStatus() + ", "
                + this.produto.getDescricao();
    }
}
