package modelo;

public class Servicio {
	//
	private int id;
	//
	private int idcat;
	private String nomidcat;
	//
	private String nomservicio;
	private double precioservicio;
	private double pesorequeridoservicio;
	private int cantrequeridaservicio;
	private int diasestimados;
	//
	private String estado;
	private boolean estadobool;

	//
	public Servicio() {
		// TODO Auto-generated constructor stub
	}

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public String getNomidcat() {
		return nomidcat;
	}

	public void setNomidcat(String nomidcat) {
		this.nomidcat = nomidcat;
	}

	public String getNomservicio() {
		return nomservicio;
	}

	public void setNomservicio(String nomservicio) {
		this.nomservicio = nomservicio;
	}

	public double getPrecioservicio() {
		return precioservicio;
	}

	public void setPrecioservicio(double precioservicio) {
		this.precioservicio = precioservicio;
	}

	public double getPesorequeridoservicio() {
		return pesorequeridoservicio;
	}

	public void setPesorequeridoservicio(double pesorequeridoservicio) {
		this.pesorequeridoservicio = pesorequeridoservicio;
	}

	public int getCantrequeridaservicio() {
		return cantrequeridaservicio;
	}

	public void setCantrequeridaservicio(int cantrequeridaservicio) {
		this.cantrequeridaservicio = cantrequeridaservicio;
	}

	public int getDiasestimados() {
		return diasestimados;
	}

	public void setDiasestimados(int diasestimados) {
		this.diasestimados = diasestimados;
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