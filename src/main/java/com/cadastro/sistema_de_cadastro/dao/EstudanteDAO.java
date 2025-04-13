package com.cadastro.sistema_de_cadastro.dao;

import com.cadastro.sistema_de_cadastro.Conexao;
import com.cadastro.sistema_de_cadastro.Estudante;
import com.cadastro.sistema_de_cadastro.repositorio.EstudanteRepositorio;

import java.sql.PreparedStatement;
import java.util.List;

                    //DAO (Data Access Object)
//classe é responsável pelas operações com o banco de dados relacionadas à entidade Estudante.
//essa classe implementa uma interface chamada EstudanteRepositorio,
// que define os métodos básicos para lidar com estudantes (inserir, porId, buscarTodos, etc.)

public class EstudanteDAO  implements EstudanteRepositorio {

    @Override
    public void porId(Long id) {

    }

    @Override
    public List<Estudante> buscarTodos() {
        return List.of();
    }

    @Override
    public void inserir(Estudante estudante) {

        try {
            String sql = "INSERT INTO estudante(nome, sexo, idade) VALUES(?, ?, ?)"; //Define uma string SQL para inserção de dados. Os ? são placeholders que serão substituídos por valores reais usando PreparedStatement
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql); //Obtém uma conexão com o banco de dados (via classe Conexao) e prepara o comando SQL

            //Substituir os ? do SQL pelos valores do objeto estudante
            ps.setString(1, estudante.getNome());
            ps.setString(2, estudante.getSexo());
            ps.setInt(3, estudante.getIdade());
            ps.execute();                                           //Executa o comando SQL no banco de dados

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error "+ e.getMessage());
        }

    }

    @Override
    public void apagar(Long id) {

    }
}
