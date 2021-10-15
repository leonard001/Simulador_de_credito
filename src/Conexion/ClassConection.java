
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class ClassConection {
    
private final String Driver = "com.mysql.jdbc.Driver";
private final String cadenaConeccion = "jdbc:mysql://localhost:3306/appcreditos?zeroDateTimeBehavior=convertToNull";
private final String Usuario = "root";
private final String Contraseña = "";
public Connection con = null;
    
public Connection getConection() {
     
    try{
    Class.forName(Driver);
    con=DriverManager.getConnection(cadenaConeccion, Usuario, Contraseña);
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, "Desconectado");
    }
    return con;
}


}

