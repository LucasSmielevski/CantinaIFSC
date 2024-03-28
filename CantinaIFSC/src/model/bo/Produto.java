package model.bo;

public class Produto {

    private int id;
    private String descricao;
    private String codigoBarra;
    private String status;
    private float valorUnit;
    private float quantidade;

    public Produto() {
    }

    public Produto(int id, String descricao, String codigobarra, String status, float valorUnit, float quantidade) {
        this.id = id;
        this.descricao = descricao;
        this.codigoBarra = codigobarra;
        this.status = status;
        this.valorUnit = valorUnit;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigobarra() {
        return codigoBarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigoBarra = codigobarra;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(float valorunit) {
        this.valorUnit = valorunit;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    
    

    @Override
    public String toString() {
        return this.getId() + ", "
                + this.getCodigobarra() + ", "
                + this.getDescricao() + ", "
                + this.valorUnit + ", "
                + this.getStatus() + ", "
                +this.getQuantidade();
    }
}
