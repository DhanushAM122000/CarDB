package customException;

public class CarNotFoundException extends Exception {
 private String message;

 	public CarNotFoundException(String message){
 		this.message=message;
 	}
 	
 	public String getMessage() {
 		return message;
 	}
}
