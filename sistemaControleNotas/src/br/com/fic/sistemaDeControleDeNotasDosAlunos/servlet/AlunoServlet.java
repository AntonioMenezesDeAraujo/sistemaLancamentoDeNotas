package br.com.fic.sistemaDeControleDeNotasDosAlunos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.servico.Servico;

/**
 * Servlet implementation class AlunoServlet
 */
@WebServlet("/AlunoServlet")

public class AlunoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("parametro");
		String nomeDaClasse = "br.com.fic.sistemaDeControleDeNotasDosAlunos.servico." + parametro;
		String paginaSucesso = "";
		String paginaErro = "";
		if(nomeDaClasse != null){
			try {
				Class<?> classe = Class.forName(nomeDaClasse);
				Servico servico = (Servico) classe.newInstance();

				// Recebe o String após a execução da lógica
				paginaSucesso = servico.getNomePaginaSucesso();
				paginaErro = servico.getNomePaginaErro();
				servico.executaLogica(request, response);
				paginaSucesso = paginaSucesso + "?message=Cadastro realizado com sucesso!";
				RequestDispatcher dispatcher = request.getRequestDispatcher(paginaSucesso);  
				dispatcher.forward(request, response);

			} catch (Exception e) {
				paginaErro = paginaErro + "?erro=" + e.getCause().getCause().getMessage();
				RequestDispatcher dispatcher = request.getRequestDispatcher(paginaErro);  
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
