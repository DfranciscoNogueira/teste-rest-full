package br.com.aprendendo.restfull.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.aprendendo.restfull.entidadeModel.Cliente;
import br.com.aprendendo.restfull.factory.ConexaoUtil;

/**
 * 
 * @author Diego_Francisco
 * @since 11/09/2016
 *
 */
public class ClienteDao extends ConexaoUtil {

    private static ClienteDao instance;

    private PreparedStatement pstmt;
    private Connection conexao;
    private ResultSet rs;

    // cria uma instancia da classe clienteDao (singleton)
    public static ClienteDao getInstance() {
        if (instance == null)
            instance = new ClienteDao();
        return instance;
    }

    public List<Cliente> findAllClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        conexao = criarConexao();
        try {
            pstmt = conexao.prepareStatement("SELECT * FROM cliente ORDER BY nome");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setId(rs.getInt("id"));

                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar todos os clientes : " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, pstmt, rs);
        }
        return clientes;
    }

}
