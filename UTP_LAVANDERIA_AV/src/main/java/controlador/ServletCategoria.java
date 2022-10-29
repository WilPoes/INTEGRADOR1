package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Categoria;
import modelodao.CategoriaDAO;

@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoriaDAO cdao = new CategoriaDAO();

	public ServletCategoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accion = req.getParameter("accion");

		if (accion != null) {
			switch (accion) {
			case "insertar":
				this.crearCategoria(req, resp);
				break;
			case "escoger":
				this.escogerCategoria(req, resp);
				break;
			case "actualizar":
				this.actualizarCategoria(req, resp);
				break;
			case "listar":
				this.listarCategoria(req, resp);
				break;
			case "eliminar":
				this.eliminarCategoria(req, resp);
				break;
			case "buscar":
				this.buscarCategoria(req, resp);
				break;
			default:
				this.accionDefault(req, resp);
			}
		} else {
			this.accionDefault(req, resp);
		}
	}

	protected void crearCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean estadoboolean = false;
		String titulo = req.getParameter("titulo");
		String descripcion = req.getParameter("descripcion");
		String estadostring = req.getParameter("estadostring");
		estadoboolean = (estadostring.equalsIgnoreCase("activo"))? true : false;
		
		Categoria cat = new Categoria();
		cat.setTitulo(titulo);
		cat.setDescripcion(descripcion);
		cat.setEstadobool(estadoboolean);
		cdao.Crear(cat);
		this.listarCategoria(req, resp);
	}

	protected void listarCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Categoria> datos = cdao.ListarTodos();
		req.setAttribute("datos", datos);
		req.getRequestDispatcher("categorias.jsp").forward(req, resp);
	}

	protected void escogerCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idCategoria = Integer.parseInt(req.getParameter("idCategoria"));
		Categoria categoria = cdao.Obtener(idCategoria);
		req.setAttribute("categoria", categoria);
		req.getRequestDispatcher("/paginas/categoria/editarCategoria.jsp").forward(req, resp);
	}

	protected void actualizarCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoriaDAO dao = new CategoriaDAO();

		String idString = req.getParameter("id");
		int id = Integer.parseInt(idString);
		String titulo = req.getParameter("titulo");
		String descripcion = req.getParameter("descripcion");

		String estado = req.getParameter("estadostring");
		boolean estadoboolean = false;
		estadoboolean = (estado.equalsIgnoreCase("activo")) ? true : false;

		Categoria cat = new Categoria();
		cat.setId(id);
		cat.setTitulo(titulo);
		cat.setDescripcion(descripcion);
		cat.setEstadobool(estadoboolean);

		dao.Actualizar(cat);

		this.accionDefault(req, resp);
	}

	protected void eliminarCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idCategoria = Integer.parseInt(req.getParameter("idCategoria"));
		cdao.Eliminar(idCategoria);
		this.accionDefault(req, resp);
	}

	protected void buscarCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String busqueda = req.getParameter("buscar");
		List<Categoria> datos = cdao.Buscar(busqueda);
		req.setAttribute("datos", datos);
		req.getRequestDispatcher("categorias.jsp").forward(req, resp);
	}

	protected void accionDefault(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Categoria> categorias = new CategoriaDAO().ListarTodos();
		HttpSession sesion = req.getSession();
		sesion.setAttribute("categoria", categorias);
		sesion.setAttribute("totalCategorias", categorias.size());
		listarCategoria(req, resp);
	}
}
