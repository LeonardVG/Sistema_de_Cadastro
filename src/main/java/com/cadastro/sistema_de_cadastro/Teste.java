package com.cadastro.sistema_de_cadastro;

import com.cadastro.sistema_de_cadastro.dao.EstudanteDAO;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {

        Estudante estudante1 = new Estudante();

        estudante1.setNome("Leonard Moro");
        estudante1.setIdade(24);
        estudante1.setSexo("Masculino");

        EstudanteDAO estudanteDao = new EstudanteDAO();
        estudanteDao.inserir(estudante1);

    }
}
