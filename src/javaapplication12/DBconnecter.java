/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

 

/**
 *
 * @author ASUS™
 */
public class DBconnecter {
     public static DBconnecter dBconnecter;
     private Connection connection;
    public DBconnecter() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade","root","nanayakkara");    
    }
    public static DBconnecter getInstance() throws ClassNotFoundException, SQLException{
        if(dBconnecter==null){
            dBconnecter=new DBconnecter();
    }
       return dBconnecter;
    }
     
    public Connection getConnection() {
        return connection;
    }
    
     
}
