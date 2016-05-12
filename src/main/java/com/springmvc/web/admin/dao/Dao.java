package com.springmvc.web.admin.dao;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.admin.entity.Contact;
import com.springmvc.web.person.entity.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;



public interface Dao {
	  public void addContact(Admin admin,Person person);
	  public boolean listContact(Admin admin,HttpServletRequest request);
	  public List List();
	  public Admin queryId(String id);
	  public void addContent(Contact contact);
	  public void removeContact(Integer id);
	  public void updateContent(Contact contact);

	  public boolean registercontact(Admin admin);

}
