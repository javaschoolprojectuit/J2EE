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
 * Servlet implementation class AddEditProductSubmit
 */
@WebServlet("/AddEditProductSubmit")
public class AddEditProductSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEditProductSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDTO proddto = new ProductDTO();
		ProductBO prodbo = new ProductBO();
		String action = request.getParameter("action");

		if (request.getParameter("id") != null)
			proddto.setId(Integer.parseInt(request.getParameter("id")));
		if (request.getParameter("name") != null)
			proddto.setName(request.getParameter("name"));
		if (request.getParameter("price") != null)
			proddto.setPrice(Integer.parseInt(request.getParameter("price")));
		if (request.getParameter("description") != null)
			proddto.setDescription(request.getParameter("description"));
		if (request.getParameter("size") != null)
			proddto.setSize(Integer.parseInt(request.getParameter("size")));
		if (request.getParameter("quantity") != null)
			proddto.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		if (request.getParameter("category") != null)
			proddto.setCatId(Integer.parseInt(request.getParameter("category")));
		if (request.getParameter("supplier") != null)
			proddto.setPrice(Integer.parseInt(request.getParameter("supplier")));
		UploadFileUtil fileUploader = new UploadFileUtil(getServletContext());
		proddto.setImage(fileUploader.getUploadFile(request, response));
		try {
			System.out.print(prodbo.addProduct(proddto));
		} catch (Exception e) {
			request.getRequestDispatcher("/AddEditProductForm.jsp");
		}
		
		if(action.equals("Create")) {
			try {
				System.out.print(prodbo.addProduct(proddto));
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditProductForm.jsp").forward(request, response);
			}
		}
		
		if (action.equals("Edit")) {
			try {
				prodbo.updateProduct(proddto);
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditProductForm.jsp").forward(request, response);
			}
		}else {
			proddto.setDeleted(true);
			prodbo.updateProduct(proddto);
		}

		response.sendRedirect(request.getContextPath() + "/AdminProduct");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
