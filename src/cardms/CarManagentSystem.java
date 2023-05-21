package cardms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.CarNotFoundException;
import customException.InvalidChoiceException;

import customsorting.SortCarbyColour;
import customsorting.SortCarbyId;
import customsorting.SortCarbyName;
import customsorting.SortCarbyPrice;
;

public class CarManagentSystem implements CarManagentSystemImp {

	Scanner scan=new Scanner(System.in);

	Map<String, Car> db=new LinkedHashMap<String, Car>();

	@Override
	public void addCar() {
		System.out.println("Enter car Name");
		String name=scan.next();
		System.out.println("Enter car Colour");
		String colour=scan.next();
		System.out.println("Enter car Price");
		int price=scan.nextInt();


		Car c=new Car(name,colour,price);
		db.put(c.getId(), c);
		System.out.println("Car Record Inserted Sucessfuely");
		System.out.println("Car Id is "+c.getId());

	}

	@Override
	public void displayCar() {
		System.out.println("Enter car  id");
		String id=scan.next();
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			Car c=db.get(id);
			System.out.println("Id: "+c.getId());
			System.out.println("Name: "+c.getName());
			System.out.println("Colour: "+ c.getColer());
			System.out.println("Price: "+c.getPrice());
		}
		else {
			try {
				throw new CarNotFoundException("Car not found by this id");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());


			}
		}


	}

	@Override
	public void displayAllCars() {
		if(db.size()!=0) {
			System.out.println("Car Detailes as follows");
			System.out.println("----------------------------------------");

			Set<String>keys=db.keySet();
			for(String key:keys) {
				Car values=db.get(key);
				System.out.println(values);
			} 
		}
		else {
			try {
				throw new CarNotFoundException("car not found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}


	@Override
	public void removeCar() {
		System.out.println("Enter car Id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Car Record Found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("car record deleted Sucessfully");
		}
		else {
			try {
				throw new CarNotFoundException("car not found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}

	}

	@Override
	public void removeAllCars() {
		if(db.size()!=0) {
			System.out.println("car detailes are avaliable "+db.size());
			db.clear();
			System.out.println("car Detailes Sucessfully");
			System.out.println("car detailes are avaliable "+db.size());


		}
		else {
			try {
				throw new CarNotFoundException("car not found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}

	}

	@Override
	public void updateCar() {
		System.out.println("Enter car id");
		String id=scan.next();
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			Car c=db.get(id); 
			System.out.println("1.Updatr Name\n2.Update Colour\n3.Update Price ");
			System.out.println("Enter your choice");
			int choice =scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Name");
				String name=scan.next();
				c.setName(name);
				System.out.println("Car name has been updated");
				break;

			case 2:
				System.out.println("Enter Colour");
				String colour=scan.next();
				c.setColer(colour);
				System.out.println("Car colour has been updated");
				break;

			case 3:
				System.out.println("Enter Price");
				int price=scan.nextInt();
				c.setPrice(price);
				System.out.println("Car price has been updated");
				break;

			default:
				try {
					throw new InvalidChoiceException("Invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}
			}

		}


		else {

			try {
				String message="Car with the Id "+id+" is not Found";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}

	}


	@Override
	public void countCars() {
		System.out.println("No of Student Records "+db.size());

	}

	@Override
	public void sortCars() {
		if(db.size()>=2) {
			Set<String>keys=db.keySet();
			
			List<Car> list=new ArrayList<Car>();
			
			for(String key:keys) {
				list.add(db.get(key));
			}
			
			System.out.println("1.Sort by Id\n2.Sort by Name\n3.Sort by Colour\n4.Sort by Price");
			System.out.println("Enter your choice");
			int choice=scan.nextInt();
			
			switch(choice) {
			case 1:
				Collections.sort(list, new SortCarbyId() );
				display(list);
				break;
				
			case 2:
				Collections.sort(list, new SortCarbyName() );
				display(list);
				break;
				
			case 3:
				Collections.sort(list,new SortCarbyColour());
				display(list);
				break;
				
			case 4:
				Collections.sort(list, new SortCarbyPrice() );
				display(list);
				break;
				
				default:
					try {
						String message="Invalid Choice";
						throw new InvalidChoiceException(message);

					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
			}
		}
		
		else {
			try {
				String message="No Sufficient car Objects to Sort";
				throw new CarNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
		}

	}
	}
	
	private static void display(List<Car> list) {
		for(Car s: list) {
			System.out.println(s);
		}
	}

	@Override
	public void getCarsWithLowestPrice() {
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			
			List<Car>l=new ArrayList<Car>();
			
			for(String key:keys) {
				l.add(db.get(key));
				
			}
			Collections.sort(l, new SortCarbyPrice());
			System.out.println(l.get(0));
		}
		else {
			try {
				String message="No Sufficient car Objects to Compare";
				throw new CarNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void getCarsWithHigesPrice() {
		if(db.size()>=2) {
			
			Set<String> keys=db.keySet();
			
			List<Car>l=new ArrayList<Car>();
			
			for(String key:keys) {
				l.add(db.get(key));
			}
			Collections.sort(l, new SortCarbyPrice());
			System.out.println(l.get(l.size()-1));
		}
		else {
			try {
				String message="No Sufficient car Objects to Compare";
				throw new CarNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
