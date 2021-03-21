package br.dev.simon.booksapi.domain;

public class ErrorDetails {

	private String titulo;

	private Long status;

	private Long timestamp;

	private String msgDev;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsgDev() {
		return msgDev;
	}

	public void setMsgDev(String msgDev) {
		this.msgDev = msgDev;
	}

}
