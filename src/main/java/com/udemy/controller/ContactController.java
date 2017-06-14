package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/contacts")
public class ContactController {

    public static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/contacts/showcontacts";
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    // @PreAuthorize("permitAll()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/contactform")
    public String redirectContactForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        ContactModel contactModel = new ContactModel();
        if (id != 0) {
            contactModel = contactService.findContactModelById(id);
        }
        model.addAttribute("contactModel", contactModel);
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel,
            Model model) {
        LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());

        if (contactService.addContact(contactModel) != null) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }

        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts() {
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername() + " 1");
        mav.addObject("contacts", contactService.listAllContacts());
        return mav;
    }

    @GetMapping("/removecontact")
    public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
        contactService.removeContact(id);
        return showContacts();
    }
}
