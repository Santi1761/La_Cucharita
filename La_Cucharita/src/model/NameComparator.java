package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Client>{

	@Override
	public int compare(Client a, Client b) {
		
		return a.getFullName().compareTo(b.getFullName());
	}

}
