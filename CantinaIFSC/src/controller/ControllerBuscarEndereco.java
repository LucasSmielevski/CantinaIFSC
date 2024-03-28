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
import view.TelaBuscaEndere�o;

/**
 *
 * @author patyx
 */
public class ControllerBuscarEndereco implements ActionListener {

    TelaBuscaEndere�o telaBuscaEndere�o;

    public ControllerBuscarEndereco(TelaBuscaEndere�o telaBuscaEndere�o) {
        this.telaBuscaEndere�o = telaBuscaEndere�o;

        this.telaBuscaEndere�o.getjButtonCarregar().addActionListener(this);
        this.telaBuscaEndere�o.getjButtonSair().addActionListener(this);
        this.telaBuscaEndere�o.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaEndere�o.getjCBDescricao().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaEndere�o.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaEndere�o.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaEndere�o.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaEndere�o.getjPanBotoes());

            if (!this.telaBuscaEndere�o.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Endereco> listaEnderecos = new ArrayList<Endereco>();

                if (this.telaBuscaEndere�o.getjCBDescricao().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaEnderecos.add(service.EnderecoService.carregar(Integer.parseInt(this.telaBuscaEndere�o.getjTFFitrar().getText())));
                } else if (this.telaBuscaEndere�o.getjCBDescricao().getSelectedItem().toString().equalsIgnoreCase("cidade")) {
                    listaEnderecos = service.EnderecoService.carregar("cidade.descricao", this.telaBuscaEndere�o.getjTFFitrar().getText());
                } else if (this.telaBuscaEndere�o.getjCBDescricao().getSelectedItem().toString().equalsIgnoreCase("bairro")) {
                    listaEnderecos = service.EnderecoService.carregar("bairro.descricao", this.telaBuscaEndere�o.getjTFFitrar().getText());
                } else {
                    listaEnderecos = service.EnderecoService.carregar(this.telaBuscaEndere�o.getjCBDescricao().getSelectedItem().toString(), this.telaBuscaEndere�o.getjTFFitrar().getText());
                }

                //Criar um objeto do tipo TableModel
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEndere�o.getjTableDados().getModel();
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
                this.telaBuscaEndere�o.getjTFFitrar().requestFocus();
            }

        }
        if (e.getSource() == this.telaBuscaEndere�o.getjButtonCarregar()) {

            controller.ControllerCadastroEndereco.codigoEndereco = (int) this.telaBuscaEndere�o.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndere�o.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndere�o.getjPanBotoes());
            this.telaBuscaEndere�o.dispose();

            controller.ControllerCadastroCliente.codigoEndereco = (int) this.telaBuscaEndere�o.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndere�o.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndere�o.getjPanBotoes());
            this.telaBuscaEndere�o.dispose();

            controller.ControllerCadastroFuncionario.codigoEndereco = (int) this.telaBuscaEndere�o.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndere�o.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndere�o.getjPanBotoes());
            this.telaBuscaEndere�o.dispose();

            controller.ControllerCadastroFornecedor.codigoEndereco = (int) this.telaBuscaEndere�o.
                    getjTableDados().
                    getValueAt(this.telaBuscaEndere�o.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaEndere�o.getjPanBotoes());
            this.telaBuscaEndere�o.dispose();

        }
        if (e.getSource() == this.telaBuscaEndere�o.getjButtonSair()) {
            this.telaBuscaEndere�o.dispose();
        }
    }

}
