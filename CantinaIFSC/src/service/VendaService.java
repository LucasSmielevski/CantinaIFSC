/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.DAO.VendaDAO;
import model.bo.ItemVenda;
import model.bo.Venda;

/**
 *
 * @author patyx
 */
public class VendaService {

    public static void adicionar(Venda objeto) {
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.create(objeto);
    }

    public static Venda carregar(int parPK) {
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.retrieve(parPK);
    }

    public static ItemVenda carregarItemVenda(int codigoItemVenda) {
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.carregarItemVenda(codigoItemVenda);
    }

}
