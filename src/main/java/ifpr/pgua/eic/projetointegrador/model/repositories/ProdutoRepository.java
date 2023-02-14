package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Produto;
import ifpr.pgua.eic.projetointegrador.model.daos.ProdutoDAO;
import ifpr.pgua.eic.projetointegrador.model.results.Result;


public class ProdutoRepository {
    
    private ProdutoDAO dao;

    public ProdutoRepository(ProdutoDAO dao) {
        this.dao = dao;
    }

    public Result cadastrar(String nome, String codigo, Double valor, String validade, Long quantidade,
    Integer id_departamento){
        
        Produto produto = new Produto(nome, codigo, valor, validade, quantidade, id_departamento);
        return dao.inserir(produto);
    }

    public List<Produto> listar(){
        return dao.buscarTodos();
    }

    public List<Produto> filtrarPorNome(String nome){
        return Collections.emptyList();
    }

}