package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import javax.persistence.EntityManager;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.NotaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Nota;

public class NotaDaoImpl extends ConexaoBancoDeDados implements NotaDao {

	private static EntityManager entity;
	public NotaDaoImpl() {
		entity = conexao();
		entity.getTransaction().begin();
	}
	
	@Override
	public void lancarNota(Aluno aluno, Avaliacao avaliacao, Double nota) {
		Nota notaPersist = new Nota();
		notaPersist.setAluno(aluno);
		notaPersist.setNota(nota);
		notaPersist.setNotaAluno(avaliacao);
		entity.persist(notaPersist);
		entity.getTransaction().commit();
	}

}
