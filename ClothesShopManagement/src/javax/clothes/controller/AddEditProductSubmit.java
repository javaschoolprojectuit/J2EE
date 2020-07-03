package javax.clothes.controller;

import java.io.IOException;

import javax.clothes.bo.ProductBO;
import javax.clothes.dto.ProductDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEditProductSubmit
 */
@WebServlet("/AddEditProductSubmit")
@MultipartConfig
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			proddto.setSuppId(Integer.parseInt(request.getParameter("supplier")));
		// add new image
		if (request.getParameter("image") != null && request.getParameter("image").equals("")) {
			UploadFileUtil fileUploader = new UploadFileUtil(getServletContext());
			proddto.setImage(fileUploader.getUploadFile(request, response));
		}

		switch (action) {
		case "Create":
			try {
				System.out.print(prodbo.addProduct(proddto));
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditProductForm.jsp").forward(request, response);
			}
			break;
		case "Edit":
			try {
				UploadFileUtil fileUploader = new UploadFileUtil(getServletContext());
				String path = fileUploader.getUploadFile(request, response);
				if (!path.equals(request.getParameter("image")) && !path.equals(fileUploader.serverpath)) {
					proddto.setImage(path);
				}
				prodbo.updateProduct(proddto);
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditProductForm.jsp").forward(request, response);
			}
			break;
		case "Delete":
			proddto.setImage(request.getParameter("image"));
			proddto.setDeleted(true);
			prodbo.updateProduct(proddto);
			break;

		}

		response.sendRedirect(request.getContextPath() + "/AdminProduct");
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
