
public class PrepareFood {

	public void prepareFood(Order order) throws InterruptedException {

		System.out.println( Thread.currentThread().getName() + " is Food preparing for : " + order.orderno);
		Thread.sleep(15000);
		System.out.println( Thread.currentThread().getName() +" is prepared food for : " + order.orderno);

		if (!Queue.orderqueue.isEmpty()) {
			order = Queue.orderqueue.pollFirst();
			prepareFood(order);
		}

	}

}
