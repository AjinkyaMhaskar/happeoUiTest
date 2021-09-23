package commonFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommonStringFunctions {

	// function to remove special character from a string
	// https://stackoverflow.com/questions/7552253/how-to-remove-special-characters-from-a-string

	public static String removeSpecialChar(String Input) {
		return (Input.replaceAll("[^A-Za-z0-9]", ""));
	}

	// function to reverse string
	// I/P : ABC, O/P: CBA [Type : String]

	public static String reverseString(String s) {
		char[] s_char = s.toCharArray();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++)
			list.add(Character.toString(s_char[i]));

		Stack<String> stack = new Stack<String>();
		while (list.size() > 0) {
			stack.push(list.remove(0));
		}

		while (stack.size() > 0) {
			list.add(stack.pop());
		}

		String x = null;
		for (int j = 0; j < list.size(); j++) {
			if (j == 0)
				x = list.get(j);
			else
				x = x + list.get(j);
		}
		return x;
	}
}
