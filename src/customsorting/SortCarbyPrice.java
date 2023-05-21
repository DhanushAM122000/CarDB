package customsorting;

import java.util.Comparator;

import cardms.Car;

public class SortCarbyPrice implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		return c1.getPrice()-c2.getPrice();
		
	}
}

