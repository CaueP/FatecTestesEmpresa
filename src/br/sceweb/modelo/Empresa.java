package br.sceweb.modelo;


import java.util.InputMismatchException;

/**
 * Classe que define a entidade Empresa
 * @author Caue Polimanti
 * @version 1.0
 */
public class Empresa {
	private String cnpj;
	private String nomeDaEmpresa;
	private String nomeFantasia;
	private String endereco;
	private String telefone;
	

	// getters and setters
	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		if (nomeDaEmpresa.equals("")) {
			throw new IllegalArgumentException("Nome da empresa invalido");
		} else {
			this.nomeDaEmpresa = nomeDaEmpresa;
		}		
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		if (cnpj.equals("")) {
			throw new IllegalArgumentException("CNPJ da empresa invalido");
		} else {
			this.cnpj = cnpj;
		}	
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		if (nomeFantasia.equals("")) {
			throw new IllegalArgumentException("Nome Fantasia da empresa invalido");
		} else {
			this.nomeFantasia = nomeFantasia;
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if (endereco.equals("")) {
			throw new IllegalArgumentException("Endereco da empresa invalido");
		} else {
			this.endereco = endereco;
		}
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if (telefone.equals("")) {
			throw new IllegalArgumentException("Telefone da empresa invalido");
		} else {
			this.telefone = telefone;
		}
	}
}
