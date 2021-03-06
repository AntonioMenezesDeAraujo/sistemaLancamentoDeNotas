package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public interface AlunoDao {

	void salvarAluno(Aluno aluno) throws Exception;

	void alterarDadosDoAluno(Aluno aluno) throws Exception;

	List<Aluno> retornarTodosOsAluno();

	List<Aluno> pesquisarAlunoPorNome(String nome);

	List<Aluno> pesquisarAlunoPorMatricula(String matricula) throws Exception;

	void excluirAluno(String matriculaOuNome);
	
	List<Double> pesquisarTodasNotasDoAluno(Aluno aluno);

	List<Aluno> pesquisarAluno(String matricula) throws Exception;
}
