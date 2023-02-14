package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Vendedor;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface VendedorDAO {
    Result inserir(Vendedor vendedor);
    List<Vendedor> buscarTodos();
    Result fazerLogin(String email, String senha);
}
