package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.ProductBO;
import javax.clothes.dto.ProductDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminProduct
 */
@WebServlet("/AdminProduct")
public class AdminProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDTO prodinput = new ProductDTO();
		String priceOrder = "", sizeOrder = "", quantityOrder = "";
		ArrayList<ProductDTO> prodList = new ArrayList<ProductDTO>();

		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			prodinput.setId(Integer.parseInt(request.getParameter("id")));
			ProductBO userbo = new ProductBO();
			prodList.add(userbo.getProductByID(prodinput.getId()));
		} else {
			if (request.getParameter("name") != null)
				prodinput.setName(request.getParameter("name"));
			if (request.getParameter("catid") != null && !request.getParameter("catid").equals(""))
				prodinput.setCatId(Integer.parseInt(request.getParameter("catid")));
			if (request.getParameter("suppid") != null && !request.getParameter("suppid").equals(""))
				prodinput.setSuppId(Integer.parseInt(request.getParameter("suppid")));
			if (request.getParameter("priceorder") != null && request.getParameter("price") != null && !request.getParameter("price").equals("")) {
				priceOrder = request.getParameter("priceorder");
				prodinput.setPrice(Integer.parseInt(request.getParameter("price")));
			}
			if (request.getParameter("sizeorder") != null && request.getParameter("size") != null && !request.getParameter("size").equals("")) {
				sizeOrder = request.getParameter("sizeorder");
				prodinput.setSize(Integer.parseInt(request.getParameter("size")));
			}
			if (request.getParameter("quantityorder") != null && request.getParameter("quantity") != null && !request.getParameter("quantity").equals("")) {
				quantityOrder = request.getParameter("quantityorder");
				prodinput.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			}

			ProductBO userbo = new ProductBO();
			prodList = userbo.getProductByFilters(prodinput, priceOrder, sizeOrder, quantityOrder);
		}
		
		request.setAttribute("products", prodList);
		request.getRequestDispatcher("/AdminProduct.jsp").forward(request, response);
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
