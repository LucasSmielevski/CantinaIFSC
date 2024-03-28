package utilities;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;


/**
 *
 * @author aluno
 */
public class Utilities {

    public static void ativaDesativa(boolean ativa, JPanel painel) {

        Component[] componentes = painel.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JButton) {
                if (((JButton) componente).getActionCommand() == "0") {
                    componente.setEnabled(ativa);
                } else {
                    componente.setEnabled(!ativa);
                }

            }
        }
    }

    public static void limpaComponentes(boolean ativa, JPanel painel) {
        Component[] componentes = painel.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JTextArea) {
                ((JTextArea) componente).setText("");
               
            }
             componente.setEnabled(ativa);
        }
    }

    public static void limpaTextArea(boolean ativa, JScrollPane scrollPane) {
        Component[] componentesT = scrollPane.getComponents();
        for (Component componenteTextA : componentesT) {
            if (componenteTextA instanceof JTextArea) {
                ((JTextArea) componenteTextA).setText("");
            }
            componenteTextA.setEnabled(ativa);
        }
    }
    public static boolean verificarApenasNumeros(String str){
        return str.matches("\\d+");
    }
}


