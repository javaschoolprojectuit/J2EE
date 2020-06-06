package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.clothes.dto.PaymentDTO;

public class PaymentMapper extends DBMapper {

	public PaymentMapper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentDTO resultSetMapping (ResultSet rs) {
		PaymentDTO payment = new PaymentDTO();
		try {
			payment.setActive(rs.getBoolean("ACTIVE"));
			payment.setId(rs.getInt("PAYMENT_ID"));
			payment.setType(rs.getString("TYPE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payment;
	}
	
	public ArrayList<PaymentDTO> getPaymenstByFilters (PaymentDTO payment) {
		ArrayList<PaymentDTO> payments = new ArrayList<PaymentDTO>();
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM PAYMENTS WHERE " + 
						 "TYPE LIKE '%" + payment.getType() + "%' AND " +
						 "ACTIVE = ISNULL(" + payment.isActive() + ",ACTIVE)";
			
			ResultSet rs = stmt.executeQuery(sql);
			PaymentDTO paymentdto = new PaymentDTO();
			while (rs != null && rs.next()) {
				paymentdto = resultSetMapping(rs);
				payments.add(paymentdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return payments;
	}
	
	public PaymentDTO getPaymentByID (int id) {
		PaymentDTO payment = new PaymentDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM PAYMENTS WHERE PAYMENT_ID = " + id;
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs != null && rs.next()) {
				payment = resultSetMapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return payment;
	}
	
	public boolean addPayment (PaymentDTO payment) {
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "INSERT INTO PAYMENTS (TYPE,ACTIVE) VALUES ('" + payment.getType() + "'," + payment.isActive() + ")";
			
			stmt.executeUpdate(sql);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean updatePayment (PaymentDTO payment) {
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "UPDATE PAYMENTS  SET" + 
						 "TYPE='" + payment.getType() + 
						 "', ACTIVE=" + payment.isActive() +
						 " WHERE PAYMENT_ID=" + payment.getId();
			
			stmt.executeUpdate(sql);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean deletePayment (int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "DELETE FROM PAYMENTS WHERE PAYMENT_ID=" + id;
			
			stmt.executeUpdate(sql);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
