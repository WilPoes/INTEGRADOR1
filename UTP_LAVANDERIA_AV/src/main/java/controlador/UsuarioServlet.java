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
import modelo.Distrito;
import modelo.Usuario;
import modelodao.DistritoDAO;
import modelodao.UsuarioDAO;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDAO = new UsuarioDAO();
    public UsuarioServlet() {
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
				this.crearUsuario(req, resp);
				break;
			case "escoger":
				this.escogerUsuario(req, resp);
				break;
			case "actualizar":
				this.actualizarUsuario(req, resp);
				break;
			case "eliminar":
				this.eliminarUsuario(req, resp);
				break;
			case "buscar":
				this.buscarUsuario(req, resp);
				break;
			case "listar":
				this.listarUsuario(req, resp);
				break;
			case "prepararusuario":
				this.prepararUsuario(req,resp);
				break;
			default:
				this.accionDefault(req, resp);
			}
		} else {
			this.accionDefault(req, resp);
		}
	}
	protected void crearUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		boolean estadoboolean = false;
		//
		String nomusuario = request.getParameter("nomusuario");
		String pass = request.getParameter("pass");
		//
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String cargo = request.getParameter("cargo");
		String estadostring = request.getParameter("estadostring");
		int iddistrito = Integer.parseInt(request.getParameter("iddistrito"));
		
		estadoboolean = (estadostring.equalsIgnoreCase("activo"))? true : false;
		Usuario usuario = new Usuario();
		usuario.setNombreusuario(nomusuario);
		usuario.setContraseñausuario(pass);
		//
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setDireccion(direccion);
		usuario.setCorreo(correo);
		usuario.setTelefono(telefono);
		usuario.setCargo(cargo);
		usuario.setEstadobool(estadoboolean);
		usuario.setIddistrito(iddistrito);
		//
		usuarioDAO.Crear(usuario);
		this.listarUsuario(request, response);
	}

	protected void escogerUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		int codUsuario = Integer.parseInt(request.getParameter("cod_usuario"));
		Usuario usuario = usuarioDAO.Obtener(codUsuario);
		DistritoDAO ddao = new DistritoDAO();
		List<Distrito> datosdistrito = ddao.ListarTodos();
		request.setAttribute("usuario", usuario);
		request.setAttribute("datosdistrito", datosdistrito);
		request.getRequestDispatcher("/paginas/usuario/editarUsuario.jsp").forward(request, response);
		this.accionDefault(request, response);
	}
	
	protected void prepararUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		DistritoDAO ddao = new DistritoDAO();
		List<Distrito> datosdistrito = ddao.ListarTodos();
		System.out.println("exito");
		request.setAttribute("datosdistrito", datosdistrito);
		request.getRequestDispatcher("/paginas/usuario/agregarUsuario.jsp").forward(request, response);
		this.accionDefault(request, response);
	}
	
	
	protected void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		int codusu = Integer.parseInt(request.getParameter("cod_usuario"));
		//
		String nomusuario = request.getParameter("nomusuario");
		String pass = request.getParameter("pass");
		//
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String cargo = request.getParameter("cargo");
		String estado = request.getParameter("estadostring");
		int iddistrito = Integer.parseInt(request.getParameter("iddistrito"));
		boolean estadoboolean = false;
		estadoboolean = (estado.equalsIgnoreCase("activo"))? true : false;
		Usuario usu = new Usuario();
		usu.setIdusuario(codusu);
		usu.setNombreusuario(nomusuario);
		usu.setContraseñausuario(pass);
		usu.setNombres(nombres);
		usu.setApellidos(apellidos);
		usu.setDireccion(direccion);
		usu.setCorreo(correo);
		usu.setTelefono(telefono);
		usu.setCargo(cargo);
		usu.setIddistrito(iddistrito);
		usu.setEstadobool(estadoboolean);
		//
		usuarioDAO.Actualizar(usu);
		listarUsuario(request, response);
	}

	protected void eliminarUsuario(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int idUsuario= Integer.parseInt(req.getParameter("cod_usuario"));
		usuarioDAO.Eliminar(idUsuario);
		//req.getRequestDispatcher("usuarios.jsp").forward(req, resp);
		listarUsuario(req, resp);
	}

	protected void listarUsuario(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Usuario> datos = usuarioDAO.ListarTodos();
		req.setAttribute("datos", datos);
		req.getRequestDispatcher("usuarios.jsp").forward(req, resp);
	}
	
	protected void buscarUsuario(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// CategoriaDAO dao = new CategoriaDAO();
		String busqueda = req.getParameter("buscar");
		List<Usuario> datos = usuarioDAO.Buscar(busqueda);
		req.setAttribute("datos", datos);

		req.getRequestDispatcher("usuarios.jsp").forward(req, resp);
	}
	
	protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Usuario> usuarios = usuarioDAO.ListarTodos();
		//System.out.println("clientes: " + clientes);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("usuarios", usuarios);
		sesion.setAttribute("totalUsuarios", usuarios.size());
		response.sendRedirect("usuarios.jsp");
	}
}
