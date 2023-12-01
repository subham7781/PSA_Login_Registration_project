package ragistration_app_controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ragistration_app_model.DAOserviceimpl;


@WebServlet("/verifyLogin")
public class logincontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public logincontroler() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
			String email = request.getParameter("email");
		String pass = request.getParameter("password");
		DAOserviceimpl service = new DAOserviceimpl();
		service.connectDB();
		boolean status = service.verifyLogin(email, pass);
		System.out.println(status);
		if (status) {
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(10);
			session.setAttribute("email",email);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		} catch (Exception e) {
			request.setAttribute("msg", "session Expired .login Again!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
