

public class Kitchen {

	public  void prepareFood() throws InterruptedException {
		
			System.out.println(Thread.currentThread().getName() + " is food preparing for " + SendOrder.orderno);
			Thread.sleep(15000);
			System.out.println(Thread.currentThread().getName() + " is food  prepared for " + SendOrder.orderno);
			
			
			if(!Queue.orderqueue.isEmpty())
			{
				Queue.orderqueue.pollFirst();
				prepareFood();
			}
				
			
		
	}

}
