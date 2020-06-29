package javax.clothes.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEditOrderSubmit() {
		super();
		// TODO Auto-generated constructor stub
		filePath = getServletContext().getInitParameter("file-upload");
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
		if(request.getParameter("paymentId") != null ) orderdto.setPaymentid(Integer.parseInt(request.getParameter("paymentId")));
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
