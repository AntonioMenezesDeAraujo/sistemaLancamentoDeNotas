package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Nota;

public class ServicoLancarNota implements Servico{

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		AlunoDao dao = new AlunoDaoImpl();
		AvaliacaoDao daoAv = new AvaliacaoDaoImpl();
		Nota nota = new Nota();
		
		Aluno aluno = (dao.pesquisarAlunoPorMatricula((String)req.getParameter("mat")).get(0));
		
		List<Avaliacao> avaliacoes = daoAv.pesquisarAvaliacao();
		
		for(Avaliacao av : avaliacoes){
			if(av.getDescricao().equals((String)req.getParameter("avaliacao"))){
				nota.setNotaAluno(av);
			}
		}
		
		nota.setAluno(aluno);
		
		nota.setNota(Double.parseDouble((String)req.getParameter("nota")));
		
		List<Nota> notas = new ArrayList<Nota>();
		
		notas.add(nota);
		
		aluno.setNotas(notas);
		
		dao.alterarDadosDoAluno(aluno);
		
		
	}

	@Override
	public String getNomePagina() {
		return "lancarNota.jsp";
	}

}
