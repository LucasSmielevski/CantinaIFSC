
package model.bo;


public class Funcionario extends Pessoa{
    
    private String cpf;
    private String rg;
    private String usuario;
    private String senha;
    private String dataNascimento;
    public Funcionario() {
    }

    public Funcionario(int id,String cpf, String rg, String usuario, String senha, String dataNascimento, 
            String nome, String fone1, String fone2, String email, char status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    @Override
    public String toString() {
        return this.getCpf() + ", " 
                + this.getRg() + ", "
                + this.getSenha() + ", "
                + this.getUsuario() + ","
                + this.getDataNascimento();
    } 
}
