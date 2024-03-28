
package model.bo;

import java.util.ArrayList;


public class Cliente extends Pessoa{
    
    private String cpf;
    private String rg;
    private String matricula;
    private String dataNascimento;
    private String funcao;
    private Carteirinha carteirinha;

    public Cliente(int id, String nome, String fone1, String fone2, String email, char status, String complementoEndereco, Endereco endereco, Carteirinha carteirinha) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.funcao = funcao;
        this.matricula = matricula;
        this.rg = rg;
        this.carteirinha = carteirinha;
    }
    
    public Cliente() {
    }
    
    

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return super.toString() + ", "
                +this.getCpf() + ", " 
                + this.getRg() + ", "
                + this.getMatricula() + ", "
                + this.getDataNascimento()
                + this.getFuncao();
    }

}
