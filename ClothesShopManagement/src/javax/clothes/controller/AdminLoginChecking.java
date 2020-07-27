package javax.clothes.controller;

import java.io.IOException;
import javax.clothes.bo.UserBO;
import javax.clothes.dto.UserDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class AdminLoginChecking
 */
@WebServlet("/AdminLoginChecking")
public class AdminLoginChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginChecking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userdto = new UserDTO();
		UserBO user = new UserBO();
		userdto.setEmail(request.getParameter("email"));
		userdto.setPassword(request.getParameter("password"));

		UserDTO result = new UserDTO();
		result = user.checkUserLogin(userdto);

		HttpSession oldSession = request.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate();
		}
		if(result.getId() <= 0) {
			request.setAttribute("loginErrorMessage", "wrong email or password");
			request.getRequestDispatcher("./AdminLogin.jsp").forward(request, response);
		} else {
			HttpSession newSession = request.getSession(true);
			newSession.setAttribute("currentSession", result);
			request.getRequestDispatcher("./AdminHome.jsp").forward(request, response);
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
