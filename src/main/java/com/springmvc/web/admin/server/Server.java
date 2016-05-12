package com.springmvc.web.admin.server;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.admin.entity.Contact;
import com.springmvc.web.person.entity.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface Server {
  public void addContact(Admin admin,Person person);
  public boolean registercontact(Admin admin);
  public Admin queryId(String id);
  //这个是登陆
  public boolean listContact(Admin admin,HttpServletRequest request);
  public void removeContact(Integer id);
  // 首页内容
  public List lists();
}
