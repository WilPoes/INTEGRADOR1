package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;
import modelo.Provisita;

public class ProvisitasDAO extends Conexion implements IcrudDAO<Provisita> {
	// ATT
	private String sql_select = "SELECT idprovisitas, idusuario_conductor, detalles, fechapedido, fechaentrega, placavehiculo FROM provisitas;";
	private String sql_insert = "INSERT INTO provisitas (idprovisitas, idusuario_conductor, detalles, fechapedido, fechaentrega, placavehiculo, estado) VALUES (nextval('sqservicios'),?,?,?,?,?,?)";
	private String sql_update = "UPDATE provisitas SET idusuario_conductor=?, detalles=?, fechapedido=?, fechaentrega=?, placavehiculo=?, estado=? WHERE idprovisitas=?";
	private String sql_delete = "UPDATE provisitas SET estado='false' WHERE idprovisitas="; //SE ELILMINO
	private String sql_selectbyid = "SELECT idusuario_conductor, detalles, fechapedido, fechaentrega, placavehiculo, estado FROM provisitas WHERE idprovisitas =";
	// UNIONES
	private String sql_nomconductor_provisitas = "SELECT provisitas.idprovisitas, usuarios.nomusuario, provisitas.detalles, provisitas.fechapedido, provisitas.fechaentrega, provisitas.placavehiculo, provisitas.estado, usuarios.cargo FROM usuarios  RIGHT JOIN provisitas ON usuarios.cargo LIKE 'conductor'";
	//
	public List<Provisita> ListarTodosProVisitasConductor() {
		List<Provisita> provisitas = new ArrayList<>();
		boolean cen = false;
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_nomconductor_provisitas + " order by idprovisitas asc");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Provisita pv = new Provisita();
				pv.setIdprovisitas(rs.getInt(1));
				pv.setNomusuario_conductor(rs.getString(2));
				pv.setDetalles(rs.getString(3));
				pv.setFechapedido(rs.getString(4));
				pv.setFechaentrega(rs.getString(5));
				pv.setPlacavehiculo(rs.getString(6));
				pv.setEstadobool(rs.getBoolean(7));
				cen = rs.getBoolean(7);
				if(cen==true){
					pv.setEstado("activo");
				} else {
					pv.setEstado("inactivo");
				}
				provisitas.add(pv);
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
		return provisitas;
	}

	//
	@Override
	public void Crear(Provisita pvis) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			stmt.setInt(1, pvis.getIdusuario_conductor());
			stmt.setString(2, pvis.getDetalles());
			stmt.setString(3, pvis.getFechapedido());
			stmt.setString(4, pvis.getFechaentrega());
			stmt.setString(5, pvis.getPlacavehiculo());
			stmt.setBoolean(6, pvis.isEstadobool());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int Actualizar(Provisita pvis) {
		Connection con = obtenerConexion();
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql_update);
			ps.setInt(1, pvis.getIdusuario_conductor());
			ps.setString(2, pvis.getDetalles());
			ps.setString(3, pvis.getFechapedido());
			ps.setString(4, pvis.getFechaentrega());
			ps.setString(5, pvis.getPlacavehiculo());
			ps.setBoolean(6, pvis.isEstadobool());
			ps.setInt(8, pvis.getIdprovisitas());
			
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
	public Provisita Obtener(int idprovisitas) {
		Provisita pvis = new Provisita();
		boolean cen = false;
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_selectbyid + idprovisitas);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pvis.setIdprovisitas(rs.getInt(1));
				pvis.setIdusuario_conductor(rs.getInt(2));
				pvis.setDetalles(rs.getString(3));
				pvis.setFechapedido(rs.getString(4));
				pvis.setFechaentrega(rs.getString(5));
				pvis.setPlacavehiculo(rs.getString(6));
				pvis.setEstadobool(rs.getBoolean(7));
				cen = rs.getBoolean(8);
				if(cen==true){
					pvis.setEstado("activo");
				} else {
					pvis.setEstado("inactivo");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pvis;
	}

	@Override
	public void Eliminar(int idprovisitas) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement ps = con.prepareStatement(sql_delete + idprovisitas);
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
	public List<Provisita> ListarTodos() {
		List<Provisita> listaprovisitas = new ArrayList<>();
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_select);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Provisita pv = new Provisita();
				pv.setIdprovisitas(rs.getInt(1));
				pv.setIdusuario_conductor(rs.getInt(2));
				pv.setDetalles(rs.getString(3));
				pv.setFechapedido(rs.getString(4));
				pv.setFechaentrega(rs.getString(5));
				pv.setPlacavehiculo(rs.getString(6));
				listaprovisitas.add(pv);
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
		return listaprovisitas;
	}

	@Override
	public List<Provisita> Buscar(String busqueda) {
		List<Provisita> listaprovisitas = new ArrayList<>();
		Connection con = obtenerConexion();
		try {
			String sql_searchcrossbywordcategory = "SELECT provisitas.idprovisitas, usuarios.nomusuario, provisitas.detalles, provisitas.fechapedido, provisitas.fechaentrega, provisitas.placavehiculo, provisitas.estado FROM usuarios LEFT JOIN provisitas ON provisitas.idusuario_conductor = usuarios.cod_usuario where provisitas.placavehiculo like '%" + busqueda + "%' or usuarios.nomusuario like '%" + busqueda + "%' order by idprovisitas asc";
			PreparedStatement stmt = con.prepareStatement(sql_searchcrossbywordcategory);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Provisita pv = new Provisita();
				pv.setIdprovisitas(rs.getInt(1));
				pv.setNomusuario_conductor(rs.getString(2));
				pv.setDetalles(rs.getString(3));
				pv.setFechaentrega(rs.getString(4));
				pv.setFechapedido(rs.getString(5));
				pv.setPlacavehiculo(rs.getString(6));
				listaprovisitas.add(pv);
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
		return listaprovisitas;
	}

}
