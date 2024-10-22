package javax.clothes.controller;

import java.io.IOException;

import javax.clothes.bo.CategoryBO;
import javax.clothes.dto.CategoryDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEditCategorySubmit
 */
@WebServlet("/AddEditCategorySubmit")
@MultipartConfig
public class AddEditCategorySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEditCategorySubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDTO catdto = new CategoryDTO();
		CategoryBO catbo = new CategoryBO();
		String action = request.getParameter("action");

		if (request.getParameter("id") != null)
			catdto.setId(Integer.parseInt(request.getParameter("id")));
		if (request.getParameter("name") != null)
			catdto.setName(request.getParameter("name"));
		if (request.getParameter("active") != null)
			catdto.setActive((Boolean.valueOf(request.getParameter("active"))));
		if (request.getParameter("description") != null)
			catdto.setDescription(request.getParameter("description"));
		// add new image
		if (request.getParameter("image") != null && request.getParameter("image").equals("")) {
			UploadFileUtil fileUploader = new UploadFileUtil(getServletContext());
			catdto.setImage(fileUploader.getUploadFile(request, response));
		}

		switch (action) {
		case "Create":
			try {
				System.out.print(catbo.addCategory(catdto));
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditCategoryForm.jsp").forward(request, response);
			}
			break;
		case "Edit":
			try {
				UploadFileUtil fileUploader = new UploadFileUtil(getServletContext());
				String path = fileUploader.getUploadFile(request, response);
				if (!path.equals(request.getParameter("image")) && !path.equals(fileUploader.serverpath)) {
					catdto.setImage(path);
				}
				catbo.updateCategory(catdto);
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditCategoryForm.jsp").forward(request, response);
			}
			break;
		case "Delete":
			catdto.setImage(request.getParameter("image"));
			catdto.setActive(false);
			catbo.updateCategory(catdto);
			break;
		}

		response.sendRedirect(request.getContextPath() + "/AdminCategory");
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
