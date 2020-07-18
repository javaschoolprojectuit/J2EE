package javax.clothes.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.clothes.dto.OrderDTO;
import javax.clothes.mapper.OrderMapper;

public class OrderBO {
	public ArrayList<OrderDTO> getOrdersByFilters(OrderDTO order) {
		ArrayList<OrderDTO> cats = null;
		OrderMapper mapper = null;
		try {
			mapper = new OrderMapper();
			cats = mapper.getOrdersByFilters(order);
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
	
	public ArrayList<OrderDTO> getOrdersByOrderDate(String start, String end) {
		ArrayList<OrderDTO> cats = null;
		OrderMapper mapper = null;
		try {
			mapper = new OrderMapper();
			cats = mapper.getOrdersByOrderDate(start, end);
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
	
	public OrderDTO getOrderByID(int id) {
		OrderDTO cat = new OrderDTO();
		OrderMapper mapper = null;
		try {
			mapper = new OrderMapper();
			cat = mapper.getOrderById(id);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return cat;
	}
	
	public boolean addOrder(OrderDTO input) {
		OrderMapper mapper = null;
		try {
			mapper = new OrderMapper();
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
	
	public boolean updateOrder(OrderDTO input) {
		OrderMapper mapper = null;
		try {
			mapper = new OrderMapper();
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
		OrderMapper mapper = null;
		try {
			mapper = new OrderMapper();
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
	}
}
