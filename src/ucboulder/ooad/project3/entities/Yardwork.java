package ucboulder.ooad.project3.entities;

public class Yardwork extends Tool{

	static final int price = 8;
	
	static int count = 4;
	
	private Yardwork(String name,int nytNo){
		this.name=name;
		this.nytNo = nytNo;
	}
	
	public static Yardwork getInstance(String name,int nytNo) {
		
		if(count >= 1) {
			count--;
			return new Yardwork(name,nytNo);
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
