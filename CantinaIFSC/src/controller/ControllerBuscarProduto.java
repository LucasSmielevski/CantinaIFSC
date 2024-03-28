/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Produto;
import service.ProdutoService;
import view.TelaBuscaProduto;

/**
 *
 * @author patyx
 */
public class ControllerBuscarProduto implements ActionListener {

    TelaBuscaProduto telaBuscaProduto;

    public ControllerBuscarProduto(TelaBuscaProduto telaBuscaProduto) {
        this.telaBuscaProduto = telaBuscaProduto;

        this.telaBuscaProduto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaProduto.getjButtonSair().addActionListener(this);
        this.telaBuscaProduto.getjButtonFiltrar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaProduto.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaProduto.getjPanDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaProduto.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaProduto.getjPanBotoes());
            if (this.telaBuscaProduto.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção!\nOpção de Filtro Vazia.");
                this.telaBuscaProduto.getjTFFitrar().requestFocus();
            } else {
                List<Produto> listaProdutos = new ArrayList<Produto>();

                if (this.telaBuscaProduto.getjCBDescricao().getSelectedIndex() == 0) {
                    listaProdutos.add(ProdutoService.carregar(Integer.parseInt(this.telaBuscaProduto.getjTFFitrar().getText())));

                } else if (this.telaBuscaProduto.getjCBDescricao().getSelectedIndex() == 1) {
                    listaProdutos = ProdutoService.carregar(this.telaBuscaProduto.getjTFFitrar().getText().trim());
                } else if (this.telaBuscaProduto.getjCBDescricao().getSelectedIndex() == 2) {
                    listaProdutos = ProdutoService.carregar(this.telaBuscaProduto.getjTFFitrar().getText().trim());
                }

                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProduto.getjTableDados().getModel();
                tabela.setRowCount(0);
                for (Produto produtoAtual : listaProdutos) {
                    tabela.addRow(new Object[]{produtoAtual.getId(),
                        produtoAtual.getDescricao(), produtoAtual.getCodigoBarra(), 
                        produtoAtual.getValorUnit(),produtoAtual.getQuantidade()});
                }
            }
        }
        if (e.getSource() == this.telaBuscaProduto.getjButtonCarregar()) {
            controller.ControllerCadastroProduto.codigo = (int) this.telaBuscaProduto.
                    getjTableDados().
                    getValueAt(this.telaBuscaProduto.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaProduto.getjPanBotoes());
            
           controller.ControllerVendas.codigoProduto = (int) this.telaBuscaProduto.
                    getjTableDados().
                    getValueAt(this.telaBuscaProduto.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaProduto.getjPanBotoes());
            this.telaBuscaProduto.dispose();
        }
        if (e.getSource() == this.telaBuscaProduto.getjButtonSair()) {
            this.telaBuscaProduto.dispose();
        }
    }

}
