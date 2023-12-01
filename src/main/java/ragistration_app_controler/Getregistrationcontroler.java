package ragistration_app_controler;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ragistration_app_model.DAOserviceimpl;


@WebServlet("/allreg")
public class Getregistrationcontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Getregistrationcontroler() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if (session.getAttribute("email")!=null) {
			
		DAOserviceimpl service =new DAOserviceimpl();
		service.connectDB();
		ResultSet res =service.readallReg();
		
		request.setAttribute("res",res);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
	    rd.forward(request, response);
		}else {
			request.setAttribute("msg", "session Expired .login Again!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		} catch (Exception e) {
			request.setAttribute("msg", "session Expired .login Again!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
