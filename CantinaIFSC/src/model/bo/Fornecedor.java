
package model.bo;


public class Fornecedor extends Pessoa{
    
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;

    public Fornecedor() {
    }

    public Fornecedor(int id,String cnpj, String inscricaoEstadual, String razaoSocial, String nome, 
            String fone1, String fone2, String email, char status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return this.getCnpj() + ", " 
                + this.getInscricaoEstadual() + ", "
                + this.getRazaoSocial();
    }
}