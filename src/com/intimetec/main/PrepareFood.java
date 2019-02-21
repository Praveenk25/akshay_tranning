package com.intimetec.main;

public class PrepareFood {

	public void prepareFood(Order order) throws InterruptedException {

		System.out.println(Thread.currentThread().getName() + " is Food preparing for : " + order.orderNo);
		Thread.sleep(15000);
		System.out.println(Thread.currentThread().getName() + " is prepared food for : " + order.orderNo);

		if (!Queue.orderQueue.isEmpty()) {
			order = Queue.orderQueue.pollFirst();
			prepareFood(order);
		}

	}

}
