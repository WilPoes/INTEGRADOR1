package modelodao;

import java.util.List;

public interface IcrudDAO<T>{
	public void Crear(T t);
	public int Actualizar(T t);
	public T Obtener(int id);
	public void Eliminar(int id);
	public List<T> ListarTodos();
	public List<T> Buscar(String busqueda);
}
