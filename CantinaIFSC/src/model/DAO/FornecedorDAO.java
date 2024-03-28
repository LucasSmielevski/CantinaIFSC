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
import model.bo.Fornecedor;

/**
 *
 * @author patyx
 */
public class FornecedorDAO implements InterfaceDao<Fornecedor> {

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO fornecedor (nome, fone1, fone2, email, status,"
                + " cnpj, inscricaoestadual, endereco_id, razaosocial, complementoEndereco) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getCnpj());
            pstm.setString(7, objeto.getInscricaoEstadual());
            pstm.setInt(8, objeto.getEndereco().getId());
            pstm.setString(9, objeto.getRazaoSocial());
            pstm.setString(10, objeto.getComplementoEndereco());

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public List<Fornecedor> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT fornecedor.id, fornecedor.nome, fornecedor.fone1, fornecedor.fone2, fornecedor.email, fornecedor.status, "
                + "fornecedor.cnpj, fornecedor.inscricaoestadual, fornecedor.razaosocial, "
                + "endereco.cep, endereco.logradouro, "
                + "cidade.descricao AS cidade_descricao, cidade.uf AS cidade_uf"
                + "bairro.descricao AS bairro_descricao, complementoEndereco "
                + "FROM fornecedor "
                + "LEFT OUTER JOIN endereco ON fornecedor.endereco_id = endereco.id "
                + "LEFT OUTER JOIN cidade ON endereco.cidade_id = cidade.id "
                + "LEFT OUTER JOIN bairro ON endereco.bairro_id = bairro.id";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Fornecedor> listaFornecedor = new ArrayList<>();

        try {

            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while (rst.next()) {

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setStatus(rst.getString("status").charAt(0));
                fornecedor.setInscricaoEstadual(rst.getString("inscricaoestadual"));
                fornecedor.setRazaoSocial(rst.getString("razaosocial"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));

                // Configurar cidade
                Cidade cidade = new Cidade();
                cidade.setDescricao(rst.getString("cidade_descricao"));
                cidade.setUf(rst.getString("cidade_uf"));
                endereco.setCidade(cidade);

                // Configurar bairro
                Bairro bairro = new Bairro();
                bairro.setDescricao(rst.getString("bairro_descricao"));
                endereco.setBairro(bairro);

                fornecedor.setEndereco(endereco);
                listaFornecedor.add(fornecedor);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFornecedor;
        }
    }

    @Override
    public Fornecedor retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT fornecedor.id, fornecedor.nome, fornecedor.fone1, fornecedor.fone2, "
                + "fornecedor.email, fornecedor.status, fornecedor.cnpj, fornecedor.inscricaoestadual, "
                + "fornecedor.razaosocial, endereco.cep, endereco.logradouro,"
                + "cidade.descricao AS cidade_descricao, cidade.uf AS cidade_uf,"
                + "bairro.descricao AS bairro_descricao, complementoEndereco "
                + "FROM fornecedor "
                + "LEFT OUTER JOIN endereco ON fornecedor.endereco_id = endereco.id "
                + "LEFT OUTER JOIN cidade ON endereco.cidade_id = cidade.id "
                + "LEFT OUTER JOIN bairro ON endereco.bairro_id = bairro.id "
                + "WHERE fornecedor.id = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        Fornecedor fornecedor = new Fornecedor();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while (rst.next()) {

                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setStatus(rst.getString("status").charAt(0));
                fornecedor.setInscricaoEstadual(rst.getString("inscricaoestadual"));
                fornecedor.setRazaoSocial(rst.getString("razaosocial"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));

                // Configurar cidade
                Cidade cidade = new Cidade();
                cidade.setDescricao(rst.getString("cidade_descricao"));
                cidade.setUf(rst.getString("cidade_uf"));
                endereco.setCidade(cidade);

                // Configurar bairro
                Bairro bairro = new Bairro();
                bairro.setDescricao(rst.getString("bairro_descricao"));
                endereco.setBairro(bairro);

                fornecedor.setEndereco(endereco);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return fornecedor;
        }
    }

    @Override
    public List<Fornecedor> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT fornecedor.id, fornecedor.nome, fornecedor.fone1, fornecedor.fone2,"
                + " fornecedor.email, fornecedor.status, fornecedor.cnpj, fornecedor.inscricaoestadual, "
                + "fornecedor.razaosocial, endereco.cep, "
                + "cidade.descricao AS cidade_descricao, "
                + "bairro.descricao AS bairro_descricao, complementoEndereco "
                + "FROM fornecedor "
                + "LEFT OUTER JOIN endereco ON fornecedor.endereco_id = endereco.id "
                + "LEFT OUTER JOIN cidade ON endereco.cidade_id = cidade.id "
                + "LEFT OUTER JOIN bairro ON endereco.bairro_id = bairro.id "
                + "WHERE nome LIKE ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Fornecedor> listaFornecedor = new ArrayList<>();

        try {

            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + parString + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setStatus(rst.getString("status").charAt(0));
                fornecedor.setInscricaoEstadual(rst.getString("inscricaoestadual"));
                fornecedor.setRazaoSocial(rst.getString("razaosocial"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));

                // Configurar cidade
                Cidade cidade = new Cidade();
                cidade.setDescricao(rst.getString("cidade_descricao"));
                endereco.setCidade(cidade);

                // Configurar bairro
                Bairro bairro = new Bairro();
                bairro.setDescricao(rst.getString("bairro_descricao"));
                endereco.setBairro(bairro);

                fornecedor.setEndereco(endereco);

                listaFornecedor.add(fornecedor);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFornecedor;
        }
    }

    @Override
    public void uptade(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE fornecedor " 
                + "SET nome = ?, fone1 = ?, fone2 = ?, email = ?, status = ?, cnpj = ?, inscricaoestadual = ?,"
                + " endereco_id = ?, razaosocial = ?, complementoEndereco = ? "
                + "WHERE id = ?";
        
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getCnpj());
            pstm.setString(7, objeto.getInscricaoEstadual());
            pstm.setInt(8, objeto.getEndereco().getId());
            pstm.setString(9, objeto.getRazaoSocial());
            pstm.setString(10, objeto.getComplementoEndereco());
            pstm.setInt(11, objeto.getId());

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Fornecedor object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
