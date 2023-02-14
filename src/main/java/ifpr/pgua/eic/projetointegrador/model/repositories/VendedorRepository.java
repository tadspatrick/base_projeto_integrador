package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Vendedor;
import ifpr.pgua.eic.projetointegrador.model.daos.VendedorDAO;
import ifpr.pgua.eic.projetointegrador.model.results.Result;


public class VendedorRepository {
    
    private VendedorDAO dao;

    public VendedorRepository(VendedorDAO dao) {
        this.dao = dao;
    }

    public Result cadastrar(String nome, String prontuario, String email, String senha){
        if(!email.contains("@")){
            return Result.fail("E-mail inválido!");
        }
        
        Vendedor vendedor = new Vendedor(nome, prontuario, email, senha);
        return dao.inserir(vendedor);
    }

    public List<Vendedor> listar(){
        return dao.buscarTodos();
    }

    public List<Vendedor> filtrarPorNome(String nome){
        return Collections.emptyList();
    }

    public Result fazerLogin(String email, String senha){
        if(!email.contains("@")){
            return Result.fail("E-mail inválido!");
        }
        
        return dao.fazerLogin(email, senha);
    }
}