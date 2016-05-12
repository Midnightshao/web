package com.springmvc.web.person.server;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.person.dao.PersonDao;
import com.springmvc.web.person.dao.PersonDaoImpl;
import com.springmvc.web.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guanghaoshao on 16/3/2.
 */
@Service
public class PersonServerImpl implements PersonServer{

    @Autowired
    private PersonDaoImpl dao;
    @Override
    public void Person_add(Person person) {

    }

    @Override
    public Person Person_query(int first_title)
    {

        return dao.Person_query(first_title);
    }

    @Override
    public void Person_delete() {

    }

    @Override
    public void Person_update(int person_id, Person person) {
        dao.Person_update(person_id,person);
    }



}
