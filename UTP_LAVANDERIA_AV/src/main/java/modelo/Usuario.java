package modelo;

public class Usuario {
	private int idusuario;
	private String nombreusuario;
	private String contraseñausuario;
	//
	private String nombres;
	private String apellidos;
	private String direccion;
	private String correo;
	private String telefono;
	private String cargo;
	//
	private int iddistrito;
	private String nomdistrito;
	//
	private String estado;
	private boolean estadobool;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombreusuario, String contraseñausuario) {
		super();
		this.nombreusuario = nombreusuario;
		this.contraseñausuario = contraseñausuario;
	}
	//
	public Usuario(int idusuario, String nombres, String apellidos, String direccion, String correo, String telefono,
			String cargo) {
		super();
		this.idusuario = idusuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.cargo = cargo;
	}
	//

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getContraseñausuario() {
		return contraseñausuario;
	}

	public void setContraseñausuario(String contraseñausuario) {
		this.contraseñausuario = contraseñausuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public int getIddistrito() {
		return iddistrito;
	}

	public void setIddistrito(int iddistrito) {
		this.iddistrito = iddistrito;
	}

	public String getNomdistrito() {
		return nomdistrito;
	}

	public void setNomdistrito(String nomdistrito) {
		this.nomdistrito = nomdistrito;
	}

	
}
