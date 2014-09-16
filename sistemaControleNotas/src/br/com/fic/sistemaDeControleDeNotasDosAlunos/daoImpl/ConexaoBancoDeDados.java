package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public abstract class ConexaoBancoDeDados {

	public static EntityManager conexao(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaLancamentoDeNotas");
		return factory.createEntityManager();
	}
	
//	
//	
//	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaLancamentoDeNotas");
//		EntityManager entity = factory.createEntityManager();
//		Aluno p = new Aluno();
//		p.setMatricula("001");
//		p.setNome("Antonio");
//
//		entity.getTransaction().begin();
//		entity.persist(p);
//		entity.getTransaction().commit();
//	}
}
