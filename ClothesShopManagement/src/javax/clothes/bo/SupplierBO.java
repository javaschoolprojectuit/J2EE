package javax.clothes.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.clothes.dto.SupplierDTO;
import javax.clothes.mapper.SupplierMapper;

public class SupplierBO {
	public ArrayList<SupplierDTO> getSuppliersByFilters(SupplierDTO input) {
		ArrayList<SupplierDTO> suppliers = null;
		SupplierMapper mapper = null;
		try {
			mapper = new SupplierMapper();
			suppliers = mapper.getSuppliersByFilters(input);
		} catch (Exception ex) {
			Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return suppliers;
	}

	public SupplierDTO getSupplierById(int id) {
		SupplierDTO supplier = null;
		SupplierMapper mapper = null;
		try {
			mapper = new SupplierMapper();
			supplier = mapper.getSupplierById(id);
		} catch (Exception ex) {
			Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return supplier;
	}

	public void addSupplier(SupplierDTO input) {
		SupplierMapper mapper = null;
		try {
			mapper = new SupplierMapper();
			mapper.addSupplier(input);
		} catch (Exception ex) {
			Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void updateSupplier(SupplierDTO input) {
		SupplierMapper mapper = null;
		try {
			mapper = new SupplierMapper();
			mapper.updateSupplier(input);
		} catch (Exception ex) {
			Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(SupplierBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
