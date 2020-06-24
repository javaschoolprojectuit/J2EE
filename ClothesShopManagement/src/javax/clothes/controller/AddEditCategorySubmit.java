package javax.clothes.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.clothes.bo.CategoryBO;
import javax.clothes.dto.CategoryDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class AddEditCategorySubmit
 */
@WebServlet("/AddEditCategorySubmit")
public class AddEditCategorySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEditCategorySubmit() {
		super();
		// TODO Auto-generated constructor stub
		filePath = getServletContext().getInitParameter("file-upload");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDTO catdto = new CategoryDTO();
		CategoryBO catbo = new CategoryBO();

		if (request.getParameter("name") != null)
			catdto.setName(request.getParameter("name"));
		if (request.getParameter("active") != null)
			catdto.setActive((Boolean.valueOf(request.getParameter("active"))));
		if (request.getParameter("description") != null)
			catdto.setDescription(request.getParameter("description"));
		catdto.setImage(filePath + getUploadFile(request, response));
		try {
			System.out.print(catbo.addCategory(catdto));
		} catch (Exception e) {
			request.getRequestDispatcher("/AddEditCategoryForm.jsp");
		}

		request.getRequestDispatcher("/AdminCategory").forward(request, response);
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
		String name = "";
		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");

		if (!isMultipart) {
			return name;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest((RequestContext) request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fileName = fi.getName();

					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					name = fileName;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return name;
	}

}
