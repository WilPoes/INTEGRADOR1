package modelo;

public class PedidoDetalles {
	private int idpeddetalles;
	private int idpedido;
	private String nompeddetail;
	private String fechaentrega;
	private int cantidadttl;
	private double pesottl;
	private int idservicio;
	//
	public PedidoDetalles() {
		// TODO Auto-generated constructor stub
	}
	//
	public int getIdpeddetalles() {
		return idpeddetalles;
	}
	public void setIdpeddetalles(int idpeddetalles) {
		this.idpeddetalles = idpeddetalles;
	}
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public String getNompeddetail() {
		return nompeddetail;
	}
	public void setNompeddetail(String nompeddetail) {
		this.nompeddetail = nompeddetail;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public int getCantidadttl() {
		return cantidadttl;
	}
	public void setCantidadttl(int cantidadttl) {
		this.cantidadttl = cantidadttl;
	}
	public double getPesottl() {
		return pesottl;
	}
	public void setPesottl(double pesottl) {
		this.pesottl = pesottl;
	}
	public int getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}
	
}
