package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.clothes.dto.OrderDTO;

public class OrderMapper extends DBMapper {

	public OrderMapper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDTO resultSetMapping(ResultSet rs) {
		OrderDTO order = new OrderDTO();
		
		try {
			order.setId(rs.getInt("ORDER_ID"));
			order.setNumber(rs.getString("NUMBER"));
			order.setOrderDate(rs.getString("ORDERDATE"));
			order.setPaymentDate(rs.getString("PAYMENTDATE"));
			order.setPaymentid(rs.getInt("PAYMENT_ID"));
			order.setShippingDate(rs.getString("SHIPPINGDATE"));
			order.setStatus(rs.getString("STATUS"));
			order.setTax(rs.getInt("TAX"));
			order.setUserid(rs.getInt("USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}

	public ArrayList<OrderDTO> getOrdersByFilters(OrderDTO order) {
		ArrayList<OrderDTO> orders = new ArrayList<OrderDTO>();
		try {
			String paymentId = order.getPaymentid() > 0 ? Integer.toString(order.getPaymentid()) : "null";
			String userId = order.getUserid() > 0 ? Integer.toString(order.getUserid()) : "null";
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM ORDERS WHERE " + "NUMBER LIKE '%" + order.getNumber() + "%' AND " + 
						  "PAYMENT_ID = ISNULL(" + paymentId + ",PAYMENT_ID)" +  
						  " AND STATUS LIKE '%" + order.getStatus() + 
						  "%' AND USER_ID = ISNULL(" + userId + ",USER_ID)" ;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs != null && rs.next()) {
				OrderDTO temp = new OrderDTO();
				temp = resultSetMapping(rs);
				orders.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public OrderDTO getOrderById(int id) {
		OrderDTO order = new OrderDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM ORDERS WHERE ORDER_ID = " + Integer.toString(order.getUserid());
			ResultSet rs = stmt.executeQuery(sql);
			while (rs != null && rs.next()) {
				order = resultSetMapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public boolean updateOrder (OrderDTO order) {
		try {
			Statement stmt = getConnection().createStatement();
			String fields = "NUMBER='" + order.getNumber() + "' , ORDERDATE='" + order.getOrderDate() + "' , PAYMENTDATE='" + 
					order.getPaymentDate() + "' , PAYMENT_ID=" + Integer.toString(order.getPaymentid()) + " , SHIPPINGDATE='" +
					order.getShippingDate() + "' , STATUS ='" + order.getStatus() + "', TAX=" +
					Integer.toString(order.getTax()) + "AND USER_ID=" + Integer.toString(order.getUserid());
			String query = "UPDATE ORDERS SET " + fields + "WHERE ORDER_ID = " + Integer.toString(order.getId());
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean addOrder (OrderDTO order) {
		try {
			Statement stmt = getConnection().createStatement();
			String fields = "'" + order.getNumber() + "','" + order.getOrderDate() + "','" + 
							order.getPaymentDate() + "'," + Integer.toString(order.getPaymentid()) + ",'" +
							order.getShippingDate() + "','" + order.getStatus() + "'," +
							Integer.toString(order.getTax()) + "," + Integer.toString(order.getUserid());
			String sql = "INSERT INTO ORDERS (NUMBER,ORDERDATE,PAYMENTDATE,PAYMENT_ID,SHIPPINGDATE,STATUS,TAX,USER_ID) VALUES (" + fields +")";
			
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deleteOrder(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String query = "DELETE FROM ORDERS WHERE ORDER_ID =" + Integer.toString(id);
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
