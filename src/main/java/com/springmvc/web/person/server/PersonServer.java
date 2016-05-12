package com.springmvc.web.person.server;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.person.entity.Person;

import java.util.List;

/**
 * Created by guanghaoshao on 16/3/2.
 */
public interface PersonServer {
    public void Person_add(Person person);
    public Person Person_query(int first_title);
    public void Person_delete();
    public void Person_update(int person_id,Person person);
}
