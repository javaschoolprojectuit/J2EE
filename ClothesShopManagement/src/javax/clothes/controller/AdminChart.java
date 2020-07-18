package javax.clothes.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminChart
 */
@WebServlet("/AdminChart")
public class AdminChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String start = "", end = "";
		LocalDate defaultEnd = LocalDate.now().plusDays(1);  
		LocalDate defaultStart = defaultEnd.minusDays(7);

		if(request.getParameter("start") != null) {
			start = convertDateFormat(request.getParameter("start")); 
		} else {
			start = convertDateFormat(defaultStart.toString());
		}
		
		
		if(request.getParameter("end") != null) {
			end = convertDateFormat(request.getParameter("end")); 
		} else {
			end = convertDateFormat(defaultEnd.toString());
		}
		HttpSession session = request.getSession();
		session.setAttribute("end", end);
		session.setAttribute("start", start);
		request.getRequestDispatcher("/AdminChart.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/AdminChart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String convertDateFormat(String date) {
		return date.replace("-","");
	}

}
