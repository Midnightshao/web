package com.springmvc.web.login.dao;

import com.springmvc.web.login.entity.Login;

/**
 * Created by guanghaoshao on 15/11/24.
 */
public interface LoginDao {
    public void addContact(Login login);
    public boolean listContact(Login admin);
    public void removeContact(Integer id);
}
