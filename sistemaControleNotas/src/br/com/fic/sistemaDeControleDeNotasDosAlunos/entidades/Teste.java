package br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades;

//TestaInsereProduto.java
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaLancamentoDeNotas");
		EntityManager em = factory.createEntityManager();
		Aluno p = new Aluno();
		p.setMatricula("005");
		p.setNome("Antonio Menezes de Araújo");
//		p.getAlunosDisciplina().
		em.getTransaction().begin();
		em.getTransaction().commit();
	}	
}
