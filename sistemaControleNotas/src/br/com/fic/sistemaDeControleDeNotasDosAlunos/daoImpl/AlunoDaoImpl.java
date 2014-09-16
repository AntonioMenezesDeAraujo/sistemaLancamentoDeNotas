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

public class AlunoDaoImpl extends ConexaoBancoDeDados implements AlunoDao {

	private static EntityManager entity;
	private DisciplinaDao daoDisciplina = new DisciplinaDaoImpl();
	public AlunoDaoImpl() {
		entity = conexao();
		entity.getTransaction().begin();
	}

	@Override
	public void salvarAluno(Aluno aluno, Disciplina disciplina) {
		if (disciplinaExiste(disciplina)) {
			entity.persist(aluno);
			entity.getTransaction().commit();
			criarRelacionamento(aluno, disciplina);
		}
	}

	@Override
	public void alterarDadosDoAluno(Aluno aluno) {
		entity.merge(aluno);
		entity.getTransaction().commit();

	}

	@Override
	public List<Aluno> retornarTodosOsAluno() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Query query = entity.createNamedQuery("aluno.todosAlunos");
		alunos = query.getResultList();
		return alunos;
	}

	@Override
	public List<Aluno> pesquisarAlunoPorNome(String nome) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Query query = entity
				.createQuery("select aluno from Aluno aluno where upper(aluno.nome) like upper('%"
						+ nome + "%')");
		alunos = query.getResultList();
		return alunos;
	}

	@Override
	public List<Aluno> pesquisarAlunoPorMaricula(String matricula) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Query query = entity
				.createQuery("select aluno from Aluno aluno where aluno.matricula = "
						+ matricula);
		alunos = query.getResultList();
		return alunos;
	}

	@Override
	public void excluirAluno(String matriculaOuNome, Disciplina disciplina) {
		List<Aluno> alunos = retornarTodosOsAluno();
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equalsIgnoreCase(matriculaOuNome) || aluno.getMatricula().equalsIgnoreCase(matriculaOuNome)) {
				excluirRelacionamento(aluno, disciplina);
				entity.getTransaction().begin();
				entity.remove(aluno);
				entity.getTransaction().commit();
				return;
			}
		}

	}
	
	private Boolean disciplinaExiste(Disciplina disciplina){
		if((daoDisciplina.pesquisaDisciplinaPeloCodigo(disciplina.getCodigo()).size()) > 0)
			return true;
		return false;	
	}
	
	private void excluirRelacionamento(Aluno aluno, Disciplina disciplina){
		String jpql = "delete from AlunoDisciplina where upper(aluno_matricula) like " + "upper("+aluno.getMatricula()+")" +
				" and disciplina_codigo = " + disciplina.getCodigo();
		Query query = entity.createNativeQuery(jpql);
		query.executeUpdate();
		entity.getTransaction().commit();
	}
		
	private void criarRelacionamento(Aluno aluno, Disciplina disciplina){
			AlunoDisciplina aluDisc = new AlunoDisciplina();
			aluDisc.setAluno(aluno);
			aluDisc.setDisciplina(disciplina);
			entity.getTransaction().begin();
			entity.persist(aluDisc);
			entity.getTransaction().commit();
	}

	@Override
	public List<Double> pesquisarTodasNotasDoAlunoNaDisciplina(Aluno aluno,	Disciplina disciplina) {
		String jpql = "select nota.nota from Nota nota where nota.codigo = "+disciplina.getCodigo()+
				" and nota.matricula = "+aluno.getMatricula();
		Query query = entity.createQuery(jpql);
		
		List<Double> notas = query.getResultList(); 
		return null;
	}

}
