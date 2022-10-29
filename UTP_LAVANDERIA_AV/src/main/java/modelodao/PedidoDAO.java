package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;
import modelo.Pedido;
import modelo.Servicio;

public class PedidoDAO extends Conexion implements IcrudDAO<Pedido>{

	
	//
	@Override
	public void Crear(Pedido t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int Actualizar(Pedido t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pedido Obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> ListarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> Buscar(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
