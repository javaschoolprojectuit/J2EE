package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.OrderDetailBO;
import javax.clothes.dto.OrderDetailDTO;
import javax.clothes.bo.ProductBO;
import javax.clothes.dto.ProductDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminOrder
 */
@WebServlet("/AdminOrderDetail")
public class AdminOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int requestId = 0;
		int productId = 0;
		int quantity = 0;
		int productPrice = 0;
		ArrayList<OrderDetailDTO> inputOrderDetail = new ArrayList<OrderDetailDTO>();
		ProductBO productbo = new ProductBO();
		ProductDTO productDetail = new ProductDTO();
		if (request.getParameter("id") == null) {
			requestId = 0;
		} else {
			requestId = Integer.parseInt(request.getParameter("id"));
			OrderDetailBO orderdetailbo = new OrderDetailBO();
			inputOrderDetail = orderdetailbo.getOrderDetail(requestId);
			 for (int i = 0; i < inputOrderDetail.size(); i++) {
				 productId = inputOrderDetail.get(i).getProductId();
				 quantity = inputOrderDetail.get(i).getQuantity();
				 productDetail = productbo.getProductByID(productId);
				 productPrice = productDetail.getPrice();
				 inputOrderDetail.get(i).setPrice(quantity*productPrice);
			 }	
		}
		
		request.setAttribute("OrderDetails", inputOrderDetail);
		request.getRequestDispatcher("/AdminOrderDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
