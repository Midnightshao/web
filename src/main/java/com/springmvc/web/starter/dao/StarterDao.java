package com.springmvc.web.starter.dao;

import com.springmvc.web.admin.entity.Contact;

import java.util.List;

/**
 * Created by guanghaoshao on 15/11/24.
 */
public interface StarterDao {

    public List LoginList();

    public void addContent(Contact contact);

    public void deleteContent(Integer id,String dete_address);
}
