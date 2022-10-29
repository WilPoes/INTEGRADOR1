package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelo.Prenda;
import modelo.PrendaDetalles;

public class PrendaDetallesDAO extends Conexion implements IcrudDAO<PrendaDetalles>, IcontarDAO<PrendaDetalles>, IdistinguirDAO<PrendaDetalles>{
	private String sql_selectbyprendadetalles = "SELECT dpd.iddetalleprenda ,pd.idprenda, dpd.idpeddetalles, pd.nomprenda, pd.descprenda, dpd.cantidadunitaria, dpd.pesounitario FROM prendas pd inner join detalleprendas dpd ON dpd.idprenda = pd.idprenda where dpd.iddetalleprenda =";
	private String sql_insert = "INSERT INTO detalleprendas(iddetalleprenda, idprenda, idpeddetalles, cantidadunitaria, pesounitario) VALUES (nextval('sqdetalleprendas'),?,?,?,?)";
	//CONTAR TODOS
	private String sql_countpeddet = "SELECT count(*) from pedidodetalles where idpeddetalles=";
	@Override
	public int ContarTodos() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void Crear(PrendaDetalles t) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			stmt.setInt(1, t.getIdprendafk());
			stmt.setInt(2, t.getIdpeddetalles());
			stmt.setInt(3, t.getCantidadunitaria());
			stmt.setDouble(4, t.getPesounitario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int Actualizar(PrendaDetalles t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public PrendaDetalles Obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void Eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<PrendaDetalles> ListarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<PrendaDetalles> Buscar(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	//
	public List<PrendaDetalles> ListarTodos(int i) {
		List<PrendaDetalles> prenda = new ArrayList<>();
		Connection con = obtenerConexion();
		//dpd.iddetalleprenda ,pd.idprenda, pd.nomprenda, pd.descprenda, dpd.cantidadunitaria, dpd.pesounitario
		try {
			PreparedStatement stmt = con.prepareStatement(sql_selectbyprendadetalles + i);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PrendaDetalles p = new PrendaDetalles();
				p.setIdprendadetalles(rs.getInt(1));
				p.setIdprenda(rs.getInt(2));
				p.setIdpeddetalles(rs.getInt(3));
				//
				p.setNomprenda(rs.getString(4));
				p.setDescprenda(rs.getString(5));
				//
				p.setCantidadunitaria(rs.getInt(6));
				p.setPesounitario(rs.getDouble(7));
				
				//
				prenda.add(p);
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
		return prenda;
	}
}
