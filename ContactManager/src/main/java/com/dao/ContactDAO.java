package com.dao;

import java.util.ArrayList;

import com.model.Contact;

public interface ContactDAO {
	boolean create(Contact contact);
	ArrayList<Contact> getAllContacts(int id);
}
