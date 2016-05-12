package com.springmvc.web.houtai_admin.server;

import com.springmvc.web.admin.entity.Admin;
import com.springmvc.web.houtai_admin.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guanghaoshao on 16/1/11.
 */
@Service
public class AdminServerImpl implements AdminServer{
    @Autowired
    AdminDao dao;
    @Override
    public List QueryAdmin() {
        return dao.QueryAdmin();
    }

    @Override
    public void addAdmin() {

    }

    @Override
    public void removeAdmin(Integer id) {
        dao.removeAdmin(id);
    }

    @Override
    public void updateAdmin() {

    }
}
