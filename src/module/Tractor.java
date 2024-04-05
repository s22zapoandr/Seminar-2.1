package module;

public class Tractor extends Vehicle{
	private String additionalTechniques;
	private boolean isOnlyLargeTires;
	
	public String getAdditionalTechniques() {
		return additionalTechniques;
	}
	public void setAdditionalTechniques(String additionalTechniques) {
		if (additionalTechniques != null && additionalTechniques.matches("[A-Za-z 0-9] {1, 20}")) {
			this.additionalTechniques = additionalTechniques;
		}
		else {
			additionalTechniques = "Undefined";
		}
	}
	public boolean isOnlyLargeTires() {
		return isOnlyLargeTires;
	}
	public void setOnlyLargeTires(boolean isOnlyLargeTires) {
		this.isOnlyLargeTires = isOnlyLargeTires;
	}
	
	public Tractor() {
		super();
		setAdditionalTechniques("Extra tires");
		setOnlyLargeTires(false);
	}
	
	public Tractor(String title,  float price, Fuel etype, int quantity, String additionalTechniques, boolean isOnlyLargeTires) {
		super(title, price, etype, quantity);
		setAdditionalTechniques(additionalTechniques);
		setOnlyLargeTires(isOnlyLargeTires);
	}
	public String toString(){
		return super.toString() + getAdditionalTechniques() + isOnlyLargeTires();
	}
	
}
