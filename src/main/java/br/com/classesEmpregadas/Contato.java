package br.com.classesEmpregadas;

public class Contato {
	
	private String telefone;
	private String email;
	
	public Contato( String telefone, String email) {
		this.telefone = telefone;
		this.email = email;
	}

	public String getDescricao2() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
