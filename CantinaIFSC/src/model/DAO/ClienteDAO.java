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
import model.bo.Cliente;
import model.bo.Endereco;

/**
 *
 * @author patyx
 */
public class ClienteDAO implements InterfaceDao<Cliente> {

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cliente (nome, fone1, fone2, email, status, rg, cpf, "
                + "matricula, datanascimento, endereco_id, complementoEndereco) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getRg());
            pstm.setString(7, objeto.getCpf());
            pstm.setString(8, objeto.getMatricula());
            pstm.setString(9, objeto.getDataNascimento());
            pstm.setInt(10, objeto.getEndereco().getId());
            pstm.setString(11, objeto.getComplementoEndereco());

            pstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }
    }

    @Override
    public List<Cliente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cliente.id, cliente.nome, cliente.fone1, cliente.fone2, cliente.email, "
                + "cliente.status, cliente.rg, cliente.cpf, cliente.matricula, cliente.datanascimento, endereco.cep,endereco.logradouro, "
                + "cidade.descricao AS cidade_descricao, cidade.uf AS cidade_uf, bairro.descricao AS bairro_descricao, complementoEndereco "
                + "FROM cliente "
                +  "LEFT OUTER JOIN endereco ON cliente.endereco_id = endereco.id"
                + "LEFT OUTER JOIN cidade ON endereco.cidade_id = cidade.id "
                + "LEFT OUTER JOIN bairro ON endereco.bairro_id = bairro.id";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Cliente> listaCliente = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setStatus(rst.getString("status").charAt(0));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("datanascimento"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));

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

                cliente.setEndereco(endereco);
                listaCliente.add(cliente);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCliente;
        }

    }

    @Override
    public Cliente retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cliente.id, cliente.nome, cliente.fone1, cliente.fone2, cliente.email, "
                + "cliente.status, cliente.rg, cliente.cpf, cliente.matricula, cliente.datanascimento, cliente.endereco_id ,"
                + "endereco.cep,endereco.logradouro, "
                + "cidade.descricao AS cidade_descricao, cidade.uf AS cidade_uf, bairro.descricao AS bairro_descricao, complementoEndereco "
                + "FROM cliente "
                + "LEFT OUTER JOIN endereco ON cliente.endereco_id = endereco.id "
                + "LEFT OUTER JOIN cidade ON endereco.cidade_id = cidade.id "
                + "LEFT OUTER JOIN bairro ON endereco.bairro_id = bairro.id "
                + "WHERE cliente.id = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        Cliente cliente = new Cliente();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while (rst.next()) {
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setStatus(rst.getString("status").charAt(0));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("datanascimento"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setCep(rst.getString("cep"));

                // Configurar cidade
                Cidade cidade = new Cidade();
                cidade.setDescricao(rst.getString("cidade_descricao"));
                cidade.setUf(rst.getString("cidade_uf"));
                endereco.setCidade(cidade);

                // Configurar bairro
                Bairro bairro = new Bairro();
                bairro.setDescricao(rst.getString("bairro_descricao"));
                endereco.setBairro(bairro);

                
                
                cliente.setEndereco(endereco);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cliente;
        }

    }

    @Override
    public List<Cliente> retrieve(String parString) {

        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cliente.id, cliente.nome, cliente.fone1, cliente.fone2, cliente.email, "
                + "cliente.status, cliente.rg, cliente.cpf, cliente.matricula, cliente.datanascimento, endereco.cep, cidade.descricao AS cidade_descricao, bairro.descricao AS bairro_descricao, complementoEndereco "
                + "FROM cliente "
                + "LEFT OUTER JOIN endereco ON cliente.endereco_id = endereco.id "
                + "LEFT OUTER JOIN cidade ON endereco.cidade_id = cidade.id "
                + "LEFT OUTER JOIN bairro ON endereco.bairro_id = bairro.id "
                + "WHERE nome LIKE ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaCliente = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + parString + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setStatus(rst.getString("status").charAt(0));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("datanascimento"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));

                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("endereco_id"));
                endereco.setCep(rst.getString("cep"));

                // Configurar cidade
                Cidade cidade = new Cidade();
                cidade.setDescricao(rst.getString("cidade_descricao"));
                endereco.setCidade(cidade);

                // Configurar bairro
                Bairro bairro = new Bairro();
                bairro.setDescricao(rst.getString("bairro_descricao"));
                endereco.setBairro(bairro);

                cliente.setEndereco(endereco);

                listaCliente.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCliente;
        }

    }

    @Override
    public void uptade(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE cliente SET "
                + "nome = ?, "
                + "fone1 = ?, "
                + "fone2 = ?, "
                + "email = ?, "
                + "status = ?, "
                + "cpf = ?, "
                + "rg = ?, "
                + "matricula = ?, "
                + "datanascimento = ?, "
                + "endereco_Sid = ?, "
                + "complementoEndereco = ? "
                + "WHERE id = ?";

        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus() + "");
            pstm.setString(6, objeto.getCpf());
            pstm.setString(7, objeto.getRg());
            pstm.setString(8, objeto.getMatricula());
            pstm.setString(9, objeto.getDataNascimento());
            pstm.setInt(10, objeto.getEndereco().getId());
            pstm.setString(11, objeto.getComplementoEndereco());
            pstm.setInt(12, objeto.getId());

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {

            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void delete(Cliente object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
