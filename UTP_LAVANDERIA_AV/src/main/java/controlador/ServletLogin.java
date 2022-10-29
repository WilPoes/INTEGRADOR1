package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import modelodao.UsuarioDAO;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario usuario;
	UsuarioDAO dusuario = new UsuarioDAO();

	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		usuario = new Usuario(uname, pass);
		
		PrintWriter out = resp.getWriter();
		System.out.println(usuario.getNombreusuario());
		// usuario.toString();
		boolean rpta = dusuario.Validar(usuario.getNombreusuario(), usuario.getContraseñausuario());
		
		if (rpta) {
			//out.println("Bienvenido " + usuario.getNombreusuario());
			System.out.println("encontrado");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			System.out.println("error");
			//out.println("error");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}	
	}

}
