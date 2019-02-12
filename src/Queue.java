import java.util.ArrayDeque;

public class Queue {
	public static ArrayDeque<SendOrder> orderqueue = new ArrayDeque<SendOrder>();

	public static void queue(SendOrder order) {
		orderqueue.add(order); // adding the order into the queue
		System.out.println(SendOrder.orderno + " submited in queue");
	}
}
