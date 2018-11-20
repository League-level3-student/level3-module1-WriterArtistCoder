package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> marmalade = new ArrayList<String>();
		//2. Add five Strings to your list
		marmalade.add("Something's jamming the system!");
		marmalade.add("I think it's a baguette.");
		marmalade.add("Is that peanut butter?");
		marmalade.add("Too orange. I think it's...");
		marmalade.add("Marmalade.");
		//3. Print all the Strings using a standard for-loop
		System.out.println("_");
		for (int i = 0; i < marmalade.size(); i++) {
			System.out.println(marmalade.get(i));
		}
		//4. Print all the Strings using a for-each loop
		System.out.println("_");
		for (String s : marmalade) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		System.out.println("_");
		for (int i = 0; i < marmalade.size(); i++) {
			if (i%2 == 1) {
				System.out.println(marmalade.get(i));
			}
		}
		//6. Print all the Strings in reverse order.
		System.out.println("_");
		for (int i = 0; i < marmalade.size(); i++) {
			System.out.println(marmalade.get(marmalade.size()-i-1));
		}
		//7. Print only the Strings that have the letter 'g' in them.
		System.out.println("_");
		for (String s : marmalade) {
			if (s.contains("g")) {
				System.out.println(s);
			}
		}
	}
}
