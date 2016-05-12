package com.springmvc.web.admin.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.admin.entity.Contact;
import com.springmvc.web.person.entity.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

@Repository
public class DaoImpl implements Dao{
	@Autowired
   public SessionFactory sessionfactory;

	@Override
	public void addContact(Admin admin,Person person) {

		Session session= sessionfactory.openSession();

		session.save(admin);

		//查询到这个Admin ，添加到Person昵称

		admin.getPersonSet().add(person);

		person.setAdmin(admin);

		session.save(person);

	}

	@Override
	public boolean listContact(Admin admin,HttpServletRequest request) {
		Query query= sessionfactory.openSession().createQuery("from Admin c where c.name=:name and c.password=:password");
//	      return sessionfactory.getCurrentSession().createQuery("from Admin").list();
		query.setString("name",admin.getName());
		query.setString("password",admin.getPassword());
		System.out.println(query.list());
		if(query.list().isEmpty()){
			return false; 
				}
		//写的差不多了 这里是获得id
		Admin admin1= (Admin) query.list().get(0);
		System.out.println("看看有没有什么东西id");
		request.getSession().setAttribute("id",admin1.getId());
		return true;
	}


	public List List() {
		List list=new ArrayList();
		Query query=sessionfactory.openSession().createQuery("from Contact");
		list=query.list();
		return list;
	}

	@Override
	public Admin queryId(String id) {
		Query query=sessionfactory.openSession().createQuery("from Admin c where c.id=:id");
		query.setInteger("id", Integer.valueOf(id));
		Admin admin= (Admin) query.list().get(0);
		return admin;
	}


	@Override
	public void addContent(Contact contact) {

	}

	@Override
	public void removeContact(Integer id) {

	}

	@Override
	public void updateContent(Contact contact) {

	}


	@Override
	public boolean registercontact(Admin admin) {
		Query query=sessionfactory.openSession().createQuery("from Admin c where c.name=:name");
		query.setString("name",admin.getName());
		if(query.list().isEmpty()){
			return true;
		}
		return false;
	}

}
