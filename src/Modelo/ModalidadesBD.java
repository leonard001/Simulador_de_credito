
package Modelo;

import Conexion.ClassConection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.CallableStatement;

public class ModalidadesBD extends ClassConection {
    
    Conexion.ClassConection conexion;
    private int Id;
    
    public boolean registrar (Modalidades mod){
     
        PreparedStatement ps = null;
        Connection conn = getConection();
        
        String sql = "INSERT INTO modalidades (IdModalidad, ModSeg_Vida, ModCapitalizacion  \n" +
        " , ModLeyPyme, ModTaza, ModPlazo) VALUES (?,?,?,?,?,?)";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod.getIdModalidad());
            ps.setFloat(2, mod.getModSeg_Vida());
            ps.setFloat(3, mod.getModCapitalizacion());
            ps.setFloat(4, mod.getModLeyPyme());
            ps.setFloat(5, mod.getModTaza());
            ps.setInt(6, mod.getModPlazo());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally {
            try{
            conn.close();
            }
            catch(SQLException e){
            System.err.print(e);
            }
        }
    }
    
    
    public boolean Modificar (Modalidades mod){
     
        PreparedStatement ps = null;
        Connection conn = getConection();
        
        String sql = "UPDATE modalidades SET ModSeg_Vida=?, ModCapitalizacion=?  \n" +
        " , ModLeyPyme=?, ModTaza=?, ModPlazo=? WHERE IdModalidad=?";
        
        try{
             ps = conn.prepareStatement(sql);
            ps.setFloat(1, mod.getModSeg_Vida());
            ps.setFloat(2, mod.getModCapitalizacion());
            ps.setFloat(3, mod.getModLeyPyme());
            ps.setFloat(4, mod.getModTaza());
            ps.setInt(5, mod.getModPlazo());
            ps.setInt(6, mod.getIdModalidad());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally {
            try{
            conn.close();
            }
            catch(SQLException e){
            System.err.print(e);
            }
        }
    }
    
     
    public boolean Eliminar (Modalidades mod){
     
        PreparedStatement ps = null;
        Connection conn = getConection();
        
        String sql = "DELETE FROM modalidades WHERE IdModalidad=?";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod.getIdModalidad());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally {
            try{
            conn.close();
            }
            catch(SQLException e){
            System.err.print(e);
            }
        }
    }


    public boolean buscar (Modalidades mod){
     
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConection();
        
        String sql = "SELECT* FROM modalidades WHERE IdModalidad=?";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod.getIdModalidad());
            rs = ps.executeQuery();
            
            if(rs.next()){
            
             mod.setIdModalidad(rs.getInt("IdModalidad"));
             mod.setModSeg_Vida(rs.getFloat("ModSeg_Vida"));
             mod.setModCapitalizacion(rs.getFloat("ModCapitalizacion"));
             mod.setModLeyPyme(rs.getFloat("ModLeyPyme"));
             mod.setModTaza(rs.getFloat("ModTaza"));
             mod.setModPlazo(rs.getInt("ModPlazo"));
             return true;
            
            }
                    
            return false;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally {
            try{
            conn.close();
            }
            catch(SQLException e){
            System.err.print(e);
            }
        }
    }
    

    public List<Modalidades> Listar (){
    
        PreparedStatement ps = null;
        Connection conn = getConection();
        ResultSet rs = null;
        List<Modalidades> lista = null;
        String sql = "SELECT* FROM modalidades";
        
     try{
     
         lista = new ArrayList();
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();
         Modalidades mod = null;
         while(rs.next()){
             mod = new Modalidades();
             mod.setIdModalidad(rs.getInt("IdModalidad"));
             mod.setModSeg_Vida(rs.getFloat("ModSeg_Vida"));
             mod.setModCapitalizacion(rs.getFloat("ModCapitalizacion"));
             mod.setModLeyPyme(rs.getFloat("ModLeyPyme"));
             mod.setModTaza(rs.getFloat("ModTaza"));
             mod.setModPlazo(rs.getInt("ModPlazo"));
             lista.add(mod);
            }
         }
         catch(SQLException e){
            System.err.print(e);
         }
         finally {
            try{
            conn.close();
            }
            catch(SQLException e){
            System.err.print(e);
            }
        }
       
         return lista;
       
       
     
    }   
  
    
    public List<Modalidades> Listar2 (){
    
        PreparedStatement ps = null;
        Connection conn = getConection();
        ResultSet rs = null;
        List<Modalidades> lista = null;
        String sql = "SELECT* FROM modalidades";
        
     try{
     
         lista = new ArrayList();
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();
         Modalidades mod = null;
         while(rs.next()){
             mod = new Modalidades();
             mod.setIdModalidad(rs.getInt("IdModalidad"));
             lista.add(mod);
            }
         }
         catch(SQLException e){
            System.err.print(e);
         }
         finally {
            try{
            conn.close();
            }
            catch(SQLException e){
            System.err.print(e);
            }
        }
       
         return lista;
       
       
     
    }
    
         
    
}
