package com.foodapp;

import com.foodapp.config.AppConfig;
import com.foodapp.controller.OrderController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodappApplication {

    public static void main(String[] args) throws SQLException {

        //MySql Connection manual configuration
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Root@123");
        PreparedStatement ps=
                con.prepareStatement("CREATE DATABASE IF NOT EXISTS foodapp1");
        ps.executeUpdate();
        ps.close();

        Connection dbCon = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/foodapp1",
                "root",
                "Root@123"
        );


        PreparedStatement ps1=dbCon.prepareStatement("CREATE Table product(id int primary key,name varchar(30), price int)");
        ps1.executeUpdate();
        ps1.close();

        PreparedStatement ps2=dbCon.prepareStatement("INSERT INTO product values(?,?,?)");
        ps2.setInt(1,1);
        ps2.setString(2,"Product name");
        ps2.setInt(3,1233);
        ps2.executeUpdate();
        ps2.close();
        con.close();

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OrderController controller = ctx.getBean(OrderController.class);
        controller.placeOrder();
    }
}
