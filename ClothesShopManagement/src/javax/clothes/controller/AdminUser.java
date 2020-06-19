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

/**
 * Servlet implementation class AdminUser
 */
@WebServlet("/AdminUser")
public class AdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userinput = new UserDTO();
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		if(request.getParameter("fname") != null ) userinput.setFirstName(request.getParameter("fname"));
		if(request.getParameter("lname") != null ) userinput.setLastName(request.getParameter("lname"));
		if(request.getParameter("address") != null ) userinput.setAddress(request.getParameter("address"));
		if(request.getParameter("city") != null ) userinput.setCity(request.getParameter("city"));
		if(request.getParameter("username") != null ) userinput.setUserName(request.getParameter("username"));
		if(request.getParameter("phone") != null ) userinput.setPhone(request.getParameter("phone"));
		if(request.getParameter("email") != null ) userinput.setEmail(request.getParameter("email"));
		
		UserBO userbo = new UserBO();
		userList = userbo.getUserByFilters(userinput);
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/AdminUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
