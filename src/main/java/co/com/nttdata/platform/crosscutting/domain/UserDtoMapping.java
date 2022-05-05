package co.com.nttdata.platform.crosscutting.domain;

public class UserDtoMapping {

	public UserDtoMapping() {
		super();
	}
	
	private String firtsName;
	
	private String secondName;
	
	private String lastName;
	
	private String secondLastName;
	
	private int typeDocument;
	
	private String idDocument;
	
	public String getFirtsName() {
		return firtsName;
	}
	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public int getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(int typeDocument) {
		this.typeDocument = typeDocument;
	}
	public String getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}	
}
