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
import model.bo.Endereco;
import view.TelaBuscaEndereço;

/**
 *
 * @author patyx
 */
public class ControllerBuscarEndereco implements ActionListener {

    TelaBuscaEndereço telaBuscaEndereço;

    public ControllerBuscarEndereco(TelaBuscaEndereço telaBuscaEndereço) {
        this.telaBuscaEndereço = telaBuscaEndereço;

        this.telaBuscaEndereço.getjButtonCarregar().addActionListener(this);
        this.telaBuscaEndereço.getjButtonSair().addActionListener(this);
        this.telaBuscaEndereço.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaEndereço.getjCBDescricao().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaEndereço.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaEndereço.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaEndereço.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaEndereço.getjPanBotoes());

            if (!this.telaBuscaEndereço.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Endereco> listaEnderecos = new ArrayList<Endereco>();

                if (this.telaBuscaEndereço.getjCBDescricao().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaEnderecos.add(service.EnderecoService.carregar(Integer.parseInt(this.telaBuscaEndereço.getjTFFitrar().getText())));
                } else if (this.telaBuscaEndereço.getjCBDescricao().getSelectedItem().toString().equalsIgnoreCase("cidade")) {
                    listaEnderecos = service.EnderecoService.carregar("cidade.descricao", this.telaBuscaEndereço.getjTFFitrar().getText());
                } else if (this.telaBuscaEndereço.getjCBDescricao().getSelectedItem().toString().equalsIgnoreCase("bairro")) {
                    listaEnderecos = service.EnderecoService.carregar("bairro.descricao", this.telaBuscaEndereço.getjTFFitrar().getText());
                } else {
                    listaEnderecos = service.EnderecoService.carregar(this.telaBuscaEndereço.getjCBDescricao().getSelectedItem().toString(), this.telaBuscaEndereço.getjTFFitrar().getText());
                }

                //Criar um objeto do tipo TableModel
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEndereço.getjTableDados().getModel();
                tabela.setRowCount(0);

                for (Endereco enderecoAtual : listaEnderecos) {
                    tabela.addRow(new Object[]{enderecoAtual.getId(),
                        enderecoAtual.getCep(),
                        enderecoAtual.getLogradouro(),
                        enderecoAtual.getCidade().getDescricao(),
                        enderecoAtual.getBairro().getDescricao()});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aten??o!\nOp??o de Filtro Vazia...");
                this.telaBuscaEndereço.getjTFFitrar().requestFocus();
            }

        }
        if (e.getSource() == this.telaBuscaEndereço.getjButtonCarregar()) {

            controller.ControllerCadastroEndereco.codigoEndereco = (int) this.telaBuscaEndereço.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndereço.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndereço.getjPanBotoes());
            this.telaBuscaEndereço.dispose();

            controller.ControllerCadastroCliente.codigoEndereco = (int) this.telaBuscaEndereço.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndereço.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndereço.getjPanBotoes());
            this.telaBuscaEndereço.dispose();

            controller.ControllerCadastroFuncionario.codigoEndereco = (int) this.telaBuscaEndereço.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndereço.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndereço.getjPanBotoes());
            this.telaBuscaEndereço.dispose();

            controller.ControllerCadastroFornecedor.codigoEndereco = (int) this.telaBuscaEndereço.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndereço.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndereço.getjPanBotoes());
            this.telaBuscaEndereço.dispose();

        }
        if (e.getSource() == this.telaBuscaEndereço.getjButtonSair()) {
            this.telaBuscaEndereço.dispose();
        }
    }

}
