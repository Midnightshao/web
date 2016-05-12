package com.springmvc.web.login.server;

import com.springmvc.web.login.dao.LoginDao;
import com.springmvc.web.login.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guanghaoshao on 15/11/24.
 */
@Service

public class LoginServerImpl implements LoginServer {
	@Autowired
	private LoginDao d;
	@Override
	public void addContact(Login login) {

	}
	@Transactional
	@Override
	public boolean listContact(Login admin) {

		return d.listContact(admin);
	}

	@Override
	public void removeContact(Integer id) {
}
}
