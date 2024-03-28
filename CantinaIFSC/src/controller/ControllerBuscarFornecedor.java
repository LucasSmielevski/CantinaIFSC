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
import model.bo.Fornecedor;
import view.TelaBuscaFornecedor;

/**
 *
 * @author patyx
 */
public class ControllerBuscarFornecedor implements ActionListener {

    TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscarFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;

        this.telaBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonFiltrar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaFornecedor.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaFornecedor.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaFornecedor.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaFornecedor.getjPanBotoes());
            if (!this.telaBuscaFornecedor.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                
                List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
                
                if (this.telaBuscaFornecedor.getjCBDescricao().getSelectedIndex() == 0) {
                    listaFornecedor.add(service.FornecedorService.carregar(Integer.parseInt(this.telaBuscaFornecedor.getjTFFitrar().getText())));

                } else if (this.telaBuscaFornecedor.getjCBDescricao().getSelectedIndex() == 1) {
                    listaFornecedor = service.FornecedorService.carregar(this.telaBuscaFornecedor.getjTFFitrar().getText().trim());
                } else if (this.telaBuscaFornecedor.getjCBDescricao().getSelectedIndex() == 2) {
                    listaFornecedor = service.FornecedorService.carregar(this.telaBuscaFornecedor.getjTFFitrar().getText().trim());
                }
                //Criar um onjeto do tipo tablemodel
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                tabela.setRowCount(0);

                for (Fornecedor fornecedoratual : listaFornecedor) {
                    tabela.addRow(new Object[]{fornecedoratual.getId(),
                        fornecedoratual.getStatus(), fornecedoratual.getCnpj(),
                        fornecedoratual.getRazaoSocial(), fornecedoratual.getEmail(), 
                        fornecedoratual.getNome(),
                        fornecedoratual.getInscricaoEstadual(), fornecedoratual.getFone1(),
                        fornecedoratual.getFone2(), 
                        fornecedoratual.getEndereco().getCep(), 
                        fornecedoratual.getEndereco().getCidade(),
                        fornecedoratual.getEndereco().getBairro(), 
                        fornecedoratual.getEndereco().getLogradouro(),
                        fornecedoratual.getComplementoEndereco()});

                }

            }else{
                JOptionPane.showMessageDialog(null, "Aten??o!\nOp??o de Filtro Vazia...");
                this.telaBuscaFornecedor.getjTFFitrar().requestFocus();
            }

        }
        if (e.getSource() == this.telaBuscaFornecedor.getjButtonCarregar()) {

            controller.ControllerCadastroFornecedor.codigoFornecedor = (int) this.telaBuscaFornecedor.
                    getjTableDados().getValueAt(this.telaBuscaFornecedor.getjTableDados().getSelectedRow(), 0);

            utilities.Utilities.ativaDesativa(true, this.telaBuscaFornecedor.getjPanBotoes());
            this.telaBuscaFornecedor.dispose();
        }
        if (e.getSource() == this.telaBuscaFornecedor.getjButtonSair()) {
            this.telaBuscaFornecedor.dispose();
        }
    }

}
