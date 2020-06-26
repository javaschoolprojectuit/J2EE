package javax.clothes.controller;

import java.io.IOException;

import javax.clothes.bo.ProductBO;
import javax.clothes.dto.ProductDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoToAddEditProduct
 */
@WebServlet("/GoToAddEditProduct")
public class GoToAddEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoToAddEditProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int requestId = 0;
		ProductDTO inputProd = new ProductDTO();
		if (request.getParameter("id") == null) {
			requestId = 0;
		} else {
			requestId = Integer.parseInt(request.getParameter("id"));
			ProductBO catbo = new ProductBO();
			inputProd = catbo.getProductByID(requestId);
		}

		request.setAttribute("inputProd", inputProd);
		request.getRequestDispatcher("./AddEditProductForm.jsp").forward(request, response);
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
