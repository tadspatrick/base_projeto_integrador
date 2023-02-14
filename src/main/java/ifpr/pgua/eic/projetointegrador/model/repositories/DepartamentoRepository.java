package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Departamento;
import ifpr.pgua.eic.projetointegrador.model.daos.DepartamentoDAO;
import ifpr.pgua.eic.projetointegrador.model.results.Result;


public class DepartamentoRepository {
    
    private DepartamentoDAO dao;

    public DepartamentoRepository(DepartamentoDAO dao) {
        this.dao = dao;
    }

    public Result cadastrar(String nome, String responsavel){
        
        Departamento departamento = new Departamento(nome, responsavel);
        return dao.inserir(departamento);
    }

    public List<Departamento> listar(){
        return dao.buscarTodos();
    }

    public List<Departamento> filtrarPorNome(String nome){
        return Collections.emptyList();
    }

}