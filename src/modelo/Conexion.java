/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geral
 */
public class Conexion {
    private String usuario;
    private String pwd;
    private String url;
    private Connection conexion = null;

    public Conexion(String usuario, String pwd, String bd) {
        this.usuario = usuario;
        this.pwd = pwd;
        this.url = "jdbc:mysql://localhost:3306/"+bd;
    }
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conexion != null){
            return true;
        }else{
            return false;
        }
    }
}
