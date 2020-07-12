package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.SupplierBO;
import javax.clothes.dto.SupplierDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminSupplier
 */
@WebServlet("/AdminSupplier")
public class AdminSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		SupplierDTO supplierinput = new SupplierDTO();
		ArrayList<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
		if(request.getParameter("name") != null ) supplierinput.setName(request.getParameter("name"));
		if(request.getParameter("address") != null ) supplierinput.setAddress(request.getParameter("address"));
		if(request.getParameter("city") != null ) supplierinput.setCity(request.getParameter("city"));
		if(request.getParameter("district") != null ) supplierinput.setDistrict(request.getParameter("district"));
		if(request.getParameter("email") != null ) supplierinput.setEmail(request.getParameter("email"));
		if(request.getParameter("phone") != null ) supplierinput.setPhone(request.getParameter("phone"));
		
		SupplierBO supplierbo = new SupplierBO();
		supplierList = supplierbo.getSuppliersByFilters(supplierinput);
		request.setAttribute("suppliers", supplierList);
		request.getRequestDispatcher("/AdminSupplier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
