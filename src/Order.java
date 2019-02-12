import java.util.ArrayList;

class SendOrder {
	static int orderno = 0;
	ArrayList<Menu> order = new ArrayList<Menu>();
}

public class Order {
	// make the order object
	public void add(ArrayList<Menu> finalorderlist) {
		SendOrder order = new SendOrder();

		SendOrder.orderno++;

		for (Menu m : finalorderlist) {
			order.order.add(m);
		}
		Queue.queue(order);
	}
}
