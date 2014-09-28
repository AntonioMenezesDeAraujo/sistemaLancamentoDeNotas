package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public interface NotaDao {

	void lancarNota(Aluno aluno, Avaliacao avaliacao, Double nota);
	
	void calculaMediaComTodasNotas();

	void calculaMediaComNotasMaiores(int qtdd);
}
