package module;

public class Bus extends Vehicle{

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
	 
	public Bus() {
		super();
		setNumberOfSeats(10);
		setHasBaggageDivision(false);
	}
	
	public Bus(String title, float price, Fuel etype, int quantity,int numberOfSeats, boolean hasBaggageDivision) {
		super(title, price, etype, quantity);
		setNumberOfSeats(numberOfSeats);
		setHasBaggageDivision(hasBaggageDivision);
		// TODO Auto-generated constructor stub
	}

	 public String toString(){
		 
		 return super.toString() + " has " +  numberOfSeats + " seats, has baggage division - " + hasBaggageDivision;
	 }
}
