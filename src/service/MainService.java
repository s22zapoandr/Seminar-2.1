package service;

import java.util.ArrayList;
import java.util.Arrays;

import module.Bus;
import module.Fuel;
import module.Tractor;
import module.Vehicle;

public class MainService {
 
	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	public static void main(String[] args) {
		
		Bus bus1 = new Bus("Mercedes", 10000, Fuel.diesel, 60, 2, true);
		Bus bus2 = new Bus("Landkreuzer P. 1000 Ratte", 117100, Fuel.gas, 100, 50, true);
		
		Tractor tractor1 = new Tractor("Big Bob", 50000, Fuel.gas, 20, "Tractor tank", false);
		Tractor tractor2 = new Tractor("Leichttraktor", 10000, Fuel.diesel, 4, "Can shoot 3.7 cm missiles", true);
		
		allVehicles.addAll(Arrays.asList(bus1, bus2, tractor1, tractor2));
		
		for(Vehicle tempV : allVehicles) {
			System.out.println(tempV.getClass().getName() + " -> " + tempV);
		} 
	}
	public static Bus getBusById(int Id) throws Exception {
		if(Id < 0 || Id > 100000) throw new Exception("Invalid ID");
		for(Vehicle tempV : allVehicles) {
			if(tempV.getID() == Id) {
				return (Bus)tempV;
				
			}
		}
		
		throw new Exception("No such bus found");
	}
	public static Bus getBusByVehicleCode(String vehicleCode) throws Exception{
		if(!vehicleCode.matches ("[A-Za-z 0-9] {1, 20}")) throw new Exception("Invalid code");
		for(Vehicle tempV : allVehicles) {
			if(tempV instanceof Bus && tempV.getVehicleCode().equals(vehicleCode)) {
				return (Bus) tempV;
			}
			
		}
		throw new Exception("No such bus found");
	}
	
	public static void createNewBus(String title, float price, Fuel etype, int quantity,int numberOfSeats, boolean hasBaggageDivision) throws Exception{
		if(!title.matches("[A-Za-z )-9]") || 0 > price || price > 100000) throw new Exception ("Invalid title or price");
		for(Vehicle tempV : allVehicles) {
			if(tempV instanceof Bus && (tempV.getTitle().equals(title) && tempV.geteType().equals(etype) && ((Bus)tempV).getNumberOfSeats() == numberOfSeats))
			{
				tempV.setQuantity(tempV.getQuantity()+quantity);
				System.out.println("The bus is already in system. The quantity will be increased");
				return; 
				
			}
			Bus newBus = new Bus(title, price,etype, quantity,numberOfSeats, hasBaggageDivision);
			allVehicles.add(newBus);
		}
	}
	public static ArrayList<Bus> getAllBusses(){
		ArrayList <Bus> AllBuses = new ArrayList<Bus>();
		for(Vehicle tempV : allVehicles) {
			if(tempV instanceof Bus) {
				AllBuses.add((Bus) tempV);
			}
		}
		return AllBuses;
	}

}
