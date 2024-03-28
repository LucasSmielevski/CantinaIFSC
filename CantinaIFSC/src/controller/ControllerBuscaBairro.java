
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaBuscaBairro;

/**
 *
 * @author patyx
 */
public class ControllerBuscaBairro implements ActionListener{
    TelaBuscaBairro telaBuscaBairro;

    public ControllerBuscaBairro(TelaBuscaBairro telaBuscaBairro) {
        this.telaBuscaBairro = telaBuscaBairro;
        
        this.telaBuscaBairro.getjButtonCarregar().addActionListener(this);
        this.telaBuscaBairro.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaBuscaBairro.getjPanBotoes());
        utilities.Utilities.limpaComponentes(true, this.telaBuscaBairro.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaBairro.getjButtonSair()) {
            this.telaBuscaBairro.dispose();
    }
    
    
    }
}
