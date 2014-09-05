package br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nota {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "nota")
	private Double nota;
	@ManyToOne
	private Aluno aluno;
	@ManyToOne
	private Avaliacao notaAluno;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Avaliacao getNotaAluno() {
		return notaAluno;
	}

	public void setNotaAluno(Avaliacao notaAluno) {
		this.notaAluno = notaAluno;
	}

}
