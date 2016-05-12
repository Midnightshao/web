package com.springmvc.web.starter.server;


import com.springmvc.web.admin.entity.Contact;

import java.util.List;

public interface StarterServer {

  public List LoginList();

  public void addContent(Contact contact);

  public void deleteContent(Integer id,String dete_address);

}
