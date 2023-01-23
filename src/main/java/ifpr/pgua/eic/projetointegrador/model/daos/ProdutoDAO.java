package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Produto;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface ProdutoDAO {
    Result inserir(Produto produto);
    List<Produto> buscarTodos();
}
