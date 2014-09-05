package br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disciplina {
	@Id
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "descricao")
	private String descricao;
	@OneToMany(mappedBy = "disciplina")
	private List<Avaliacao> avaliacoes;
	@OneToMany(mappedBy = "disciplina")
	private List<AlunoDisciplina> alunosDisciplinas;
	
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AlunoDisciplina> getAlunosDisciplinas() {
		return alunosDisciplinas;
	}

	public void setAlunosDisciplinas(List<AlunoDisciplina> alunosDisciplinas) {
		this.alunosDisciplinas = alunosDisciplinas;
	}

}
