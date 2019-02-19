package com.intimetec.main;
import com.intimetec.interfaceOfRestaurentapp.IntimetecRestaurent;

public class Kitchen {
	Thread chef1;
	Thread chef2;
	Thread chef3;

	Chef chefobject1;

	Chef chefobject2;

	Chef chefobject3;

	public Kitchen() {
		super();

		chefobject1 = new Chef();
		chef1 = new Thread(chefobject1);
		chef1.setName("chef1");
		chef1.setDaemon(true);
		chef1.start();

		chefobject2 = new Chef();
		chef2 = new Thread(chefobject2);
		chef2.setName("chef2");
		chef2.setDaemon(true);
		chef2.start();

		chefobject3 = new Chef();
		chef3 = new Thread(chefobject3);
		chef3.setName("chef3");
		chef3.setDaemon(true);
		chef3.start();

	}

	public synchronized void notifyToChef() { // notify to chef threads if they are in wait status

		if (chefobject1 instanceof IntimetecRestaurent && chefobject1.flag == 0)
			chefobject1.giveNotify();
		else if (chefobject2 instanceof IntimetecRestaurent && chefobject2.flag == 0)
			chefobject2.giveNotify();
		else if (chefobject3 instanceof IntimetecRestaurent && chefobject3.flag == 0)
			chefobject3.giveNotify();

	}

}
