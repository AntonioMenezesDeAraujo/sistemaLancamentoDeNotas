package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public class AvaliacaoDaoImpl extends ConexaoBancoDeDados implements AvaliacaoDao {
	private static EntityManager entity;
	
	public AvaliacaoDaoImpl() {
		entity = conexao();
		entity.getTransaction().begin();
	}
	
	@Override
	public void cadastroDeAvaliacaoNaDisciplina(Avaliacao avaliacao) {
		entity.persist(avaliacao);
		entity.getTransaction().commit();
	}

	@Override
	public void alterarDadosDaAvaliacao(Avaliacao avaliacao) {
		entity.merge(avaliacao);
		entity.getTransaction().commit();
	}

	@Override
	public List<Avaliacao> pesquisarAvaliacaoPorDisciplina(Disciplina disciplina) {
		String jpql = "select avaliacao from Avaliacao avaliacao where avaliacao.disciplina.codigo = "+disciplina.getCodigo();
		Query query = entity.createQuery(jpql);
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		avaliacoes = query.getResultList();
		return avaliacoes;
	}

	@Override
	public void excluirDisciplina( Avaliacao avaliacao) {
		entity.remove(avaliacao);
		entity.getTransaction().commit();
	}
	
}
