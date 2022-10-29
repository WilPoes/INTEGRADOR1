package modelo;

public class Categoria {
	//
	private int id;
	private String titulo;
	private String descripcion;
	//
	private String estado;
	private boolean estadobool;

	//
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(int id, String titulo, String descripcion) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isEstadobool() {
		return estadobool;
	}

	public void setEstadobool(boolean estadobool) {
		this.estadobool = estadobool;
	}

}