package com.bw.dao;

import com.bw.bean.Admin;

import java.util.List;

public interface AdminJbdc {
    //查
    public List<Admin> findAll();
    //增
    public int addAdmin(Admin admin);
    //该
    public int updateAdmin(String pwd,String name);
    //删
    public int deleteAdmin(String name);
}
