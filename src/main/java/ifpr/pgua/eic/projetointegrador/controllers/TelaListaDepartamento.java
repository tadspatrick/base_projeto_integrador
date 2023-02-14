package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.model.entities.Departamento;
import ifpr.pgua.eic.projetointegrador.model.repositories.DepartamentoRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class TelaListaDepartamento implements Initializable {
    
    @FXML
    private ListView<Departamento> ltvDepartamentos;

    @FXML
    private TextArea taDetalhes;

    @FXML
    private TextField tfBusca;

    private DepartamentoRepository repositorio;

    public TelaListaDepartamento(DepartamentoRepository repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ltvDepartamentos.getItems().clear();
        
        //inicialização do listview    
        ltvDepartamentos.getItems().addAll(repositorio.listar());
    }

    @FXML
    private void mostrarDetalhes(MouseEvent evento){
        Departamento departamento = ltvDepartamentos.getSelectionModel().getSelectedItem();

        if(departamento != null){
            taDetalhes.clear();
            taDetalhes.appendText("Nome: "+departamento.getNome()+"\n");
            taDetalhes.appendText("Responsavel: "+departamento.getResponsavel()+"\n");
        }
    }

    @FXML
    private void voltar(){
        App.popScreen();
    }


}