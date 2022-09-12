
package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.List;


public class contOtrosDct implements ActionListener {
    
    Modelo.Descuentos desc;
    Modelo.DescuentosBD descBD;
    Vista.otrosDesc frmOtros;

  public contOtrosDct (Vista.otrosDesc frmOtros){
    
      this.frmOtros = frmOtros;
      descBD = new Modelo.DescuentosBD();
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
  
   if(e.getSource()== frmOtros.GuardarBtn){
      
       String id = frmOtros.DesIDtxt.getText();
       String A = frmOtros.ApxMMtxt.getText();
       String AM = frmOtros.Ap5MMa10MMtxt.getText();
       String AMM = frmOtros.Ap10MMadtxt.getText();
       String AF= frmOtros.desAfiliaciontxt.getText();
       String AH = frmOtros.Ahorrotxt.getText();
       String CT = frmOtros.consultatxt.getText();
       
       desc = new Modelo.Descuentos();
       desc.setId(Integer.parseInt(id));
       desc.setAporXMM(Integer.parseInt(A));
       desc.setApor5MMa10MM(Integer.parseInt(AM));
       desc.setApor10MMadelante(Integer.parseInt(AMM));
       desc.setAfiliacion(Integer.parseInt(AF));
       desc.setAhorro(Integer.parseInt(AH));
       desc.setConsulta(Integer.parseInt(CT));
       
       if(descBD.registrar(desc)){
       
           JOptionPane.showMessageDialog(null, "Registro guardado");
           Limpiar();
           AVNuevoCargar ();
           actualizarTabla();

       }
       else{
          
           JOptionPane.showMessageDialog(null, "Error al guardar");
           Limpiar();
       }
   
   }
   
   
    if(e.getSource()== frmOtros.nuevoBtn){
         Limpiar();
        int v = descBD.getContar();
        frmOtros.DesIDtxt.setText(Integer.toString(v + 1));
        AVGuardar();
         limpiarTabla();
    }
   
    if(e.getSource()== frmOtros.EliminarBtn){
    
        //int fila = frmOtros.TablaDescTB.getSelectedRow();
        //String id = frmOtros.getTableModel().getValueAt(fila, 0).toString();
        String id = frmOtros.DesIDtxt.getText();
        
        desc = new Modelo.Descuentos();
        desc.setId(Integer.parseInt(id));
        
            if(descBD.Eliminar(desc)){
       
           JOptionPane.showMessageDialog(null, "Registro eliminado");
           Limpiar();
           AVNuevoCargar ();
           actualizarTabla();

       }
       else{
          
           JOptionPane.showMessageDialog(null, "Error al eliminar");
           Limpiar();
       }
    
    }
    
    
    if(e.getSource()== frmOtros.CargarBtn){
    
        int fila = frmOtros.TablaDescTB.getSelectedRow();
        frmOtros.DesIDtxt.setText(frmOtros.getTableModel().getValueAt(fila, 0).toString());
        frmOtros.ApxMMtxt.setText(frmOtros.getTableModel().getValueAt(fila, 2).toString());
        frmOtros.Ap5MMa10MMtxt.setText(frmOtros.getTableModel().getValueAt(fila, 3).toString());
        frmOtros.Ap10MMadtxt.setText(frmOtros.getTableModel().getValueAt(fila, 4).toString());
        frmOtros.desAfiliaciontxt.setText(frmOtros.getTableModel().getValueAt(fila, 1).toString());
        frmOtros.Ahorrotxt.setText(frmOtros.getTableModel().getValueAt(fila, 5).toString());
        frmOtros.consultatxt.setText(frmOtros.getTableModel().getValueAt(fila, 6).toString());
        AVEEliminarActualizar();
        limpiarTabla();
    }
    
    
    if(e.getSource()== frmOtros.ActualizarBtn){
      
       String id = frmOtros.DesIDtxt.getText();
       String A = frmOtros.ApxMMtxt.getText();
       String AM = frmOtros.Ap5MMa10MMtxt.getText();
       String AMM = frmOtros.Ap10MMadtxt.getText();
       String AF= frmOtros.desAfiliaciontxt.getText();
       String AH = frmOtros.Ahorrotxt.getText();
       String CT = frmOtros.consultatxt.getText();
       
       desc = new Modelo.Descuentos();
       desc.setId(Integer.parseInt(id));
       desc.setAporXMM(Integer.parseInt(A));
       desc.setApor5MMa10MM(Integer.parseInt(AM));
       desc.setApor10MMadelante(Integer.parseInt(AMM));
       desc.setAfiliacion(Integer.parseInt(AF));
       desc.setAhorro(Integer.parseInt(AH));
       desc.setConsulta(Integer.parseInt(CT));
       
       if(descBD.Modificar(desc)){
       
           JOptionPane.showMessageDialog(null, "Registro modificado");
           Limpiar();
           AVNuevoCargar ();
           actualizarTabla();

       }
       else{
          
           JOptionPane.showMessageDialog(null, "Error al modificar");
           Limpiar();
       }
   
   }
    
   if(e.getSource()== frmOtros.AtrasBtn){
   
       AVNuevoCargar ();
       actualizarTabla();
       Limpiar();
   }
    
  }
  
  
  public void Limpiar(){

      frmOtros.DesIDtxt.setText(null);
      frmOtros.ApxMMtxt.setText(null);
      frmOtros.Ap5MMa10MMtxt.setText(null);
      frmOtros.Ap10MMadtxt.setText(null);
      frmOtros.desAfiliaciontxt.setText(null);
      frmOtros.Ahorrotxt.setText(null);
      frmOtros.consultatxt.setText(null);
  }
  
  
  
  private void mostrarTabla(Modelo.Descuentos d){
      String[] registro = new String[7];
      registro[0] = Integer.toString(d.getId());
      registro[1] = Integer.toString(d.getAfiliacion());
      registro[2] = Integer.toString(d.getAporXMM());
      registro[3] = Integer.toString(d.getApor5MMa10MM());
      registro[4] = Integer.toString(d.getApor10MMadelante());
      registro[5] = Integer.toString(d.getAhorro());
      registro[6] = Integer.toString(d.getConsulta());
      frmOtros.getTableModel().addRow(registro);
      frmOtros.getTableModel().fireTableStructureChanged();
  }
  
  
  public void actualizarTabla(){
      
      List<Modelo.Descuentos> descuento = descBD.Listar();
      descuento.stream().forEach((d) -> {mostrarTabla(d);});
      
  }
  
   public void AVNuevoCargar (){
       
           frmOtros.DesIDtxt.setEnabled(false);
           frmOtros.desAfiliaciontxt.setEnabled(false);
           frmOtros.ApxMMtxt.setEnabled(false);
           frmOtros.Ap5MMa10MMtxt.setEnabled(false);
           frmOtros.Ap10MMadtxt.setEnabled(false);
           frmOtros.Ahorrotxt.setEnabled(false);
           frmOtros.consultatxt.setEnabled(false);
           frmOtros.GuardarBtn.setEnabled(false);
           frmOtros.EliminarBtn.setEnabled(false);
           frmOtros.ActualizarBtn.setEnabled(false);
           frmOtros.nuevoBtn.setEnabled(true);
           frmOtros.CargarBtn.setEnabled(true);
           frmOtros.AtrasBtn.setEnabled(false);
   
   }
  
   public void AVGuardar(){
   
        frmOtros.nuevoBtn.setEnabled(false);
        frmOtros.GuardarBtn.setEnabled(true);
        frmOtros.EliminarBtn.setEnabled(false);
        frmOtros.CargarBtn.setEnabled(false);
        frmOtros.ActualizarBtn.setEnabled(false);
        frmOtros.DesIDtxt.setEnabled(false);
        frmOtros.desAfiliaciontxt.setEnabled(true);
        frmOtros.ApxMMtxt.setEnabled(true);
        frmOtros.Ap5MMa10MMtxt.setEnabled(true);
        frmOtros.Ap10MMadtxt.setEnabled(true);
        frmOtros.Ahorrotxt.setEnabled(true);
        frmOtros.consultatxt.setEnabled(true); 
        frmOtros.AtrasBtn.setEnabled(true);
   }
   
   public void AVEEliminarActualizar(){
   
        frmOtros.nuevoBtn.setEnabled(false);
        frmOtros.GuardarBtn.setEnabled(false);
        frmOtros.EliminarBtn.setEnabled(true);
        frmOtros.CargarBtn.setEnabled(false);
        frmOtros.ActualizarBtn.setEnabled(true);
        frmOtros.DesIDtxt.setEnabled(false);
        frmOtros.desAfiliaciontxt.setEnabled(true);
        frmOtros.ApxMMtxt.setEnabled(true);
        frmOtros.Ap5MMa10MMtxt.setEnabled(true);
        frmOtros.Ap10MMadtxt.setEnabled(true);
        frmOtros.Ahorrotxt.setEnabled(true);
        frmOtros.consultatxt.setEnabled(true);
        frmOtros.AtrasBtn.setEnabled(true);
   }
   
   public void limpiarTabla(){
       
       int b = frmOtros.getTableModel().getRowCount();
       int c = 0;
       for (int i=0; i<b; i++){
         frmOtros.getTableModel().removeRow(c);
         i=i+0;

       }
   }
   
   
}
