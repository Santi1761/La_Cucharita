package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String orderStatus;
	private String listOfProducts;
	private String observations;
	private ArrayList<Products> orderProducts;
	private int[] amountPerProducts;
	private Employee orderEmployee;
	private Client orderClient;
	private String[] statusOrder={"SOLICITADO", "ENPROCESO", "ENVIADO", "ENTREGADO", "CANCELADO"};
	private String currentStatus;
	private LocalDateTime date; 
	private DateTimeFormatter dtf;
	private String dateString;
	
	
	public Order(String code, String observations, String name, String lastName, String identification, String currentStatus,String clientName, String clientLastName, String clientIdentification, String clientAdvices, String clientPhoneNumber, String clientAdress) {
		code=setCode();
		this.code=code;
		this.observations=observations;
		orderProducts=new ArrayList<Products>();
		amountPerProducts=new int[orderProducts.size()];
		orderEmployee=new Employee(name, lastName, identification);
		orderClient=new Client(clientName, clientLastName, clientIdentification, clientAdvices, clientPhoneNumber, clientAdress);
		this.currentStatus=statusOrder[0];
		date=LocalDateTime.now();
		dtf=DateTimeFormatter.ofPattern("MMMM dd, YYYY:HH:mm");
		dateString=dtf.format(date);
	}
		
		
	
	

	
	public LocalDateTime getLocalDateTime() {
		return date;
	}
	
	public DateTimeFormatter getDateTimeFormatter() {
		return dtf;
	}
	
	public String getDateString() {
		return dateString;
	}
	
	public String getCode() {
		return code;
	}

	public String setCode() {
		code="Order"+(int)Math.random()*99999+"";
		return code;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setCondition(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(String listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public int[] getAmountPerProducts() {
		return amountPerProducts;
	}
	//recordar que la cantidad por producto se va a llenar al momento en que trabajemos con la interfaz
	//La interfaz va a retornar una cantidad por cada producto y esta se va a guardar en el array
	public void setAmountPerProducts(int[] amountPerProduct) {
		amountPerProduct=new int[orderProducts.size()];
	}
	public ArrayList<Products> getProducts(){
		return orderProducts;
	}
	//Igualmente los products tomaras
	public void setOrderProducts(ArrayList<Products> orderProducts) {
		this.orderProducts=orderProducts;
	}
	public Employee getOrderEmployee() {
		return orderEmployee;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	//
	public String setCurrentStatus(int indicator, String currentStatus) {
		switch(indicator) {
		
		case 1: 
			currentStatus=statusOrder[0];
			break;
		case 2:
			currentStatus=statusOrder[1];
			break;
		case 3: 
			currentStatus=statusOrder[2];
			break;
		case 4:
			currentStatus=statusOrder[3];
			break;
		case 5:
			currentStatus=statusOrder[4];
			break;
		}
		return currentStatus;
	}
	
	public String getInformation(String separator) {
		String temp="";
		temp=orderClient.getFullName()+separator+orderClient.getAdress()+separator+orderClient.getPhoneNumber()+separator+observations+separator+orderEmployee.getName()+separator+currentStatus;
		return temp;
		
	}
	
	public String getOrderProductsInformation(String separator) {
		String temp="";
				for(int i=0;i<orderProducts.size();i++) {
					
						temp+=orderProducts.get(i).getName()+separator+amountPerProducts[i]+separator+orderProducts.get(i).getPrice();
				}
				return temp;
	}
	
	public String getEmployeeInformation(String separator) {
		String temp="";
		for(int i=0;i<orderProducts.size();i++) {
			temp+=orderEmployee.getFullName()+separator+orderEmployee.getIdentification()+separator;
		}
		return temp;
	}
	
	public String getProductsInformation(String separator) {
		String temp="";
		for(int i=0;i<orderProducts.size();i++) {
			temp+=orderProducts.get(i).getName()+separator+orderProducts.get(i).getType()+separator+orderProducts.get(i).getAllIngredients(separator)+
					separator+orderProducts.get(i).getPrice()+separator;
		}
		return temp;
	}
	
	public double orderPrize() {
		double a=0;
		String b="ENTREGADO";
		for(int i=0;i<orderProducts.size();i++) {
				if(b.equalsIgnoreCase(currentStatus)) {
					a+=orderProducts.get(i).getPrice();
				}
			}
		return a;
		
	}
	
	
	
	
}
