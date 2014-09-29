
package br.com.fic.sistemaDeControleDeNotasDosAlunos.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Nota;

public interface NotaDao {

	void lancarNota(Aluno aluno, Avaliacao avaliacao, Double nota) throws Exception;
	
	void calculaMediaComTodasNotas() throws Exception;

	void calculaMediaComNotasMaiores(int qtdd) throws Exception;

	void calculaMediaDasAvaliacaoesSelecionadas(HttpServletRequest req) throws Exception;

	List<Nota> pesquisarNota(String matricula, String codigo);
}
