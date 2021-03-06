package br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao {
	@Id
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "notaAluno")
	private List<Nota> notas;

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
}
