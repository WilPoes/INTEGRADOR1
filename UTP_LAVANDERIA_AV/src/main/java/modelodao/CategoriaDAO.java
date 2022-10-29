package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;
import modelo.Categoria;

public class CategoriaDAO extends Conexion implements IcrudDAO<Categoria> {
	// ATT
	private String sql_select = "SELECT id, titulo, descripcion, estadocategoria FROM categorias order by id asc";
	private String sql_insert = "INSERT INTO categorias (id, titulo, descripcion, estadocategoria) VALUES (nextval('sqcategorias'),?,?,?)";
	private String sql_update = "UPDATE categorias SET titulo=?, descripcion=?, estadocategoria=? WHERE id=?";
	private String sql_delete = "UPDATE categorias SET estadocategoria='false' WHERE id=";
	private String sql_selectbyid = "SELECT id, titulo, descripcion, estadocategoria FROM categorias WHERE id=";

	@Override
	public void Crear(Categoria cat) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			stmt.setString(1, cat.getTitulo());
			stmt.setString(2, cat.getDescripcion());
			stmt.setBoolean(3, cat.isEstadobool());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int Actualizar(Categoria cat) {
		Connection con = obtenerConexion();
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql_update);
			ps.setString(1, cat.getTitulo());
			ps.setString(2, cat.getDescripcion());
			ps.setBoolean(3, cat.isEstadobool());
			ps.setInt(4, cat.getId());
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
	public Categoria Obtener(int id) {
		Categoria cat = new Categoria();
		boolean cen = false;
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_selectbyid + id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cat.setId(rs.getInt(1));
				cat.setTitulo(rs.getString(2));
				cat.setDescripcion(rs.getString(3));
				cat.setEstadobool(rs.getBoolean(4));
				cen = rs.getBoolean(4);
				if(cen==true){
					cat.setEstado("activo");
				} else {
					cat.setEstado("inactivo");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
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
	public List<Categoria> ListarTodos() {
		List<Categoria> categoria = new ArrayList<>();
		boolean cen = false;
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_select);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt(1));
				c.setTitulo(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setEstadobool(rs.getBoolean(4));
				cen = rs.getBoolean(4);
				if(cen==true){
					c.setEstado("activo");
				} else {
					c.setEstado("inactivo");
				}
				categoria.add(c);
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
		return categoria;
	}

	@Override
	public List<Categoria> Buscar(String busqueda) {
		List<Categoria> listacategorias = new ArrayList<>();
		System.out.println(busqueda);
		Connection con = obtenerConexion();
		try {
			String sql_searchbyword = "select id, titulo, descripcion from categorias where titulo like '%" + busqueda
					+ "%' or descripcion like '%" + busqueda + "%' order by id asc";
			PreparedStatement stmt = con.prepareStatement(sql_searchbyword);
			ResultSet rs = stmt.executeQuery();
			System.out.println(busqueda);
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt(1));
				c.setTitulo(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				listacategorias.add(c);
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
		return listacategorias;
	}

}
