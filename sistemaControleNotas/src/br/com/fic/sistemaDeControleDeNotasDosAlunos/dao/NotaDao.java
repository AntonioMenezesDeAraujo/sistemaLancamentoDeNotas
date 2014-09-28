package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import javax.servlet.http.HttpServletRequest;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public interface NotaDao {

	void lancarNota(Aluno aluno, Avaliacao avaliacao, Double nota);
	
	void calculaMediaComTodasNotas();

	void calculaMediaComNotasMaiores(int qtdd);

	void calculaMediaDasAvaliacaoesSelecionadas(HttpServletRequest req);
}
