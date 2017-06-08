package com.udemy.repository;

import com.udemy.entity.Contact;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
