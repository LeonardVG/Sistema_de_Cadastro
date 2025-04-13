package com.cadastro.sistema_de_cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_banco";
    private static final String USUARIO = "root";
    private static final String SENHA = "l123";

    //mé para conectar com o banco de dados
    public static Connection obterConexao() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Erro ao obter conexão" + e.getMessage());
        }
    }

    public static void fecharConexao(Connection connection) throws SQLException {
        if(connection != null && !connection.isClosed() ){
            connection.close();
        }

    }

}
