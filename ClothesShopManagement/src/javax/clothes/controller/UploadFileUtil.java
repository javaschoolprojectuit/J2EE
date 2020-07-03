package javax.clothes.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public final class UploadFileUtil {
	private ServletContext context;
	final String serverpath = "images\\";
	public UploadFileUtil (ServletContext context) {
		this.context = context;
	}
	public String getUploadFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String filePath = context.getInitParameter("file-upload");
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
		
		return serverpath + name;
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
