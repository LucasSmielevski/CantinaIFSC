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
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;

/**
 *
 * @author patyx
 */
public class EnderecoDAO implements InterfaceDao<Endereco> {

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO endereco (cep,logradouro,cidade_id,bairro_id,status) VALUES(?,?,?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setInt(3, objeto.getCidade().getId());
            pstm.setInt(4, objeto.getBairro().getId());
            pstm.setString(5, objeto.getStatus() + "");
            //concatenando com "" p/ transfformar em String
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public List<Endereco> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco.id, "
                + "endereco.cep, "
                + "endereco.logradouro, "
                + "endereco.cidade_id, "
                + "endereco.bairro_id, "
                + "endereco.status, "
                + "bairro.descricao , "
                + "cidade.descricao , "
                + "cidade.uf "
                + "FROM endereco "
                + " LEFT OUTER JOIN BAIRRO ON BAIRRO.id = ENDERECO.bairro_id "
                + " LEFT OUTER JOIN CIDADE ON CIDADE.id = ENDERECO.Cidade_id ";
        ;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> listaEndereco = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setStatus(rst.getString("status").charAt(0));
                //Utilizei o String.CharAt(0) para transformar a 
                //String de retorno em char
                endereco.setCep(rst.getString("cep"));

                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("Bairro_id"));
                bairro.setDescricao(rst.getString("bairro.descricao"));
                endereco.setBairro(bairro);

                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("Cidade_id"));
                cidade.setDescricao(rst.getString("cidade.descricao"));
                cidade.setUf(rst.getString("uf"));

                endereco.setCidade(cidade);

                listaEndereco.add(endereco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaEndereco;
        }
    }

    @Override
    public Endereco retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco.id, "
                + "endereco.cep, "
                + "endereco.logradouro, "
                + "endereco.cidade_id, "
                + "endereco.bairro_id, "
                + "endereco.status, "
                + "bairro.descricao , "
                + "cidade.descricao , "
                + "cidade.uf "
                + "FROM endereco "
                + " LEFT OUTER JOIN bairro ON bairro.id = endereco.bairro_id "
                + " LEFT OUTER JOIN cidade ON cidade.id = endereco.cidade_id "
                + " WHERE endereco.id = ? ";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        Endereco endereco = new Endereco();
        //criei o objeto endereco fora do bloco protegido
        //para que seu escopo permita carreg?-lo como retorno do m?todo

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while (rst.next()) {

                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setStatus(rst.getString("status").charAt(0));
                //Utilizei o String.CharAt(0) para transformar a 
                //String de retorno em char
                endereco.setCep(rst.getString("cep"));

                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("Bairro_id"));
                bairro.setDescricao(rst.getString("bairro.descricao"));
                endereco.setBairro(bairro);

                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("Cidade_id"));
                cidade.setDescricao(rst.getString("cidade.descricao"));
                cidade.setUf(rst.getString("uf"));
                endereco.setCidade(cidade);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return endereco;
        }

    }

    @Override
    public List<Endereco> retrieve(String parString) {
        return null;
    }

    public List<Endereco> retrieve(String nomeParametro, String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco.id, "
                + "endereco.cep, "
                + "endereco.logradouro, "
                + "endereco.cidade_id, "
                + "endereco.bairro_id, "
                + "endereco.status, "
                + "bairro.descricao , "
                + "cidade.descricao , "
                + "cidade.uf "
                + "FROM endereco "
                + " LEFT OUTER JOIN BAIRRO ON BAIRRO.id = ENDERECO.bairro_id "
                + " LEFT OUTER JOIN CIDADE ON CIDADE.id = ENDERECO.Cidade_id "
                + " WHERE " + nomeParametro + " like ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> listaEndereco = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + parString + "%");
            rst = pstm.executeQuery();
            while (rst.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setStatus(rst.getString("status").charAt(0));
                //Utilizei o String.CharAt(0) para transformar a 
                //String de retorno em char
                endereco.setCep(rst.getString("cep"));

                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("Bairro_id"));
                bairro.setDescricao(rst.getString("bairro.descricao"));
                endereco.setBairro(bairro);

                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("Cidade_id"));
                cidade.setDescricao(rst.getString("cidade.descricao"));
                cidade.setUf(rst.getString("uf"));
                endereco.setCidade(cidade);

                listaEndereco.add(endereco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaEndereco;
        }
    }

    @Override
    public void uptade(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE endereco"
                + " SET "
                + " endereco.cep = ?, "
                + " endereco.logradouro = ?, "
                + " endereco.cidade_id = ?, "
                + " endereco.bairro_id = ?, "
                + " endereco.status = ? "
                + " WHERE endereco.id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setInt(3, objeto.getCidade().getId());
            pstm.setInt(4, objeto.getBairro().getId());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setInt(6, objeto.getId());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void delete(Endereco object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
