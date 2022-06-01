package br.com.fiap.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Visitor {

	@Id
	@Column(name="id_visitante", precision = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_visitante", length = 100)
	private String nome;
	
	@Column(name = "dt_nasc")
	private LocalDate dataNascimento;
	
	@Column(name = "nr_cpf", length = 12)
	private String cpf;
	
	@Column(name = "nr_rg", length = 11)
	private String rg;
	
	@Column(name = "nm_dig_rg", length = 1)
	private String numeroRg;
	
	@Column(name = "dt_cadastro")
	private LocalDate dataCadastro; 
	
	@Column(name = "fl_foto_visitante")
	private String imagePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	public String getNumeroRg() {
		return numeroRg;
	}

	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Visitante [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf
				+ ", rg=" + rg + ", numeroRg=" + numeroRg + ", dataCadastro=" + dataCadastro + ", imagePath="
				+ imagePath + "]";
	}
}
