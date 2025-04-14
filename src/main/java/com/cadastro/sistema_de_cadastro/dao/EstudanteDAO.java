package com.cadastro.sistema_de_cadastro.dao;

import com.cadastro.sistema_de_cadastro.Conexao;
import com.cadastro.sistema_de_cadastro.Estudante;
import com.cadastro.sistema_de_cadastro.repositorio.EstudanteRepositorio;

import java.lang.reflect.Executable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

                    //DAO (Data Access Object)
//classe é responsável pelas operações com o banco de dados relacionadas à entidade Estudante.
//essa classe implementa uma interface chamada EstudanteRepositorio,
// que define os métodos básicos para lidar com estudantes (inserir, porId, buscarTodos, etc.)

public class EstudanteDAO  implements EstudanteRepositorio {

    @Override
    public Estudante pesquisaPorID(Long id) {

        Estudante estudante = null;

        try{
            String sql = "SELECT * from estudante where id=?";

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                estudante = new Estudante();

                estudante.setId(rs.getLong("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setSexo(rs.getString("sexo"));
                estudante.setIdade(rs.getInt("idade"));

            }

        }catch (Exception e){
            System.out.println("ERRO " + e.getMessage());
        }

        return estudante;
    }

    @Override
    public List<Estudante> buscarTodos() {

        List<Estudante> listaEstudantes = new ArrayList<>();

        try{
            ResultSet resultSet = null;                 //ResultSet é usado para armazenar os dados retornados da consulta SQL. Aqui ele é inicializado como null e depois será preenchido com os dados da query

            String sql = "SELECT * from estudante";     // Consulta que seleciona todos os registros da tabela estudante
                                                         //SELECT: comando SQL para consultar dados.
                                                         //*: indica que você quer todas as colunas
                                                         //from estudante: da tabela chamada estudante.

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);               //PreparedStatement: Prepara o comando SQL com segurança.
                                                                                               //Conexao.obterConexao(): Método que retorna a conexão ativa com o banco (definido em outra classe).
                                                                                              // prepareStatement(sql): Prepara a execução da query.

            resultSet = ps.executeQuery();                                                      //Executa a consulta SQL preparada e guarda os resultados no resultSet.
                                                                                                //O ResultSet funciona como uma "tabela" na memória, com os dados do banco.

            while(resultSet.next()){                                                            //Cada chamada de next() avança para a próxima linha da consulta. Retorna false quando não houver mais linhas

                Estudante estudanteTemp = new Estudante();

                estudanteTemp.setId(resultSet.getLong("id"));
                estudanteTemp.setNome(resultSet.getString("nome"));
                estudanteTemp.setSexo(resultSet.getString("sexo"));
                estudanteTemp.setIdade(resultSet.getInt("idade"));

                listaEstudantes.add(estudanteTemp);
            }

        }catch (Exception e){

            System.out.println("ERRO " + e.getMessage());

        }

            return listaEstudantes;
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

        try{
            String sql = "DELETE from estudante where id=?";

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();

        }catch (Exception e){
            System.out.println("ERRO "+ e.getMessage());
        }

    }

    @Override
    public void editar(Estudante estudanteEditado, long id_paraBuscar) {

        try{

            String  sql = "UPDATE estudante SET nome=?, sexo=?, idade=? where id=?";

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

            ps.setString(1, estudanteEditado.getNome());
            ps.setString(2, estudanteEditado.getSexo());
            ps.setInt(3, estudanteEditado.getIdade());
            ps.setLong(4, id_paraBuscar);

            ps.executeUpdate();


        }catch (Exception e){
            System.out.println("ERRO " + e.getMessage());
        }
    }

}
