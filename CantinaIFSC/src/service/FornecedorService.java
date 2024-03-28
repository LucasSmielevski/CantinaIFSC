/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.FornecedorDAO;
import model.bo.Fornecedor;

/**
 *
 * @author patyx
 */
public class FornecedorService {

    public static void adicionar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.create(objeto);
    }

    public static List<Fornecedor> carregar() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve();
    }

    public static Fornecedor carregar(int parPK) {
        FornecedorDAO forncedorDAO = new FornecedorDAO();
        return forncedorDAO.retrieve(parPK);
    }

    public static List<Fornecedor> carregar(String parString) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(parString);
    }

    public static void atualizar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.uptade(objeto);
    }

    public static void remover(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.delete(objeto);
    }
}
