package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Vendedor;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCVendedorDAO implements VendedorDAO {

    private FabricaConexoes fabricaConexao;

    public JDBCVendedorDAO(FabricaConexoes fabricaConexao) {
        this.fabricaConexao = fabricaConexao;
    }

    @Override
    public Result inserir(Vendedor vendedor) {

        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con
                    .prepareStatement("INSERT INTO vendedores(nome, prontuario, email, senha) VALUES (?,?,?,?)");

            pstm.setString(1, vendedor.getNome());
            pstm.setString(2, vendedor.getProntuario());
            pstm.setString(3, vendedor.getEmail());
            pstm.setString(4, vendedor.getSenha());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("Vendedor cadastrado!");

        } catch (SQLException e) {
            return Result.fail(e.getMessage());
        }
    }

    public List<Vendedor> buscarTodos() {
        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con.prepareStatement("SELECT * FROM vendedores");

            ResultSet resultSet = pstm.executeQuery();

            ArrayList<Vendedor> vendedores = new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String prontuario = resultSet.getString("prontuario");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");

                Vendedor vendedor = new Vendedor(id, nome, prontuario, email, senha);

                vendedores.add(vendedor);
            }

            resultSet.close();
            pstm.close();
            con.close();
            return vendedores;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public Result fazerLogin(String email, String senha) {
        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con
                    .prepareStatement("SELECT * from vendedores WHERE email = ? and senha = ?");

            pstm.setString(1, email);
            pstm.setString(2, senha);

            ResultSet resultSet = pstm.executeQuery();

            System.out.println(email + senha);

            if (resultSet.next()) {
                resultSet.close();
                pstm.close();
                con.close();
                return Result.success("Você logou no sistema");
            } else {
                resultSet.close();
                pstm.close();
                con.close();
                return Result.fail("Email ou senha incorreta");
            }

        } catch (SQLException e) {
            return Result.fail(e.getMessage());
        }
    }
}
