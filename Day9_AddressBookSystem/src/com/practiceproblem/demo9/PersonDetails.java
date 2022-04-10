package com.practiceproblem.demo9;

import java.util.Scanner;

public class PersonDetails {
		static Scanner sc = new Scanner(System.in);
	public static String getString(String message) {
		System.out.println("Message");
		return sc.next();
	}
	public static Long getLong(String message) {
		System.out.println("Message");
		return sc.nextLong();
	}
}
