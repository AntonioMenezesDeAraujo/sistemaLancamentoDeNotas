package br.com.fic.sistemaDeControleDeNotasDosAlunos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

@WebServlet("/AlterarAlunoServlet")
public class AlterarAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AlterarAlunoServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		String nome;
		String matricula;
		
		nome = request.getParameter("nome");
		matricula = request.getParameter("mat");
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		
		AlunoDao dao = new AlunoDaoImpl();
		dao.alterarDadosDoAluno(aluno);
	}

}
