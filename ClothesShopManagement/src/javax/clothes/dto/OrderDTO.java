package javax.clothes.dto;


public class OrderDTO {

	private int id;
	private String number;
	private String shippingDate;
	private String orderDate;
	private int tax;
	private String status;
	private String paymentDate;
	private int userid;
	private int paymentid;
	
	public OrderDTO () {
		this.number = "";
		this.tax = 0;
		this.status = "";
		this.shippingDate = "";
		this.orderDate = "";
		this.paymentDate = "";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
}
