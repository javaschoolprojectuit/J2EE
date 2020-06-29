package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.OrderBO;
import javax.clothes.bo.RoleBO;
import javax.clothes.bo.UserBO;
import javax.clothes.dto.OrderDTO;
import javax.clothes.dto.RoleDTO;
import javax.clothes.dto.UserDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoToAddEditOrder
 */
@WebServlet("/GoToAddEditOrder")
public class GoToAddEditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToAddEditOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = 0;
		OrderDTO inputOrder = new OrderDTO();
		if (request.getParameter("id") == null) {
			requestId = 0;
		} else {
			requestId = Integer.parseInt(request.getParameter("id"));
			OrderBO orderbo = new OrderBO();
			inputOrder = orderbo.getOrderByID(requestId);
		}
		
		request.setAttribute("inputOrder", inputOrder);
		request.getRequestDispatcher("./AddEditOrderForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
