package customsorting;

import java.util.Comparator;

import cardms.Car;

public class SortCarbyColour implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		return c1.getColer().compareTo(c2.getColer());
	}

}
