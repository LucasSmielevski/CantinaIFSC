/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Produto;

/**
 *
 * @author aluno
 */
public class ProdutoDAO implements InterfaceDao<Produto> {

    @Override
    public void create(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO produto(descricao , codigoBarra, status, valorUnitario, quantidade) VALUES(?,?,?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigobarra());
            pstm.setString(3, objeto.getStatus());
            pstm.setFloat(4, objeto.getValorUnit());
            pstm.setFloat(5, objeto.getQuantidade());
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public List<Produto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        List<Produto> listaProdutos = new ArrayList<>();
        String sqlExecutar = "SELECT id, descricao, codigoBarra , status, valorUnitario , quantidades FROM produto";
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigobarra(rst.getString("codigoBarra"));
                produto.setStatus(rst.getString("status"));
                produto.setValorUnit(rst.getFloat("valorUnitario"));
                produto.setQuantidade(rst.getFloat("quantidade"));
                listaProdutos.add(produto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaProdutos;

        }

    }

    @Override
    public Produto retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao, codigoBarra, status, valorUnitario, quantidade FROM produto WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Produto produto = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            if (rst.next()) {
                produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigobarra(rst.getString("codigoBarra"));
                produto.setStatus(rst.getString("status"));
                produto.setValorUnit(rst.getFloat("valorUnitario"));
                produto.setQuantidade(rst.getFloat("quantidade"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }

        return produto;
    }

    @Override
    public List<Produto> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        List<Produto> listaProdutos = new ArrayList<>();
        String sqlExecutar = "SELECT id, descricao, codigoBarra, status, valorUnitario, quantidade FROM produto WHERE descricao LIKE ? "
                + "or codigobarra LIKE ?"
                + " or status LIKE ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString + "%");
            pstm.setString(2, parString + "%");
            pstm.setString(3, parString + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigobarra(rst.getString("codigoBarra"));
                produto.setStatus(rst.getString("status"));
                produto.setValorUnit(rst.getFloat("valorUnitario"));
                produto.setQuantidade(rst.getFloat("quantidade"));
                listaProdutos.add(produto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }

        return listaProdutos;
    }

    @Override
    public void uptade(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE produto SET descricao = ?, codigoBarra = ?, status = ? , valorUnitario = ?, quantidade = ? WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getStatus());
            pstm.setFloat(4, objeto.getValorUnit());
            pstm.setFloat(5, objeto.getQuantidade());
            pstm.setInt(6, objeto.getId());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Produto objeto) {

        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM produto WHERE id = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());

            pstm.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    public List<Produto> retrievePorCodBarra(String codBarra) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao, codigoBarra, status, valorUnitario, quantidade FROM produto WHERE id = ? ";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> listaProdutos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, codBarra);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigobarra(rst.getString("codigoBarra"));
                produto.setStatus(rst.getString("status"));
                produto.setValorUnit(rst.getFloat("valorUnitario"));
                produto.setQuantidade(rst.getFloat("quantidade"));
                listaProdutos.add(produto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }

        return listaProdutos;
    }

}
