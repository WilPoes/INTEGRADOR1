package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Servicio;
import modelodao.ServicioDAO;

@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioDAO sdao = new ServicioDAO();
	//
    public ServletPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accion = req.getParameter("accion");

		if (accion != null) {
			switch (accion) {
			case "insertar":
				//this.crearServicio(req, resp);
				break;
			case "escoger":
				//this.escogerServicio(req, resp);
				break;
			case "actualizar":
				//this.actualizarServicio(req, resp);
				break;
			case "listarclienteserviciospedido":
				this.listarclienteServiciosPedido(req, resp);
				break;
			case "listarcategorias":
				//this.listarCategoria(req, resp);
				break;
			case "eliminar":
				//this.eliminarCategoria(req, resp);
				break;
			case "agregarprenda":
				//this.eliminarCategoria(req, resp);
				break;
			default:
				//this.accionDefault(req, resp);
			}
		} else {
			//this.accionDefault(req, resp);
		}
	}
	
	protected void listarclienteServiciosPedido(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Servicio> datosServicio = sdao.ListarTodos();
	
		req.setAttribute("datosservicio", datosServicio);
		
		req.getRequestDispatcher("pedidos.jsp").forward(req, resp);
	}
}
