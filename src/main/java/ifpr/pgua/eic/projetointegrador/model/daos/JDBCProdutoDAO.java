package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Produto;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCProdutoDAO implements ProdutoDAO {

    private FabricaConexoes fabricaConexao;

    public JDBCProdutoDAO(FabricaConexoes fabricaConexao) {
        this.fabricaConexao = fabricaConexao;
    }

    @Override
    public Result inserir(Produto produto) {

        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO produtos(nome,codigo,valor,validade,quantidade, id_departamento) VALUES (?,?,?,?,?,?)");

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getCodigo());
            pstm.setDouble(3, produto.getValor());
            pstm.setString(4, produto.getValidade());
            pstm.setLong(5, produto.getQuantidade());
            pstm.setInt(6, produto.getId_departamento());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Produto cadastrado!");

        } catch (SQLException e) {
            return Result.fail(e.getMessage());
        }
    }

    public List<Produto> buscarTodos() {
        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM produtos");

            ResultSet resultSet = pstm.executeQuery();

            ArrayList<Produto> produtos = new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String codigo = resultSet.getString("codigo");
                Double valor = resultSet.getDouble("valor");
                String validade = resultSet.getString("validade");
                Long quantidade = resultSet.getLong("quantidade");
                Integer id_departamento = resultSet.getInt("id_departamento");

                Produto produto = new Produto(id, nome, codigo, valor, validade, quantidade, id_departamento);

                produtos.add(produto);
            }

            resultSet.close();
            pstm.close();
            con.close();
            return produtos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
