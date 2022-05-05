package co.com.nttdata.platform.crosscutting.payload;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GetUserPayload {

	@Min(value=1, message = "min value is 1")
	@Max(value=2, message = "max values is 2")
	private int typeDocument;
	
	@NotNull(message="idDocument is a required field")
	@NotEmpty(message="idDocument is a required field")
	private String idDocument;	
	
	public GetUserPayload() {
		super();
	}

	public int getTypeDocument() {
		return typeDocument;
	}
	
	public String getIdDocument() {
		return idDocument;
	}
	
	public void setTypeDocument(int typeDocument) {
		this.typeDocument = typeDocument;
	}

	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}


}
