package ucboulder.ooad.project3.entities;

public class Yardwork extends Tool{

	static final int price = 8;
	
	static int count = 4;
	
	private Yardwork(String name){
		this.name=name;
	}
	
	public static Yardwork getInstance(String name) {
		
		if(count > 1) {
			count--;
			return new Yardwork(name);
		}
		else {
			return null;
		}
		
	}
	
}
