package model;

import java.util.Comparator;

public class DateComparator implements Comparator<Order> {

	@Override
	public int compare(Order a, Order b) {
		
		return a.getLocalDateTime().compareTo(b.getLocalDateTime());
	}

}
