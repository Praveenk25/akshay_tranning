
public class Chef {
	Thread chef1;
	Thread chef2;
	Thread chef3;

	Chef1 t1;

	Chef1 t2;

	Chef1 t3;

	public Chef(int i) {

	}

	public Chef() {
		super();

		t1 = new Chef1();
		chef1 = new Thread(t1);
		chef1.setName("chef1");
		chef1.setDaemon(true);
		chef1.start();

		t2 = new Chef1();
		chef2 = new Thread(t2);
		chef2.setName("chef2");
		chef2.setDaemon(true);
		chef2.start();

		t3 = new Chef1();
		chef3 = new Thread(t3);
		chef3.setName("chef3");
		chef3.setDaemon(true);
		chef3.start();

	}

	synchronized public void giveorder() {

		System.out.println("give order");
		if (t1.flag == 0)
			t1.giveNotify();
		if (t2.flag == 0)
			t2.giveNotify();
		if (t3.flag == 0)
			t3.giveNotify();
		System.out.println("order given");

	}

}
