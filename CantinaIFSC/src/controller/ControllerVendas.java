/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Funcionario;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import model.bo.MovimentacaoEstoque;
import view.TelaBuscaCarteirinha;
import view.TelaBuscaFuncionario;
import view.TelaBuscaProduto;
import view.TelaVenda;

/**
 *
 * @author patyx
 */
public class ControllerVendas implements ActionListener, KeyListener {

    TelaVenda telaVenda;
    TelaBuscaCarteirinha telaBuscaCarteirinha;
    public static int codigoCarteirinha, codigoFuncionario, codigoProduto, codigoItemVenda, codigoItemCompra;
    public float quantid;

    public ControllerVendas(TelaVenda telaVenda) {
        this.telaVenda = telaVenda;
        this.telaVenda.setController(this);

        this.telaVenda.getjButton2().addActionListener(this);
        //this.telaVenda.getjBBuscarProduto().addActionListener(this);
        this.telaVenda.getjTextFieldProduto().addKeyListener(this);
        this.telaVenda.getjTFQuantidade().addKeyListener(this);
        this.telaVenda.getjTFDescontoValor().addKeyListener(this);
        this.telaVenda.getjTFDescontoPorcentagem().addKeyListener(this);
        this.telaVenda.getjButtonAbrir().addActionListener(this);
        this.telaVenda.getjButtonFechar().addActionListener(this);
        this.telaVenda.getjBBuscarFunc().addActionListener(this);

        this.telaVenda.getjTFQuantidade().setEnabled(false);
        this.telaVenda.getjTFValorCaixa().setEnabled(false);
        this.telaVenda.getjTextFieldUsuario().setEnabled(false);
        this.telaVenda.getjTextFieldSenha().setEnabled(false);
        this.telaVenda.getjTFHoraFecharCaixa().setEnabled(false);
        this.telaVenda.getjButtonFechar().setEnabled(false);
        this.telaVenda.getjTFHoraCaixaAbr().setEnabled(false);
        this.telaVenda.getjTFIdProduto().setEnabled(false);
        this.telaVenda.getjTFValorTotalDesconto().setEnabled(false);
        this.telaVenda.getjButtonAbrir().setEnabled(false);

        // Obtém todos os componentes do JPanel
        Component[] components = telaVenda.getjPanel1().getComponents();

        // Percorre todos os componentes e os desabilita
        for (Component component : components) {
            component.setEnabled(false);
            telaVenda.getjButton2().setEnabled(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaVenda.getjButton2()) {
            buscarCarteirinha();
        } /*else if (e.getSource() == this.telaVenda.getjBBuscarProduto()) {
            buscarProduto();
        } */else if (e.getSource() == this.telaVenda.getjBBuscarFunc()) {
            buscarFuncionario();

            //Abrir Caixa
        } else if (e.getSource() == this.telaVenda.getjButtonAbrir()) {
            Component[] components = telaVenda.getjPanel1().getComponents();
            for (Component component : components) {
                component.setEnabled(true);
            }
            Component[] components2 = telaVenda.getjPanel11().getComponents();
            for (Component component : components2) {
                component.setEnabled(false);
            }
            // Obtém a data e hora atuais
            LocalDateTime dataHoraAtual = LocalDateTime.now();

            // Define o formato desejado para exibição
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            // Converte a data e hora para uma string formatada
            String dataHoraFormatada = dataHoraAtual.format(formatter);

            // Define a string formatada no campo de texto
            telaVenda.getjTFHoraCaixaAbr().setText(dataHoraFormatada);
            telaVenda.getjButtonFechar().setEnabled(true);
            telaVenda.getjButton2().setEnabled(true);
            telaVenda.getjTextAreaOBS().setEnabled(false);
            telaVenda.getjTextFieldValorUnit().setEnabled(false);
            telaVenda.getjTextFieldValorUnit1().setEnabled(false);
            telaVenda.getjTFValorTotal().setEnabled(false);
            telaVenda.getjTFTroco().setEnabled(false);
            telaVenda.getjTFValorRecebido().setEnabled(false);
            telaVenda.getjTFCodBarras().setEnabled(false);
            telaVenda.getjTFHoraFecharCaixa().setEnabled(false);
            telaVenda.getjTFIdProduto().setEnabled(false);
            telaVenda.getjTFValorTotalDesconto().setEnabled(false);
            //telaVenda.getjBBuscarProduto1().setEnabled(false);
            utilities.Utilities.limpaComponentes(true, telaVenda.getjPanel4());
            telaVenda.getjTFValorRecebido().setText("0.00");
            telaVenda.getjTFQuantidade().setText("1");
            telaVenda.getjTFDescontoValor().setText("0.00");
            telaVenda.getjTFDescontoPorcentagem().setText("0");
            caixa();

            //Fechar Caixa
        } else if (e.getSource() == this.telaVenda.getjButtonFechar()) {
            // Obtém a data e hora atuais
            LocalDateTime dataHoraAtual = LocalDateTime.now();

            // Define o formato desejado para exibição
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            // Converte a data e hora para uma string formatada
            String dataHoraFormatada = dataHoraAtual.format(formatter);

            utilities.Utilities.limpaComponentes(true, telaVenda.getjPanel1());
            DefaultTableModel model = (DefaultTableModel) telaVenda.getjTable1().getModel();
            // Remove todas as linhas do modelo
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            telaVenda.getjTFHoraFecharCaixa().setText(dataHoraFormatada);
            abertFechCaixa();
            telaVenda.getjTextFieldSenha().setEnabled(true);
            telaVenda.getjTextFieldTroco().setEnabled(true);
            telaVenda.getjTextFieldUsuario().setEnabled(true);
            telaVenda.getjButtonAbrir().setEnabled(true);
            telaVenda.getjTextAreaOBS().setEnabled(true);
            telaVenda.getjBBuscarFunc().setEnabled(true);
            telaVenda.getjButton2().setEnabled(false);
            telaVenda.getjTextFieldUsuario().setEnabled(false);
            telaVenda.getjTextFieldSenha().setEnabled(false);
            telaVenda.getjTFHoraFecharCaixa().setEnabled(false);
            telaVenda.getjTFHoraCaixaAbr().setEnabled(false);
            String caixa = telaVenda.getjTFValorCaixa().getText();
            utilities.Utilities.limpaComponentes(true, telaVenda.getjPanel11());
            telaVenda.getjTextFieldTroco().setText(caixa);
            Component[] components = telaVenda.getjPanel1().getComponents();
            for (Component component : components) {
                component.setEnabled(false);
            }
            telaVenda.getjButtonFechar().setEnabled(false);
            telaVenda.getjTFValorCaixa().setEnabled(false);
        } /*else if (e.getSource() == this.telaVenda.getjBBuscarProduto()) {
            buscarProduto();
        }*/
    }

    public void acaoF6Botao() {
        // Lógica para lidar com a ação do F1 no botão
        TelaBuscaCarteirinha telaBuscaCarteirinha = new TelaBuscaCarteirinha(telaVenda, true);
        ControllerBuscarCarteirinha controllerBuscarCarteirinha = new ControllerBuscarCarteirinha(telaBuscaCarteirinha);
        telaBuscaCarteirinha.setVisible(true);

        if (codigoCarteirinha != 0) {
            Carteirinha carteirinha = service.CarteirinhaService.carregar(codigoCarteirinha);
            this.telaVenda.getjTFIdCliente().setText(String.valueOf(carteirinha.getId()));
            this.telaVenda.getjTFNomeCli().setText(carteirinha.getCliente().getNome());
            this.telaVenda.getjTFCarteirinha().setText(carteirinha.getCodigoBarra());
        }
    }

    public void abertFechCaixa() {
        Caixa caixa = new Caixa();
        String dataHoraAbertura = telaVenda.getjTFHoraCaixaAbr().getText();
        String dataHoraFechamento = telaVenda.getjTFHoraFecharCaixa().getText();
        float valorAbertura = Float.parseFloat(telaVenda.getjTextFieldTroco().getText());
        float valorFechamento = Float.parseFloat(telaVenda.getjTFValorCaixa().getText());
        String observacao = telaVenda.getjTextAreaOBS().getText();

        caixa.setDataHoraAbertura(dataHoraAbertura);
        caixa.setDataHoraFechamento(dataHoraFechamento);
        caixa.setValorAbertura(valorAbertura);
        caixa.setValorFechamento(valorFechamento);
        caixa.setObservacao(observacao);

        caixa.setFuncionario(service.FuncionarioService.carregar(codigoFuncionario));
        service.CaixaService.adicionar(caixa);

    }

    public void acaoF1Botao() {
        // Lógica para lidar com a ação do F1 no botão
        TelaBuscaProduto telaBuscaProduto = new TelaBuscaProduto(telaVenda, true);
        ControllerBuscarProduto controllerBuscarProduto = new ControllerBuscarProduto(telaBuscaProduto);
        telaBuscaProduto.setVisible(true);

        if (codigoProduto != 0) {
            Produto produto = service.ProdutoService.carregar(codigoProduto);
            this.telaVenda.getjTextFieldProduto().setText(produto.getDescricao());
            this.telaVenda.getjTextFieldValorUnit().setText(String.valueOf(produto.getValorUnit()));
            this.telaVenda.getjTFCodBarras().setText(produto.getCodigobarra());
            this.telaVenda.getjTFQuantidade().setEnabled(true);
        }
    }

    private void buscarCarteirinha() {
        TelaBuscaCarteirinha telaBuscaCarteirinha = new TelaBuscaCarteirinha(telaVenda, true);
        ControllerBuscarCarteirinha controllerBuscarCarteirinha = new ControllerBuscarCarteirinha(telaBuscaCarteirinha);
        telaBuscaCarteirinha.setVisible(true);

        if (codigoCarteirinha != 0) {
            Carteirinha carteirinha = service.CarteirinhaService.carregar(codigoCarteirinha);
            this.telaVenda.getjTFIdCliente().setText(String.valueOf(carteirinha.getId()));
            this.telaVenda.getjTFNomeCli().setText(carteirinha.getCliente().getNome());
            this.telaVenda.getjTFCarteirinha().setText(carteirinha.getCodigoBarra());
        }
    }

    private void buscarFuncionario() {
        TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario(telaVenda, true);
        ControllerBuscarFuncionario controllerBuscarFuncionario = new ControllerBuscarFuncionario(telaBuscaFuncionario);
        telaBuscaFuncionario.setVisible(true);

        if (codigoFuncionario != 0) {
            Funcionario funcionario = service.FuncionarioService.carregar(codigoFuncionario);
            this.telaVenda.getjTextFieldUsuario().setText(funcionario.getUsuario());
            this.telaVenda.getjTextFieldSenha().setText(funcionario.getSenha());
            this.telaVenda.getjButtonAbrir().setEnabled(true);
        }
    }

    private void buscarProduto() {
        TelaBuscaProduto telaBuscaProduto = new TelaBuscaProduto(null, true);
        ControllerBuscarProduto controllerBuscarProduto = new ControllerBuscarProduto(telaBuscaProduto);
        telaBuscaProduto.setVisible(true);

        if (codigoProduto != 0) {
            Produto produto = service.ProdutoService.carregar(codigoProduto);
            this.telaVenda.getjTextFieldProduto().setText(produto.getDescricao());
            this.telaVenda.getjTextFieldValorUnit().setText(String.valueOf(produto.getValorUnit()));
            this.telaVenda.getjTFCodBarras().setText(produto.getCodigobarra());
            this.telaVenda.getjTFQuantidade().setEnabled(true);

        }
    }

    public void calcularValorFinal() {
        DefaultTableModel model = (DefaultTableModel) this.telaVenda.getjTable1().getModel();
        int rowCount = model.getRowCount();
        float valorTotal = 0;

        for (int i = 0; i < rowCount; i++) {
            // Supondo que a última coluna (índice -1) contém o valor total de cada item
            float valorItem = Float.parseFloat(model.getValueAt(i, model.getColumnCount() - 1).toString());
            valorTotal += valorItem;
        }
        this.telaVenda.getjTFValorTotal().setText(String.valueOf(valorTotal));
    }

    public void CalcPorc() {
        DefaultTableModel modelDescP = (DefaultTableModel) this.telaVenda.getjTable1().getModel();
        int rowCount = modelDescP.getRowCount();
        float descontoTotalP = 0; // Inicializando o desconto total
        float descontoTotal = 0;

        for (int i = 0; i < rowCount; i++) {
            float descontoAdicional = 0;
            float descontoPercentual = 0;

            // Verifica se há desconto na antepenúltima coluna e adiciona ao desconto total
            if (modelDescP.getValueAt(i, modelDescP.getColumnCount() - 3) != null) {
                descontoAdicional = Float.parseFloat(modelDescP.getValueAt(i, modelDescP.getColumnCount() - 3).toString());
                descontoTotal += descontoAdicional;
            } else {

            }
            // Se não houver desconto na antepenúltima coluna, verifica a penúltima coluna
            if (modelDescP.getValueAt(i, modelDescP.getColumnCount() - 2) != null) {
                descontoPercentual = Float.parseFloat(modelDescP.getValueAt(i, modelDescP.getColumnCount() - 2).toString());
                descontoTotalP += descontoPercentual;
            } else {
            }
            float total = descontoTotal + descontoTotalP;
            this.telaVenda.getjTFValorTotalDesconto().setText(String.valueOf(total));
        }
    }

    public void Troco() {
        DefaultTableModel model = (DefaultTableModel) this.telaVenda.getjTable1().getModel();
        int rowCount = model.getRowCount();
        float valorTotal = 0;
        float valorRecebido = 0;
        float troco = 0;

        for (int i = 0; i < rowCount; i++) {
            // Supondo que a última coluna (índice -1) contém o valor total de cada item
            float valorItem = Float.parseFloat(model.getValueAt(i, model.getColumnCount() - 1).toString());
            valorTotal += valorItem;
        }

        String valorR = telaVenda.getjTFValorRecebido().getText();
        if (!valorR.isEmpty()) {
            try {
                valorRecebido = Float.parseFloat(valorR);
                if (valorRecebido >= valorTotal) {
                    troco = valorRecebido - valorTotal;
                } else {
                    //JOptionPane.showMessageDialog(telaVenda, "Valor Recebido não pode ser menor que o Valor Total");
                    telaVenda.getjTFValorRecebido().setText(String.valueOf(valorTotal));
                }
            } catch (NumberFormatException e) {
                // Exibe uma mensagem de erro informando que o valor inserido não é válido.
                JOptionPane.showMessageDialog(telaVenda, "Valor inválido inserido no campo de valor recebido."
                        + "\n Provável erro: o número está com  ','  troque por  '.'");
            }
        } else {
            // Se o campo estiver vazio, não faz o cálculo do troco
            JOptionPane.showMessageDialog(telaVenda, "O campo de valor recebido está vazio.");
        }
        if (valorRecebido > valorTotal) {
            troco = valorRecebido - valorTotal;
        }

        this.telaVenda.getjTFTroco().setText(String.valueOf(troco));
    }

    public void caixa() {
        float trocoCaixa = 0;
        float valorCaixa = 0;

        String TrocoCaixa = telaVenda.getjTextFieldTroco().getText();

        telaVenda.getjTFValorCaixa().setText(TrocoCaixa);
        telaVenda.getjTFHoraFecharCaixa().setEnabled(false);
        telaVenda.getjTFHoraCaixaAbr().setEnabled(false);

    }

    public void quantidade() {

        String busca = this.telaVenda.getjTextFieldProduto().getText();
        List<Produto> produtoo = new ArrayList<Produto>();
        if (utilities.Utilities.verificarApenasNumeros(busca)) {
            produtoo = service.ProdutoService.carregar(busca);
        } else {
            produtoo = service.ProdutoService.carregar(busca);
        }
        //float qntd2 = produtoo.get(0).getQuantidade();

        String Quantidade = telaVenda.getjTFQuantidade().getText();
        quantid = Float.parseFloat(Quantidade);

        //float QntdAtalizado = quantid;
        produtoo.get(codigoProduto).setQuantidade(quantid);
        service.ProdutoService.atualizar(produtoo.get(codigoProduto));

        //System.out.println(quantid);
    }

    /* public void MovEstoque() {
        MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque();
        //ItemVenda itemVenda = service.VendaService.carregarItemVenda(codigoItemVenda);
        Produto produto = service.ProdutoService.carregar(codigoProduto);
        ItemCompra itemCompra = new ItemCompra();

        movimentacaoEstoque.setDataHoraMovimento(pegarDataeHora());

        //float qtdMovimentada = produto.getQuantidade() ;
        // movimentacaoEstoque.setQtdMovimentada(qtdMovimentada);
        movimentacaoEstoque.setItemVenda(service.VendaService.carregarItemVenda(codigoItemVenda));
        System.out.println(codigoItemVenda);

        movimentacaoEstoque.setItemCompra(itemCompra);
        movimentacaoEstoque.setFuncionario(service.FuncionarioService.carregar(codigoFuncionario));
        service.MovimentEstoqueService.adicionar(movimentacaoEstoque);

    }*/
    public void fecharvenda() {
        float valorCaixa = 0;
        float valorVenda = 0;
        float valorTroco = 0;
        float valorTotal = 0;
        float valorTotalDesc = 0;

        DefaultTableModel model2 = (DefaultTableModel) this.telaVenda.getjTable1().getModel();

        // Lista para armazenar os IDs dos produtos
        List<Produto> produtosParaVenda = new ArrayList<>();

        // Iterar pelas linhas da tabela para capturar os IDs dos produtos
        for (int i = 0; i < model2.getRowCount(); i++) {
            int idProduto = (int) model2.getValueAt(i, 0);

            // Supondo que você tenha um método no seu DAO de Produto para obter um produto por ID
            Produto produto = service.ProdutoService.carregar(idProduto);

            if (produto != null) {
                produtosParaVenda.add(produto);
            }
        }
        System.out.println(produtosParaVenda);

        String valor = telaVenda.getjTFValorTotal().getText();
        String ValorCaixa = telaVenda.getjTFValorCaixa().getText();
        String ValorTroc = telaVenda.getjTFTroco().getText();
        String ValorTot = telaVenda.getjTFValorTotal().getText();
        String ValorTD = telaVenda.getjTFValorTotalDesconto().getText();
        String Nome = telaVenda.getjTFNomeCli().getText();

        if (!valor.isEmpty() && !ValorCaixa.isEmpty() && !ValorTroc.isEmpty() && !ValorTot.isEmpty() && !ValorTD.isEmpty()) {
            valorCaixa = Float.parseFloat(ValorCaixa);
            valorVenda = Float.parseFloat(valor);
            valorTroco = Float.parseFloat(ValorTroc);
            valorTotal = Float.parseFloat(ValorTot);
            valorTotalDesc = Float.parseFloat(ValorTD);
        } else {
            // Lide com o caso em que algum campo está vazio
        }

        utilities.Utilities.limpaComponentes(true, telaVenda.getjPanel1());
        DefaultTableModel model = (DefaultTableModel) telaVenda.getjTable1().getModel();
        // Remove todas as linhas do modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        if (Nome.isEmpty()) {
            JOptionPane.showMessageDialog(telaVenda, "Campo cliente tem que ser preenchido");
            telaVenda.getjTFValorRecebido().setText("0.00");
            telaVenda.getjTFQuantidade().setText("1");
            telaVenda.getjTFDescontoValor().setText("0.00");
            telaVenda.getjTFDescontoPorcentagem().setText("0");
            return;
        } else {
            float valorAtualizado = valorCaixa + valorVenda - valorTroco;
            String valorAtualizadoString = Float.toString(valorAtualizado);
            telaVenda.getjTFValorCaixa().setText(valorAtualizadoString);

            telaVenda.getjTFValorRecebido().setEnabled(false);
            telaVenda.getjTFValorRecebido().setText("0.00");
            telaVenda.getjTFQuantidade().setText("1");
            telaVenda.getjTFDescontoValor().setText("0.00");
            telaVenda.getjTFDescontoPorcentagem().setText("0");

            Venda venda = new Venda();
            venda.setDataHoraVenda(pegarDataeHora());
            venda.setCarteirinha(service.CarteirinhaService.carregar(codigoCarteirinha));
            venda.setFuncionario(service.FuncionarioService.carregar(codigoFuncionario));
            venda.setProdutos(produtosParaVenda);
            venda.setValorTotal(valorTotal);
            venda.setValorDesconto(valorTotalDesc);
            service.VendaService.adicionar(venda);
        }
    }

    public String pegarDataeHora() {
        // Obtém a data e hora atuais
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        // Define o formato desejado para exibição
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Converte a data e hora para uma string formatada
        String dataHoraFormatada = dataHoraAtual.format(formatter);

        // Define a string formatada no campo de texto
        return dataHoraFormatada;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String busca = this.telaVenda.getjTextFieldProduto().getText();
            Produto produtoo = new Produto();
            List<Produto> produto = new ArrayList<>();
            if (utilities.Utilities.verificarApenasNumeros(busca)) {
                produto = service.ProdutoService.carregar(busca);
            } else {
                produto = service.ProdutoService.carregar(busca);
            }
            this.telaVenda.getjTFIdProduto().setText(String.valueOf(produto.get(0).getId()));
            this.telaVenda.getjTextFieldProduto().setText(produto.get(0).getDescricao());
            this.telaVenda.getjTextFieldValorUnit().setText(String.valueOf(produto.get(0).getValorUnit()));
            this.telaVenda.getjTFCodBarras().setText(produto.get(0).getCodigobarra());
            this.telaVenda.getjTFQuantidade().setEnabled(true);

            if (telaVenda.getjTextFieldProduto() == telaVenda.getjTextFieldProduto()) {
                telaVenda.getjTFQuantidade().requestFocus();
                telaVenda.getjTFDescontoValor().selectAll();
            }

            // telaVenda.getjTextFieldProduto().addKeyListener(new KeyListener() {
            //      @Override
            //       public void keyTyped(KeyEvent e) {
            //       }
            //      @Override
            //      public void keyPressed(KeyEvent e) {
            //    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            //            telaVenda.getjTFQuantidade().requestFocus();
            //            telaVenda.getjTFDescontoValor().selectAll();
            //        }
            //      }
            //   @Override
            //      public void keyReleased(KeyEvent e) {
            //          }
            //     });
            //Fazer calculos do item
            String qnt = this.telaVenda.getjTFQuantidade().getText();
            String valor = this.telaVenda.getjTextFieldValorUnit().getText();
            String desc = this.telaVenda.getjTFDescontoValor().getText();
            String descP = this.telaVenda.getjTFDescontoPorcentagem().getText();
            String nome = this.telaVenda.getjTextFieldProduto().getText();
            String idProduto = this.telaVenda.getjTFIdProduto().getText();
            int idProd = Integer.parseInt(idProduto);

            try {
                float quantidade = Float.parseFloat(qnt);
                float valorUnitario = Float.parseFloat(valor);
                float desconto = Float.parseFloat(desc);
                float descontoPorc = Float.parseFloat(descP);

                //Calculo do valor final sem Desconto
                float valorFinal = quantidade * valorUnitario;
                // Verifica se os campos de desconto estão vazios ou iguais a 0
                if (Float.compare(desconto, 0.0f) == 0) {
                    this.telaVenda.getjTFDescontoPorcentagem().setEnabled(true);
                } else {
                    this.telaVenda.getjTFDescontoPorcentagem().setEnabled(false);
                    this.telaVenda.getjTFDescontoValor().setEnabled(true);
                }

                if (Float.compare(descontoPorc, 0.0f) == 0) {
                    this.telaVenda.getjTFDescontoValor().setEnabled(true);
                } else {
                    this.telaVenda.getjTFDescontoValor().setEnabled(false);
                    this.telaVenda.getjTFDescontoPorcentagem().setEnabled(true);
                }
                //Calculo do Valor final com Desconto
                if (desconto > 0) {
                    if (desconto > valorUnitario * quantidade) {
                        JOptionPane.showMessageDialog(telaVenda, "Desconto não pode ser maior que o valor do produto.");
                        this.telaVenda.getjTFDescontoValor().setText("0");
                        this.telaVenda.getjTextFieldValorUnit1().setText(String.valueOf(valorUnitario * quantidade));
                        return;
                    }
                    valorFinal -= desconto;
                } else if (descontoPorc > 0) {
                    if (descontoPorc > 100) {
                        JOptionPane.showMessageDialog(telaVenda, "A porcentagem de desconto não pode ser maior que 100%.");
                        this.telaVenda.getjTFDescontoPorcentagem().setText("0");
                        this.telaVenda.getjTextFieldValorUnit1().setText(String.valueOf(valorUnitario * quantidade));
                        return; // Sai do método se a condição não for atendida        
                    }
                }
                float valorFinalDesc = (descontoPorc / 100) * valorFinal;
                valorFinal -= valorFinalDesc;
                // Limitando o valor final a duas casas decimais
                valorFinal = Math.round(valorFinal * 100.0) / 100.0f;
                if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (quantidade > 0) {
                        DefaultTableModel model = (DefaultTableModel) this.telaVenda.getjTable1().getModel();
                        model.addRow(new Object[]{idProd, nome, quantidade, valorUnitario, desconto, valorFinalDesc, valorFinal});
                        calcularValorFinal();
                        Troco();
                        quantidade();
                        CalcPorc();
                        telaVenda.getjTFValorRecebido().setEnabled(true);
                        //Volta o foco para o campos de nome do produto
                        telaVenda.getjTextFieldProduto().requestFocus();
                        telaVenda.getjTextFieldProduto().selectAll();
                    } else {
                        JOptionPane.showMessageDialog(telaVenda, "Quantidade tem que ser maior que 0");
                        telaVenda.getjTFQuantidade().requestFocus();
                    }

                    //Volta os campos para padrão após adicionar o item a lista
                    telaVenda.getjTFQuantidade().setText("0");
                    telaVenda.getjTFDescontoValor().setText("0.00");
                    telaVenda.getjTFDescontoPorcentagem().setText("0");
                    telaVenda.getjTextFieldValorUnit1().setText(valor);

                    //Remover item na tabela com a tecla delete
                    this.telaVenda.getjTable1().addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                                int linhaSelecionada = telaVenda.getjTable1().getSelectedRow();
                                calcularValorFinal();

                                if (linhaSelecionada != -1) {
                                    DefaultTableModel model = (DefaultTableModel) telaVenda.getjTable1().getModel();
                                    model.removeRow(linhaSelecionada);
                                }
                            }
                        }
                    });
                }

                //Adicionando o valor final no campos valor final do item
                this.telaVenda.getjTextFieldValorUnit1().setText(String.valueOf(valorFinal));
                Troco();
                //Adicionar itens a tabela atráves da tecla Shift+Enter

            } catch (NumberFormatException es) {
                // Lidar com a situação em que a conversão falha (strings não representam números válidos)
                // Por exemplo: exibir uma mensagem de erro ou tomar uma ação alternativa
                JOptionPane.showMessageDialog(this.telaVenda, "Os números digitados não "
                        + "representam números válidos.\n Provável erro: o número está com  ','  troque por  '.'");
            }
        }

    }

}
