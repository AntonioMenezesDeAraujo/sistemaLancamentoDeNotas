package br.com.fic.sistemaDeControleDeNotasDosAlunos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.servico.Servico;


@WebServlet("/AvaliacaoServlet")
public class AvaliacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AvaliacaoServlet() {
		super();
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("parametro");
		String nomeDaClasse = "br.com.fic.sistemaDeControleDeNotasDosAlunos.servico." + parametro;
		if(nomeDaClasse != null){
			try {
				Class<?> classe = Class.forName(nomeDaClasse);
				Servico servico = (Servico) classe.newInstance();

				// Recebe o String ap�s a execu��o da l�gica
				String pagina = servico.getNomePagina();
				servico.executaLogica(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);  
				dispatcher.forward(request, response);

			} catch (Exception e) {
				throw new ServletException(
						"A l�gica de neg�cios causou uma exce��o", e);
			}
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
