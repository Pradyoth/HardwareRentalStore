package ucboulder.ooad.project3.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

	String name;
	List<RentalRecord> rr = new ArrayList<RentalRecord>();
	
	public void addRentalRecord(RentalRecord rentalRecord) {
		rr.add(rentalRecord);
	}
	public List<RentalRecord> getRentalRecordList(){
		return rr;
	}
	public int getNumberOfToolsRented() {
		int sum = 0;
		for (int i = 0; i < rr.size() ; i++) {
			
			sum += rr.get(i).getDocoratedTools().size();
		}
		return sum;
	}
	public String getCustomerName() {
		return this.name;
	}
}
