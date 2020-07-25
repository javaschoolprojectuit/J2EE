package javax.clothes.controller;

import java.io.IOException;

import javax.clothes.bo.SupplierBO;
import javax.clothes.dto.SupplierDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEditSupplierSubmit
 */
@WebServlet("/AddEditSupplierSubmit")
public class AddEditSupplierSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEditSupplierSubmit() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SupplierDTO supplierdto = new SupplierDTO();
		SupplierBO supplierbo = new SupplierBO();

		if(request.getParameter("name") != null ) supplierdto.setName(request.getParameter("name"));
		if(request.getParameter("address") != null ) supplierdto.setAddress(request.getParameter("address"));
		if(request.getParameter("city") != null ) supplierdto.setCity(request.getParameter("city"));
		if(request.getParameter("district") != null ) supplierdto.setDistrict(request.getParameter("district"));
		if(request.getParameter("email") != null ) supplierdto.setEmail(request.getParameter("email"));
		if(request.getParameter("phone") != null ) supplierdto.setPhone(request.getParameter("phone"));
		try {
			System.out.print(supplierbo.addSupplier(supplierdto));
		} catch (Exception e) {
			request.getRequestDispatcher("/AddEditSupplierForm.jsp");
		}

		request.getRequestDispatcher("/AdminSupplier").forward(request, response);
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
