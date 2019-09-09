package com.example.demo.util.json;

public class Retorno {

	private int status = 1;
	private String mensagem = "";

	public Retorno() {
	}

	public Retorno(int status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}

	public Retorno(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
