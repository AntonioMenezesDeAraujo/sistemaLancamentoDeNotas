package br.com.fic.sistemaDeControleDeNotasDosAlunos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.servico.Servico;

@WebServlet("/DisciplinaServlet")
public class DisciplinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisciplinaServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("parametro");
	    String nomeDaClasse = "br.com.fic.sistemaDeControleDeNotasDosAlunos.servico." + parametro;
	    if(nomeDaClasse != null){
	    try {
	      Class<?> classe = Class.forName(nomeDaClasse);
	      Servico logica = (Servico) classe.newInstance();
	      
	      // Recebe o String após a execução da lógica
	      String pagina = logica.executaLogica(request, response);
	      RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);  
          dispatcher.forward(request, response);

	    } catch (Exception e) {
	      throw new ServletException(
	          "A lógica de negócios causou uma exceção", e);
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
