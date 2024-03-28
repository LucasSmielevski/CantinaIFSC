/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.CarteirinhaDAO;
import model.bo.Carteirinha;

/**
 *
 * @author aluno
 */
public class CarteirinhaService {

    public static void adicionar(Carteirinha objeto) {
        CarteirinhaDAO carteirinhaDAO = new CarteirinhaDAO();
        carteirinhaDAO.create(objeto);
    }

    public static List<Carteirinha> carregar() {
        CarteirinhaDAO carteirinhaDAO = new CarteirinhaDAO();
        return carteirinhaDAO.retrieve();
    }

    public static Carteirinha carregar(int parPK) {
        CarteirinhaDAO carteirinhaDAO = new CarteirinhaDAO();
        return carteirinhaDAO.retrieve(parPK);
    }

    public static List<Carteirinha> carregar(String parString) {
        CarteirinhaDAO carteirinhaDAO = new CarteirinhaDAO();
        return carteirinhaDAO.retrieve(parString);
    }

    public static void atualizar(Carteirinha objeto) {
        CarteirinhaDAO carteirinhaDAO = new CarteirinhaDAO();
        carteirinhaDAO.uptade(objeto);
    }

    public static void remover(Carteirinha objeto) {
        CarteirinhaDAO carteirinhaDAO = new CarteirinhaDAO();
        carteirinhaDAO.delete(objeto);
    }

}
