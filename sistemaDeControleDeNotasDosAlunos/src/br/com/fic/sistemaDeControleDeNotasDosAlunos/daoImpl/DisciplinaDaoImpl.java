package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.DisciplinaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.AlunoDisciplina;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public class DisciplinaDaoImpl extends ConexaoBancoDeDados implements
		DisciplinaDao {

	private final EntityManager entity;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();


	public DisciplinaDaoImpl() {
		entity = conexao();
		entity.getTransaction().begin();
	}

	@Override
	public void salvarDisciplina(Disciplina disciplina) {
		entity.persist(disciplina);
		entity.getTransaction().commit();
	}

	@Override
	public List<Disciplina> getTodasDisciplinas() {
		disciplinas.clear();
		Query query = entity
				.createQuery("select disciplina from Disciplina disciplina");
		disciplinas = query.getResultList();
		return disciplinas;
	}

	@Override
	public List<Disciplina> pesquisaDisciplinaPeloCodigo(String codigo) {
		disciplinas.clear();
		Query query = entity
				.createQuery("select disciplina from Disciplina disciplina where disciplina.codigo = "
						+ codigo);
		disciplinas = query.getResultList();
		return disciplinas;
	}

	@Override
	public List<Disciplina> pesquisaDisciplinaPelaDescricao(String descricao) {
		disciplinas.clear();
		Query query = entity
				.createQuery("select disciplina from Disciplina disciplina where upper(disciplina.descricao) like "
						+ "upper('%" + descricao + "%')");
		disciplinas = query.getResultList();
		return disciplinas;
	}

	@Override
	public void alteraDisciplina(Disciplina disciplina) {
		entity.merge(disciplina);
		entity.getTransaction().commit();
	}

	@Override
	public List<Aluno> retornarTodosAlunosPorDisciplina(Disciplina disciplina) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Query query = entity.createNativeQuery("select a.* from Aluno a inner join AlunoDisciplina ad on a.matricula = ad.matricula"
				+ " inner join Disciplina d on ad.codigo = d.codigo where d.codigo = "+disciplina.getCodigo(),Aluno.class);
		alunos = query.getResultList();
		return alunos;
	}

	@Override
	public void excluirDisciplina(String nomeOuCodigo) {
		disciplinas.clear();
		disciplinas = getTodasDisciplinas();
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getCodigo().equals(nomeOuCodigo)	|| disciplina.getDescricao().equalsIgnoreCase(nomeOuCodigo)) {
				excluirAlunosEmCascata(disciplina);
				entity.getTransaction().begin();
				entity.remove(disciplina);
				entity.getTransaction().commit();
				return;
			}
		}

	}
	public static void main(String[] args) {
		new DisciplinaDaoImpl().excluirDisciplina("001");
	}
	
	private void excluirAlunosEmCascata(Disciplina disciplina){
		String jpql = "delete from AlunoDisciplina where disciplina_codigo = " + disciplina.getCodigo();
		Query query = entity.createNativeQuery(jpql);
		query.executeUpdate();
		entity.getTransaction().commit();
	}

	@Override
	public void lancarMediaDoAlunoNaDisciplina(Disciplina disciplina, Aluno aluno, Double media) {
		String jpql = "update AlunoDisciplina set media = "+media +" where aluno_matricula = "+aluno.getMatricula() +" "
				+ "and disciplina_codigo = " + disciplina.getCodigo();
		Query query = entity.createNativeQuery(jpql);
		query.executeUpdate();
		entity.getTransaction().commit();
	}
	
}
