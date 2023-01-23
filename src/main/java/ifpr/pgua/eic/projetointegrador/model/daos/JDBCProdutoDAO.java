package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
                    .prepareStatement("INSERT INTO produtos(nome,codigo,valor,validade,quantidade) VALUES (?,?,?,?,?)");

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getCodigo());
            pstm.setDouble(3, produto.getValor());
            pstm.setTimestamp(4, Timestamp.valueOf(produto.getValidade()));
            pstm.setLong(5, produto.getQuantidade());

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
                LocalDateTime validade = resultSet.getTimestamp("data").toLocalDateTime();
                Long quantidade = resultSet.getLong("quantidade");

                Produto produto = new Produto(id, nome, codigo, valor, validade, quantidade);

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
