package module;

public class Vehicle {
	private int ID;
	private String title;
	private String vehicleCode;
	private float price;
	private Fuel eType;
	private int quantity;
	
	static int counter = 0;

	public int getID() {
		return ID;
	}

	public void setID() {
		ID = counter;
		counter++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title != null && title.matches("[A-Za-z 0-9]{4,40}"))
			this.title = title;
		else
			this.title = "Undefined";
	}
	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = ID+"_"+title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if(price <= 9999 && price > 0 ) {
			this.price = price;
		}
		else {
			this.price = 10000;
		}
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity > 0 && quantity <= 9999) {
			this.quantity = quantity;
		}
		else {
			this.quantity = 1;
		}
	}

	public Fuel geteType() {
		return eType;
	}

	public void seteType(Fuel eType) {
		if(eType != null ) {
			this.eType = eType;
		}
		else {
			this.eType = Fuel.not_specified;
		}
	}
	
	//Constructors
	
	public Vehicle() {
		setID();
		setTitle("Panzerkampfwagen 6");
		setPrice(99999999);
		setQuantity(1939);
		seteType(Fuel.gas);
	}
	
	public Vehicle(String title, String vehicleCode, float price, Fuel etype, int quantity){
		setID();
		setTitle(title);
		setVehicleCode(vehicleCode);
		setPrice(price);
		seteType(etype);
		setQuantity(quantity);
	}		
	
	public String toString() {
		return ID + ":" + title +  " (" + vehicleCode + ") is " + price  +  " reichsmarks for each ("  + quantity + ")"      ;    
	}
	
}






