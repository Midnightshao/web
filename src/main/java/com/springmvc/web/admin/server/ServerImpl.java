package com.springmvc.web.admin.server;

import java.util.List;

import com.springmvc.web.admin.dao.Dao;
import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.admin.entity.Contact;
import com.springmvc.web.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;


@Service
public class ServerImpl implements Server{
   
     @Autowired
     private Dao dao;

	public void addContact(Admin admin,Person person) {
		// TODO Auto-generated method stub
		dao.addContact(admin,person);
	}

	@Override
	public boolean registercontact(Admin admin) {
		return dao.registercontact(admin);
	}

	@Override
	public Admin queryId(String id) {

		return dao.queryId(id);
	}



	@Transactional
	@Override
	public boolean listContact(Admin admin,HttpServletRequest request) {
    	 
    	if(dao.listContact(admin,request)){
    		return true;
    	}else{
    	return false;	
    	}	
	// TODO Auto-generated method stub	
	}

    @Transactional
	public void removeContact(Integer id) {
		// TODO Auto-generated method stub
		
	}
	//	//这个是内容
	@Transactional
	public List lists() {
	return dao.List();
	}

}
