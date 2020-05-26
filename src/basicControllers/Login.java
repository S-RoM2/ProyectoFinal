package basicControllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import basicClassDAO.AlumnosDAO;
import basicClassDAO.BusinessDAO;
import basicClassDAO.LoginDAO;  
import basicClassDAO.VacantesDAO;
import basicClassDAO.AccountDAO;
import basicClassDAO.CVDAO;
import basicClassDAO.ContactoDAO;

import basicClassModel.AccountModel;
import basicClassModel.BusinessModel;
import basicClassModel.CVModel;
import basicClassModel.AlumnosModel;
import basicClassModel.VacanteModel;
import basicClassModel.ContactoModel;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO LoginDAO;
	AlumnosDAO AlumnosDAO;
	BusinessDAO BusinessDAO;
	VacantesDAO VacantesDAO;
	AccountDAO AccountDAO;
	CVDAO CVDAO;
	ContactoDAO ContactoDAO;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
		try {
			LoginDAO = new LoginDAO();
			AlumnosDAO = new AlumnosDAO();
			BusinessDAO = new BusinessDAO();
			VacantesDAO = new VacantesDAO();
			AccountDAO = new AccountDAO();
			CVDAO = new CVDAO();
			ContactoDAO = new ContactoDAO();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}    	
	public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		String action = request.getParameter("action");
		HttpSession session=request.getSession();
		BusinessModel dataAccountBusiness;
		AlumnosModel dataAccountStudent;		
		try 
		{
			switch (action) 
			{
				case "accountPassword":
				{
						session.setAttribute("page", "change-password");
						request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "ChangePassword":
				{
						session.setAttribute("page", "change-password");
						CambiarContraseña(request, response);
				}
					break;
				case "Accountaddress":
				{
					int iType = (Integer)session.getAttribute("type");
					int id = (Integer)session.getAttribute("id");
					if (iType == 2)
					{
						dataAccountBusiness = BusinessDAO.GetBusinessByID(id);	
						session.setAttribute("dataAccount", dataAccountBusiness);
					}
					else
					{
						dataAccountStudent = AlumnosDAO.GetStudentByID(id);	
						session.setAttribute("dataAccount", dataAccountStudent);
					}
					session.setAttribute("page", "change-address");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "ChangeAddress":
				{
					session.setAttribute("page", "change-address");
					CambiarAddress(request, response);
				}
					break;
				case "Accountdescription":
				{
					session.setAttribute("page", "change-description");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "Changedescription":
				{
					session.setAttribute("page", "change-description");
					Cambiardescription(request, response);
				}
					break;
				case "Accountemail":
				{
					session.setAttribute("page", "change-email");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "Changeemail":
				{
					session.setAttribute("page", "change-email");
					Cambiaremail(request, response);
				}
					break;
				case "Accountname":
				{
					session.setAttribute("page", "change-name");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "Changename":
				{
					session.setAttribute("page", "change-name");
					Cambiarname(request, response);
				}
					break;
				case "Accountphone":
				{
					session.setAttribute("page", "change-phone");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "Changephone":
				{
					session.setAttribute("page", "change-phone");
					Cambiarphone(request, response);
				}
					break;
				case "AddVacant":
				{
					request.setAttribute("msg", "<p>La vacante será revisada por el administrador antes de ser aprobada para que pueda ser vista por los alumnos</p>");
					session.setAttribute("page", "add-vacant");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "ViewVacant":
				{
					session.setAttribute("page", "view-vacant");
					MostrarVacantes(request, response);	
				}
					break;
				case "AddVacant-add":
				{
					VacantesAdd(request, response);	
				}
					break;
				case "authentication":
				{
					VerifyLogin(request, response);
				}
					break;
				case "ViewExplicitVacant":
				{
					session.setAttribute("page", "view-explicit-vacant");
					ExplicitasVacantes(request, response);
				}
					break;
				case "ViewAllExplicitVacant":
				{
					session.setAttribute("page", "view-all-explicit-vacant");
					ExplicitasAllVacantes(request, response);
				}
					break;
				case "DeleteVacant":
				{
					session.setAttribute("page", "view-vacant");
					UpdateActiveVacant(request, response);
				}
					break;
				case "ApplyForVacant":
				{
					session.setAttribute("page", "view-vacant");
					ApplyForVacant(request, response);
				}
					break;
				case "AddCV":
				{
					session.setAttribute("page", "add-cv");
					RevisarCV(request, response);

				}
					break;
				case "AdminVacant":
				{
					session.setAttribute("page", "adminVacant");
					AdminMostrarVacantes(request, response);
				}
					break;
				case "ChangeToStudent":
				{
					LoginDAO.UpdateAccountType(1, (Integer)session.getAttribute("id"));
			        session.invalidate();  
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "ChangeToBusiness":
				{
					LoginDAO.UpdateAccountType(2, (Integer)session.getAttribute("id"));
			        session.invalidate();  
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "AdminAccount":
				{
					session.setAttribute("page", "adminAccount");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "AdminContact":
				{
					session.setAttribute("page", "adminContact");
					AdminMostrarContact(request, response);
				}
					break;
				case "ApplyForContact":
				{
					session.setAttribute("page", "adminContact");
					UpdateContact(request, response);
				}
					break;
				case "RegistAccount":
				{
					session.setAttribute("page", "adminAccount");
					registrarCuenta(request, response);
				}
					break;
				case "SuspendAccount":
				{
					AccountDAO.UpdateSuspendAccount((Integer)session.getAttribute("id"));
					session.invalidate();
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				default:
					{
						session.setAttribute("page", "explicit-vacant");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					break;
			}
		} catch(SQLException e) {
			e.getStackTrace();
		}
	}
	
	private void RevisarCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session=request.getSession();
		String action = request.getParameter("manage");
		if(action == null)
			action = "default";
		int alumno_cv = CVDAO.Verify(AlumnosDAO.GetIDStudentByID((Integer)session.getAttribute("id")));
		int idCV = CVDAO.getIDCV(AlumnosDAO.GetIDStudentByID((Integer)session.getAttribute("id")));
		switch(action) {
			case "regist":
			{
				CVDAO.InsertCV(AlumnosDAO.GetIDStudentByID((Integer)session.getAttribute("id")));
				session.setAttribute("page", "default");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			break;
			case "addEstudios":
			{
				int nivel_estudios = Integer.parseInt(request.getParameter("nivel_estudios"));
				CVDAO.UpdateNivelEstudios(AlumnosDAO.GetIDStudentByID((Integer)session.getAttribute("id")), nivel_estudios);
				request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">Se ha agregado al CV correctamente.</div>");
			}
			break;
			case "addExpLab":
			{
				String trabajo = request.getParameter("trabajo");
				String periodo = request.getParameter("periodo");
				String puesto = request.getParameter("puesto");
				CVDAO.UpdateTrabajos(idCV, trabajo, periodo, puesto);
				request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">Se ha agregado al CV correctamente.</div>");
			}
			break;
			case "addLanguage":
			{
				String idioma = request.getParameter("idioma");
				CVDAO.UpdateIdioma(idCV, idioma);
				request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">Se ha agregado al CV correctamente.</div>");
			}
			break;
			case "addInformacion":
			{
				String informacion = request.getParameter("informacion");
				CVDAO.UpdateInformacion(idCV, informacion);
				request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">Se ha agregado al CV correctamente.</div>");
			}
			break;
		}
		session.setAttribute("idCV", idCV);
		session.setAttribute("alumno_cv", alumno_cv);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void CambiarContraseña(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	
		HttpSession session=request.getSession();
		int id = (Integer)session.getAttribute("id");
		String password = request.getParameter("password");
		if (AccountDAO.UpdatePassword(id, password) > 0)
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha actualizado con éxito. </div>");
		else
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void CambiarAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	
		HttpSession session=request.getSession();
		int id = (Integer)session.getAttribute("id");
		int iType = (Integer)session.getAttribute("type");
		String calle,ciudad,DeloMun;
		int CP,numero_ext,numero_int;
		BusinessModel dataAccountBusiness;
		AlumnosModel dataAccountStudent;
		
		try {
			calle = request.getParameter("Calle");
			ciudad = request.getParameter("Ciudad");
			DeloMun = request.getParameter("DeloMun");
		} catch(Exception ex) {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");
			return;
		}
		try {
			CP = Integer.parseInt(request.getParameter("CP"));
			numero_ext = Integer.parseInt(request.getParameter("numero_ext"));
			numero_int = Integer.parseInt(request.getParameter("numero_int"));
		}catch (NumberFormatException ex){
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");			
			return;
		}
		calle = request.getParameter("Calle");
		ciudad = request.getParameter("Ciudad");
		DeloMun = request.getParameter("DeloMun");
		CP = Integer.parseInt(request.getParameter("CP"));
		numero_ext = Integer.parseInt(request.getParameter("numero_ext"));
		numero_int = Integer.parseInt(request.getParameter("numero_int"));
		
		if (AccountDAO.UpdateDireccion(id, calle, ciudad, DeloMun, CP, numero_int, numero_ext, iType) > 0)
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha actualizado con éxito. </div>");
		else
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");

		if (iType == 2)
		{
			dataAccountBusiness = BusinessDAO.GetBusinessByID(id);	
			session.setAttribute("dataAccount", dataAccountBusiness);
		}
		else
		{
			dataAccountStudent = AlumnosDAO.GetStudentByID(id);	
			session.setAttribute("dataAccount", dataAccountStudent);
		}		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void Cambiardescription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	
		HttpSession session=request.getSession();
		int id = (Integer)session.getAttribute("id");
		int iType = (Integer)session.getAttribute("type");
		String descripcion = request.getParameter("descripcion");
		if (AccountDAO.Updatedescripcion(id, descripcion, iType) > 0)
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha actualizado con éxito. </div>");
		else
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void Cambiarname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	
		HttpSession session=request.getSession();
		int id = (Integer)session.getAttribute("id");
		int iType = (Integer)session.getAttribute("type");
		String name = request.getParameter("nombre");
		if (AccountDAO.UpdateNombre(id, name, iType) > 0)
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha actualizado con éxito. </div>");
		else
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void Cambiarphone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	
		HttpSession session=request.getSession();
		int id = (Integer)session.getAttribute("id");
		int iType = (Integer)session.getAttribute("type");
		String phone = request.getParameter("telefono");
		if (AccountDAO.UpdateTelefono(id, phone, iType) > 0)
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha actualizado con éxito. </div>");
		else
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void Cambiaremail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	
		HttpSession session=request.getSession();
		int id = (Integer)session.getAttribute("id");
		int iType = (Integer)session.getAttribute("type");
		String email = request.getParameter("email");
		if (AccountDAO.UpdateEmail(id, email, iType) > 0)
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha actualizado con éxito. </div>");
		else
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante la actualización.</div>");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void registrarCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {		
		try {
			request.getParameter("clave"); 
			request.getParameter("password");
		} catch(Exception ex){
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro del alumno con los datos de texto.</div>");
			request.getRequestDispatcher("registro_alumnos.jsp").forward(request, response);
			return;
		}
		int iTipo = Integer.parseInt(request.getParameter("tipo"));
		
		AccountModel Account = new AccountModel(
				request.getParameter("clave"), 
				request.getParameter("password"));
		if (iTipo == 0)
		{
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de su cuenta.</div>");			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if (AccountDAO.InsertAccount(Account, iTipo) == 1)
		{
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha registrado con éxito. </div>");
		}
		else {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de su cuenta.</div>");
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	private void AdminMostrarVacantes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException {
		int page = 0, start = 0, method = 0, vacant;
		HttpSession session=request.getSession();
		int countPage = 0;
		List<VacanteModel> listaVacantes;
		if (request.getParameter("page") == null)
			page = 1;
		else
		{
			page = Integer.parseInt(request.getParameter("page"));
			start = (page - 1) * 5;
		}
		if (request.getParameter("method") == null)
			method = 1;
		else
			method = Integer.parseInt(request.getParameter("method"));

		if (request.getParameter("vacant") == null)
			vacant = 0;
		else
			vacant = Integer.parseInt(request.getParameter("vacant"));
		if(method == 1)
			VacantesDAO.UpdateVacanteValidate(vacant);
		else if(method == 2)
			VacantesDAO.UpdateVacanteActive(vacant);			
		
		countPage = (VacantesDAO.PaginationAdminVacant()/ 5);
		listaVacantes = VacantesDAO.listarVacantesAdmin(start);
		
		if (listaVacantes.isEmpty())
			session.setAttribute("listaVacia", 0);
		else
			session.setAttribute("listaVacia", 1);	
		
		session.setAttribute("listarVacantes", listaVacantes);
		session.setAttribute("paginateVacantes", countPage);
		session.setAttribute("actual_page", page);
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}

	private void ApplyForVacant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException {
		int page = 0, start = 0, vacante_id = 0;
		HttpSession session=request.getSession();
		int alumno_id = AlumnosDAO.GetAccountIDByAccountID((Integer)session.getAttribute("id"));
		try {
			vacante_id = Integer.parseInt(request.getParameter("vacant"));
		} catch (NumberFormatException ex) {
			vacante_id = 0;
		}
		int countPage = 0;
		List<VacanteModel> listaVacantes;
		if (request.getParameter("page") == null)
			page = 1;
		else
		{
			page = Integer.parseInt(request.getParameter("page"));
			start = (page - 1) * 5;
		}
		
		int iSolicitud = VacantesDAO.InsertSolicitudVacante(alumno_id, vacante_id);
		if (iSolicitud == 1)
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">Se ha enviado la solicitud.</div>");
		else
			session.setAttribute("msg", "<div class=\"alert alert-danger\" role=\"alert\">¡Fallo!, al parecer ha ocurrido un error durante el registro de la solicitud.</div>");
		countPage = (VacantesDAO.Pagination(0) / 5);
		listaVacantes = VacantesDAO.listarVacantes(start, alumno_id, 0);
		if (listaVacantes.isEmpty())
			session.setAttribute("listaVacia", 0);
		else
			session.setAttribute("listaVacia", 1);	
		session.setAttribute("listarVacantes", listaVacantes);
		session.setAttribute("paginateVacantes", countPage);
		session.setAttribute("actual_page", page);
		request.getRequestDispatcher("login.jsp").forward(request, response);		
	}
	
	private void UpdateActiveVacant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException {
		int page = 0, start = 0, vacante_id = 0;
		HttpSession session=request.getSession();
		int id_session;
		int iType = (Integer)session.getAttribute("type");
		try {
			vacante_id = Integer.parseInt(request.getParameter("vacant"));
		} catch (NumberFormatException ex) {
			vacante_id = 0;
		}
		int countPage = 0;
		List<VacanteModel> listaVacantes;
		if (request.getParameter("page") == null)
			page = 1;
		else
		{
			page = Integer.parseInt(request.getParameter("page"));
			start = (page - 1) * 5;
		}
		
		if(iType == 2 ) {
			id_session = BusinessDAO.GetBusinessIDByAccountID((Integer)session.getAttribute("id"));
			VacantesDAO.UpdateVacanteActive(vacante_id);
			countPage = (VacantesDAO.Pagination(id_session) / 5);
			listaVacantes = VacantesDAO.listarVacantes(start, id_session, 2);
		}
		else
		{
			id_session = AlumnosDAO.GetAccountIDByAccountID((Integer)session.getAttribute("id"));
			countPage = (VacantesDAO.Pagination(0) / 5);
			listaVacantes = VacantesDAO.listarVacantes(start, id_session, 0);
		}
		if (listaVacantes.isEmpty())
			session.setAttribute("listaVacia", 0);
		else
			session.setAttribute("listaVacia", 1);	
		session.setAttribute("listarVacantes", listaVacantes);
		session.setAttribute("paginateVacantes", countPage);
		session.setAttribute("actual_page", page);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	private void ExplicitasVacantes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException {
		String read;
		int vacante_id,alumno_id;
		int page = 0, start = 0, countPage = 0;
		HttpSession session=request.getSession();
		List<AlumnosModel> listaAlumnos;
	
		List<CVModel> listaTrabajos;
		List<String> listaCurso;
		List<String> listaInformacion;
		List<String> listaIdiomas;
		
		if (request.getParameter("page") == null)
			page = 1;
		else
		{
			page = Integer.parseInt(request.getParameter("page"));
			start = (page - 1) * 1;
		}		
		try {
			read = request.getParameter("read");			
		} catch (Exception ex) {
			read = null;
		}
		try {
			vacante_id = Integer.parseInt(request.getParameter("vacant"));
		} catch (NumberFormatException ex) {
			vacante_id = 0;
		}
		try {
			alumno_id = Integer.parseInt(request.getParameter("alumno_id"));
		} catch (NumberFormatException ex) {
			alumno_id = 0;
		}
		if (read != null)
		{
			switch (read){
				case "accept":
				{
					VacantesDAO.UpdateVacanteSolicitud(1, vacante_id, alumno_id);
					request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">Se ha aceptado la solicitud.</div>");
					countPage = (VacantesDAO.PaginationByVacant(vacante_id) / 1);
					listaAlumnos = AlumnosDAO.listarSolicitudAlumno(start, vacante_id);
					if (listaAlumnos.isEmpty())
						session.setAttribute("listaVacia", 0);
					else
						session.setAttribute("listaVacia", 1);			
					session.setAttribute("listaAlumnos", listaAlumnos);
					session.setAttribute("paginateAlumnos", countPage);
					session.setAttribute("vacante_id", vacante_id);
					session.setAttribute("actual_page", page);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
					break;
				case "dene":
				{
					VacantesDAO.UpdateVacanteSolicitud(2, vacante_id, alumno_id);
					request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">Se ha rechazado la solicitud.</div>");
					countPage = (VacantesDAO.PaginationByVacant(vacante_id) / 1);
					listaAlumnos = AlumnosDAO.listarSolicitudAlumno(start, vacante_id);
					if (listaAlumnos.isEmpty())
						session.setAttribute("listaVacia", 0);
					else
						session.setAttribute("listaVacia", 1);			
					session.setAttribute("listaAlumnos", listaAlumnos);
					session.setAttribute("paginateAlumnos", countPage);
					session.setAttribute("vacante_id", vacante_id);
					session.setAttribute("actual_page", page);
					request.getRequestDispatcher("login.jsp").forward(request, response);				
				}
					break;
				case "view_cv":
				{
					/* Listas */
					int id_cv = CVDAO.getIDCV(alumno_id);
					listaTrabajos = CVDAO.listarTrabajos(id_cv);
					listaCurso = CVDAO.listarCursos(id_cv);
					listaInformacion = CVDAO.listarInformacion(id_cv);
					listaIdiomas = CVDAO.listarIdiomas(id_cv);
					
					request.setAttribute("id_cv", id_cv);
					request.setAttribute("listaTrabajos", listaTrabajos);
					request.setAttribute("listaCurso", listaCurso);
					request.setAttribute("listaInformacion", listaInformacion);
					request.setAttribute("listaIdiomas", listaIdiomas);
					request.setAttribute("view_cv", 1);

					int nivelEstudios = CVDAO.GetNivelEstudios(id_cv);
					request.setAttribute("nivelEstudios", nivelEstudios);
					request.getRequestDispatcher("login.jsp").forward(request, response);						
				}
			}
			return;
		}		
		
		countPage = (VacantesDAO.PaginationByVacant(vacante_id) / 1);
		listaAlumnos = AlumnosDAO.listarSolicitudAlumno(start, vacante_id);
		if (listaAlumnos.isEmpty())
			session.setAttribute("listaVacia", 0);
		else
			session.setAttribute("listaVacia", 1);	
		
		session.setAttribute("view_cv", 0);
		
		session.setAttribute("listaAlumnos", listaAlumnos);
		session.setAttribute("paginateAlumnos", countPage);
		session.setAttribute("vacante_id", vacante_id);
		session.setAttribute("actual_page", page);
		request.getRequestDispatcher("login.jsp").forward(request, response);		
	}
	
	private void ExplicitasAllVacantes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException {
		int vacante_id;
		int page = 0, start = 0, countPage = 0;
		HttpSession session=request.getSession();
		List<AlumnosModel> listaAlumnos;
	
		
		if (request.getParameter("page") == null)
			page = 1;
		else
		{
			page = Integer.parseInt(request.getParameter("page"));
			start = (page - 1) * 1;
		}		
		try {
			vacante_id = Integer.parseInt(request.getParameter("vacant"));
		} catch (NumberFormatException ex) {
			vacante_id = 0;
		}
		
		countPage = (VacantesDAO.PaginationByVacantAll(vacante_id) / 1);
		listaAlumnos = AlumnosDAO.listarAllSolicitudAlumno(start, vacante_id);
		if (listaAlumnos.isEmpty())
			session.setAttribute("listaVacia", 0);
		else
			session.setAttribute("listaVacia", 1);			
		session.setAttribute("listaAlumnos", listaAlumnos);
		session.setAttribute("paginateAlumnos", countPage);
		session.setAttribute("vacante_id", vacante_id);
		session.setAttribute("actual_page", page);
		request.getRequestDispatcher("login.jsp").forward(request, response);		
	}
	//MostrarVacantes
	private void MostrarVacantes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException {
		int page = 0, start = 0;
		HttpSession session=request.getSession();
		int id_session;
		int iType = (Integer)session.getAttribute("type");
		int tipo_contratacion2; 
		int horario2;
		String nombredemierda;
		try {	
			tipo_contratacion2 = Integer.parseInt(request.getParameter("tipo_contratacion"));
			horario2= Integer.parseInt(request.getParameter("horario"));
		} catch (NumberFormatException ex) {
			tipo_contratacion2 = 0;
			horario2= 0;	
		}
		try {
			nombredemierda = request.getParameter("nombre_empresa");
			if(nombredemierda != null) nombredemierda = nombredemierda.trim();
			if(nombredemierda == null) nombredemierda = "";
		} catch(Exception ex) {
			nombredemierda = null;
		}
		int countPage = 0;
		List<VacanteModel> listaVacantes = null;
		if (request.getParameter("page") == null)
			page = 1;
		else
		{
			page = Integer.parseInt(request.getParameter("page"));
			start = (page - 1) * 5;
		}
		if(iType == 2 ) {
			id_session = BusinessDAO.GetBusinessIDByAccountID((Integer)session.getAttribute("id"));
			countPage = (VacantesDAO.Pagination(id_session) / 5);
			listaVacantes = VacantesDAO.listarVacantes(start, id_session, 2);
			if (id_session == 0)
				listaVacantes.clear();
		}
		else
		{
			id_session = AlumnosDAO.GetAccountIDByAccountID((Integer)session.getAttribute("id"));
			countPage = (VacantesDAO.Pagination(0) / 5);
			if(nombredemierda.length() > 1 || tipo_contratacion2 > 0 || horario2 > 0) {
				if (tipo_contratacion2 > 0 || horario2 > 0 && nombredemierda.length() < 1)
				{
					listaVacantes = VacantesDAO.listarVacantesByContratacionAndHorario(start, id_session, 0, tipo_contratacion2, horario2);
					if (listaVacantes.isEmpty())
						session.setAttribute("listaVacia", 0);
					else
						session.setAttribute("listaVacia", 1);	
					
					session.setAttribute("listarVacantes", listaVacantes);
					session.setAttribute("paginateVacantes", countPage);
					session.setAttribute("actual_page", page);
					request.getRequestDispatcher("login.jsp").forward(request, response);	
					return;
				}
				if (nombredemierda.length() > 1)
					listaVacantes = VacantesDAO.listarVacantesByName(start, id_session, 0, request.getParameter("nombre_empresa"));	
				if (tipo_contratacion2 > 1)
					listaVacantes = VacantesDAO.listarVacantesByContratacion(start, id_session, 0, tipo_contratacion2);
				if (horario2 > 0)
					listaVacantes = VacantesDAO.listarVacantesByHorario(start, id_session, 0, horario2);
				if (nombredemierda.length() > 1 && horario2 > 0)
					listaVacantes = VacantesDAO.listarVacantesByNameAndHorario(start, id_session, 0, request.getParameter("nombre_empresa"), horario2);
				if (nombredemierda.length() > 1 && tipo_contratacion2 > 0)
					listaVacantes = VacantesDAO.listarVacantesByNameAndContratacion(start, id_session, 0, request.getParameter("nombre_empresa"), tipo_contratacion2);
				if (nombredemierda.length() > 1 && tipo_contratacion2 > 0 && horario2 > 0)
					listaVacantes = VacantesDAO.listarVacantesByNameAndContratacionAndHorario(start, id_session, 0, 
																				request.getParameter("nombre_empresa"), tipo_contratacion2, horario2);
			}
			else {	
					listaVacantes = VacantesDAO.listarVacantes(start, id_session, 0);
			}
		}
		if (listaVacantes.isEmpty())
			session.setAttribute("listaVacia", 0);
		else
			session.setAttribute("listaVacia", 1);	
		
		session.setAttribute("listarVacantes", listaVacantes);
		session.setAttribute("paginateVacantes", countPage);
		session.setAttribute("actual_page", page);
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}
	
	//Agregar vacantes
	protected void VacantesAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session=request.getSession();
		
		try {
			request.getParameter("nombre");
			request.getParameter("requisitos");
			request.getParameter("descripcion");
			request.getParameter("nombre_contacto");
			request.getParameter("apellido_p_contacto");
			request.getParameter("apellido_m_contacto");
		} catch (Exception ex) {
			session.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de la empresa con los datos numericos.</div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		try {
			Integer.parseInt(request.getParameter("sueldo")); 
			Integer.parseInt(request.getParameter("horario"));
			Integer.parseInt(request.getParameter("tipo_contratacion"));
		} catch (NumberFormatException ex) {
			session.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de la empresa con los datos numericos.</div>");			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		int idEmpresa = BusinessDAO.GetBusinessIDByAccountID((Integer)session.getAttribute("id"));
		if (idEmpresa == 0)
		{
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error al intentar encontrar su empresa, si cree que es un error contacte al soporte.</div>");			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		VacanteModel Vacantes = new VacanteModel(0,
			request.getParameter("nombre"),
			request.getParameter("requisitos"),
			request.getParameter("descripcion"),
			Integer.parseInt(request.getParameter("sueldo")), 
			Integer.parseInt(request.getParameter("horario")),
			Integer.parseInt(request.getParameter("tipo_contratacion")),
			idEmpresa,
			"NOT",
			request.getParameter("nombre_contacto"),
			request.getParameter("apellido_p_contacto"),
			request.getParameter("apellido_m_contacto"), 
			null);
		if (VacantesDAO.InsertVacante(Vacantes) == 1)
		{
			request.setAttribute("msg", "<div class=\"alert alert-success\" role=\"alert\">¡Felicidades!, se ha registrado con éxito. </div>");
		}
		else {
			request.setAttribute("msg", "<div class=\"alert alert-danger\" role=\\\"alert\\\">¡Fallo!, al parecer ha ocurrido un error durante el registro de su vacante.</div>");
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	protected void AdminMostrarContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session=request.getSession();
		List<ContactoModel> listaContactos = null;
		listaContactos = ContactoDAO.listarContactos();

		if(listaContactos.isEmpty())
			session.setAttribute("listaContactoVacia", 0);
		else
			session.setAttribute("listaContactoVacia", 1);
		session.setAttribute("listaContactos", listaContactos);
		request.getRequestDispatcher("login.jsp").forward(request, response);		
	}
	
	protected void UpdateContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session=request.getSession();
		List<ContactoModel> listaContactos = null;
		ContactoDAO.Update(Integer.parseInt(request.getParameter("contact")));
		listaContactos = ContactoDAO.listarContactos();

		if(listaContactos.isEmpty())
			session.setAttribute("listaContactoVacia", 0);
		else
			session.setAttribute("listaContactoVacia", 1);
		session.setAttribute("listaContactos", listaContactos);
		request.getRequestDispatcher("login.jsp").forward(request, response);		
	}
	
	//Verificar login
	protected void VerifyLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		try {
			request.getParameter("clave");
			request.getParameter("password");			
		}catch(Exception ex){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		AccountModel Account = new AccountModel(
				request.getParameter("clave"), 
				request.getParameter("password")
				);
		//response.getWriter().append("Served at: ").append(request.getParameter("clave"));
		int id = LoginDAO.Verify(Account);
		if(id >= 1)
		{
					int iType = LoginDAO.GetAccountTypeByID(id);
					BusinessModel dataAccountBusiness;
					AlumnosModel dataAccountStudent;
		        	HttpSession session=request.getSession();
		        	session.setAttribute("id", id);
		        	session.setAttribute("clave",request.getParameter("clave"));
		        	session.setAttribute("type", iType);
					if (iType == 2)
					{
						dataAccountBusiness = BusinessDAO.GetBusinessByID(id);	
						session.setAttribute("dataAccount", dataAccountBusiness);
					}
					else
					{
						dataAccountStudent = AlumnosDAO.GetStudentByID(id);	
						session.setAttribute("dataAccount", dataAccountStudent);
					}
					if(LoginDAO.IsAdmin(id) > 1)
						session.setAttribute("IsAdmin", LoginDAO.IsAdmin(id));
					else
						session.setAttribute("IsAdmin", 0);
		        	request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msgLogin", "<div class=\"alert alert-danger\" role=\"alert\">No ha podido ingresar sesión.</div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
