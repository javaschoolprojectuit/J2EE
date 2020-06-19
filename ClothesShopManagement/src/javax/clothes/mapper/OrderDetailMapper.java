package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.clothes.dto.OrderDetailDTO;

public class OrderDetailMapper extends DBMapper {

	public OrderDetailMapper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetailDTO resultSetMapping(ResultSet rs) {
		OrderDetailDTO temp = new OrderDetailDTO();
		try {
			temp.setDiscount(rs.getInt("DISCOUNT"));
			temp.setId(rs.getInt("OD_ID"));
			temp.setOrderId(rs.getInt("ORDER_ID"));
			temp.setPrice(rs.getInt("PRICE"));
			temp.setProductId(rs.getInt("PROD_ID"));
			temp.setQuantity(rs.getInt("QUANTITY"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	public ArrayList<OrderDetailDTO> getOrderDetail(int orderId) {
		ArrayList<OrderDetailDTO> order  = new ArrayList<OrderDetailDTO>(); 
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM ORDER_DETAIL WHERE ORDER_ID=" + Integer.toString(orderId);
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs != null && rs.next()) {
				OrderDetailDTO orderdetail = new OrderDetailDTO();
				orderdetail = resultSetMapping(rs);
				order.add(orderdetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
}
