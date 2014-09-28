package br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
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

	@Override
	public void calculaMediaComTodasNotas() {
		Double media = 0.0;
		int cont = 0;
		AlunoDao alDao = new AlunoDaoImpl();
		List<Aluno> alunos = alDao.retornarTodosOsAluno();
		for (Aluno aluno : alunos) {
			media = calculaMedia(aluno);
			if (media != 0) {
				aluno.setMedia(media);
				new AlunoDaoImpl().alterarDadosDoAluno(aluno);
				cont++;
			}
		}

	}

	private Double calculaMedia(Aluno aluno) {
		Double media = 0.0;
		int cont = 0;
		Double resultado = 0.0;
		for (Nota nota : aluno.getNotas()) {
			media += nota.getNota();
			cont++;
		}
		if (media == 0) {
			resultado = 0.0;
		} else {
			resultado = media / cont;
		}
		return resultado;
	}

	@Override
	public void calculaMediaComNotasMaiores(int qtd) {
		AlunoDao dao = new AlunoDaoImpl();
		List<Aluno> alunos = dao.retornarTodosOsAluno();
		for (Aluno aluno : alunos) {
			calculaMediaDeNotasMaiores(aluno, qtd);
		}

	}

	private void calculaMediaDeNotasMaiores(Aluno aluno, int qtd) {
		Double notasAluno[] = new Double[10];
		Double notasAlunoOrdenados[] = new Double[10];
		Double notasConsideradas[] = new Double[qtd];
		Double media = 0.0;
		AlunoDao dao = new AlunoDaoImpl();
		int i = 0;
		for(int h=0;h<notasAlunoOrdenados.length;h++){
//			notasAlunoOrdenados[h] = 0.0;
//			notasConsideradas[h] = 0.0;
//			notasAluno[h] = 0.0;
		}
		
		for (Nota nota : aluno.getNotas()) {
			notasAluno[i] = nota.getNota();
			i++;
		}
		
		notasAlunoOrdenados = ordenaNotasOrdemDecrescente(notasAluno);
		notasConsideradas = selecionarNotasDaMedia(notasAlunoOrdenados, qtd);
		media = calculaMedia(notasConsideradas);
		aluno.setMedia(media);
		dao.alterarDadosDoAluno(aluno);

	}

	private Double calculaMedia(Double[] notasConsideradas) {
		Double media = 0.0;
		for (int i = 0; i < notasConsideradas.length; i++) {
			media += notasConsideradas[i];
		}
		return media;
	}

	private Double[] selecionarNotasDaMedia(Double[] notasAlunoOrdenados,
			int qtd) {
		Double notas[] = new Double[qtd];
		for (int i = 0; i < qtd; i++) {
			notas[i] = notasAlunoOrdenados[i];
		}
		return notas;
	}

	private Double[] ordenaNotasOrdemDecrescente(Double[] notasConsideradas) {
		for (int i = 0; i < notasConsideradas.length; i++) {
			for (int j = i + 1; i < notasConsideradas.length; j++) {
				if(notasConsideradas[j] == null){
					return notasConsideradas;
				}
				if (notasConsideradas[i] < notasConsideradas[j]) {
					Double aux = notasConsideradas[j];
					notasConsideradas[i] = notasConsideradas[j];
					notasConsideradas[j] = aux;
					
				}

			}
		}
		return notasConsideradas;
	}

}
