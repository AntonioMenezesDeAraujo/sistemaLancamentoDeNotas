package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public class AlunoDaoImpl extends ConexaoBancoDeDados implements AlunoDao {

	private static EntityManager entity;
	
	public AlunoDaoImpl() {
		entity = conexao();
		entity.getTransaction().begin();
	}

	@Override
	public void salvarAluno(Aluno aluno) throws Exception {
		try {
			validaCadastroAluno(aluno);
			entity.persist(aluno);
			entity.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception(e);
		}
			
	}
	
	private void validaCadastroAluno(Aluno aluno) throws Exception{
		try {
			if(aluno.getMatricula() == null || aluno.getMatricula().isEmpty()){
				throw new Exception("Matrícula deve ser preenchida!");
			}else{
				List<Aluno> alunos = pesquisarAlunoPorMatricula(aluno.getMatricula());
				if(alunos != null && !alunos.isEmpty()){
					throw new Exception("Matrícula já existe!");
				}
			}
			if(aluno.getNome() == null || aluno.getNome().isEmpty()){
				throw new Exception("Nome deve ser preenchido!");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	private void validaAlteracaoAluno(Aluno aluno) throws Exception{
		try {
			if(aluno.getNome() == null || aluno.getNome().isEmpty()){
				throw new Exception("Nome deve ser preenchido!");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override

	public void alterarDadosDoAluno(Aluno aluno) throws Exception {
		try {
			validaAlteracaoAluno(aluno);
			entity.merge(aluno);			
			entity.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception(e);
		}
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
		Query query = entity.createQuery("select aluno from Aluno aluno where upper(aluno.nome) like upper('%" + nome + "%')");
		alunos = query.getResultList();
		return alunos;
	}

	@Override
	public List<Aluno> pesquisarAlunoPorMatricula(String matricula) throws Exception {
		try {
			List<Aluno> alunos = new ArrayList<Aluno>();
			Query query = entity.createQuery("select aluno from Aluno aluno where aluno.matricula = '" + matricula + "'");
			alunos = query.getResultList();
			return alunos;			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public List<Aluno> pesquisarAluno(String matricula) throws Exception {
		try {
			if(matricula == null || matricula.isEmpty()){
				throw new Exception("Informe a matrícula!");
			}
			List<Aluno> alunos = pesquisarAlunoPorMatricula(matricula);
			if(alunos == null || alunos.isEmpty()){
				throw new Exception("Matrícula inexistente!");
			}
			return alunos;			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public void excluirAluno(String matriculaOuNome) {
		List<Aluno> alunos = retornarTodosOsAluno();
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equalsIgnoreCase(matriculaOuNome) || aluno.getMatricula().equalsIgnoreCase(matriculaOuNome)) {
				Query query1 = entity.createNativeQuery("delete from Nota where aluno_matricula = "+aluno.getMatricula());
				query1.executeUpdate();
				entity.getTransaction().commit();
				entity.getTransaction().begin();
				Query query = entity.createNativeQuery("delete from Aluno where matricula = "+aluno.getMatricula());
				query.executeUpdate();
				entity.getTransaction().commit();
//				entity.remove(aluno);
//				entity.getTransaction().commit();
//				entity.close();
				return;
			}
		}
	}
	
	@Override
	public List<Double> pesquisarTodasNotasDoAluno(Aluno aluno) {
		String jpql = "select nota.nota from Nota nota where nota.matricula = " + aluno.getMatricula();
		Query query = entity.createQuery(jpql);
		List<Double> notas = query.getResultList(); 
		return null;
	}

}
