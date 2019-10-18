package ucboulder.ooad.project3.factory;


import java.util.ArrayList;

import ucboulder.ooad.project3.entities.BusinessCustomer;
import ucboulder.ooad.project3.entities.CasualCustomer;
import ucboulder.ooad.project3.entities.Customer;

import ucboulder.ooad.project3.entities.RegularCustomer;
import ucboulder.ooad.project3.entities.RentalRecord;


public class CustomerFactory {

	public static Customer getCustomer(String type,String name) {
     	
		if(type.equalsIgnoreCase("RegularCustomer")) return new RegularCustomer(name);
		if(type.equalsIgnoreCase("BusinessCustomer")) return new BusinessCustomer(name);
		if(type.equalsIgnoreCase("CasualCustomer")) return new CasualCustomer(name);
		else
		return null;
		
	}
	
}
