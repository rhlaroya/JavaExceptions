package com.cognixia.calculator;
import java.util.Scanner;

/**
 * This program is a basic calculator application
 * to demonstrate Java Exceptions.
 * @author rhlar
 *
 */
public class Calculator {

	Scanner kbd = new Scanner(System.in);
	public int menuPrompt() {
		try {
			System.out.println("What operation would you be doing today?");
			System.out.println("1.) Addition");
			System.out.println("2.) Subraction");
			System.out.println("3.) Multiplication");
			System.out.println("4.) Division");
			String userInput = kbd.nextLine();
			int menuChoice = Integer.parseInt(userInput);
			if (menuChoice >= 1 && menuChoice <= 4) {
				return menuChoice;
			} else {
				System.out.println("Invalid choice!");
				return menuPrompt();
			}
		} catch (NumberFormatException e) {
			System.out.println("Please input a number");
			return menuPrompt();
		}
	}
	
	public double getFirstNumber() {
		try {
			System.out.println("Please enter the first number");
			String userInput = kbd.nextLine();
			return Double.parseDouble(userInput);
		} catch (NumberFormatException e) {
			System.out.println("Pleae input a number");
			return getFirstNumber();
		}
	}
	
	public double getSecondNumber() {
		try {
			System.out.println("Please enter the second number");
			String userInput = kbd.nextLine();
			return Double.parseDouble(userInput);
		} catch (NumberFormatException e) {
			System.out.println("Pleae input a number");
			return getSecondNumber();
		}
	}
	
	public void startCalculator() {
		double numOne = getFirstNumber();
		double numTwo = getSecondNumber();
		int menuChoice = menuPrompt();
		double result = calculate(menuChoice, numOne, numTwo);
		System.out.println("The result of your calculation is " + result);
		startCalculator();
	}
	
	private double calculate(int menuChoice, double numOne, double numTwo) {
		double result = 0;
		switch(menuChoice) {
		case 1: result = numOne + numTwo;
		break;
		case 2: result = numOne - numTwo;
		break;
		case 3: result = numOne * numTwo;
		break;
		case 4: result = numOne / numTwo;
		break;
		}
		return result;
	}
}
