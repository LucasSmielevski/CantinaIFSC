/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Produto;
import view.TelaBuscaProduto;
import view.TelaCadastroProduto;

/**
 *
 * @author patyx
 */
public class ControllerCadastroProduto implements ActionListener {

    TelaCadastroProduto telaCadastroProduto;
    public static int codigo;

    public ControllerCadastroProduto(TelaCadastroProduto telaCadastroProduto) {
        this.telaCadastroProduto = telaCadastroProduto;

        this.telaCadastroProduto.getjBNovo().addActionListener(this);
        this.telaCadastroProduto.getjBBuscar().addActionListener(this);
        this.telaCadastroProduto.getjBCancelar().addActionListener(this);
        this.telaCadastroProduto.getjBSair().addActionListener(this);
        this.telaCadastroProduto.getjBGravar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.telaCadastroProduto.getjPanBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroProduto.getjPanDados());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroProduto.getjBNovo()) {
            utilities.Utilities.ativaDesativa(false, this.telaCadastroProduto.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroProduto.getjPanDados());
            this.telaCadastroProduto.getjTFID().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroProduto.getjBCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.telaCadastroProduto.getjPanBotoes());
            utilities.Utilities.limpaComponentes(true, this.telaCadastroProduto.getjPanDados());
            //Gravar
        } else if (e.getSource() == this.telaCadastroProduto.getjBGravar()) {
            Produto produto = new Produto();

            produto.setDescricao(this.telaCadastroProduto.getjTADescricao().getText());
            produto.setCodigoBarra(this.telaCadastroProduto.getjTFCodBarra().getText());
            String texto = this.telaCadastroProduto.getjTFValorUnit().getText();
            String texto2 = this.telaCadastroProduto.getjTFQntd().getText();
            float valorFloat = Float.parseFloat(texto);
            float valorFloat2 = Float.parseFloat(texto2);
            produto.setValorUnit(valorFloat);
            produto.setQuantidade(valorFloat2);

            if (this.telaCadastroProduto.getjTFID().getText().equalsIgnoreCase("")) {

                service.ProdutoService.adicionar(produto);

            } else {
                produto.setId(Integer.parseInt(this.telaCadastroProduto.getjTFID().getText()));
                service.ProdutoService.atualizar(produto);
            }
            utilities.Utilities.ativaDesativa(true, this.telaCadastroProduto.getjPanBotoes());
            utilities.Utilities.limpaComponentes(false, this.telaCadastroProduto.getjPanDados());
        } else if (e.getSource() == this.telaCadastroProduto.getjBBuscar()) {
            codigo = 0;
            TelaBuscaProduto telaBuscaProduto = new TelaBuscaProduto(null, true);
            ControllerBuscarProduto controllerBuscarProduto = new ControllerBuscarProduto(telaBuscaProduto);
            telaBuscaProduto.setVisible(true);

            if (codigo != 0) {
                Produto produto = new Produto();
                produto = service.ProdutoService.carregar(codigo);
                utilities.Utilities.ativaDesativa(false, this.telaCadastroProduto.getjPanBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroProduto.getjPanDados());

                this.telaCadastroProduto.getjTADescricao().setText(produto.getDescricao());
                this.telaCadastroProduto.getjTFID().setText(produto.getId() + "");
                this.telaCadastroProduto.getjTFCodBarra().setText(produto.getCodigoBarra());
                this.telaCadastroProduto.getjTFValorUnit().setText(String.valueOf(produto.getValorUnit()));
                this.telaCadastroProduto.getjTFQntd().setText(String.valueOf(produto.getQuantidade()));

                this.telaCadastroProduto.getjTFID().setEnabled(false);
            } else if (e.getSource() == this.telaCadastroProduto.getjBSair()) {
                this.telaCadastroProduto.dispose();
            }
        }
    }
}
