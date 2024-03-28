/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.ProdutoDAO;
import model.bo.Produto;

/**
 *
 * @author patyx
 */
public class ProdutoService {
    
    public static void adicionar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.create(objeto);
    }

    public static List<Produto> carregar() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve();
    }

    public static Produto carregar(int parPK) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve(parPK);
    }

    public static List<Produto> carregar(String parString) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrieve(parString);
    }

    public static void atualizar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.uptade(objeto);
    }

    public static void remover(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.delete(objeto);
    }
    
    public static List<Produto> carregarPorCodBarra(String codBarra){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrievePorCodBarra(codBarra);
    }
}
