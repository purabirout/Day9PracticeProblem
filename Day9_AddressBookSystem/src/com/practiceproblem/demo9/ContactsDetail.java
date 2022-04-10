package com.practiceproblem.demo9;
import java.util.*;

public class ContactsDetail {
	private ArrayList<Contact> contactList = new ArrayList<Contact> ();

	private ContactsDetail() {
		
	}
	
	private static ContactsDetail instance;
	
	public static ContactsDetail getInstance() {
		if(instance == null) {
			instance = new ContactsDetail();
		}
		return instance;
	}
	
	public ArrayList<Contact> getContactList() {
		return contactList;
	}
	
	public void add(Contact contact)
	{
		contactList.add(contact);		
	}
		
	public void remove(Contact contact)
	{
		contactList.remove(contact);	
	}
		
	public Contact getContact(String firstName) {
		for(Contact contact : contactList) {
			if(firstName.equalsIgnoreCase(contact.firstName)) {
				return contact;
			}
		}
		return null;
	}
}
