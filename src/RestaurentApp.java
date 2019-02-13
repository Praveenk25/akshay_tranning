
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import exceptions.InvalidDataException;

public class RestaurentApp {

	public static void main(String[] args) {

		String userorder = null;
		String userorderlist[] = null;
		Scanner scan = new Scanner(System.in);

		ArrayList<Menu> menulist = new ArrayList<Menu>();
		PrepareOrder prepareorder = new PrepareOrder();
		Kitchen waiter = new Kitchen();

		Menu item1 = new Menu("Paneer butter Masala", true); // creating item of menu
		Menu item2 = new Menu("Chana Masala", true);
		Menu item3 = new Menu("Sev tamater", true);
		Menu item4 = new Menu("Besan Gutta", true);
		Menu item5 = new Menu("Cauliflower (Gobi)", false);
		Menu item6 = new Menu("Malai Methi", false);
		Menu item7 = new Menu("Aloo Pyaj Paraatha", true);
		Menu item8 = new Menu("Gobi Paratha", false);
		Menu item9 = new Menu("Tandoor Roti", true);
		Menu item10 = new Menu("Tava Roti", true);

		menulist.add(item1); // add item into menu list
		menulist.add(item2);
		menulist.add(item3);
		menulist.add(item4);
		menulist.add(item5);
		menulist.add(item6);
		menulist.add(item7);
		menulist.add(item8);
		menulist.add(item9);
		menulist.add(item10);

		Collections.sort(menulist); // sorting the list in alphabetic order

		for (Menu item : menulist) { // print menu list on console
			System.out.print(menulist.indexOf(item) + "\t");
			System.out.println(item + "\n");
		}

		do {
			ArrayList<Menu> orderlist = new ArrayList<Menu>();
			int flag = 1;

			System.out.println("\n Enter your order by serial no seperated by comma(,)"); // taking order in a string
			userorder = scan.next();
			userorderlist = userorder.split(",");

			try {

				
				for (int i = 0; i < userorderlist.length; i++) {
					if (userorderlist[i].length() == 1) { // check first input data is valid or not
						Menu m = menulist.get((int) userorderlist[i].charAt(0) - 48);
						if (m.available) { // checking availability
							orderlist.add(m);
						} else {
							System.out.println(m.itemname + "\t is not available");
							flag = 0; // change the flag status
						}
					}

					else {
						throw new InvalidDataException();
					}
				}
			} catch (InvalidDataException e) {
				flag = 0;
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			if (flag != 0) // checking the flag status
			{
				System.out.println("your order is\t" + orderlist); // print the order list
				prepareorder.add(orderlist); // sending the order list to prepare the order object and add into the
												// order queue
				waiter.notifyToChef();
			}
			orderlist.clear(); // clearing the order list for next order

		} while (true);

	}

}
