/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.ClienteDAO;
import model.bo.Cliente;

/**
 *
 * @author patyx
 */
public class ClienteService {

    public static void adicionar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(objeto);
    }

    public static List<Cliente> carregar() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve();
    }

    public static Cliente carregar(int parPK) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve(parPK);
    }

    public static List<Cliente> carregar(String parString) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrieve(parString);
    }

    public static void atualizar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.uptade(objeto);
    }

    public static void remover(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(objeto);
    }
}
