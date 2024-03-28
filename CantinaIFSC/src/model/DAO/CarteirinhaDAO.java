package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Carteirinha;
import model.bo.Cliente;

public class CarteirinhaDAO implements InterfaceDao<Carteirinha> {

    @Override
    public void create(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO carteirinha (codigoBarra, datageracao, datacancelamento, cliente_id) "
                + "values(?, ?, ?, ?)";
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCodigoBarra());
            pstm.setString(2, objeto.getDataGeracao());
            pstm.setString(3, objeto.getDataCancelamento());
            pstm.setInt(4, objeto.getCliente().getId());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();

                }
                if (conexao != null) {
                    conexao.close();

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    @Override
    public List<Carteirinha> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT carteirinha.id, "
                + "carteirinha.codigoBarra, "
                + "carteirinha.datageracao, "
                + "carteirinha.datacancelamento, "
                + "cliente.nome, "
                + "FROM carteirinha "
                + "LEFT OUTER JOIN cliente ON cliente.id = carteirinha.cliente_id";
        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Carteirinha> listaCarteirinha = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Carteirinha carteirinha = new Carteirinha();
                carteirinha.setId(rst.getInt("id"));
                carteirinha.setCodigoBarra(rst.getString("codigoBarra"));
                carteirinha.setDataGeracao(rst.getString("datageracao"));
                carteirinha.setDataCancelamento(rst.getString("datacancelamento"));

                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));

                carteirinha.setCliente(cliente);

                listaCarteirinha.add(carteirinha);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCarteirinha;
        }

    }

    @Override
    public Carteirinha retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT carteirinha.id, "
                + "carteirinha.codigoBarra, "
                + "carteirinha.datageracao, "
                + "carteirinha.datacancelamento, "
                + "cliente.nome, "
                + "cliente.cpf "
                + "FROM carteirinha "
                + "LEFT OUTER JOIN cliente ON cliente.id = carteirinha.cliente_id "
                + "WHERE carteirinha.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Carteirinha carteirinha = new Carteirinha();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while (rst.next()) {

                carteirinha.setId(rst.getInt("id"));
                carteirinha.setCodigoBarra(rst.getString("codigoBarra"));
                carteirinha.setDataGeracao(rst.getString("datageracao"));
                carteirinha.setDataCancelamento(rst.getString("datacancelamento"));

                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));

                carteirinha.setCliente(cliente);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return carteirinha;
        }
    }

    @Override
    public List<Carteirinha> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void uptade(Carteirinha object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Carteirinha object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verificarNumeroExistente(String numero) throws SQLException {
        String sqlExecutar = "SELECT COUNT(*) FROM sua_tabela WHERE CodigoBarra = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, numero);
            rst = pstm.executeQuery();
            if (rst.next()) {
                int count = rst.getInt(1);
                return count > 0; // Se existir, retorna true
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
