package com.springmvc.web.login.server;


import com.springmvc.web.login.entity.Login;

public interface LoginServer {
  public void addContact(Login login);
  public boolean listContact(Login admin);
  public void removeContact(Integer id);
}
