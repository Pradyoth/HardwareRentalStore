package ucboulder.ooad.project3.Test;

import junit.framework.TestCase;
import ucboulder.ooad.project3.decorator.AddOnDecorator;
import ucboulder.ooad.project3.entities.AccessoryKit;
import ucboulder.ooad.project3.entities.BusinessCustomer;
import ucboulder.ooad.project3.entities.CasualCustomer;
import ucboulder.ooad.project3.entities.Concrete;
import ucboulder.ooad.project3.entities.Customer;
import ucboulder.ooad.project3.entities.ExtensionCord;
import ucboulder.ooad.project3.entities.Painting;
import ucboulder.ooad.project3.entities.Plumbing;
import ucboulder.ooad.project3.entities.ProtectiveGearPack;
import ucboulder.ooad.project3.entities.RegularCustomer;
import ucboulder.ooad.project3.entities.RentalRecord;
import ucboulder.ooad.project3.entities.Tool;
import ucboulder.ooad.project3.entities.Woodwork;
import ucboulder.ooad.project3.entities.Yardwork;
import ucboulder.ooad.project3.factory.CustomerFactory;
import ucboulder.ooad.project3.factory.ToolFactory;

public class TestClasses extends TestCase{
	
	Tool  t;
	
	protected void setUp(){
		
	   }

	public void test_1(){
		assertTrue(ToolFactory.getTool("Concrete","ConcreteTool 1", 3) instanceof Concrete && 
				ToolFactory.getTool("Painting","PaintingTool 1", 3) instanceof Painting &&
				ToolFactory.getTool("Plumbing","PlumbingTool 1", 3) instanceof Plumbing &&
				ToolFactory.getTool("Woodwork","WoodworkTool 1", 3) instanceof Woodwork &&
				ToolFactory.getTool("Yardwork","YardworkTool 1", 3) instanceof Yardwork &&
				ToolFactory.getTool("Yardhjsjdbwork","RandomTool 1", 3)==null);
	   }
	
	
	  public void test_2(){
		  
		  assertTrue(ToolFactory.getAddOnTool("AccessoryKit","AccessoryKit 1",t, 3)
		    instanceof AccessoryKit &&
		    ToolFactory.getAddOnTool("ExtensionCord","ExtensionCord 1",t, 3) instanceof
		    ExtensionCord &&
		    ToolFactory.getAddOnTool("ProtectiveGearPack","ProtectiveGearPack 1",t, 3)
		    instanceof ProtectiveGearPack &&
		    ToolFactory.getAddOnTool("Yardhjsjdbwork","RandomTool 1",t, 3)==null);
		  }
	 
	   
	
	public void test_3(){
		
		int before = Concrete.count;
		Concrete.getInstance("Concrete Tool", 3);
	    assertTrue((before-1) == Concrete.count);
	   }
	
	public void test_4(){
	      Tool t1 = ToolFactory.getTool("Yardwork","YardworkTool 1", 3) ;
	      AddOnDecorator dc = (AddOnDecorator) ToolFactory.getAddOnTool("ProtectiveGearPack","ProtectiveGearPack 1",t1, 3) ;
	      RentalRecord rr = new RentalRecord(3);
	      rr.addDocoratedTools(dc);
	    //  System.out.println(rr.getTotalPrice());
	      assertTrue(rr.getTotalPrice() == 8*3+25);
	   }
	
	public void test_5(){
		Tool t1 = ToolFactory.getTool("Yardwork","YardworkTool 1", 3) ;
	      AddOnDecorator dc = (AddOnDecorator) ToolFactory.getAddOnTool("ProtectiveGearPack","ProtectiveGearPack 1",t1, 3) ;
	      RentalRecord rr = new RentalRecord(3);
	      rr.addDocoratedTools(dc);
	      int countBeforeReturing = Yardwork.count;
	      rr.returnRental();
	      int countAfterReturning = Yardwork.count;
	      assertTrue(countBeforeReturing+1 == countAfterReturning);
	   }
	
	public void test_6(){
	      
		  Tool t1 = ToolFactory.getTool("Plumbing","Plumbing Tool 1", 3) ;
	      AddOnDecorator dc = (AddOnDecorator) ToolFactory.getAddOnTool("ExtensionCord","ExtensionCord 1",t1, 3) ;
	      
	      int price = dc.getPrice();
	      
	      assertTrue(price == 7*3+16);
		
	   }
	
	public void test_7(){
		Tool t1 = ToolFactory.getTool("Woodwork","Woodwork Tool 1", 3) ;
		assertTrue(t1.getPrice()==Woodwork.price*3);
	   }
	
	public void test_8(){
		assertTrue(CustomerFactory.getCustomer("RegularCustomer","Regular Customer 1") instanceof RegularCustomer && 
				CustomerFactory.getCustomer("BusinessCustomer","Business Customer 1") instanceof BusinessCustomer &&
				CustomerFactory.getCustomer("CasualCustomer","Casual Customer 1") instanceof CasualCustomer &&
				CustomerFactory.getCustomer("Yardhjsjdbwork","Random Cutomser 1")==null);  
		
	   }
	
	public void test_9(){
		int before = Painting.count;
		Painting.getInstance("Painting Tool", 3);
	    assertTrue((before-1) == Painting.count);
	   }
	
	public void test_10(){
		
		  Tool t1 = ToolFactory.getTool("Plumbing","Plumbing Tool 1", 3) ;
	      AddOnDecorator dc = (AddOnDecorator) ToolFactory.getAddOnTool("ExtensionCord","ExtensionCord 1",t1, 3) ;
	      
	      Tool t2 = ToolFactory.getTool("Woodwork","Woodwork Tool 1", 3) ;
	      AddOnDecorator dc2 = (AddOnDecorator) ToolFactory.getAddOnTool("AccessoryKit","AccessoryKit 1",t2, 3) ;
	      
	      Customer c = CustomerFactory.getCustomer("BusinessCustomer","Business Customer 1");
	      
	      RentalRecord rr = new RentalRecord(3);
	      rr.addDocoratedTools(dc);
	      
	      RentalRecord rr2 = new RentalRecord(3);
	      rr2.addDocoratedTools(dc2);
	      
	      c.addRentalRecord(rr);
	      c.addRentalRecord(rr2);
	      
	     assertTrue(c.getNumberOfToolsRented()==2);
	      
	      
	   }
	
}
