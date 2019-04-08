package com.intimetec.restaurant.util;

public class RestaurantUtil {

	public static String capitalizeFirstLetter(String string) {
		string = string.trim();

		string = string.toLowerCase();

		char[] str = string.toCharArray();

		if (str[0] >= 'a' && str[0] <= 'z') {
			str[0] = (char) (str[0] - 32);
		}
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				if (str[i + 1] >= 'a' && str[i + 1] <= 'z') {
					i++;
					str[i] = (char) (str[i] - 32);
				}
			}
		}

		string = "";

		for (int i = 0; i < str.length; i++) {
			string += str[i];
		}
		return string;
	}

}
