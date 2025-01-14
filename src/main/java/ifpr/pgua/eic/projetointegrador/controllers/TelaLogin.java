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

public class TelaLogin implements Initializable {

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    private VendedorRepository repositorio;

    public TelaLogin(VendedorRepository repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    @FXML
    private void carregaTelaCadastro(ActionEvent evento) {
        App.pushScreen("CADASTRO");
    }

    @FXML
    private void logar(ActionEvent evento) {
       String email = tfEmail.getText();
       String senha = tfSenha.getText();

       Result resultado = repositorio.fazerLogin(email,senha);

       String msg = resultado.getMsg();

        if(resultado instanceof SuccessResult){
            App.pushScreen("PRINCIPAL");
        }

        Alert alert = new Alert(AlertType.INFORMATION,msg);
        alert.showAndWait();
    }


}