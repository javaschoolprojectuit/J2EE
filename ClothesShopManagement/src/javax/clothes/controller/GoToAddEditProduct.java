package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.CategoryBO;
import javax.clothes.bo.ProductBO;
import javax.clothes.bo.SupplierBO;
import javax.clothes.dto.CategoryDTO;
import javax.clothes.dto.ProductDTO;
import javax.clothes.dto.SupplierDTO;
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
			ProductBO prodbo = new ProductBO();
			inputProd = prodbo.getProductByID(requestId);
		}
		
		CategoryBO catbo = new CategoryBO();
		ArrayList<CategoryDTO> categories = new ArrayList<CategoryDTO>();
		categories = catbo.getAllCategories();
		
		SupplierBO suppbo = new SupplierBO();
		ArrayList<SupplierDTO> suppliers = new ArrayList<SupplierDTO>();
		SupplierDTO supp = new SupplierDTO();
		suppliers = suppbo.getSuppliersByFilters(supp);
		

		request.setAttribute("inputProd", inputProd);
		request.setAttribute("categories", categories);
		request.setAttribute("suppliers", suppliers);
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
