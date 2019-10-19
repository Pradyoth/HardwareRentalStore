package ucboulder.ooad.project3.entities;

public class Plumbing extends Tool{

	public static final int price = 7;
	
	public static int count = 5;
	
	private Plumbing(String name,int nytNo){
		this.name=name;
		this.nytNo=nytNo;
	}
	
	//Returns an instance of this particular tool from a pool on an on-demand basis. 
		// Typically reducing the inventory count of this tool when rented.
	public static Plumbing getInstance(String name,int nytNo) {
		
		if(count > 1) {
			count--;
			return new Plumbing(name,nytNo);
		}
		else {
			return null;
		}
		
	}
	
	// Returns the rental price for this tool
	@Override
	public int getPrice() {
		
		return price*nytNo;
	}
	
	//ReStock Inventory when returned by customer
	@Override
	public void increaseCount() {
		
		 count = count+1;
	}
}
