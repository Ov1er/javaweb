package com.bw.test;

import com.bw.bean.Admin;
import com.bw.dao.AdminManager;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminManager am = new AdminManager();

        while (true){
            System.out.println("1.添加 2.查询 3.修改 4.删除");
            int key = sc.nextInt();
            switch (key){
                case 1:{
                    Admin a1 = new Admin(1, "admin_1", "123456");
                    Admin a2 = new Admin(2, "admin_2", "654321");
                    Admin a3 = new Admin(3, "admin_3", "abcdefg");
                    int i1 = am.addAdmin(a1);
                    int i2 = am.addAdmin(a2);
                    int i3 = am.addAdmin(a3);
                    if (i1>0&&i2>0&&i3>0){
                        System.out.println("插入3条记录，数据添加成功");
                    }else {
                        System.out.println("添加失败");
                    }
                    break;
                }case 2:{
                    List<Admin> all = am.findAll();
                    all.forEach(System.out::println);
                    break;
                }case 3:{
                    int admin_3 = am.updateAdmin("666999","admin_3");
                    if (admin_3>0){
                        System.out.println("更新1条记录，数据更新成功");
                    }

                    break;
                }case 4:{
                    int admin_2 = am.deleteAdmin("admin_2");
                    if (admin_2>0){
                        System.out.println("删除1条记录，数据删除成功");
                    }else {
                        System.out.println("删除失败");
                    }
                    break;
                }
            }
        }


    }
}
