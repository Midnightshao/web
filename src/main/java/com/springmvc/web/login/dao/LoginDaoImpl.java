package com.springmvc.web.login.dao;

import com.springmvc.web.login.entity.Login;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by guanghaoshao on 15/11/24.
 */
@Repository
public class LoginDaoImpl implements LoginDao{
    @Autowired
    public SessionFactory sessionfactory;
    @Override
    public void addContact(Login login) {

    }

    @Override
    public boolean listContact(Login admin) {
        Query query= sessionfactory.openSession().createQuery("from Login c where c.username=:name and c.password=:password");
//	      return sessionfactory.getCurrentSession().createQuery("from Admin").list();
        query.setString("name",admin.getUsername());
        query.setString("password",admin.getPassword());
        System.out.println(query.list());
        if(query.list().isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public void removeContact(Integer id) {

    }
}
