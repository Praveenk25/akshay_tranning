package com.intimetec.main;


public class Kitchen {
	Thread chef1;
	Thread chef2;
	Thread chef3;

	Chef chefObject1;

	Chef chefObject2;

	Chef chefObject3;

	public Kitchen() {
		super();

		chefObject1 = new Chef();
		chef1 = new Thread(chefObject1);
		chef1.setName("chef1");
		chef1.setDaemon(true);
		chef1.start();

		chefObject2 = new Chef();
		chef2 = new Thread(chefObject2);
		chef2.setName("chef2");
		chef2.setDaemon(true);
		chef2.start();

		chefObject3 = new Chef();
		chef3 = new Thread(chefObject3);
		chef3.setName("chef3");
		chef3.setDaemon(true);
		chef3.start();

	}

	public synchronized void notifyToChef() { // notify to chef threads if they are in wait status

		if (chefObject1.flag == 0) {
			chefObject1.giveNotify();
		}
		else if (chefObject2.flag == 0) {
			chefObject2.giveNotify();
		}
		else if (chefObject3.flag == 0) {
			chefObject3.giveNotify();
		}

	}

}
