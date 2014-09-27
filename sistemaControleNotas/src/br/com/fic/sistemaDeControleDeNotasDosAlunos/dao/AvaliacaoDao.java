package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public interface AvaliacaoDao {

	void cadastroDeAvaliacao(Avaliacao avaliacao) throws Exception;

	void alterarDadosDaAvaliacao(Avaliacao avaliacao);

	List<Avaliacao> pesquisarAvaliacao();
	
	List<Avaliacao> pesquisarAvaliacaoPorCodigo(String codigo);
	
	List<Avaliacao> pesquisarAvaliacaoPorDescricao(String descricao);

	void excluirAvaliacao(Avaliacao avaliacao);
}
