package com.intimetec.main;

public class Chef extends PrepareFood implements Runnable {
	Order order = null;
	int flag = 0;

	public void run() {
		try {
			goWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void order() throws InterruptedException {
		order = Queue.orderQueue.pollFirst();// pulling the order object
		if (order != null) {
			prepareFood(order);
		}
		goWait();
	}

	public synchronized void goWait() throws InterruptedException {
		flag = 0;
		wait();
		flag = 1;
		order();
	}

	public synchronized void giveNotify() {
		notify();
	}
}