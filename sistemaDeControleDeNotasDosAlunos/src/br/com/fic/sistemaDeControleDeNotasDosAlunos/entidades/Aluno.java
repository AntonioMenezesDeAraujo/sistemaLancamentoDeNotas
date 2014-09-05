package br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CascadeType;

@Entity
@NamedQueries({
	@NamedQuery(name="aluno.todosAlunos",query="select aluno from Aluno aluno"),
	@NamedQuery(name="aluno.selecionaTodosAlunoPorNome" , query="select aluno from Aluno aluno where upper(aluno.nome) = upper(':nome')")
})
public class Aluno {
	@Id
	@Column(name = "matricula")
	private String matricula;
	@Column(name = "nome")
	private String nome;
	@OneToMany(mappedBy = "aluno")
	private List<Nota> notas;
	@OneToMany(mappedBy = "aluno")
	private List<AlunoDisciplina> alunosDisciplina;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public List<AlunoDisciplina> getAlunosDisciplina() {
		return alunosDisciplina;
	}

	public void setAlunosDisciplina(List<AlunoDisciplina> alunosDisciplina) {
		this.alunosDisciplina = alunosDisciplina;
	}
}
