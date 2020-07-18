package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.clothes.dto.ProductDTO;

public class ProductMapper extends DBMapper{

	public ProductMapper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductDTO resultSetMapping(ResultSet rs) {
		ProductDTO temp = new ProductDTO();
		try {
			temp.setCatId(rs.getInt("CAT_ID"));
			temp.setDeleted(rs.getBoolean("DELETED"));
			temp.setDescription(rs.getString("DESCRIPTION"));
			temp.setId(rs.getInt("PROD_ID"));
			temp.setImage(rs.getString("IMAGE"));
			temp.setName(rs.getString("NAME"));
			temp.setPrice(rs.getInt("PRICE"));
			temp.setQuantity(rs.getInt("QUANTITY"));
			temp.setSize(rs.getInt("SIZE"));
			temp.setSuppId(rs.getInt("SUPPLIER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	
	/**
	 * get product by id
	 * */
	
	public ProductDTO getProduct(int id) {
		ProductDTO product = new ProductDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM PRODUCTS WHERE PROD_ID=" + Integer.toString(id);
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs != null && rs.next()) {
				product = resultSetMapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	/**
	 * get product by filter: name, price, size, quantity, category, supplier and
	 * priceorder & sizeorder & quanorder must be "><="
	 * */
	
	public ArrayList<ProductDTO> getProductsByFilters (ProductDTO product, String priceOrder, String sizeOrder, String quanOrder) {
		ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
		String sizeSql = "", priceSql = "",quanSql = "";
		String catID="null", suppID="null";
		if (product.getCatId() > 0 ) {
			catID = Integer.toString(product.getCatId());
		}
		if (product.getSuppId() > 0) {
			suppID = Integer.toString(product.getSuppId());
		}
		if (!priceOrder.equals("")) {
			priceSql = " AND PRICE " + priceOrder + product.getPrice();
		}
		if (!sizeOrder.equals("")) {
			sizeSql = " AND SIZE " + sizeOrder + product.getSize();
		}
		if (!quanOrder.equals("")) {
			quanSql = " AND QUANTITY " + quanOrder + product.getQuantity();
		}
		try {
			Statement stmt = getConnection().createStatement();
			
			String sql = "SELECT * FROM PRODUCTS WHERE " + 
						 "NAME LIKE '%" + product.getName() + "%' AND " + 
						 "CAT_ID = ISNULL(" + catID + ",CAT_ID) AND " +
						 "SUPPLIER_ID = ISNULL(" + suppID + ",SUPPLIER_ID)" + 
						 priceSql + sizeSql + quanSql;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs != null && rs.next()) {
				ProductDTO prd = new ProductDTO();
				prd = resultSetMapping(rs);
				products.add(prd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public boolean addNewProduct(ProductDTO product) {
		int convertBit = 0;
		if(product.isDeleted()) convertBit = 1;
		try {
			Statement stmt = getConnection().createStatement();
			String values = "(" + product.getCatId() + ",'" + 
							product.getImage() + "','" + 
							product.getName() + "'," + 
							product.getPrice() + "," + 
							product.getQuantity() + "," + 
							product.getSize() + "," + 
							product.getSuppId() + "," + 
							convertBit + ")"; 
			String sql = "INSERT INTO PRODUCTS (CAT_ID,IMAGE,NAME,PRICE,QUANTITY,SIZE,SUPPLIER_ID,DELETED) VALUES" + values;
			
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean updateProduct (ProductDTO product) {
		int convertBit = 0;
		if(product.isDeleted()) convertBit = 1;
		try {
			Statement stmt = getConnection().createStatement();
			String values = " CAT_ID=" + product.getCatId() + ",IMAGE ='" + 
							product.getImage() + "',NAME='" + 
							product.getName() + "',PRICE=" + 
							product.getPrice() + ",QUANTITY=" + 
							product.getQuantity() + ",SIZE=" + 
							product.getSize() + ",SUPPLIER_ID=" + 
							product.getSuppId() + ", DELETED="+ convertBit; 
			String sql = "UPDATE PRODUCTS SET" + values + " WHERE PROD_ID=" + product.getId();
			
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean deleteProduct (int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "DELETE FROM PRODUCTS WHERE PROD_ID=" + id;
			
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
