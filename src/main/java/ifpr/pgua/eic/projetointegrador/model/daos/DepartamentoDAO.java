package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Departamento;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface DepartamentoDAO {
    Result inserir(Departamento departamento);
    List<Departamento> buscarTodos();
}
