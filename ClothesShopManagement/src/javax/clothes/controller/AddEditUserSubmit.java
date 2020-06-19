package javax.clothes.controller;

import java.io.IOException;

import javax.clothes.bo.UserBO;
import javax.clothes.dto.UserDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEditUserSubmit
 */
@WebServlet("/AddEditUserSubmit")
public class AddEditUserSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEditUserSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userdto = new UserDTO();
		UserBO userbo = new UserBO();
		
		if(request.getParameter("fname") != null ) userdto.setFirstName(request.getParameter("fname"));
		if(request.getParameter("lname") != null ) userdto.setLastName(request.getParameter("lname"));
		if(request.getParameter("address") != null ) userdto.setAddress(request.getParameter("address"));
		if(request.getParameter("city") != null ) userdto.setCity(request.getParameter("city"));
		if(request.getParameter("username") != null ) userdto.setUserName(request.getParameter("username"));
		if(request.getParameter("phone") != null ) userdto.setPhone(request.getParameter("phone"));
		if(request.getParameter("email") != null ) userdto.setEmail(request.getParameter("email"));
		if(request.getParameter("password") != null ) userdto.setPassword(request.getParameter("password"));
		if(request.getParameter("role") != null) {
			userdto.setRoleID(Integer.parseInt(request.getParameter("role")));
		} else {
			userdto.setRoleID(2);
		}
		try {
			System.out.print(userbo.addUser(userdto));
		} catch (Exception e) {
			request.getRequestDispatcher("/AddEditUserForm.jsp");
		}
		
		request.getRequestDispatcher("/AdminUser").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
