package javax.clothes.controller;

import java.io.IOException;

import javax.clothes.bo.OrderBO;
import javax.clothes.dto.OrderDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEditOrderSubmit
 */
@WebServlet("/AddEditOrderSubmit")
public class AddEditOrderSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEditOrderSubmit() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDTO orderdto = new OrderDTO();
		OrderBO orderbo = new OrderBO();

		if(request.getParameter("number") != null ) orderdto.setNumber(request.getParameter("number"));
		if(request.getParameter("orderDate") != null ) orderdto.setOrderDate(request.getParameter("orderDate"));
		if(request.getParameter("shippingDate") != null ) orderdto.setShippingDate(request.getParameter("shippingDate"));
		if(request.getParameter("tax") != null ) orderdto.setTax(Integer.parseInt(request.getParameter("tax")));
		if(request.getParameter("status") != null ) orderdto.setStatus(request.getParameter("status"));
		orderdto.setPaymentid(1);
		orderdto.setUserid(2);
		if(request.getParameter("paymentDate") != null ) orderdto.setPaymentDate(request.getParameter("paymentDate"));
		try {
			System.out.print(orderbo.addOrder(orderdto));
		} catch (Exception e) {
			request.getRequestDispatcher("/AddEditOrderForm.jsp");
		}

		request.getRequestDispatcher("/AdminOrder").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
