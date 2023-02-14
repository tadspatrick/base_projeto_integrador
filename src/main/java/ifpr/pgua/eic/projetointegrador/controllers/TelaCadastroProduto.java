package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.model.repositories.ProdutoRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastroProduto implements Initializable {
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfValor;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfValidade;

    @FXML
    private TextField tfDepartamento;


    private ProdutoRepository repositorio;

    public TelaCadastroProduto(ProdutoRepository repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    private void cadastrar(ActionEvent evento){
        String nome = tfNome.getText();
        String codigo = tfCodigo.getText();
        Double valor = Double.parseDouble(tfValor.getText());
        String validade = tfValidade.getText();
        Long quantidade = Long.parseLong(tfQuantidade.getText());
        Integer departamento = Integer.parseInt(tfDepartamento.getText());

        Result resultado = repositorio.cadastrar(nome, codigo, valor, validade, quantidade, departamento);
        
        String msg = resultado.getMsg();

        if(resultado instanceof SuccessResult){
            limpar();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();


    }

    private void limpar(){
        tfNome.clear();
        tfCodigo.clear();
        tfQuantidade.clear();
        tfValidade.clear();
        tfValor.clear();
        tfDepartamento.clear();
    }

    @FXML
    private void voltar(){
        App.popScreen();
    }


}