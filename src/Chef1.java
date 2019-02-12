import Interface.IntimetecRestaurent;

public class Chef1 extends Kitchen implements IntimetecRestaurent, Runnable {
	int i = 0;
	int flag=0;
	public void run() {
		System.out.println(Thread.currentThread().getName() + "  is start");

		try {
			gowait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void order() throws InterruptedException {

		synchronized (this) {
			if (!Queue.orderqueue.isEmpty()) {
				Queue.orderqueue.pollFirst();
				i = 1;
			}
		}
		if (i == 1) {
			i++;
			prepareFood();
			gowait();
		} else
			gowait();
	}

	synchronized public  void gowait() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "  is going to wait");
		flag=0;
		wait();
		flag=1;
		order();
	}

	

	synchronized public void giveNotify() {
		System.out.println("notify");
		notify();
	}
}