package ucboulder.ooad.project3.entities;

public class Plumbing extends Tool{

	static final int price = 7;
	
	static int count = 5;
	
	private Plumbing(String name){
		this.name=name;
	}
	
	public static Plumbing getInstance(String name) {
		
		if(count > 1) {
			count--;
			return new Plumbing(name);
		}
		else {
			return null;
		}
		
	}
	
}
