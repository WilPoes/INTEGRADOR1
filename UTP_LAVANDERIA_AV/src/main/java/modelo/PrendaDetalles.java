package modelo;

public class PrendaDetalles extends Prenda {
	private int idprendadetalles;
	//
	private int idprendafk;
	private String nomprenda;
	private String descprenda;
	//
	private int idpeddetalles;
	private int cantidadunitaria;
	private double pesounitario;
	////dpd.iddetalleprenda ,pd.idprenda, pd.nomprenda, pd.descprenda, dpd.cantidadunitaria, dpd.pesounitario
	public PrendaDetalles() {
		// TODO Auto-generated constructor stub
	}
	//
	public int getIdprendadetalles() {
		return idprendadetalles;
	}
	public void setIdprendadetalles(int idprendadetalles) {
		this.idprendadetalles = idprendadetalles;
	}
	public int getIdpeddetalles() {
		return idpeddetalles;
	}
	public void setIdpeddetalles(int idpeddetalles) {
		this.idpeddetalles = idpeddetalles;
	}
	public int getCantidadunitaria() {
		return cantidadunitaria;
	}
	public void setCantidadunitaria(int cantidadunitaria) {
		this.cantidadunitaria = cantidadunitaria;
	}
	public double getPesounitario() {
		return pesounitario;
	}
	public void setPesounitario(double pesounitario) {
		this.pesounitario = getPesoprenda();
	}
	//
	public int getIdprendafk() {
		return idprendafk;
	}
	public void setIdprendafk(int idprendafk) {
		this.idprendafk = getIdprenda();
	}
	public String getNomprenda() {
		return nomprenda;
	}
	public void setNomprenda(String nomprenda) {
		this.nomprenda = nomprenda;
	}
	public String getDescprenda() {
		return descprenda;
	}
	public void setDescprenda(String descprenda) {
		this.descprenda = descprenda;
	}
	
	
}
