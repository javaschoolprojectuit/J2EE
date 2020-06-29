package javax.clothes.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.clothes.dto.OrderDetailDTO;
import javax.clothes.mapper.OrderDetailMapper;

public class OrderDetailBO {
	public ArrayList<OrderDetailDTO> getOrderDetail(int orderId) {
		ArrayList<OrderDetailDTO> cats = null;
		OrderDetailMapper mapper = null;
		try {
			mapper = new OrderDetailMapper();
			cats = mapper.getOrderDetail(orderId);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return cats;
	}
	
	/*public boolean addOrder(OrderDetailDTO input) {
		OrderDetailMapper mapper = null;
		try {
			mapper = new OrderDetailMapper();
			mapper.addOrder(input);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return true;
	}
	
	public boolean updateOrder(OrderDetailDTO input) {
		OrderDetailMapper mapper = null;
		try {
			mapper = new OrderDetailMapper();
			mapper.updateOrder(input);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return true;
	}
	
	public boolean deleteOrder(int id) {
		OrderDetailMapper mapper = null;
		try {
			mapper = new OrderDetailMapper();
			mapper.deleteOrder(id);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return false;
	}*/
}
