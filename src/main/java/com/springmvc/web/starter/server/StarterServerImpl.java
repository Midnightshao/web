package com.springmvc.web.starter.server;

import com.springmvc.web.admin.entity.Contact;
import org.springframework.stereotype.Service;

import com.springmvc.web.starter.dao.StarterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guanghaoshao on 15/11/24.
 */
@Service
public class StarterServerImpl implements StarterServer {
	@Autowired
	private StarterDao dao;

	@Transactional
	public List LoginList() {
		return dao.LoginList();
	}

	@Transactional
	@Override
	public void addContent(Contact contact) {
		dao.addContent(contact);
	}
	@Override
	@Transactional
	public void deleteContent(Integer id,String dete_address) {
		dao.deleteContent(id,dete_address);
	}




}
