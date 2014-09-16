package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public interface DisciplinaDao {

	void salvarDisciplina(Disciplina disciplina);

	List<Disciplina> getTodasDisciplinas();

	List<Disciplina> pesquisaDisciplinaPeloCodigo(String codigo);

	List<Disciplina> pesquisaDisciplinaPelaDescricao(String descricao);

	void alteraDisciplina(Disciplina disciplina);

	List<Aluno> retornarTodosAlunosPorDisciplina(Disciplina disciplina);

	void excluirDisciplina(String nomeOuCodigo);
	
	void lancarMediaDoAlunoNaDisciplina(Disciplina disciplina, Aluno aluno, Double media);

}
