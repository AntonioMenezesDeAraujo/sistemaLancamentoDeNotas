package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public interface AvaliacaoDao {

	void cadastroDeAvaliacaoNaDisciplina(Avaliacao avaliacao);

	void alterarDadosDaAvaliacao(Avaliacao avaliacao);

	List<Avaliacao> pesquisarAvaliacaoPorDisciplina(Disciplina disciplina);

	void excluirDisciplina(Avaliacao avaliacao);
}
