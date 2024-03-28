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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;

/**
 *
 * @author patyx
 */
public class VendaDAO implements InterfaceDao<Venda> {

    @Override
    public void create(Venda objeto) {

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet generatedKeys = null;
        int idVenda = -1;
        int idFuncionario = -1;

        try {
            // Inserir os dados gerais da venda na tabela 'venda'
            String sqlVenda = "INSERT INTO venda (dataHoraVenda, valorDesconto, observacao, valorTotal, carteirinha_id, funcionario_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, objeto.getDataHoraVenda());
            pstm.setFloat(2, objeto.getValorDesconto());
            pstm.setString(3, objeto.getObservacao());
            pstm.setFloat(4, objeto.getValorTotal());
            pstm.setInt(5, objeto.getCarteirinha().getId());
            pstm.setInt(6, objeto.getFuncionario().getId());
            pstm.executeUpdate();

            // Recuperar o ID da venda recém-inserida
            generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                idVenda = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Falha ao recuperar o ID da venda.");
            }
            try {
                // Consulta para recuperar o ID do funcionário associado à venda recentemente inserida
                String sqlRecuperarIdFuncionario = "SELECT funcionario_id FROM venda WHERE id = ?";
                PreparedStatement pstmRecuperarIdFuncionario = conexao.prepareStatement(sqlRecuperarIdFuncionario);
                pstmRecuperarIdFuncionario.setInt(1, idVenda); // Substitua 'idVenda' pelo ID da venda inserida recentemente

                ResultSet rs = pstmRecuperarIdFuncionario.executeQuery();

                if (rs.next()) {
                    idFuncionario = rs.getInt("funcionario_id");
                } else {
                    throw new SQLException("Falha ao recuperar o ID do funcionário.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            // Chamar o método para inserir os itens da venda
            inserirItensVenda(conexao, objeto.getProdutos(), idVenda);
            inserirMovimentacoesEstoque(conexao, objeto.getProdutos(), idVenda, objeto, idFuncionario);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    private void inserirItensVenda(Connection conexao, List<Produto> produtos, int idVenda) throws SQLException {
        PreparedStatement pstm = null;

        try {
            String sqlItemVenda = "INSERT INTO itemVenda (venda_id, produto_id, qtdProduto, valorUnitario) "
                    + "VALUES (?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sqlItemVenda);

            for (Produto produto : produtos) {
                pstm.setInt(1, idVenda);
                pstm.setInt(2, produto.getId());
                pstm.setFloat(3, produto.getQuantidade());
                pstm.setFloat(4, produto.getValorUnit());
                pstm.addBatch();
            }

            pstm.executeBatch();

        } finally {
            if (pstm != null) {
                pstm.close();
            }
        }
    }

    private ItemVenda encontrarItemVendaPeloProdutoId(int idProduto, int idVenda) {
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ItemVenda itemVenda = null;

        try {
            conexao = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM itemVenda WHERE produto_id = ? AND venda_id = ?";
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, idProduto);
            pstm.setInt(2, idVenda);
            rs = pstm.executeQuery();

            if (rs.next()) {
                // Preencha os dados do ItemVenda encontrado
                itemVenda = new ItemVenda();
                itemVenda.setId(rs.getInt("id")); // Supondo que o ID do ItemVenda seja 'id' na tabela
                // Preencha os outros campos necessários
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itemVenda;
    }

    private void inserirMovimentacoesEstoque(Connection conexao, List<Produto> produtos, int idVenda, Venda venda, int idFuncionario) throws SQLException {
        PreparedStatement pstm = null;

        try {
                String sqlMovimentacao = "INSERT INTO movimentacaoestoque (dataHoraMovimento, flagTipoMovimento, qtdMovimentada, observacaoMovimento, status, itemVenda_id, funcionario_id, venda_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = conexao.prepareStatement(sqlMovimentacao);

            for (Produto produto : produtos) {
                pstm.setString(1, venda.getDataHoraVenda()); // Utilizamos a mesma data e hora da venda
                pstm.setString(2, "S"); // 'S' para saída de estoque (venda)
                pstm.setFloat(3, produto.getQuantidade()); // Quantidade vendida
                pstm.setString(4, "Venda do produto ID: " + produto.getDescricao()); // Observação da movimentação
                pstm.setString(5, "A"); // Defina o status da movimentação conforme necessário
                pstm.setInt(6, encontrarItemVendaPeloProdutoId(produto.getId(), idVenda).getId()); // ID do ItemVenda associado
                pstm.setInt(7, idFuncionario); // ID do funcionário responsável
                pstm.setInt(8, idVenda); // ID do funcionário responsável

                pstm.addBatch();
            }

            pstm.executeBatch();
        } finally {
            if (pstm != null) {
                pstm.close();
            }
        }
    }

    @Override
    public List<Venda> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda retrieve(int parPK) {
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Venda venda = null;

        try {
            conexao = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM venda WHERE id = ?";
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, parPK);
            rs = pstm.executeQuery();

            if (rs.next()) {
                venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setDataHoraVenda(rs.getString("dataHoraVenda"));
                venda.setValorDesconto(rs.getFloat("valorDesconto"));
                venda.setObservacao(rs.getString("observacao"));
                venda.setValorTotal(rs.getFloat("valorTotal"));
                // Definir outros campos necessários

                // Aqui, você pode chamar um método para recuperar os produtos associados a esta venda
                venda.setProdutos(retrieveProdutosPorVendaId(parPK));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return venda;
    }

    private List<Produto> retrieveProdutosPorVendaId(int vendaId) {
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            conexao = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM itemVenda WHERE venda_id = ?";
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, vendaId);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("produto_id"));
                produto.setQuantidade(rs.getFloat("qtdProduto"));
                produto.setValorUnit(rs.getFloat("valorUnitario"));
                // Definir outros campos necessários

                produtos.add(produto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return produtos;
    }

    @Override
    public List<Venda> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void uptade(Venda object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Venda object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ItemVenda carregarItemVenda(int codigoItemVenda) {
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ItemVenda itemVenda = null;

        try {
            conexao = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM itemvenda WHERE id = ?";
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, codigoItemVenda);
            rs = pstm.executeQuery();

            if (rs.next()) {
                itemVenda = new ItemVenda();
                itemVenda.setId(rs.getInt("id"));
                itemVenda.setQtdProduto(rs.getFloat("qtdProduto"));
                // Carregar outros campos necessários
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rs);
        }

        return itemVenda;
    }

}
