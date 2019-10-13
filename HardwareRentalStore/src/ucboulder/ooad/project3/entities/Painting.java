package ucboulder.ooad.project3.entities;

public class Painting extends Tool{

	public static final int price = 5;
	
	public static int count = 5;
	
	private Painting(String name,int nytNo){
		this.name=name;
		this.nytNo=nytNo;
	}
	
	public static Painting getInstance(String name,int nytNo) {
		
		if(count > 1) {
			count--;
			return new Painting(name,nytNo);
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public int getPrice() {
		
		return price*nytNo;
	}
	
	@Override
	public void increaseCount() {
		
		 count = count+1;
	}
	
}
