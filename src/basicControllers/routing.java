package basicControllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicClassDAO.ContactoDAO;
import basicClassModel.ContactoModel;

/**
 * Servlet implementation class routing
 */
@WebServlet(name="routingController", urlPatterns={
		//General part
		"/index", "/recomend", "/business", "/search_job", "/about_us", 
		//Part user
		"/user-login", "/user-register", "/user-register-business", "/user-register-student", "/contacto"}) 
public class routing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContactoDAO ContactoDAO;
	
	public void init() {
		try {
			ContactoDAO = new ContactoDAO();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public routing() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(request.getServletPath())
		{
				// General Part
			case "/index":
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "/recomend":
				request.getRequestDispatcher("404.jsp").forward(request, response); 
				break;
			case "/business":
				request.getRequestDispatcher("404.jsp").forward(request, response); 
				break;
			case "/search_job":
				request.getRequestDispatcher("buscarEmpleo.jsp").forward(request, response); 
				break;
			case "/about_us":
				request.getRequestDispatcher("404.jsp").forward(request, response); 
				break;
				//Part User
			case "/user-login":
				request.getRequestDispatcher("login.jsp").forward(request, response);
				break;
			case "/user-register":
				request.getRequestDispatcher("type_registro.jsp").forward(request, response);
				break;
			case "/user-register-business":
				request.getRequestDispatcher("registro_empresas.jsp").forward(request, response);
				break;
			case "/user-register-student":
				request.setAttribute("msg", "Por favor llene todos los campos correctamente");
				request.setAttribute("resultado", "transparent");
				request.getRequestDispatcher("registro_alumnos.jsp").forward(request, response);
				break;
			case "/contacto":
			{
				String action = request.getParameter("action");
				request.getRequestDispatcher("contacto.jsp").forward(request, response);
				switch (action)
				{
					case "sendContact":
					{
						try {
							MensajeContacto(request, response);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						break;
				}
			}
				break;
			default: // 404
				request.getRequestDispatcher("404.jsp").forward(request, response); 
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void MensajeContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		ContactoModel Contacto = new ContactoModel(0, name, email, subject, message, "NOT");
		ContactoDAO.InsertContacto(Contacto);
		request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha registrado con éxito. </div>");
		request.getRequestDispatcher("contacto.jsp").forward(request, response);	
		
	}
}
