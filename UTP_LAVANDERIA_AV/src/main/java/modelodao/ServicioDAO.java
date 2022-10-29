package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;
import modelo.Servicio;

public class ServicioDAO extends Conexion implements IcrudDAO<Servicio> {
	// ATT
	private String sql_select = "SELECT idservicio, idcat, nomservicio,precioservicio, pesorequeridoservicio, cantrequeridaservicio, diasestimados FROM servicios order by idservicio asc";
	private String sql_insert = "INSERT INTO servicios (idservicio, idcat, nomservicio, precioservicio, pesorequeridoservicio, cantrequeridaservicio, diasestimados, estadoservicio) VALUES (nextval('sqservicios'),?,?,?,?,?,?,?)";
	private String sql_update = "UPDATE servicios SET idcat=?, nomservicio=?, precioservicio=?, pesorequeridoservicio=?, cantrequeridaservicio=?, diasestimados=?, estadoservicio=? WHERE idservicio=?";
	private String sql_delete = "UPDATE servicios SET estadoservicio='false' WHERE idservicio=";
	private String sql_selectbyid = "SELECT idservicio, idcat, nomservicio, precioservicio, pesorequeridoservicio, cantrequeridaservicio, diasestimados, estadoservicio FROM servicios WHERE idServicio =";
	// UNIONES
	private String sql_nomcategoria_servicio = "SELECT s.idservicio,c.titulo,s.nomservicio,s.precioservicio,s.pesorequeridoservicio,s.cantrequeridaservicio,s.diasestimados, s.estadoservicio\r\n"
			+ "FROM servicios s\r\n" + "INNER JOIN categorias c\r\n" + "ON s.idcat = c.id";
	//
	public List<Servicio> ListarTodosServicioCategoria() {
		List<Servicio> servicio = new ArrayList<>();
		boolean cen = false;
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_nomcategoria_servicio + " order by idservicio asc");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Servicio s = new Servicio();
				s.setId(rs.getInt(1));
				s.setNomidcat(rs.getString(2));
				s.setNomservicio(rs.getString(3));
				s.setPrecioservicio(rs.getDouble(4));
				s.setPesorequeridoservicio(rs.getDouble(5));
				s.setCantrequeridaservicio(rs.getInt(6));
				s.setDiasestimados(rs.getInt(7));
				s.setEstadobool(rs.getBoolean(8));
				cen = rs.getBoolean(8);
				if(cen==true){
					s.setEstado("activo");
				} else {
					s.setEstado("inactivo");
				}
				servicio.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return servicio;
	}

	//
	@Override
	public void Crear(Servicio serv) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			stmt.setInt(1, serv.getIdcat());
			stmt.setString(2, serv.getNomservicio());
			stmt.setDouble(3, serv.getPrecioservicio());
			stmt.setDouble(4, serv.getPesorequeridoservicio());
			stmt.setInt(5, serv.getCantrequeridaservicio());
			stmt.setInt(6, serv.getDiasestimados());
			stmt.setBoolean(7, serv.isEstadobool());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int Actualizar(Servicio serv) {
		Connection con = obtenerConexion();
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql_update);
			ps.setInt(1, serv.getIdcat());
			ps.setString(2, serv.getNomservicio());
			ps.setDouble(3, serv.getPrecioservicio());
			ps.setDouble(4, serv.getPesorequeridoservicio());
			ps.setInt(5, serv.getCantrequeridaservicio());
			ps.setInt(6, serv.getDiasestimados());
			ps.setBoolean(7, serv.isEstadobool());
			ps.setInt(8, serv.getId());
			
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
	public Servicio Obtener(int id) {
		Servicio serv = new Servicio();
		boolean cen = false;
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_selectbyid + id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				serv.setId(rs.getInt(1));
				serv.setIdcat(rs.getInt(2));
				serv.setNomservicio(rs.getString(3));
				serv.setPrecioservicio(rs.getDouble(4));
				serv.setPesorequeridoservicio(rs.getDouble(5));
				serv.setCantrequeridaservicio(rs.getInt(6));
				serv.setDiasestimados(rs.getInt(7));
				serv.setEstadobool(rs.getBoolean(8));
				cen = rs.getBoolean(8);
				if(cen==true){
					serv.setEstado("activo");
				} else {
					serv.setEstado("inactivo");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serv;
	}

	@Override
	public void Eliminar(int id) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement ps = con.prepareStatement(sql_delete + id);
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
	public List<Servicio> ListarTodos() {
		List<Servicio> listaservicios = new ArrayList<>();
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_select);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Servicio s = new Servicio();
				s.setId(rs.getInt(1));
				s.setIdcat(rs.getInt(2));
				s.setNomservicio(rs.getString(3));
				s.setPrecioservicio(rs.getDouble(4));
				s.setPesorequeridoservicio(rs.getDouble(5));
				s.setCantrequeridaservicio(rs.getInt(6));
				s.setDiasestimados(rs.getInt(7));
				listaservicios.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaservicios;
	}

	@Override
	public List<Servicio> Buscar(String busqueda) {
		List<Servicio> listaservicios = new ArrayList<>();
		Connection con = obtenerConexion();
		try {
			String sql_searchcrossbywordcategory = "SELECT s.idservicio,c.titulo,s.nomservicio,s.precioservicio,s.pesorequeridoservicio,s.cantrequeridaservicio,s.diasestimados FROM servicios s INNER JOIN categorias c ON s.idcat = c.id "
					+ "where s.nomservicio like '%" + busqueda + "%' " + "or c.titulo like '%" + busqueda + "%' "
					+ "order by idservicio asc";
			PreparedStatement stmt = con.prepareStatement(sql_searchcrossbywordcategory);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Servicio s = new Servicio();
				s.setId(rs.getInt(1));
				s.setNomidcat(rs.getString(2));
				s.setNomservicio(rs.getString(3));
				s.setPrecioservicio(rs.getDouble(4));
				s.setPesorequeridoservicio(rs.getDouble(5));
				s.setCantrequeridaservicio(rs.getInt(6));
				s.setDiasestimados(rs.getInt(7));
				listaservicios.add(s);
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
		return listaservicios;
	}

}
