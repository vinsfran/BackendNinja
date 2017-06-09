package com.udemy.service;

import com.udemy.model.ContactModel;
import java.util.List;


public interface ContactService {
    
    public abstract ContactModel addContact(ContactModel contactModel);
    
    public abstract List<ContactModel> listAllContacts();
    
}
