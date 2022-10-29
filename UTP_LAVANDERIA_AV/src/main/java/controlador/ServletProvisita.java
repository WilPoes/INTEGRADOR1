package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.Provisita;
import modelodao.UsuarioDAO;
import modelodao.ProvisitasDAO;

@WebServlet("/ServletProvisita")
public class ServletProvisita extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProvisitasDAO pvdao = new ProvisitasDAO();
	UsuarioDAO udao = new UsuarioDAO();

	public ServletProvisita() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accion = req.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "insertar":
				this.crearProvisita(req, resp);
				break;
			case "escoger":
				this.escogerProvisita(req, resp);
				break;
			case "actualizar":
				this.actualizarProvisita(req, resp);
				break;
			case "listarprovisitatodos":
				this.listarProvisitaUsuario(req, resp);
				break;
			case "listarusuarios":
				this.listarUsuario(req, resp);
				break;
			case "listartodos2":
				//this.eliminarServicio(req, resp);
				break;
			case "buscar":
				this.buscarProvisita(req, resp);
				break;
			default:
				this.accionDefault(req, resp);
			}
		} else {
			this.accionDefault(req, resp);
		}
	}

	protected void crearProvisita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean estadoboolean = false;
		int idusuario_conductor = Integer.parseInt(request.getParameter("idusuario_conductor"));
		String detalles = request.getParameter("detalles");
		String fechapedido = request.getParameter("fechapedido");
		String fechaentrega = request.getParameter("fechaentrega");
		String placavehiculo = request.getParameter("placavehiculo");
		String estadostring = request.getParameter("estadostring");
		estadoboolean = (estadostring.equalsIgnoreCase("activo"))? true : false;
		
		Provisita pvis = new Provisita();

		pvis.setIdusuario_conductor(idusuario_conductor);
		pvis.setDetalles(detalles);
		pvis.setFechapedido(fechapedido);
		pvis.setFechaentrega(fechaentrega);
		pvis.setPlacavehiculo(placavehiculo);
		pvis.setEstadobool(estadoboolean);
		pvdao.Crear(pvis);

		listarProvisitaUsuario(request, response);
	}

	protected void listarProvisitaUsuario(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Provisita> datos = pvdao.ListarTodosProVisitasConductor();
		req.setAttribute("datos", datos);

		for (Provisita provisita : datos) {
			System.out.println(provisita.getIdprovisitas());
		}
		
		req.getRequestDispatcher("provisitas.jsp").forward(req, resp);
	}

	protected void listarUsuario(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Usuario> datos = udao.ListarTodosPorConductor();
		req.setAttribute("datos", datos);
		req.getRequestDispatcher("/paginas/provisitas/agregarProvisita.jsp").forward(req, resp);
	}

	protected void listarUsuarioenModificacion(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Usuario> datos = udao.ListarTodos();
		req.setAttribute("datos", datos);
	}

	protected void escogerProvisita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idProvisita = Integer.parseInt(request.getParameter("idProvisita"));
		Provisita provisita = pvdao.Obtener(idProvisita);
		request.setAttribute("provisita", provisita);
		listarUsuarioenModificacion(request, response);
		request.getRequestDispatcher("/paginas/provisitas/editarProvisita.jsp").forward(request, response);
	}

	protected void actualizarProvisita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idprovisitas = Integer.parseInt(request.getParameter("idprovisitas"));
		int idusuario_conductor = Integer.parseInt(request.getParameter("idusuario_conductor"));
		String detalles = request.getParameter("detalles");
		String fechapedido = request.getParameter("fechapedido");
		String fechaentrega = request.getParameter("fechaentrega");
		String placavehiculo = request.getParameter("placavehiculo");
		String estado = request.getParameter("estadostring");
		boolean estadoboolean = false;
		estadoboolean = (estado.equalsIgnoreCase("activo")) ? true : false;

		Provisita pvis = new Provisita();
		pvis.setIdprovisitas(idprovisitas);
		pvis.setIdusuario_conductor(idusuario_conductor);
		pvis.setDetalles(detalles);
		pvis.setFechapedido(fechapedido);
		pvis.setFechaentrega(fechaentrega);
		pvis.setPlacavehiculo(placavehiculo);
		pvis.setEstadobool(estadoboolean);

		pvdao.Actualizar(pvis);
		//
		this.accionDefault(request, response);
	}

	protected void buscarProvisita(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String busqueda = req.getParameter("buscar");
		List<Provisita> datos = pvdao.Buscar(busqueda);
		req.setAttribute("datos", datos);

		req.getRequestDispatcher("provisitas.jsp").forward(req, resp);
	}

	protected void eliminarProvista(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idprovisitas = Integer.parseInt(req.getParameter("idprovisitas"));
		pvdao.Eliminar(idprovisitas);
		listarProvisitaUsuario(req, resp);
	}

	//
	protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Provisita> provisitas = new ProvisitasDAO().ListarTodos();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("provisitas", provisitas);
		sesion.setAttribute("totalProvisitas", provisitas.size());
		listarProvisitaUsuario(request, response);
	}
}
