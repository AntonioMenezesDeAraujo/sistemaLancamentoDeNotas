package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public interface LancamentoDeNotaDao {

	void lancarNotaDoAlunoNaDisciplina(Aluno aluno, Avaliacao avaliacao, double nota);
}
