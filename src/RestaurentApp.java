
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import exceptions.InvalidDataException;

public class RestaurentApp {

	public static void main(String[] args) {

		String order = null;
		String orderlist[] = null;
		Scanner scan = new Scanner(System.in);

		ArrayList<Menu> menulist = new ArrayList<Menu>();
		Order finalorder = new Order();
		Chef chef = new Chef();

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
			ArrayList<Menu> finalorderlist = new ArrayList<Menu>();
			int checkflag = 1;

			System.out.println("\n Enter your order by serial no seperated by comma(,)"); // taking order in a string
			order = scan.next();
			orderlist = order.split(",");

			try {

				// display the order
				for (int i = 0; i < orderlist.length; i++) {
					if (orderlist[i].length() == 1) {
						Menu m = menulist.get((int) orderlist[i].charAt(0) - 48);
						if (m.available) { // checking availability
							System.out.println(m.itemname);
							finalorderlist.add(m);
						} else
							System.out.println(m.itemname + "\t is not available");
					}

					else {
						throw new InvalidDataException();
					}
				}
			} catch (InvalidDataException e) {
				checkflag = 0;
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			if (checkflag != 0) // checking the invalid data
			{
				finalorder.add(finalorderlist);
				chef.giveorder(); 
			}
			finalorderlist.clear(); // clearing the order list for next order

		} while (true);
	}

}
