package com.springmvc.web.person.dao;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.person.entity.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guanghaoshao on 16/3/1.
 */
@Repository
public class PersonDaoImpl implements PersonDao{

    @Autowired
    public SessionFactory sessionfactory;

    @Override
    public void Person_add(Person person) {
        sessionfactory.openSession().save(person);
    }

    @Override
    public Person Person_query(int first_title) {

        String sql="select * from person c where c.rid_id="+String.valueOf(first_title);

       List list= (List) sessionfactory.openSession().createSQLQuery(sql).addEntity(Person.class).list();

//        Person person= (Person) list.get(0);
        if(!list.isEmpty()){
            Person person= (Person) list.get(0);
            System.out.println(person);
            System.out.println(list);
            return person;
        }else {
            return null;
        }
    }

    @Override
    public void Person_delete() {

    }

    @Override
    public void Person_update(int person_id, Person person) {

        Session session=sessionfactory.openSession();

        session.beginTransaction();

        Person person1= (Person) session.load(Person.class, person_id);

        person1.setImg_type(person.getImg_type());

        person1.setCity(person.getCity());

        person1.setName(person.getName());

        person1.setAge(person.getAge());

        person1.setContent(person.getContent());

        session.update(person1);

        session.getTransaction().commit();
    }


}
