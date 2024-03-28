/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.CidadeDAO;
import model.bo.Cidade;

/**
 *
 * @author aluno
 */
public class CidadeService {

    public static void adicionar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.create(objeto);
    }

    public static List<Cidade> carregar() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve();
    }

    public static Cidade carregar(int parPK) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(parPK);
    }
    
    
    public static List<Cidade> carregar(String parString) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(parString);
    }


    public static void atualizar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.uptade(objeto);
    }

}
