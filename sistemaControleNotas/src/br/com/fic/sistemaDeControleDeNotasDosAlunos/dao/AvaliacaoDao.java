package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public interface AvaliacaoDao {

	void cadastroDeAvaliacao(Avaliacao avaliacao);

	void alterarDadosDaAvaliacao(Avaliacao avaliacao);

	List<Avaliacao> pesquisarAvaliacao();

	void excluirAvaliacao(Avaliacao avaliacao);
}
