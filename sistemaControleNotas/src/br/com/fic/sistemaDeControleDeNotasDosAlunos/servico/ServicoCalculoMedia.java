package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.NotaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.NotaDaoImpl;

public class ServicoCalculoMedia implements Servico {

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		NotaDao notaDao = new NotaDaoImpl();
		String opcaoSelecionada = req.getParameter("opcaoSelecionada");
		if (opcaoSelecionada.equals("todasNotas")) {
			notaDao.calculaMediaComTodasNotas();
		}else if(opcaoSelecionada.equals("notasMaiores")){
			String opcao = req.getParameter("qtdNotas");
			int qtdNotasMaiores = Integer.parseInt(opcao); 
			notaDao.calculaMediaComNotasMaiores(qtdNotasMaiores);
		}else if(opcaoSelecionada.equals("")){
			notaDao.calculaMediaComNotasMaiores(1);
		}

	}

	@Override
	public String getNomePagina() {
		return "conAluno.jsp";
	}

}
