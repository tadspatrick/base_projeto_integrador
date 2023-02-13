package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.model.repositories.VendedorRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastro implements Initializable {
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfProntuario;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;


    private VendedorRepository repositorio;

    public TelaCadastro(VendedorRepository repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

    @FXML
    private void cadastrar(ActionEvent evento){
        String nome = tfNome.getText();
        String prontuario = tfProntuario.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();
        
        Result resultado = repositorio.cadastrar(nome, prontuario, email, senha);
        
        String msg = resultado.getMsg();

        if(resultado instanceof SuccessResult){
            limpar();
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();


    }

    private void limpar(){
        tfNome.clear();
        tfProntuario.clear();
        tfEmail.clear();
        tfSenha.clear();
    }

    @FXML
    private void voltar(){
        App.popScreen();
    }


}