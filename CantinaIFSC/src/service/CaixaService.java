/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.CaixaDAO;
import model.bo.Caixa;

/**
 *
 * @author patyx
 */
public class CaixaService {
    public static void adicionar(Caixa objeto) {
        CaixaDAO caixaDAO = new CaixaDAO();
        caixaDAO.create(objeto);
    }

    public static List<Caixa> carregar() {
        CaixaDAO caixaDAO = new CaixaDAO();
        return caixaDAO.retrieve();
    } 
}
