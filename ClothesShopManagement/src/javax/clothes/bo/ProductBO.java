package javax.clothes.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.clothes.dto.ProductDTO;
import javax.clothes.mapper.ProductMapper;

public class ProductBO {
	
	
	public ArrayList<ProductDTO> getProductByFilters(ProductDTO prod, String priceOrder, String sizeOrder, String quanOrder ) {
		ArrayList<ProductDTO> prods = null;
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			prods = mapper.getProductsByFilters(prod, priceOrder, sizeOrder, quanOrder);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return prods;
	}
	
	public ProductDTO getProductByID(int id) {
		ProductDTO cat = new ProductDTO();
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			cat = mapper.getProduct(id);
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
	
	public boolean addProduct(ProductDTO input) {
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			mapper.addNewProduct(input);
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
	
	public boolean updateProduct(ProductDTO input) {
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			mapper.updateProduct(input);
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
	
	public boolean deleteProduct(int id) {
		ProductMapper mapper = null;
		try {
			mapper = new ProductMapper();
			mapper.deleteProduct(id);
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
