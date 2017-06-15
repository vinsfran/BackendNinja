package com.udemy.service;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import java.util.List;

/**
 *
 * @author vinsfran
 */
public interface ContactService {

    /**
     *
     * @param contactModel
     * @return
     */
    public abstract ContactModel addContact(ContactModel contactModel);

    /**
     *
     * @return
     */
    public abstract List<ContactModel> listAllContacts();

    /**
     *
     * @param id
     * @return
     */
    public abstract Contact findContactById(int id);

    /**
     *
     * @param id
     * @return
     */
    public abstract ContactModel findContactModelById(int id);

    /**
     *
     * @param id
     */
    public abstract void removeContact(int id);

}
