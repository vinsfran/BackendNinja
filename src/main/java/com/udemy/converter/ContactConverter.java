package com.udemy.converter;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public Contact convertContactModelToContact(ContactModel contactModel) {
        Contact contact = new Contact(contactModel.getId(),
                contactModel.getFirstname(),
                contactModel.getLastname(),
                contactModel.getTelephone(),
                contactModel.getCity());
        return contact;
    }

    public ContactModel convertContactToContactModel(Contact contact) {
        ContactModel contactModel = new ContactModel(contact.getId(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getTelephone(),
                contact.getCity());
        return contactModel;
    }

}
