package com.springmvc.web.houtai_admin.dao;

import java.util.List;

/**
 * Created by guanghaoshao on 16/1/11.
 */
public interface AdminDao {
    public List QueryAdmin();
    public void addAdmin();
    public void removeAdmin(Integer id);
    public void updateAdmin();
}
