/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.comoqueraisvosotros;

import java.sql.*;

/**
 *
 * @author pablo
 */
public class ComoQueraisVosotros {

    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "dam2";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                Statement stmt = conn.createStatement(); 
                ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                System.out.print("\n"+"ID: " + rs.getInt("id"));
                System.out.print(" Nombre: " + rs.getString("Nombre"));
                System.out.print(" Género: " + rs.getString("Género"));
                System.out.print(" FechaLanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.print(" Compañía: " + rs.getString("Compañía"));
                System.out.print(" Precio: " + rs.getFloat("Precio"));  
            }   
            
        }
        catch (SQLException e){
        e.printStackTrace();
    }
   
    }
}
