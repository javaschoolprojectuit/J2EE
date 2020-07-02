package javax.clothes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.clothes.dto.OrderDTO;
import javax.clothes.dto.OrderDetailDTO;
import javax.clothes.mapper.OrderDetailMapper;
import javax.clothes.mapper.OrderMapper;
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

		try {
			OrderMapper orderbo = new OrderMapper();
			OrderDetailMapper orderdetails = new OrderDetailMapper();
			orders = orderbo.getOrdersByOrderDate("20200601", "20200630");

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

		JFreeChart chart = ChartFactory.createLineChart("Orders", "Sum", "Date", dataset,
				PlotOrientation.VERTICAL, true, true, false);

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
