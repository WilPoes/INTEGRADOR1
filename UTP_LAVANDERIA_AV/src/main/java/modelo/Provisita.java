package modelo;

public class Provisita {
	private int idprovisitas;
	//
	private int idusuario_conductor;
	private String nomusuario_conductor;
	//
	private String detalles;
	private String fechapedido;
	private String fechaentrega;
	private String placavehiculo;
	//
	private String estado;
	private boolean estadobool;
	
	public int getIdprovisitas() {
		return idprovisitas;
	}

	public void setIdprovisitas(int idprovisitas) {
		this.idprovisitas = idprovisitas;
	}

	public int getIdusuario_conductor() {
		return idusuario_conductor;
	}

	public void setIdusuario_conductor(int idusuario_conductor) {
		this.idusuario_conductor = idusuario_conductor;
	}

	public String getNomusuario_conductor() {
		return nomusuario_conductor;
	}

	public void setNomusuario_conductor(String nomusuario_conductor) {
		this.nomusuario_conductor = nomusuario_conductor;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(String fechapedido) {
		this.fechapedido = fechapedido;
	}

	public String getFechaentrega() {
		return fechaentrega;
	}

	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public String getPlacavehiculo() {
		return placavehiculo;
	}

	public void setPlacavehiculo(String placavehiculo) {
		this.placavehiculo = placavehiculo;
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