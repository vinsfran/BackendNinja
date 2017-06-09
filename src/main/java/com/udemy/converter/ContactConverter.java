package com.udemy.converter;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import java.util.ArrayList;
import java.util.List;
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

    public List<Contact> convertContactsModelToContacts(List<ContactModel> contactsModel) {
        List<Contact> contacts = new ArrayList<>();
        for (ContactModel contactModel : contactsModel) {
            contacts.add(convertContactModelToContact(contactModel));
        }
        return contacts;
    }

    public ContactModel convertContactToContactModel(Contact contact) {
        ContactModel contactModel = new ContactModel(contact.getId(),
                contact.getFirstname(),
                contact.getLastname(),
                contact.getTelephone(),
                contact.getCity());
        return contactModel;
    }

    public List<ContactModel> convertContactsToContactsModel(List<Contact> contacts) {
        List<ContactModel> contactsModel = new ArrayList<>();
        for (Contact contact : contacts) {
            contactsModel.add(convertContactToContactModel(contact));
        }
        return contactsModel;
    }

}
