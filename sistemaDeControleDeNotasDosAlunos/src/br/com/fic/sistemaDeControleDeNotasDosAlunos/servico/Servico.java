package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Servico {
	String executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
