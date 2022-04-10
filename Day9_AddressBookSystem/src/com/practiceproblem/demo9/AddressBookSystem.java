package com.practiceproblem.demo9;

import java.util.Scanner;

public class AddressBookSystem {
	static {
		System.out.print("Welcome to Address Book Program");
	}
	ContactsDetail contactsDetail = ContactsDetail.getInstance();
	UserInput scn = new UserInput();
	
	public void handleUserSelection(int choice) {
		UserInterface userInterface = UserInterface.getInstance();
		
		switch(choice) {
		case 1: 
			addContact();
			System.out.println("Contact Added Successfully");
			break;
		case 2:
			updateContact();
			System.out.println("Contact Updated Successfully");
			break;
		case 3:
			String userSelection = userInterface.selectContact();
			Contact contact = contactsDetail.getContact(userSelection);
			System.out.println("Contact = "+contact);
			contactsDetail.getContactList().remove(contact);
			System.out.println("Medicine Removed Successfully");
			System.out.println(contactsDetail.getContactList());
			break;
		case 4:
			System.out.println("The Contact List is ");
			userInterface.print(contactsDetail.getContactList());
			break;
		case 5:
			System.out.println("Exited Main Menu");
			break;
		}

	}
	

	public void addContact() {
		Contact contact = new Contact();
		
		System.out.println("Enter First Name");
		contact.firstName = scn.StringInput();
		System.out.println("Enter Last Name");
		contact.lastName = scn.StringInput();
		System.out.println("Enter Address ");
		contact.address = scn.StringInput();
		System.out.println("Enter City Name");
		contact.city = scn.StringInput();
		System.out.println("Enter State Name");
		contact.state = scn.StringInput();
		System.out.println("Enter Zip Code");
		contact.zip = scn.LongInput();
		System.out.println("Enter Phone Number");
		contact.phoneNumber = scn.LongInput();
		System.out.println("Enter email Address");
		contact.email = scn.StringInput();
		
		contactsDetail.add(contact);
		System.out.println(contactsDetail.getContactList());
			
	}
	
	private void updateContact() {
		UserInterface userInterface = UserInterface.getInstance();
		String firstname = userInterface.selectContact();
		
		Contact contactForUpdate = contactsDetail.getContact(firstname);
		System.out.println(contactForUpdate);
		
		int updateChoice = userInterface.showUpdateMenu();
		
		switch (updateChoice) {
		case 1:
			System.out.println("Current First Name is : " 
					+ contactForUpdate.firstName + ". Enter your new First Name :");
			contactForUpdate.firstName = scn.StringInput();
			break;
		case 2:
			System.out.println("Current Last Name is : " 
					+ contactForUpdate.lastName + ". Enter your new Last Name :");
			contactForUpdate.lastName = scn.StringInput();
			break;
		case 3:
			System.out.println("Current Address is : " 
					+ contactForUpdate.address + ". Enter your new Address :");
			contactForUpdate.address = scn.StringInput();
			break;
		case 4:
			System.out.println("Current CIty Name is : " 
					+ contactForUpdate.city + ". Enter your new City Name :");
			contactForUpdate.city = scn.StringInput();
			break;
		case 5:
			System.out.println("Current State Name is : " 
					+ contactForUpdate.state + ". Enter your new State Name :");
			contactForUpdate.state = scn.StringInput();
			break;
		case 6:
			System.out.println("Current Zip code is : " 
					+ contactForUpdate.zip + ". Enter your new Zip Code :");
			contactForUpdate.zip = scn.LongInput();
			break;
		case 7:
			System.out.println("Current Phone Number is : " 
					+ contactForUpdate.phoneNumber + ". Enter your new Phone Number :");
			contactForUpdate.phoneNumber = scn.LongInput();
			break;
		case 8:
			System.out.println("Current email address is : " 
					+ contactForUpdate.email + ". Enter your new email address :");
			contactForUpdate.email = scn.StringInput();
			break;
		
		}
	}
	
	public static void main(String[] args) {
	
		UserInterface userInterface = UserInterface.getInstance();
		AddressBookSystem main = new AddressBookSystem();
		
		int choice = 0;
		while(choice != 5) {
			choice = userInterface.showMainMenu();
			main.handleUserSelection(choice);
		}
	
	}

}
