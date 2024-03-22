package module;

public class Buss extends Vehicle{
	public Buss(String title, String vehicleCode, float price, Fuel etype, int quantity) {
		super(title, vehicleCode, price, etype, quantity);
		// TODO Auto-generated constructor stub
	}

	private int numberOfSeats;
	private boolean hasBaggageDivision;
	 
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		if(numberOfSeats > 0 && numberOfSeats < 9999) {
			this.numberOfSeats = numberOfSeats;
		}
		else {
			this.numberOfSeats = 1;
		}
	}
	public boolean isHasBaggageDivision() {
		return hasBaggageDivision;
	}
	public void setHasBaggageDivision(boolean hasBaggageDivision) {
		this.hasBaggageDivision = hasBaggageDivision;
	}
	 
	public Buss() {
		super();
		setNumberOfSeats(10);
		setHasBaggageDivision(false);
	}
	 public String toString(){
		 
		 return super.toString() + " has " +  numberOfSeats + " seats, has baggage division - " + hasBaggageDivision;
	 }
}
