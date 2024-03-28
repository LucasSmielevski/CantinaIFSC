package controller;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import view.TelaBuscaBairro;
import view.TelaCadastroBairro;

/**
 *
 * @author aluno
 */
public class ControllerCadastroBairro implements ActionListener {

    TelaCadastroBairro telaCadastroBairro;
    public static int codigo;

    public ControllerCadastroBairro(TelaCadastroBairro telaCadastroBairro) {
        this.telaCadastroBairro = telaCadastroBairro;

        this.telaCadastroBairro.getjBNovo().addActionListener(this);
        this.telaCadastroBairro.getjBBuscar().addActionListener(this);
        this.telaCadastroBairro.getjBCancelar().addActionListener(this);
        this.telaCadastroBairro.getjBSair().addActionListener(this);
        this.telaCadastroBairro.getjBGravar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaCadastroBairro.getjPanBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroBairro.getjPanDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroBairro.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroBairro.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroBairro.getjPanDados());

            this.telaCadastroBairro.getjTFId().setEnabled(false);
        } else if (e.getSource() == this.telaCadastroBairro.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroBairro.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroBairro.getjPanDados());
            
        } else if (e.getSource() == this.telaCadastroBairro.getjBGravar()) {

            Bairro bairro = new Bairro();
            bairro.setDescricao(this.telaCadastroBairro.getjTFDescricao().getText());

              if (bairro.getDescricao().isEmpty()){
                    JOptionPane.showMessageDialog(this.telaCadastroBairro, "Todos os campos devem ser preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            if (this.telaCadastroBairro.getjTFId().getText().equalsIgnoreCase("")) {
               service.BairroService.adicionar(bairro);

            } else {
                bairro.setId(Integer.parseInt(this.telaCadastroBairro.getjTFId().getText()));
                service.BairroService.atualizar(bairro);
            }

            utilities.Utilities.ativaDesativa(true, this.telaCadastroBairro.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroBairro.getjPanDados());

        } else if (e.getSource() == this.telaCadastroBairro.getjBBuscar()) {
            codigo = 0;
            TelaBuscaBairro telaBuscaBairro = new TelaBuscaBairro(null, true);
            ControllerBuscarBairro controllerBuscaBairro = new ControllerBuscarBairro(telaBuscaBairro);
            telaBuscaBairro.setVisible(true);
            

            if (codigo != 0) {
                Bairro bairro = new Bairro();
                bairro = service.BairroService.carregar(codigo);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroBairro.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroBairro.getjPanDados());

                this.telaCadastroBairro.getjTFId().setText(bairro.getId() + "");
                this.telaCadastroBairro.getjTFDescricao().setText(bairro.getDescricao());
                this.telaCadastroBairro.getjTFId().setEnabled(false);
            }

        } else if (e.getSource() == this.telaCadastroBairro.getjBSair()) {
            this.telaCadastroBairro.dispose();
        }
    }

}
