package ragistration_app_controler;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ragistration_app_model.DAOserviceimpl;

@WebServlet("/delete")
public class deletecontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deletecontroler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("emailID");
		DAOserviceimpl service = new DAOserviceimpl();
		service.connectDB();
		service.deleteByEmail(email);

		ResultSet res = service.readallReg();

		request.setAttribute("res", res);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
