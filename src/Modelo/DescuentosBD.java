
package Modelo;

import Conexion.ClassConection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.CallableStatement;


public class DescuentosBD extends ClassConection {
    
    Conexion.ClassConection conexion;
    private int Id;
    
    public boolean registrar (Descuentos des){
     
        PreparedStatement ps = null;
        Connection conn = getConection();
        
        String sql = "INSERT INTO deducciones (ID, DedAporxMM, DedApor5MMa10MM, DedApor10MMadelante,  \n" +
" DedAfiliacion, DedAhorro, DedVlrConsulta) VALUES (?,?,?,?,?,?,?)";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, des.getId());
            ps.setInt(2, des.getAporXMM());
            ps.setInt(3, des.getApor5MMa10MM());
            ps.setInt(4, des.getApor10MMadelante());
            ps.setInt(5, des.getAfiliacion());
            ps.setInt(6, des.getAhorro());
            ps.setInt(7, des.getConsulta());
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
    
    
    public boolean Modificar (Descuentos des){
     
        PreparedStatement ps = null;
        Connection conn = getConection();
        
        String sql = "UPDATE deducciones SET DedAporxMM=?, DedApor5MMa10MM=?, DedApor10MMadelante=?,  \n" +
" DedAfiliacion=?, DedAhorro=?, DedVlrConsulta=? WHERE ID=?";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, des.getAporXMM());
            ps.setInt(2, des.getApor5MMa10MM());
            ps.setInt(3, des.getApor10MMadelante());
            ps.setInt(4, des.getAfiliacion());
            ps.setInt(5, des.getAhorro());
            ps.setInt(6, des.getConsulta());
            ps.setInt(7, des.getId());
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
    
     
    public boolean Eliminar (Descuentos des){
     
        PreparedStatement ps = null;
        Connection conn = getConection();
        
        String sql = "DELETE FROM deducciones WHERE ID=?";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, des.getId());
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


    public boolean buscar (Descuentos des){
     
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConection();
        
        String sql = "SELECT* FROM deducciones WHERE ID=?";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, des.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
            
             des.setId(rs.getInt("ID"));
             des.setAporXMM(rs.getInt("DedAporxMM"));
             des.setApor5MMa10MM(rs.getInt("DedApor5MMa10MM"));
             des.setApor10MMadelante(rs.getInt("DedApor10MMadelante"));
             des.setAfiliacion(rs.getInt("DedAfiliacion"));
             des.setAhorro(rs.getInt("DedAhorro"));
             des.setConsulta(rs.getInt("DedVlrConsulta"));
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
    
    public int getContar(){
    
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConection();
        
        String sql = "SELECT COUNT(*) FROM deducciones";
        
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){

               Id = rs.getInt(1);
            }  
        }
        catch(SQLException e){
            System.err.print(e);
        }  
        return Id;
    
    }

    public List<Descuentos> Listar (){
    
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        List<Descuentos> lista = null;
        
     try{
     
         lista = new ArrayList();
         conn = getConection();
         cstm = conn.prepareCall("{Call Listar}");
         rs = cstm.executeQuery();
         Descuentos des = null;
         while(rs.next()){
         
             des = new Descuentos();
             des.setId(rs.getInt("ID"));
             des.setAporXMM(rs.getInt("DedAporxMM"));
             des.setApor5MMa10MM(rs.getInt("DedApor5MMa10MM"));
             des.setApor10MMadelante(rs.getInt("DedApor10MMadelante"));
             des.setAfiliacion(rs.getInt("DedAfiliacion"));
             des.setAhorro(rs.getInt("DedAhorro"));
             des.setConsulta(rs.getInt("DedVlrConsulta"));
             lista.add(des);
            }
         }
         catch(SQLException e){
            System.err.print(e);
         }
       
         return lista;
     
    }   
  
    
    public List<Descuentos> Listar2 (){
    
        PreparedStatement ps = null;
        Connection conn = getConection();
        ResultSet rs = null;
        List<Descuentos> lista = null;
        String sql = "SELECT* FROM deducciones";
        
     try{
     
         lista = new ArrayList();
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();
         Descuentos des = null;
         while(rs.next()){
             des = new Descuentos();
             des.setId(rs.getInt("ID"));
             lista.add(des);
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
    

