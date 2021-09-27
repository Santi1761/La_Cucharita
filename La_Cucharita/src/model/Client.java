package model;

import java.io.Serializable;

public class Client extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String adress;
	private String phoneNumber;
	private String advices;
	private String fullname;
	
	public Client (String name, String lastName, String identification, String advices, String phoneNumber, String adress) {
		super(name, lastName, identification);
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.advices = advices; 
		fullname=name+lastName;
	}
		public String getFullName() {
			return fullname;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress=adress;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber=phoneNumber;
		}
		public String getAdvices() {
			return advices;
		}
		public void setAdvices(String advices) {
			this.advices=advices;
		}
		
	@Override
	public String getInformation() {
		String a="";
		a+= getName()+" "+getLastName()+" "+getIdentification()+" "+adress+" "+phoneNumber+" "+advices+" ";
		return a;
		
		
	}
		
}
