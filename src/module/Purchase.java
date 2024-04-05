package module;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Purchase {
	private String userCardNr;
	private ArrayList<Vehicle> shoppingList = new ArrayList<Vehicle>();
	private LocalDateTime dateTime= LocalDateTime.now();
	public String getUserCardNr() {
		return userCardNr;
	}
	public void setUserCardNr(String userCardNr) {
		if(userCardNr != null  && userCardNr.matches("[0-9]{1,20}"))
			this.userCardNr = userCardNr;
		else
			this.userCardNr = "000000000";
	}
	public ArrayList<Vehicle> getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ArrayList<Vehicle> shoppingList) {
		if(userCardNr != null)
			this.shoppingList = shoppingList;
		else
			this.shoppingList = new ArrayList<Vehicle>();
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	// Constructors
	public Purchase() {
		setUserCardNr("asd");
	}
	
	public Purchase(String userCardNr, ArrayList<Vehicle> shoppingList, LocalDateTime dateTime) {
		setUserCardNr(userCardNr);
	}
	// toString
	@Override
	public String toString() {
		return "Purchase [userCardNr=" + userCardNr + ", shoppingList=" + shoppingList + ", dateTime=" + dateTime + "]";
	}
}