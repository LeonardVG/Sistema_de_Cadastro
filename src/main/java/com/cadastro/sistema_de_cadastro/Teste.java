package com.cadastro.sistema_de_cadastro;

import com.cadastro.sistema_de_cadastro.dao.EstudanteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws SQLException {

        //TESTE MÉTODO INSERIR NO BANCO DE DADOS
//        Estudante estudante1 = new Estudante();
//
//        estudante1.setNome("Fulana");
//        estudante1.setIdade(22);
//        estudante1.setSexo("Feminino");
//
//        EstudanteDAO estudanteDao = new EstudanteDAO();
//        estudanteDao.inserir(estudante1);

///////////////////////////////////////////////////////////////
//             TESTE DO MÉTODO QUE LISTA TODA A TABELA
//        EstudanteDAO estudanteDao = new EstudanteDAO();
//        List<Estudante> estudantes = new ArrayList<>();
//
//        estudantes = estudanteDao.buscarTodos();
//
//        for (int i = 0; i < estudantes.size(); i++){
//            System.out.println("ID: "+ estudantes.get(i).getId());
//            System.out.println("NOME: "+ estudantes.get(i).getNome());
//            System.out.println("SEXO: "+ estudantes.get(i).getSexo());
//            System.out.println("IDADE: "+ estudantes.get(i).getIdade());
//        }
//////////////////////////////////////////////////////////////////////////////////////
//              TESTE MÉTODO EDITAR NO BANCO DE DADOS
//        Estudante estudante2 = new Estudante();
//        EstudanteDAO estudanteDao = new EstudanteDAO();
//
//        estudante2.setNome("Lucas");
//        estudante2.setIdade(25);
//        estudante2.setSexo("Masculino");
//
//        estudanteDao.editar(estudante2, 2);
////////////////////////////////////////////////////////////////////////////////////////
//              TESTE DA BUSCA NO BANCO DE DADOS PELO ID DO ALUNNO
//        EstudanteDAO estudanteDao = new EstudanteDAO();
//        Estudante estudante3 = new Estudante();
//
//        estudante3 = estudanteDao.pesquisaPorID(1L);
//        System.out.println("Nome: "+ estudante3.getNome());
//        System.out.println("Sexo: "+ estudante3.getSexo());
//        System.out.println("Idade: "+ estudante3.getIdade());
//////////////////////////////////////////////////////////////////////////////////////
//              TESTE DELETANDO NO BANCO DE DADOS
        EstudanteDAO estudanteDao = new EstudanteDAO();
        estudanteDao.apagar(2L);

    }
}
