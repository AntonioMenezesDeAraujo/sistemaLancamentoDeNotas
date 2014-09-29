package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.NotaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.NotaDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoLancarNota implements Servico {

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception {
		NotaDao notaDao = new NotaDaoImpl();
		AlunoDao dao = new AlunoDaoImpl();
		AvaliacaoDao daoAv = new AvaliacaoDaoImpl();
		Avaliacao avaliacao = null;

		Aluno aluno = (dao.pesquisarAlunoPorMatricula((String) req.getParameter("mat")).get(0));

		List<Avaliacao> avaliacoes = daoAv.pesquisarAvaliacao();

		for (Avaliacao av : avaliacoes) {
			if (av.getDescricao().equals(req.getParameter("avaliacao"))) {
				avaliacao = av;
			}
		}
		
		Double nota = null;
		if(req.getParameter("nota") != null && !req.getParameter("nota").isEmpty()){
			nota = Double.parseDouble(req.getParameter("nota"));
		}
		
		notaDao.lancarNota(aluno, avaliacao, nota);

	}

	@Override
	public String getNomePaginaSucesso() {
		return "lancNotas.jsp";
	}

	@Override
	public String getNomePaginaErro() {
		return "lancNotas.jsp";
	}

}
