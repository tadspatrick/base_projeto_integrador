package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Departamento;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCDepartamentoDAO implements DepartamentoDAO {

    private FabricaConexoes fabricaConexao;

    public JDBCDepartamentoDAO(FabricaConexoes fabricaConexao) {
        this.fabricaConexao = fabricaConexao;
    }

    @Override
    public Result inserir(Departamento departamento) {

        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO vendedores(nome, responsavel, produtos) VALUES (?,?,?)");

            pstm.setString(1, departamento.getNome());
            pstm.setString(2, departamento.getResponsavel());
            pstm.setArray(3, departamento.getProdutos());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Departamento cadastrado!");

        } catch (SQLException e) {
            return Result.fail(e.getMessage());
        }
    }

    public List<Departamento> buscarTodos() {
        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM departamentos");

            ResultSet resultSet = pstm.executeQuery();

            ArrayList<Departamento> departamentos = new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String responsavel = resultSet.getString("responsavel");
                Array produtos = resultSet.getArray("produtos");

                Departamento departamento = new Departamento(id, nome, responsavel, produtos);

                departamentos.add(departamento);
            }

            resultSet.close();
            pstm.close();
            con.close();
            return departamentos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
