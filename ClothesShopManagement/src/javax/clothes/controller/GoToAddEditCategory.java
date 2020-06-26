package javax.clothes.controller;

import java.io.IOException;

import javax.clothes.bo.CategoryBO;
import javax.clothes.dto.CategoryDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoToAddEditCategory
 */
@WebServlet("/GoToAddEditCategory")
public class GoToAddEditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToAddEditCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = 0;
		CategoryDTO inputCat = new CategoryDTO();
		if (request.getParameter("id") == null) {
			requestId = 0;
		} else {
			requestId = Integer.parseInt(request.getParameter("id"));
			CategoryBO catbo = new CategoryBO();
			inputCat = catbo.getCategoryByID(requestId);
		}
		
		request.setAttribute("inputCat", inputCat);
		request.getRequestDispatcher("./AddEditCategoryForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
