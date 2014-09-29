package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.NotaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.NotaDaoImpl;

public class ServicoCalculoMedia implements Servico {

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		try {
			NotaDao notaDao = new NotaDaoImpl();
			String opcaoSelecionada = req.getParameter("opcaoSelecionada");
			validarParametro(opcaoSelecionada);
			if (opcaoSelecionada.equals("todasNotas")) {
				notaDao.calculaMediaComTodasNotas();
			}else if(opcaoSelecionada.equals("notasMaiores")){
				String opcao = req.getParameter("qtdNotas");
				validarNrNotas(opcao);
				int qtdNotasMaiores = Integer.parseInt(opcao); 
				notaDao.calculaMediaComNotasMaiores(qtdNotasMaiores);
			}else if(opcaoSelecionada.equals("avsSelecionadas")){
				notaDao.calculaMediaDasAvaliacaoesSelecionadas(req);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	private void validarParametro(String opcao) throws Exception{
		try {
			if(opcao == null){
				throw new Exception("Selecione uma das opções");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	private void validarNrNotas(String opcao) throws Exception{
		try {
			if(opcao == null || opcao.isEmpty()){
				throw new Exception("Informe o número de notas.");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public String getNomePaginaSucesso() {
		return "conAluno.jsp";
	}

	@Override
	public String getNomePaginaErro() {
		return "calcMedia.jsp";
	}

}
