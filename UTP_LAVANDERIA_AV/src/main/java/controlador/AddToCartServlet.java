package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import modelo.Cart;
import modelo.Categoria;
import modelo.Prenda;
import modelo.PrendaDetalles;
import modelo.Servicio;
import modelodao.CategoriaDAO;
import modelodao.PrendaDAO;
import modelodao.PrendaDetallesDAO;
import modelodao.ServicioDAO;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				String accion = req.getParameter("accion");

				if (accion != null) {
					switch (accion) {
					case "agregarACarrito":
						this.agregarPrendaACarrito(req, resp);
						break;
					case "escoger":
						this.listarDetallesPrendaEnCarrito(req, resp);
						break;
					case "actualizar":
						// this.actualizarCategoria(req, resp);
						break;
					case "listarServicioAPrenda":
						this.listarServicioAPrenda(req, resp);
						break;
					case "eliminar":
						// this.eliminarCategoria(req, resp);
						break;
					case "buscar":
						// this.buscarCategoria(req, resp);
						break;
					default:
						this.accionDefault(req, resp);
					}
				} else {
					this.accionDefault(req, resp);
				}
	}

	protected void agregarPrendaACarrito(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
			PrendaDAO pdao = new PrendaDAO();
			String nomprenda = req.getParameter("nomprenda");
			String descprenda= req.getParameter("descprenda");
			double pesoprenda = Double.parseDouble(req.getParameter("pesoprenda"));
			int cantprenda = Integer.parseInt(req.getParameter("cantprenda"));
			Prenda prenda = new Prenda();
			prenda.setNomprenda(nomprenda);
			prenda.setDescprenda(descprenda);
			prenda.setPesoprenda(pesoprenda);
			prenda.setCantidadprenda(cantprenda);
			pdao.Crear(prenda);
			this.listarDetallesPrendaEnCarrito(req, resp);
			//
			PrendaDetallesDAO pddDAO = new PrendaDetallesDAO();
			List<PrendaDetalles> datos = pddDAO.ListarTodos(1);
			
			req.setAttribute("datos", datos);
			//
			req.getRequestDispatcher("/paginas/comunes/close.jsp").forward(req, resp);
			//resp.sendRedirect("pedidos.jsp");
			
			//PrendaDAO pdao = new PrendaDAO();
			int countprendas = pdao.ContarTodos();
			countprendas++;
			System.out.println(countprendas);
			req.setAttribute("id_prenda", countprendas);
			//req.getRequestDispatcher("pedidos.jsp").forward(req, resp);
			
			
			//window.close();
			/*
			ArrayList<Cart> cartList = new ArrayList<>();
			int id = Integer.parseInt(req.getParameter("id_prenda"));

			System.out.println("sos: id"+id);
			Cart cart = new Cart();
			
			cart.setIdprenda(id); // xq extiende
			cart.setQuantity(1);

			HttpSession session = req.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list"); // ssession
			
			PrintWriter out = resp.getWriter();
			*/
		
			/*
			if (cart_list == null) {
				cartList.add(cart); // producto agregado
				
				session.setAttribute("cart-list", cartList); // cart list agregado a la session
				//out.println("session creada y agregada a la lista");
				out.println("<html><body onLoad='window.close()'></body>");
				//resp.sendRedirect("./paginas/prenda/agregarPrenda.jsp");
			} 
			*/
			
			/*else {
				//out.println("ya existe la lista del carrito");
				cartList = cart_list;
				boolean existe = false;
				for(Cart c: cart_list) {
					if(c.getIdprenda() == id) {
						existe = true;
						
						out.println("<h3 style='color: crimson; text-align:center'>Prenda ya esta en el pedido<a href='javascript:window.close();'>Regresar</a></h3>");
					}
				}
				if(!existe) {
					cartList.add(cart);
					out.println("prenda agregada!");
					resp.sendRedirect("./paginas/prenda/agregarPrenda.jsp");
				}
			}*/
				/*
				for(Cart c:cart_list) {
					out.println(c.getIdprenda());
				}*/
			
	}
	protected void listarDetallesPrendaEnCarrito(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
			PrendaDetallesDAO detallesDAO = new PrendaDetallesDAO();
			detallesDAO.ListarTodos(1);
			/*
			ArrayList<Cart> cartList = new ArrayList<>();
			int id = Integer.parseInt(req.getParameter("id_prenda"));

			System.out.println("sos: id"+id);
			Cart cart = new Cart();
			
			cart.setIdprenda(id); // xq extiende
			cart.setQuantity(1);

			HttpSession session = req.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list"); // ssession
			
			PrintWriter out = resp.getWriter();
			*/
		
			/*
			if (cart_list == null) {
				cartList.add(cart); // producto agregado
				
				session.setAttribute("cart-list", cartList); // cart list agregado a la session
				//out.println("session creada y agregada a la lista");
				out.println("<html><body onLoad='window.close()'></body>");
				//resp.sendRedirect("./paginas/prenda/agregarPrenda.jsp");
			} 
			*/
			
			/*else {
				//out.println("ya existe la lista del carrito");
				cartList = cart_list;
				boolean existe = false;
				for(Cart c: cart_list) {
					if(c.getIdprenda() == id) {
						existe = true;
						
						out.println("<h3 style='color: crimson; text-align:center'>Prenda ya esta en el pedido<a href='javascript:window.close();'>Regresar</a></h3>");
					}
				}
				if(!existe) {
					cartList.add(cart);
					out.println("prenda agregada!");
					resp.sendRedirect("./paginas/prenda/agregarPrenda.jsp");
				}
			}*/
				/*
				for(Cart c:cart_list) {
					out.println(c.getIdprenda());
				}*/
			
	}
	protected void listarServicioAPrenda(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServicioDAO sdao = new ServicioDAO();
		List<Servicio> datosservicio = sdao.ListarTodos();
		req.setAttribute("datosservicio", datosservicio);
		System.out.println("servicios al dar al boton agregar prenda ");
		//req.getRequestDispatcher("/paginas/servicio/agregarServicio.jsp").forward(req, resp);
		//req.getRequestDispatcher("/paginas/prenda/agregarPrenda.jsp").forward(req, resp);
	}
	protected void accionDefault(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * List<Categoria> categorias = new CategoriaDAO().ListarTodos(); HttpSession
		 * sesion = req.getSession(); sesion.setAttribute("categoria", categorias);
		 * sesion.setAttribute("totalCategorias", categorias.size());
		 * listarCategoria(req, resp);
		 */
		System.out.println("SIN exito!");
	}

}
