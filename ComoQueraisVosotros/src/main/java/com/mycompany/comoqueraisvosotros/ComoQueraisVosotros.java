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
    //declaramos la url, el usuario, la contraseña para conectarnos a la base de datos
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "dam2";
    static final String PASS = "1234";
    //declaramos la query para que la ejecute en la base de datos
    static final String QUERY = "SELECT * FROM videojuegos";

    public static void main(String[] args) {
        //abre una conexion a la base de datos con los datos introducidos enteriormente
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                //crea un metodo statement para ejecutar el sql y la almacena en resultset
                Statement stmt = conn.createStatement(); 
                ResultSet rs = stmt.executeQuery(QUERY);) {
                //imprime cada valor de cada columna mientras haya lineas que leer
            while (rs.next()) {
                System.out.print("\n"+"ID: " + rs.getInt("id"));
                System.out.print(" Nombre: " + rs.getString("Nombre"));
                System.out.print(" Género: " + rs.getString("Género"));
                System.out.print(" FechaLanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.print(" Compañía: " + rs.getString("Compañía"));
                System.out.print(" Precio: " + rs.getFloat("Precio"));  
            } 
            //cierra el statement
            stmt.close();
        }
        //captura las excepciones sqlexception e imprime la pila de errores
        catch (SQLException e){
        e.printStackTrace();
    }
   
    }
}
