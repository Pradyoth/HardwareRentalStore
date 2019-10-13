package ucboulder.ooad.project3.entities;

public class Concrete extends Tool{

	static final  int price = 6;
	
	static int count = 5;
	
	private  Concrete(String name,int nytNo){
		this.name = name;
		this.nytNo=nytNo;
	}
	
	public static Concrete getInstance(String name,int nytNo) {
		
		if(count > 1) {
			count--;
			return new Concrete(name,nytNo);
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
