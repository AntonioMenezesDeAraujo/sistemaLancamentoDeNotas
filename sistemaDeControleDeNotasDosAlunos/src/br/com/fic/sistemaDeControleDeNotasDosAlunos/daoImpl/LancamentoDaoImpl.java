package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import javax.persistence.EntityManager;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.LancamentoDeNotaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Nota;

public class LancamentoDaoImpl extends ConexaoBancoDeDados implements
		LancamentoDeNotaDao {
	private static EntityManager entity;

	public LancamentoDaoImpl() {
		entity = conexao();
		entity.getTransaction().begin();
	}

	@Override
	public void lancarNotaDoAlunoNaDisciplina(Aluno aluno, Avaliacao avaliacao,	double nota) {
		/*Nota notaPersist = new Nota();
		NotaPK chave = new NotaPK();
		chave.setCodigo(avaliacao.getCodigo());
		chave.setMatricula(aluno.getMatricula());
		notaPersist.setNotaPk(chave);
		notaPersist.setNota(nota);
		entity.persist(notaPersist);
		entity.getTransaction().commit();*/
	}
	

}
