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
import modelo.Servicio;
import modelodao.CategoriaDAO;
import modelodao.ServicioDAO;

@WebServlet("/ServletServicio")
public class ServletServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioDAO sdao = new ServicioDAO();
	CategoriaDAO cdao = new CategoriaDAO();

	public ServletServicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accion = req.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "insertar":
				this.crearServicio(req, resp);
				break;
			case "escoger":
				this.escogerServicio(req, resp);
				break;
			case "actualizar":
				this.actualizarServicio(req, resp);
				break;
			case "listarserviciocategoria":
				this.listarServicioCategoria(req, resp);
				break;
			case "listarcategorias":
				this.listarCategoria(req, resp);
				break;
			case "eliminar":
				this.eliminarServicio(req, resp);
				break;
			case "buscar":
				this.buscarServicio(req, resp);
				break;
			default:
				this.accionDefault(req, resp);
			}
		} else {
			this.accionDefault(req, resp);
		}
	}

	protected void crearServicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean estadoboolean = false;
		int Idcat = Integer.parseInt(request.getParameter("idcat"));
		String Nomserv = request.getParameter("nomservicio");
		Double Precioserv = Double.parseDouble(request.getParameter("precioservicio"));
		Double Pesoreqserv = Double.parseDouble(request.getParameter("pesoreq"));
		int Cantreqserv = Integer.parseInt(request.getParameter("cantreq"));
		int Diasestserv = Integer.parseInt(request.getParameter("diasest"));
		String estadostring = request.getParameter("estadostring");
		estadoboolean = (estadostring.equalsIgnoreCase("activo"))? true : false;
		
		Servicio serv = new Servicio();

		serv.setIdcat(Idcat);
		serv.setNomservicio(Nomserv);
		serv.setPrecioservicio(Precioserv);
		serv.setPesorequeridoservicio(Pesoreqserv);
		serv.setCantrequeridaservicio(Cantreqserv);
		serv.setDiasestimados(Diasestserv);
		serv.setEstadobool(estadoboolean);
		sdao.Crear(serv);

		listarServicioCategoria(request, response);
	}

	protected void listarServicioCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Servicio> datos = sdao.ListarTodosServicioCategoria();
		req.setAttribute("datos", datos);
		req.getRequestDispatcher("servicios.jsp").forward(req, resp);
	}

	protected void listarCategoria(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Categoria> datos = cdao.ListarTodos();
		req.setAttribute("datos", datos);
		req.getRequestDispatcher("/paginas/servicio/agregarServicio.jsp").forward(req, resp);
	}

	protected void listarCategoriaenModificacion(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Categoria> datos = cdao.ListarTodos();
		req.setAttribute("datos", datos);
	}

	protected void escogerServicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idServicio = Integer.parseInt(request.getParameter("idServicio"));
		Servicio servicio = sdao.Obtener(idServicio);
		request.setAttribute("servicio", servicio);
		listarCategoriaenModificacion(request, response);
		request.getRequestDispatcher("/paginas/servicio/editarServicio.jsp").forward(request, response);
	}

	protected void actualizarServicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idServ = Integer.parseInt(request.getParameter("idServicio"));
		int idCat = Integer.parseInt(request.getParameter("idCategoria"));
		String nomservicio = request.getParameter("nomservicio");
		double precioservicio = Double.parseDouble(request.getParameter("precioservicio"));
		double pesorequeridoservicio = Double.parseDouble(request.getParameter("pesoreq"));
		int cantrequeridaservicio = Integer.parseInt(request.getParameter("cantrequerida"));
		int diasestimados = Integer.parseInt(request.getParameter("diasestimados"));
		String estado = request.getParameter("estadostring");
		boolean estadoboolean = false;
		estadoboolean = (estado.equalsIgnoreCase("activo")) ? true : false;

		Servicio serv = new Servicio();
		serv.setId(idServ);
		serv.setIdcat(idCat);
		serv.setNomservicio(nomservicio);
		serv.setPrecioservicio(precioservicio);
		serv.setPesorequeridoservicio(pesorequeridoservicio);
		serv.setCantrequeridaservicio(cantrequeridaservicio);
		serv.setDiasestimados(diasestimados);
		serv.setEstadobool(estadoboolean);

		sdao.Actualizar(serv);
		//
		this.accionDefault(request, response);
	}

	protected void buscarServicio(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String busqueda = req.getParameter("buscar");
		List<Servicio> datos = sdao.Buscar(busqueda);
		req.setAttribute("datos", datos);

		req.getRequestDispatcher("servicios.jsp").forward(req, resp);
	}

	protected void eliminarServicio(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idServicio = Integer.parseInt(req.getParameter("idServicio"));
		sdao.Eliminar(idServicio);
		listarServicioCategoria(req, resp);
	}

	//
	protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Servicio> servicios = new ServicioDAO().ListarTodos();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("servicios", servicios);
		sesion.setAttribute("totalServicios", servicios.size());
		listarServicioCategoria(request, response);
	}
}
