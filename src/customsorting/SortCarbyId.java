package customsorting;

import java.util.Comparator;

import cardms.Car;

public class SortCarbyId implements Comparator<Car>{

	@Override
	public int compare(Car c1, Car c2) {
		
		return c1.getId().compareTo(c2.getId());
	}
	

}
