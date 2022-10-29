package modelo;

public class Pedido {
	private int idpedido;
	private int idcliente;
	private int idservicio;
	private String comentariospedido;
	private String fechapedido;
	private String fechafinpedido;
	private double totalpedido;
	//
	private String nombreidcliente;
	private String nombreidservicio;
	//
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}
	public String getComentariospedido() {
		return comentariospedido;
	}
	public void setComentariospedido(String comentariospedido) {
		this.comentariospedido = comentariospedido;
	}
	public String getFechapedido() {
		return fechapedido;
	}
	public void setFechapedido(String fechapedido) {
		this.fechapedido = fechapedido;
	}
	public String getFechafinpedido() {
		return fechafinpedido;
	}
	public void setFechafinpedido(String fechafinpedido) {
		this.fechafinpedido = fechafinpedido;
	}
	public double getTotalpedido() {
		return totalpedido;
	}
	public void setTotalpedido(double totalpedido) {
		this.totalpedido = totalpedido;
	}
	public String getNombreidcliente() {
		return nombreidcliente;
	}
	public void setNombreidcliente(String nombreidcliente) {
		this.nombreidcliente = nombreidcliente;
	}
	public String getNombreidservicio() {
		return nombreidservicio;
	}
	public void setNombreidservicio(String nombreidservicio) {
		this.nombreidservicio = nombreidservicio;
	}

}
