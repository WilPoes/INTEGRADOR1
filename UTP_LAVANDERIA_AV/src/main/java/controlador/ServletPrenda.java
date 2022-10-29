package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import modelo.Prenda;
import modelo.Servicio;
import modelodao.PrendaDAO;
import modelodao.ServicioDAO;

@WebServlet("/ServletPrenda")
public class ServletPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletPrenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accion = req.getParameter("accion");

		if (accion != null) {
			switch (accion) {
			case "contartodos":
				this.contarprendas(req,resp);
				break;
			case "escoger":
				//this.escogerServicio(req, resp);
				break;
			case "actualizar":
				//this.actualizarServicio(req, resp);
				break;
			case "listarclienteserviciospedido":
				//this.listarclienteServiciosPedido(req, resp);
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
	protected void contarprendas(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrendaDAO pdao = new PrendaDAO();
		int countprendas = pdao.ContarTodos();
		countprendas++;
		System.out.println(countprendas);
		
		List<Prenda> datos = pdao.ListarTodos();
		req.setAttribute("datos", datos);
		
		req.setAttribute("id_prenda", countprendas);
		//
		
		ServicioDAO sdao = new ServicioDAO();
		List<Servicio> datosservicio = sdao.ListarTodos();
		req.setAttribute("datosservicio", datosservicio);
		System.out.println("servicios al dar al boton de pedidos ");
		//
		req.getRequestDispatcher("pedidos.jsp").forward(req, resp);

	}
	
}
