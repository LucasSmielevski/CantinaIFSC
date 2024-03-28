/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Endereco;
import model.bo.Produto;

/**
 *
 * @author aluno
 */
public class Listas {

    public static ArrayList<model.bo.Bairro> listabairros;
    public static ArrayList<model.bo.Cidade> listacidades;
    public static ArrayList<model.bo.Carteirinha> listacarteirinhas;
    private ArrayList<model.bo.Caixa> listacaixas;
    public static ArrayList<model.bo.Cliente> listaclientes;
    private ArrayList<model.bo.Compra> compras;
    private ArrayList<model.bo.Contas> contas;
    public static ArrayList<model.bo.Endereco> listaenderecos;
    public static ArrayList<model.bo.Fornecedor> listafornecedores;
    public static ArrayList<model.bo.Funcionario> listafuncionarios;
    private ArrayList<model.bo.ItemCompra> itemCompras;
    private ArrayList<model.bo.ItemVenda> listaitemVendas;
    private ArrayList<model.bo.MovimentacaoEstoque> movimentacaoEstoques;
    private ArrayList<model.bo.MovimentoCaixa> movimentosCaixa;
    public static ArrayList<model.bo.Produto> listaprodutos;
    private ArrayList<model.bo.Venda> listavendas;

    private Listas() {
        listavendas = new ArrayList<>();
        listaprodutos = new ArrayList<>();
        movimentosCaixa = new ArrayList<>();
        movimentacaoEstoques = new ArrayList<>();
        listaitemVendas = new ArrayList<>();
        itemCompras = new ArrayList<>();
        listafuncionarios = new ArrayList<>();
        listafornecedores = new ArrayList<>();
        listaenderecos = new ArrayList<>();
        contas = new ArrayList<>();
        compras = new ArrayList<>();
        listaclientes = new ArrayList<>();
        listacaixas = new ArrayList<>();
        listacarteirinhas = new ArrayList<>();
        listacidades = new ArrayList<>();
        listabairros = new ArrayList<>();
       
        
        //Bairro bairro1 = new Bairro(1, "Centro");
        
        //Endereco endereco1 = new Endereco(1, "22222 - 222", "Centenario", bairro1);
        //Endereco endereco2 = new Endereco(2, "33333 - 333", "Almir do Santos" , bairro1);
        
        //listaenderecos.add(endereco1);
        //listaenderecos.add(endereco2);

        
  

    }

    public static ArrayList<Bairro> getListabairros() {
        return listabairros;
    }
    
    public static ArrayList<Cidade> getListacidade(){
        return listacidades;
    }

    public static ArrayList<Produto> getListProdutos(){
        return listaprodutos;
    }
    
    private static Listas instance;

    public static synchronized Listas getInstance() {
        if (instance == null) {
            instance = new Listas();
        }
        return instance;
    }

}
