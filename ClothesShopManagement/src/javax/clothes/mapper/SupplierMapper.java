package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.clothes.dto.SupplierDTO;

public class SupplierMapper extends DBMapper {

	public SupplierMapper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SupplierDTO resultSetMapping(ResultSet rs) {
		SupplierDTO temp = new SupplierDTO();
		try {
			temp.setId(rs.getInt("SUPPLIER_ID"));
			temp.setName(rs.getString("NAME"));
			temp.setAddress(rs.getString("ADDRESS"));
			temp.setCity(rs.getString("CITY"));
			temp.setDistrict(rs.getString("DISTRICT"));
			temp.setEmail(rs.getString("EMAIL"));
			temp.setPhone(rs.getString("PHONE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	public ArrayList<SupplierDTO> getSuppliersByFilters (SupplierDTO supp) {
		ArrayList<SupplierDTO> supplist = new ArrayList<SupplierDTO>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM SUPPLIERS WHERE " +
							"NAME LIKE '%" + supp.getName() + "%'" + " AND " +
							"ADDRESS LIKE '%" + supp.getAddress() + "%'" + " AND " +
							"CITY LIKE '%" + supp.getCity() + "%'" + " AND " +
							"DISTRICT LIKE '%" + supp.getDistrict() + "%'" + " AND " +
							"EMAIL LIKE '%" + supp.getEmail() + "%'" + " AND " +
							"PHONE LIKE '%" + supp.getPhone() + "%'" ;
			ResultSet rs = stmt.executeQuery(sqlStr);
			
			while (rs != null && rs.next()) {
				SupplierDTO temp = new SupplierDTO(); 
				temp = resultSetMapping(rs);
				supplist.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplist;
	}
	
	public SupplierDTO getSupplierById (int id) {
		SupplierDTO supp = new SupplierDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM SUPPLIERS WHERE SUPPLIER_ID = " + Integer.toString(id);
			ResultSet rs = stmt.executeQuery(sqlStr);
			supp = resultSetMapping(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return supp;
	}
	
	public void addSupplier(SupplierDTO supp) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "INSERT INTO SUPPLIERS (NAME,ADDRESS,CITY,DISTRICT,EMAIL,PHONE) VALUES ('" + 
							supp.getName() + "','" + supp.getAddress() + "','" + 
							supp.getCity() + "','" + supp.getDistrict() + "','" + 
							supp.getEmail() + "','" + supp.getPhone() +"')";
			stmt.executeUpdate(sqlStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSupplier(SupplierDTO supp) {
		try {
			Statement stmt = getConnection().createStatement();
			String fields = "NAME = '" + supp.getName() + "'," +
							"ADDRESS = '" + supp.getAddress() + "'," +
							"CITY = '" + supp.getCity() + "'," +
							"DISTRICT = '" + supp.getDistrict() + "'," +
							"EMAIL = '" + supp.getEmail() + "'," +
							"PHONE = '" + supp.getPhone() + "'";
			String sqlStr = "UPDATE SUPPLIERS SET " + fields + 
							" WHERE ROLE_ID=" + Integer.toString(supp.getId());
			stmt.executeUpdate(sqlStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSupplier(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "DELETE FROM SUPPLIERS WHERE SUPPLIER_ID = " + Integer.toString(id);
			stmt.executeUpdate(sqlStr);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
