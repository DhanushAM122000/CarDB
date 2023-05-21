package customsorting;

import java.util.Comparator;

import cardms.Car;

public class SortCarbyName implements Comparator<Car>{
	
	
	@Override
	public int compare(Car c1, Car c2) {
		return c1.getName().compareTo(c2.getName());
	}

}
