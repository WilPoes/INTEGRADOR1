package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;
import modelo.Usuario;

public class UsuarioDAO extends Conexion implements IvalidarDAO, IcrudDAO<Usuario>{
	private String sql_login = "SELECT nomusuario,contraseñausuario FROM usuarios WHERE nomusuario=? and contraseñausuario=?";
	private String sql_select = "SELECT cod_usuario, nomusuario, nombres, apellidos, direccion, correo, telefono, cargo, estadobool FROM usuarios order by cod_usuario asc";
	private String sql_insert = "INSERT INTO usuarios (cod_usuario, nomusuario, contraseñausuario, nombres, apellidos, direccion, correo, telefono, cargo, estadobool, iddistritos) VALUES (nextval('squsuarios'),?,?,?,?,?,?,?,?,?,?)";
	private String sql_update = "UPDATE usuarios SET nomusuario=?, nombres=?, apellidos=?, direccion=?, correo=?, telefono=?, cargo=?, estadobool=?, iddistritos=? WHERE cod_usuario=?";
	private String sql_selectbyid = "SELECT cod_usuario, nomusuario, contraseñausuario, nombres, apellidos, direccion, correo, telefono, cargo, estadobool FROM usuarios WHERE cod_usuario=";
	private String sql_delete="UPDATE usuarios SET estadobool='false' WHERE cod_usuario=";	
	private String sql_select_byconductor = "SELECT nomusuario, cod_usuario, estadobool  FROM usuarios WHERE cargo like 'conductor'";
	private String sql_nomdistrito_usuario = "SELECT u.cod_usuario, u.nomusuario, u.nombres, u.apellidos, d.nombredistrito, u.direccion, u.correo, u.telefono, u.cargo, u.estadobool FROM usuarios u LEFT JOIN distritos d on u.iddistritos = d.iddistrito order by u.cod_usuario asc";
	//
	public List<Usuario> ListarTodosPorConductor() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_select_byconductor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				boolean estadobool = rs.getBoolean(3);
				if(estadobool == true) {					
					u.setNombreusuario(rs.getString(1));
					u.setIdusuario(rs.getInt(2));
					usuarios.add(u);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}
	//*
	@Override
	public boolean Validar(String usuario, String contraseña) {
		boolean rpta = false;

		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_login);
			stmt.setString(1, usuario);
			stmt.setString(2, contraseña);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == false) {
				rpta = false;
			} else {
				rpta = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rpta;
	}

	@Override
	public void Crear(Usuario t) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			
			stmt.setString(1, t.getNombreusuario());
			stmt.setString(2, t.getContraseñausuario());
			stmt.setString(3, t.getNombres());
			stmt.setString(4, t.getApellidos());
			stmt.setString(5, t.getDireccion());
			stmt.setString(6, t.getCorreo());
			stmt.setString(7, t.getTelefono());
			stmt.setString(8, t.getCargo());
			stmt.setBoolean(9, t.isEstadobool());
			stmt.setInt(10, t.getIddistrito());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int Actualizar(Usuario t) {
		Connection con = obtenerConexion();
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql_update);
			ps.setString(1, t.getNombreusuario());
			ps.setString(2, t.getNombres());
			ps.setString(3, t.getApellidos());
			ps.setString(4, t.getDireccion());
			ps.setString(5, t.getCorreo());
			ps.setString(6, t.getTelefono());
			ps.setString(7, t.getCargo());
			ps.setBoolean(8, t.isEstadobool());
			ps.setInt(9, t.getIddistrito());
			ps.setInt(10, t.getIdusuario());
			
			i = ps.executeUpdate();
			if (i != 1) {
				i = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Usuario Obtener(int id) {
		Usuario usu = new Usuario();
		boolean cen = false;
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_selectbyid + id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usu.setIdusuario(rs.getInt(1));
				usu.setNombreusuario(rs.getString(2));
				usu.setContraseñausuario(rs.getString(3));
				usu.setNombres(rs.getString(4));
				usu.setApellidos(rs.getString(5));
				usu.setDireccion(rs.getString(6));
				usu.setCorreo(rs.getString(7));
				usu.setTelefono(rs.getString(8));
				//falta contraseña si es usuario
				usu.setCargo(rs.getString(9));
				cen = rs.getBoolean(10);
				if(cen==true){
					usu.setEstado("activo");
				} else {
					usu.setEstado("inactivo");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usu;
	}

	@Override
	public void Eliminar(int id) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement ps = con.prepareStatement(sql_delete+id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Usuario> ListarTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_nomdistrito_usuario);
			ResultSet rs = stmt.executeQuery();
			boolean cen=false;
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setIdusuario(rs.getInt(1));
				u.setNombreusuario(rs.getString(2));
				u.setNombres(rs.getString(3));
				u.setApellidos(rs.getString(4));
				u.setNomdistrito(rs.getString(5));
				u.setDireccion(rs.getString(6));
				u.setCorreo(rs.getString(7));
				u.setTelefono(rs.getString(8));
				u.setCargo(rs.getString(9));
				u.setEstadobool(rs.getBoolean(10));
				cen = rs.getBoolean(10);
				if(cen==true){
					u.setEstado("activo");
				} else {
					u.setEstado("inactivo");
				}
				usuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}

	@Override
	public List<Usuario> Buscar(String busqueda) {
		List<Usuario> listausuarios = new ArrayList<>();
		Connection con = obtenerConexion();
		try {
			String sql_searchbyword = "select cod_usuario, nomusuario, nombres, apellidos, direccion, correo, telefono, cargo  from usuarios where nomusuario like '%" 
					+ busqueda + "%' or nombres like '%" 
					+ busqueda + "%' or apellidos like '%"
					+ busqueda + "%' or correo like '%"
					+ busqueda + "%' order by cod_usuario asc";
			PreparedStatement stmt = con.prepareStatement(sql_searchbyword);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setIdusuario(rs.getInt(1));
				u.setNombreusuario(rs.getString(2));
				u.setNombres(rs.getString(3));
				u.setApellidos(rs.getString(4));
				u.setDireccion(rs.getString(5));
				u.setCorreo(rs.getString(6));
				u.setTelefono(rs.getString(7));
				u.setCargo(rs.getString(8));
				listausuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listausuarios;
	}


}
