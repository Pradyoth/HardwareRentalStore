package ucboulder.ooad.project3.entities;

public class Woodwork extends Tool{

	static final int price = 8;
	
	static int count = 5;
	
	private Woodwork(String name){
		this.name=name;
	}
	
	public static Woodwork getInstance(String name) {
		
		if(count > 1) {
			count--;
			return new Woodwork(name);
		}
		else {
			return null;
		}
		
	}
	
}
