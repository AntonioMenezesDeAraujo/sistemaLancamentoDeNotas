package br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades;

//TestaInsereProduto.java
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaLancamentoDeNotas");
		EntityManager em = factory.createEntityManager();
		Aluno p = new Aluno();
		p.setMatricula("004");
		p.setNome("Antonio Menezes de Araújo");
		Disciplina d = new Disciplina();
		d.setCodigo("004");
		d.setDescricao("Banco de Dados");
//		p.getAlunosDisciplina().
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
	}
}
