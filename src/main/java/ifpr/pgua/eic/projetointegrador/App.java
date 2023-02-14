package ifpr.pgua.eic.projetointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.projetointegrador.controllers.TelaPrincipal;
import ifpr.pgua.eic.projetointegrador.controllers.TelaCadastro;
import ifpr.pgua.eic.projetointegrador.controllers.TelaLogin;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCVendedorDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.VendedorDAO;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.ScreenRegistryFXML;
import ifpr.pgua.eic.projetointegrador.model.repositories.VendedorRepository;


/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {


    private FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();
    private VendedorDAO vendedorDAO;
    private VendedorRepository vendedorRepository;

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();
     
        vendedorDAO = new JDBCVendedorDAO(fabricaConexoes);
        vendedorRepository = new VendedorRepository(vendedorDAO);
    
    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }



    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "LOGIN";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Projeto Integrador";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(getClass(), "fxml/principal.fxml", (o)->new TelaPrincipal()));
        registraTela("CADASTRO", new ScreenRegistryFXML(getClass(), "fxml/cadastro.fxml", (o)->new TelaCadastro(vendedorRepository)));
        registraTela("LOGIN", new ScreenRegistryFXML(getClass(), "fxml/login.fxml", (o)->new TelaLogin(vendedorRepository)));
        /*registraTela("CADASTRO-PRODUTO", new ScreenRegistryFXML(getClass(), "fxml/cadastro-produto.fxml", (o)->new TelaCadastroProduto()));
        registraTela("CADASTRO-DEPARTAMENTO", new ScreenRegistryFXML(getClass(), "fxml/cadastro-departamento.fxml", (o)->new TelaCadastroDepartamento()));
        registraTela("RELATORIO", new ScreenRegistryFXML(getClass(), "fxml/relatorio.fxml", (o)->new TelaRelatorio()));*/
        
        //REGISTRAR AS OUTRAS TELAS

    }


}