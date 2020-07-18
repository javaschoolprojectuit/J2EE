package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.bo.OrderBO;
import javax.clothes.bo.OrderDetailBO;
import javax.clothes.dto.OrderDTO;
import javax.clothes.dto.OrderDetailDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Servlet implementation class AdminChart
 */
@WebServlet("/AdminShowChart")
public class AdminShowChart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminShowChart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<OrderDTO> orders = new ArrayList<OrderDTO>();
		String start = "", end ="";
		try {
			start = request.getSession().getAttribute("start").toString();
			end = request.getSession().getAttribute("end").toString();
		} catch (Exception e) {
			start = "20200601";
			end = "20200630";
		}
		System.out.print(start);
		try {
			OrderBO orderbo = new OrderBO();
			OrderDetailBO orderdetails = new OrderDetailBO();
			orders = orderbo.getOrdersByOrderDate(start, end);

			orders.forEach((order) -> {
				int sum = 0;
				ArrayList<OrderDetailDTO> details = orderdetails.getOrderDetail(order.getId());
				for (int i = 0; i < details.size(); i++) {
					sum += details.get(i).getPrice();
				}
				dataset.setValue(sum, "Order", order.getOrderDate());
			});
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		JFreeChart chart = ChartFactory.createLineChart("Orders", "Date", "Sum", dataset, PlotOrientation.VERTICAL,
				true, true, false);

		try {

			final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 400, info);
		} catch (Exception e) {
			System.out.println(e);

		}
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
