package com.cadastro.sistema_de_cadastro.repositorio;

import com.cadastro.sistema_de_cadastro.Estudante;

import java.util.List;

public interface EstudanteRepositorio {

    public Estudante pesquisaPorID(Long id);

    public List<Estudante> buscarTodos();

    public void inserir(Estudante estudante);

    public void apagar(Long id);

    public void editar(Estudante estudante, long id);

}
