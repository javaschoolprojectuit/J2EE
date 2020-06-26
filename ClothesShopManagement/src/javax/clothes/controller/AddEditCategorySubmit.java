package javax.clothes.controller;

import java.io.File;
import java.io.IOException;

import javax.clothes.bo.CategoryBO;
import javax.clothes.dto.CategoryDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		catdto.setImage(getUploadFile(request, response));
		try {
			System.out.print(catbo.addCategory(catdto));
		} catch (Exception e) {
			request.getRequestDispatcher("/AddEditCategoryForm.jsp");
		}
		
		if(action.equals("Create")) {
			try {
				System.out.print(catbo.addCategory(catdto));
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditCategoryForm.jsp").forward(request, response);
			}
		}
		
		if (action.equals("Edit")) {
			try {
				catbo.updateCategory(catdto);
			} catch (Exception e) {
				request.getRequestDispatcher("/AddEditCategoryForm.jsp").forward(request, response);
			}
		}else {
			catdto.setActive(false);
			catbo.updateCategory(catdto);
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

	protected String getUploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String filePath = getServletContext().getInitParameter("file-upload");
		String name = "";
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			if (!fileName.equals("")) {
				// refines the fileName in case it is an absolute path
				fileName = new File(fileName).getName();
				name = fileName;
				part.write(filePath + fileName);
			}
		}
		return filePath + name;
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
