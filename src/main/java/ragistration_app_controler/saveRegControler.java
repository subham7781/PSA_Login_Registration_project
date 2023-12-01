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


@WebServlet("/saveReg")
public class saveRegControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public saveRegControler() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
		rd.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if (session.getAttribute("email")!=null) {
			
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobil = request.getParameter("mobil");
		String pass = request.getParameter("password");
		DAOserviceimpl service = new DAOserviceimpl();
		service.connectDB();
		service.saveRegistration(name, city, email, mobil,pass);
		request.setAttribute("msg","<h1 style='color:green'>Registration Done</h1>");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
		rd.forward(request, response);	
	}else {
		request.setAttribute("msg", "session Expired .login Again!!");
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
