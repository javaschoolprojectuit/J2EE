package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.RoleBO;
import javax.clothes.bo.UserBO;
import javax.clothes.dto.RoleDTO;
import javax.clothes.dto.UserDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GoToNewEditUser
 */
@WebServlet("/GoToAddEditUser")
public class GoToAddEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToAddEditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = 0;
		UserDTO inputUser = new UserDTO();
		if (request.getParameter("id") == null) {
			requestId = 0;
		} else {
			requestId = Integer.parseInt(request.getParameter("id"));
			UserBO userbo = new UserBO();
			inputUser = userbo.getUserById(requestId);
		}
		
		RoleBO rolebo = new RoleBO();
		ArrayList<RoleDTO> roles = rolebo.getRolesrByFilters("");
		request.setAttribute("roles", roles);
		request.setAttribute("inputUser", inputUser);
		request.getRequestDispatcher("./AddEditUserForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
