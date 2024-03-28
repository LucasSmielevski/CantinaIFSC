/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Caixa;

/**
 *
 * @author patyx
 */
public class CaixaDAO implements InterfaceDao<Caixa> {

    @Override
    public void create(Caixa object) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO caixa (dataHoraAbertura, dataHoraFechamento, valorAbertura, "
                + "valorFechamento, observacao, status, funcionario_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, object.getDataHoraAbertura());
            pstm.setString(2, object.getDataHoraFechamento());
            pstm.setFloat(3, object.getValorAbertura());
            pstm.setFloat(4, object.getValorFechamento());
            pstm.setString(5, object.getObservacao());
            pstm.setString(6, String.valueOf(object.getStatus()));
            pstm.setInt(7, object.getFuncionario().getId()); // Supondo que o Funcionario tem um ID no banco

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Caixa> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT * FROM caixa";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Caixa> listaCaixas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Caixa caixa = new Caixa();
                // Defina os valores do objeto Caixa com base nos resultados do ResultSet

                listaCaixas.add(caixa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }

        return listaCaixas;
    }

    @Override
    public Caixa retrieve(int id) {
        // Implemente a lógica para recuperar um único Caixa pelo ID
        return null;
    }

    @Override
    public List<Caixa> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void uptade(Caixa object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Caixa object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
