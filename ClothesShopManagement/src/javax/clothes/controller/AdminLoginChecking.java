package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

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

		ArrayList<UserDTO> listOfUsers = user.getUserByFilters(userdto);

		HttpSession oldSession = request.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate();
		}
		if(listOfUsers.size() == 0) {
			request.getRequestDispatcher("./AdminLogin.jsp");
		} else {
			HttpSession newSession = request.getSession(true);
			UserDTO currentUser = listOfUsers.get(0);
			newSession.setAttribute("currentSession", currentUser);
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
