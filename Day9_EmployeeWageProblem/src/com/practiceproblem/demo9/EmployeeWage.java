package com.practiceproblem.demo9;

import java.util.Random;
import java.util.Scanner;

public class EmployeeWage {
	static final int FULL_DAY_HOUR = 8;
	static final int PART_DAY_HOUR = 4;
	// static final int DAYS_PER_MONTH = 20;
	int days = 0;
	int hours = 0;
	int monthlyWage = 0;

	int checkAttendance(int randInt) {
		switch (randInt) {
		case 1:
			// System.out.println("Full Time Employee is present");
			return FULL_DAY_HOUR;

		case 2:
			// System.out.println("Part Time Employee is present");
			return PART_DAY_HOUR;
		default:
			// System.out.println("Employee is absent");
			return 0;
		}

	}

	int calculateWage(int randInt, Company company) {
		int dailyWage = 0;
		switch (randInt) {
		case 1:
			// System.out.println("Daily Wage of employee is :Rs." + FULL_DAY_HOUR *
			// company.wagePerHour);
			dailyWage = FULL_DAY_HOUR * company.wagePerHour;
			return dailyWage;

		case 2:
			// System.out.println("Daily Wage of employee is :Rs." + PART_DAY_HOUR *
			// company.wagePerHour);
			dailyWage = PART_DAY_HOUR * company.wagePerHour;
			return dailyWage;
		default:
			return dailyWage;
		}
	}

	int calculateMonthlyWage(EmployeeWage employee, Company company) {
		Random randomInt = new Random();

		while (days < company.workingDays && hours <= company.workingHoursMonthly) {
			int randInt = randomInt.nextInt(3);
			hours = hours + employee.checkAttendance(randInt);
			if (hours > company.workingHoursMonthly) {
				int remainingHours = hours - company.workingHoursMonthly;
				hours = company.workingHoursMonthly;
				monthlyWage = monthlyWage + employee.calculateWage(randInt, company)
						- company.wagePerHour * remainingHours;
				company.dailyWage(employee.calculateWage(randInt, company) - company.wagePerHour * remainingHours,
						days);
				break;
			} else {
				monthlyWage = monthlyWage + employee.calculateWage(randInt, company);
				company.dailyWage(employee.calculateWage(randInt, company), days);
			}
			days += 1;
			if (employee.checkAttendance(randInt) == 0) {
				days -= 1;
			}
		}
		// System.out.println("The name of company is "+ company.name);
		// System.out.println("The monthly wage of the employee is Rs. " + monthlyWage);
		System.out.println("Total days the employee worked is " + days + " days");
		System.out.println("Total hours the employee Worked is " + hours + " hours");
		return monthlyWage;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Employee wage computation program");

		while (true) {
			EmployeeWage employee = new EmployeeWage();
			EmpWageBuilder empWageBuilder = new EmpWageBuilder();
			System.out.println(
					"Enter 0 to add the company or enter 1 to see the company and its total wage : Press 2 to quit");
			int input = in.nextInt();
			if (input == 0) {
				Company company = new Company();
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter the name of the company :");
				String name = scan.nextLine();
				System.out.println("Enter wage per hour :");
				int wagePerHour = scan.nextInt();
				System.out.println("Enter the total working days: ");
				int workingDays = scan.nextInt();
				System.out.println("Enter total monthly working hours :");
				int workingHoursMonthly = scan.nextInt();

				company.setInfo(name, wagePerHour, workingDays, workingHoursMonthly);
				int monthlyWage = employee.calculateMonthlyWage(employee, company);
				company.companyMonthlyWage(monthlyWage);

				empWageBuilder.showInfo(company);

				empWageBuilder.addCompany(company);

			} else if (input == 1) {
				Scanner in1 = new Scanner(System.in);
				System.out.println("Enter the name of company :");
				String name = in1.nextLine();
				empWageBuilder.showMonthlyWage(name);
			} else if (input == 2) {
				System.out.println("The program is closed");
				break;
			}
		}

	}

	}
