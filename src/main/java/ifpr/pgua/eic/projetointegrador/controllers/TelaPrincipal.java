package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TelaPrincipal extends BaseController {
    

    @FXML
    private void carregaTelaCadastro(ActionEvent evento) {
        App.pushScreen("CADASTRO");
    }

    @FXML
    private void carregaTelaCadastroDepartamento(ActionEvent evento) {
        App.pushScreen("CADASTRO-DEPARTAMENTO");
    }

    @FXML
    private void carregaTelaCadastroProduto(ActionEvent evento) {
        App.pushScreen("CADASTRO-PRODUTO");
    }

    @FXML
    private void deslogar(){
        App.pushScreen("LOGIN");
    }

}
