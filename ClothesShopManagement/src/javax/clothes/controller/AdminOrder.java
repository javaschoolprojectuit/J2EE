package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.OrderBO;
import javax.clothes.dto.OrderDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminOrder
 */
@WebServlet("/AdminOrder")
public class AdminOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		OrderDTO orderinput = new OrderDTO();
		ArrayList<OrderDTO> orderList = new ArrayList<OrderDTO>();
		if(request.getParameter("number") != null ) orderinput.setNumber(request.getParameter("number"));
		if(request.getParameter("status") != null ) orderinput.setStatus(request.getParameter("status"));
		if(request.getParameter("paymentId") != null ) orderinput.setPaymentid(Integer.parseInt(request.getParameter("paymentId")));
		if(request.getParameter("userId") != null ) orderinput.setPaymentid(Integer.parseInt(request.getParameter("userId")));
		
		OrderBO orderbo = new OrderBO();
		orderList = orderbo.getOrdersByFilters(orderinput);
		request.setAttribute("orders", orderList);
		request.getRequestDispatcher("/AdminOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
