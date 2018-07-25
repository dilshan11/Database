/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import com.sun.media.jfxmedia.locator.ConnectionHolder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS™
 */
public class ItemController {
    public static ArrayList<Itemmodel> sendtocombo() throws ClassNotFoundException, SQLException{
        String sql="select *from item";
        Connection connection=DBconnecter.getInstance().getConnection();
        Statement statement=connection.createStatement();
        ResultSet rst=statement.executeQuery(sql);
        ArrayList<Itemmodel> allitem=new ArrayList<>();
        while(rst.next()){
            Itemmodel itemmodel=new Itemmodel();
            itemmodel.setCode(rst.getString("code"));
            allitem.add(itemmodel);
        }
        return allitem;
        }
    public static ArrayList<Itemmodel> loadallitemtomytable() throws ClassNotFoundException, SQLException{
        Connection connection=DBconnecter.getInstance().getConnection();
        Statement statement=connection.createStatement();
        String sql="select *from item";
        ResultSet rst=statement.executeQuery(sql);
        ArrayList<Itemmodel> allitem=new ArrayList<>();
        while(rst.next()){
            Itemmodel itemmodel=new Itemmodel(rst.getString("code"),rst.getString("description"),rst.getDouble("unitPrice"),rst.getInt("qtyOnHand"));
            allitem.add(itemmodel);
    }
        return allitem;
    }
    public static Itemmodel loaddescription(String item) throws ClassNotFoundException, SQLException{
        Connection connection=DBconnecter.getInstance().getConnection();
        Statement statement=connection.createStatement();
        String sql="select *from item where code='"+item+"'";
        ResultSet rst=statement.executeQuery(sql);
        rst.next();
        Itemmodel itemmodel=new Itemmodel(rst.getString("code"),rst.getString("description"),rst.getDouble("unitPrice"),rst.getInt("qtyOnHand"));
        return itemmodel;
}
}