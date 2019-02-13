import java.util.ArrayList;

class Order {
	static int ordernumber = 0;
	int orderno=0;
	ArrayList<Menu> order = new ArrayList<Menu>();
	public Order()
	{
		orderno = ++ordernumber;
	}
}

public class PrepareOrder {
	// make the order object
	public void add(ArrayList<Menu> finalorderlist) {
		Order order = new Order();

		

		for (Menu m : finalorderlist) {
			order.order.add(m);
		}
		Queue.queue(order);
	}
}
