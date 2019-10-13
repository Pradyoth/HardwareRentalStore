package ucboulder.ooad.project3.entities;

public class Concrete extends Tool{

	static final int price = 6;
	
	static int count = 5;
	
	private  Concrete(String name){
		this.name = name;
	}
	
	public static Concrete getInstance(String name) {
		
		if(count > 1) {
			count--;
			return new Concrete(name);
		}
		else {
			return null;
		}
		
	}
	
}
