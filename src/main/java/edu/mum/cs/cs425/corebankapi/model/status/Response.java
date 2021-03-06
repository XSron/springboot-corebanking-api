package edu.mum.cs.cs425.corebankapi.model.status;

public class Response {
	private int status_code;
	private String message;
	private Iterable<?> data;
	public Response(int status_code, String message, Iterable<?> data) {
		this.status_code = status_code;
		this.message = message;
		this.data = data;
	}
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Iterable<?> getData() {
		return data;
	}
	public void setData(Iterable<?> data) {
		this.data = data;
	}
}
