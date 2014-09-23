package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public interface AlunoDao {

	void salvarAluno(Aluno aluno) throws Exception;

	void alterarDadosDoAluno(Aluno aluno);

	List<Aluno> retornarTodosOsAluno();

	List<Aluno> pesquisarAlunoPorNome(String nome);

	List<Aluno> pesquisarAlunoPorMaricula(String matricula);

	void excluirAluno(String matriculaOuNome);
	
	List<Double> pesquisarTodasNotasDoAluno(Aluno aluno);
}
