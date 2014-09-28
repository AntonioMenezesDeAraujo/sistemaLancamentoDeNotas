package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class AvaliacaoDaoImpl extends ConexaoBancoDeDados implements AvaliacaoDao {

	private static EntityManager entity;
	
	public AvaliacaoDaoImpl() {
		entity = conexao();
		entity.getTransaction().begin();
	}
	
	@Override
	public void cadastroDeAvaliacao(Avaliacao avaliacao) throws Exception {
		try {
			validarAvaliacao(avaliacao);
			entity.persist(avaliacao);
			entity.getTransaction().commit();			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	private void validarAvaliacao(Avaliacao avaliacao) throws Exception{
		try {
			if(avaliacao.getCodigo() == null || avaliacao.getCodigo().isEmpty()){
				throw new Exception("Código deve ser preenchido!");
			}else{
				List<Avaliacao> avaliacoes = pesquisarAvaliacaoPorCodigo(avaliacao.getCodigo());
				if(avaliacoes != null && !avaliacoes.isEmpty()){
					throw new Exception("Código já cadastrado!");
				}
			}
			if(avaliacao.getDescricao() == null || avaliacao.getDescricao().isEmpty()){
				throw new Exception("Descrição deve ser preenchido!");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public void alterarDadosDaAvaliacao(Avaliacao avaliacao) {
		entity.merge(avaliacao);
		entity.getTransaction().commit();
	}

	@Override
	public List<Avaliacao> pesquisarAvaliacao() {
		String jpql = "select avaliacao from Avaliacao avaliacao";
		Query query = entity.createQuery(jpql);
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		avaliacoes = query.getResultList();
		return avaliacoes;
	}
	
	@Override
	public List<Avaliacao> pesquisarAvaliacaoPorCodigo(String codigo) {
		String jpql = "select avaliacao.codigo, avaliacao.descricao from Avaliacao avaliacao where avaliacao.codigo = '" + codigo + "'";
		Query query = entity.createQuery(jpql);
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		avaliacoes = query.getResultList();
		return avaliacoes;
	}
	
	@Override
	public List<Avaliacao> pesquisarAvaliacaoPorDescricao(String descricao) {
		String jpql = "select avaliacao.codigo, avaliacao.descricao from Avaliacao avaliacao where avaliacao.descricao like '%" + descricao + "%'";
		Query query = entity.createQuery(jpql);
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		avaliacoes = query.getResultList();
		return avaliacoes;
	}

	@Override
	public void excluirAvaliacao(Avaliacao avaliacao) {
		entity.remove(avaliacao);
		entity.getTransaction().commit();
	}
	
}
