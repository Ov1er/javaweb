package com.bw.dao;

import com.bw.bean.Admin;
import com.bw.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminManager implements AdminJbdc{

    @Override
    public List<Admin> findAll() {
        ArrayList<Admin> list = new ArrayList<>();
        //sql语句
        String sql="SELECT * FROM admin;";
        try {
            //注册驱动，获取连接
            Connection con = JDBCUtil.con();
            //发送sql语句
            PreparedStatement ps = con.prepareStatement(sql);
            //执行sql语句
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addAdmin(Admin admin) {
        String sql="INSERT admin VALUES(0,?,?);";
        try {
            Connection con = JDBCUtil.con();
            //发送sql语句
            PreparedStatement ps = con.prepareStatement(sql);
            //执行sql语句
            ps.setString(1,admin.getAdminName());
            ps.setString(2,admin.getAdminPwd());
            int i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateAdmin(String pwd,String name) {
        //sql
        String sql="UPDATE admin SET adminPwd=? WHERE adminName=?;";
        //注册，获取连接
        try {
            Connection con = JDBCUtil.con();
            //发送sql
            PreparedStatement ps = con.prepareStatement(sql);
            //,赋值
            ps.setString(1,pwd);
            ps.setString(2,name);
            //执行sql
            int i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteAdmin(String name) {
        //sql
        String sql="DELETE FROM admin WHERE adminName=?;";
        //注册，连接
        try {
            Connection con = JDBCUtil.con();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            int i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
