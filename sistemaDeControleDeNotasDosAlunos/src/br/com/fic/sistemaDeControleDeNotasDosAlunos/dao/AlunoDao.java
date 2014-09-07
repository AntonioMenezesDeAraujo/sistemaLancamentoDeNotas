package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public interface AlunoDao {
/*teste de commit*/ /*Mais um commit*/
	void salvarAluno(Aluno aluno, Disciplina disciplina);
/*teste*/
	void alterarDadosDoAluno(Aluno aluno);

	List<Aluno> retornarTodosOsAluno();

	List<Aluno> pesquisarAlunoPorNome(String nome);

	List<Aluno> pesquisarAlunoPorMaricula(String matricula);

	void excluirAluno(String matriculaOuNome, Disciplina disciplina);
	
	List<Double> pesquisarTodasNotasDoAlunoNaDisciplina(Aluno aluno, Disciplina disciplina);
}
