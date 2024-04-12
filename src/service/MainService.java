package service;

import java.util.ArrayList;
import java.util.Arrays;

import module.Bus;
import module.EnergyType;
import module.Purchase;
import module.Tractor;
import module.Vehicle;

public class MainService {

	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	private static ArrayList<Purchase> allPurchases = new ArrayList<Purchase>();
	
	public static void main(String[] args) {
		
				
		Bus bus1 = new Bus("Mercedes", 10000,  2, EnergyType.diesel, 60, true);
		Bus bus2 = new Bus("BWM", 20000,  3, EnergyType.electric, 20, false);
		
		Tractor tractor1 = new Tractor("RAM", 567532, 12, EnergyType.gas, "None", true);
		Tractor tractor2 = new Tractor("Ferrari", 54321, 2, EnergyType.petrol, "None", false);
		
		allVehicles.addAll(Arrays.asList(bus1, bus2, tractor1, tractor2));
		
		
		for(Vehicle tempV : allVehicles) {
			System.out.println(tempV.getClass().getName() + "->" + tempV);
		}
		
		
		Purchase p1 = new Purchase("12345int id67890", new ArrayList<Vehicle>(Arrays.asList(bus1)));
		Purchase p2 = new Purchase("1234567899", new ArrayList<Vehicle>(Arrays.asList(bus1, bus2, tractor1)));
		try {
			p1.addVehicleToShoppingListByVehicleCode("0_Mercedes", 1);
			p2.addVehicleToShoppingListByVehicleCode("2_Ram", 2);
			System.out.println("----------After bying--------");			
			System.out.println(p1.calculateShoppingListValue() + " eur");
			System.out.println(p2.getShoppingList());
			System.out.println("----------After deleting 1 2_RAM-------------");
			System.out.println(p2.removeOneVehicleFromShoppingList("2_Ram"));
			System.out.println(p2.getShoppingList());
		}
		
		allPurchases.addAll(Arrays.asList(p1, p2));
		
		for(Purchase tempP: allPurchases) {
			System.out.println(tempP);
		}
		System.out.println("----------------------------");
		try {
			System.out.println("GetById: " + getBusById(1));
			System.out.println("GetByCode: " + getBusByVehicleCode("1_BWM"));
			
			
			createNewBus("Audi", 24234324, 3, EnergyType.electric, 40, false);
			
			createNewBus("Mercedes", 10000,  10, EnergyType.diesel, 60, true);//2+10 = 12
			
			for(Vehicle tempV : allVehicles) {
				System.out.println(tempV.getClass().getName() + "->" + tempV);
			}
			
			
			
			System.out.println("----------After update----------");
			updateBusById(1, 100.99f, 5, EnergyType.diesel,4);
			for(Vehicle tempV : allVehicles) {
				System.out.println(tempV.getClass().getName() + "->" + tempV);
			}
			deleteBusByID(0);
			for(Vehicle tempV : allVehicles) {
				System.out.println(tempV.getClass().getName() + "->" + tempV);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		

	}
	
	public static Bus getBusById(int id) throws Exception{
		if(id < 0 ) throw new Exception("Id should be positive");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getId() == id)
			{
				return (Bus)tempV;
			}
		}
		
		throw new Exception("There is no bus with this id");
		
	}
	
	public static Bus getBusByVehicleCode(String code) throws Exception{
		if(code == null ) throw new Exception("Problems with arguments");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getCode().equals(code))
			{
				return (Bus)tempV;
			}
		}
		
		throw new Exception("There is no bus with this code");
		
	}
	
	
	public static void createNewBus(String title, float price, int quantity, EnergyType type, int numberOfSeats, boolean hasBaggageDivision) throws Exception
	{
		//TODO verify all input params
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && (tempV.getTitle().equals(title) && tempV.getEnergyType().equals(type)
					&& ((Bus)tempV).getNumberOfSeats() == numberOfSeats ))
			{
				tempV.setQuantity(tempV.getQuantity()+quantity);
				
				System.out.println("This bus is already in the system. The quantity will be increased");
				return;
			}
		}
		
		Bus newBus = new Bus(title, price, quantity, type, numberOfSeats, hasBaggageDivision);
		allVehicles.add(newBus);

	}
	public static void updateBusById(int id, float price, int quantity, EnergyType type, int numberOfSeats)throws Exception {
		//TODO do validations of input params
		
		for(Vehicle tempV: allVehicles) {
			if(tempV.getId() == id && tempV instanceof Bus)
			{
					Bus tempBus = (Bus)tempV;
					tempBus.setPrice(price);
					tempBus.setQuantity(quantity);
					tempBus.setEnergyType(type);
					tempBus.setNumberOfSeats(numberOfSeats);
					return;
				}
		}
		throw new Exception("There is no Bus with " + id + " id" );	
	}
	
	public static void deleteBusByID(int id) throws Exception {
		if(id < 0) throw new Exception("ID should be positive");
		
		for (Vehicle tempV: allVehicles) {
			if(tempV.getId() == id && tempV instanceof Bus) {
				
				allVehicles.remove(tempV);
				return;
			
			}
			else {
				throw new Exception("Bus not found");
			}
			
		}
	}
	
	
	
	

}
