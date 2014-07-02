package com.baekgom.util;

import java.util.Scanner;

public class InputUtil {

	private static Scanner scanner = new Scanner(System.in);

	public static String getInputString() {
		return scanner.next();
	}

	public static int getInputInteger() {
		return scanner.nextInt();
	}

	public static String getInputLine() {
		return scanner.nextLine();
	}
	
}
