package com.cadastro.sistema_de_cadastro;

import com.cadastro.sistema_de_cadastro.dao.EstudanteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws SQLException {

//        Estudante estudante1 = new Estudante();
//
//        estudante1.setNome("Fulana");
//        estudante1.setIdade(22);
//        estudante1.setSexo("Feminino");
//
//        EstudanteDAO estudanteDao = new EstudanteDAO();
//        estudanteDao.inserir(estudante1);

///////////////////////////////////////////////////////////////

        EstudanteDAO estudanteDao = new EstudanteDAO();
        List<Estudante> estudantes = new ArrayList<>();

        estudantes = estudanteDao.buscarTodos();

        for (int i = 0; i < estudantes.size(); i++){
            System.out.println("ID: "+ estudantes.get(i).getId());
            System.out.println("NOME: "+ estudantes.get(i).getNome());
            System.out.println("SEXO: "+ estudantes.get(i).getSexo());
            System.out.println("IDADE: "+ estudantes.get(i).getIdade());
        }

    }
}
