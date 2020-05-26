package basicControllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import basicClassDAO.BusinessDAO;
import basicClassModel.BusinessModel;

import basicClassDAO.AlumnosDAO;
import basicClassModel.AlumnosModel;

/**
 * Servlet implementation class manageRegister
 */
@WebServlet("/manageRegister")
public class manageRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AlumnosDAO AlumnosDAO;
	BusinessDAO BusinessDAO;
	
	public void init() {
		try {
			AlumnosDAO = new AlumnosDAO();
			BusinessDAO = new BusinessDAO();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "registerStudent":
				registrarAlumno(request, response);
				break;
			case "registerBusiness":
				registrarEmpresa(request, response);
				break;
			default:
				request.getRequestDispatcher("404.jsp").forward(request, response);
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//Alumnos
	private void registrarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {		
		try {
			request.getParameter("clave"); 
			request.getParameter("password");
			request.getParameter("nombre");
			request.getParameter("apellido_p"); 
			request.getParameter("apellido_m"); 
			request.getParameter("telefono");
			request.getParameter("email");
			request.getParameter("calle"); 
			request.getParameter("ciudad"); 
			request.getParameter("delomun");
		} catch(Exception ex){
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro del alumno con los datos de texto.</div>");
			request.getRequestDispatcher("registro_alumnos.jsp").forward(request, response);
			return;
		}
		try {
			Integer.parseInt(request.getParameter("cp")); 
			Integer.parseInt(request.getParameter("numero_interior"));
			Integer.parseInt(request.getParameter("numero_exterior"));
		} catch (NumberFormatException ex) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro del alumno con los datos numericos.</div>");			
			request.getRequestDispatcher("registro_alumnos.jsp").forward(request, response);
			return;
		}
		
		AlumnosModel Alumnos = new AlumnosModel(0,
				request.getParameter("clave"), 
				request.getParameter("password"), 
				request.getParameter("nombre"), 
				request.getParameter("apellido_p"), 
				request.getParameter("apellido_m"), 
				request.getParameter("telefono"), 
				request.getParameter("email"),
				request.getParameter("calle"), 
				request.getParameter("ciudad"), 
				request.getParameter("delomun"),
				Integer.parseInt(request.getParameter("cp")), 
				Integer.parseInt(request.getParameter("numero_interior")),
				Integer.parseInt(request.getParameter("numero_exterior")));
		if (AlumnosDAO.InsertAlumno(Alumnos) == 1)
		{
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha registrado con éxito. </div>");
		}
		else if(AlumnosDAO.InsertAlumno(Alumnos) == 2) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, parece que usted no tiene una cuenta, debe pedirla con el administrador o los datos son incorrectos.</div>");
		}else if(AlumnosDAO.InsertAlumno(Alumnos) == 3) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, parece que usted ya tiene un registro asociado a esta cuenta.</div>");
		}else {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de su cuenta.</div>");
		}
		request.getRequestDispatcher("registro_alumnos.jsp").forward(request, response);
	}
	
	//Empresas
	private void registrarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {		
		try {
			request.getParameter("clave"); 
			request.getParameter("password");
			request.getParameter("nombre");
			request.getParameter("RFC");  
			request.getParameter("telefono");
			request.getParameter("FAX");
			request.getParameter("giro");
			request.getParameter("descripcion"); 
			request.getParameter("email"); 
			request.getParameter("paginaweb");
			request.getParameter("Calle");
			request.getParameter("DeloMun");
		} catch(Exception ex){
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de la empresa con los datos de texto.</div>");
			request.getRequestDispatcher("registro_empresas.jsp").forward(request, response);
			return;
		}
		try {
			Integer.parseInt(request.getParameter("CP")); 
			Integer.parseInt(request.getParameter("numero_int"));
			Integer.parseInt(request.getParameter("numero_ext"));
		} catch (NumberFormatException ex) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de la empresa con los datos numericos.</div>");			
			request.getRequestDispatcher("registro_empresas.jsp").forward(request, response);
			return;
		}
		
		BusinessModel Business = new BusinessModel(
				request.getParameter("clave"),
				request.getParameter("password"),
				request.getParameter("nombre"),
				request.getParameter("RFC"),
				request.getParameter("telefono"),
				request.getParameter("FAX"),
				request.getParameter("giro"),
				request.getParameter("descripcion"), 
				request.getParameter("email"),
				request.getParameter("paginaweb"),
				request.getParameter("Calle"),
				request.getParameter("DeloMun"),
				Integer.parseInt(request.getParameter("numero_int")),
				Integer.parseInt(request.getParameter("numero_ext")),
				Integer.parseInt(request.getParameter("CP")),
				request.getParameter("Ciudad")
				);
		if (BusinessDAO.InsertBusiness(Business) == 1)
		{
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha registrado con éxito. </div>");
		}
		else if (BusinessDAO.InsertBusiness(Business) == 2) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer no tiene una cuenta asociada, debe pedirla con el administrador o los datos son incorrectos.</div>");
		}
		else if (BusinessDAO.InsertBusiness(Business) == 4) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer el nombre de la empresa ya se encuentra registrado, si considera que hay un error informe con el administrador.</div>");
		}
		else if (BusinessDAO.InsertBusiness(Business) == 3) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ya tiene un registro asociado con esta cuenta.</div>");
		}
		else {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante el registro de su empresa.</div>");
		}
		request.getRequestDispatcher("registro_empresas.jsp").forward(request, response);
	}

}
