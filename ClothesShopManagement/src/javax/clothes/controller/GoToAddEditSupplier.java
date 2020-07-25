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
 * Servlet implementation class GoToAddEditSupplier
 */
@WebServlet("/GoToAddEditSupplier")
public class GoToAddEditSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToAddEditSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = 0;
		SupplierDTO inputSupplier = new SupplierDTO();
		if (request.getParameter("id") == null) {
			requestId = 0;
		} else {
			requestId = Integer.parseInt(request.getParameter("id"));
			SupplierBO supplierbo = new SupplierBO();
			inputSupplier = supplierbo.getSupplierById(requestId);
		}
		
		request.setAttribute("inputSupplier", inputSupplier);
		request.getRequestDispatcher("./AddEditSupplierForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
