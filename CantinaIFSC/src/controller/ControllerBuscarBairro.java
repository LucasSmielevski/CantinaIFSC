package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import view.TelaBuscaBairro;

/**
 *
 * @author patyx
 */
public class ControllerBuscarBairro implements ActionListener {

    TelaBuscaBairro telaBuscaBairro;

    public ControllerBuscarBairro(TelaBuscaBairro telaBuscaBairro) {
        this.telaBuscaBairro = telaBuscaBairro;

        this.telaBuscaBairro.getjButtonCarregar().addActionListener(this);
        this.telaBuscaBairro.getjButtonSair().addActionListener(this);
        this.telaBuscaBairro.getjButtonFiltrar().addActionListener(this);
        //fazendo a carga inicial de dados , sendo provisorio

        utilities.Utilities.ativaDesativa(true, this.telaBuscaBairro.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaBairro.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaBairro.getjButtonFiltrar()) {
            utilities.Utilities.ativaDesativa(false, this.telaBuscaBairro.getjPanBotoes());
            if (this.telaBuscaBairro.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção!\nOpção de Filtro Vazia.");
                this.telaBuscaBairro.getjTFFitrar().requestFocus();
            } else  {
                List<Bairro> listaBairros = new ArrayList<Bairro>();

                if (this.telaBuscaBairro.getjCBDescricao().getSelectedIndex() == 0) {
                    listaBairros.add(BairroService.carregar(Integer.parseInt(this.telaBuscaBairro.getjTFFitrar().getText())));
                    
                } else if (this.telaBuscaBairro.getjCBDescricao().getSelectedIndex() == 1) {
                    listaBairros = BairroService.carregar(this.telaBuscaBairro.getjTFFitrar().getText().trim());
                }

                //Criar um objeto do tipo TableModel
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaBairro.getjTableDados().getModel();
                tabela.setRowCount(0);
                for (Bairro bairroAtual : listaBairros) {
                    tabela.addRow(new Object[]{bairroAtual.getId(),
                        bairroAtual.getDescricao()});
                }
            }

        }
        if (e.getSource() == this.telaBuscaBairro.getjButtonCarregar()) {
            controller.ControllerCadastroBairro.codigo = (int) this.telaBuscaBairro.
                    getjTableDados().
                    getValueAt(this.telaBuscaBairro.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaBairro.getjPanBotoes());
            this.telaBuscaBairro.dispose();

            controller.ControllerCadastroEndereco.codigoBairro = (int) this.telaBuscaBairro.
                    getjTableDados().
                    getValueAt(this.telaBuscaBairro.getjTableDados().getSelectedRow(), 0);
            utilities.Utilities.ativaDesativa(true, this.telaBuscaBairro.getjPanBotoes());
            this.telaBuscaBairro.dispose();

        }
        if (e.getSource() == this.telaBuscaBairro.getjButtonSair()) {
            this.telaBuscaBairro.dispose();
        }
    }
}
