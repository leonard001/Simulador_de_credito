
package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.List;


public class contBDcreditos implements ActionListener {
    
    Modelo.Modalidades modal;
    Modelo.ModalidadesBD modalBD;
    Vista.creditoBD frmcreBD;

  public contBDcreditos (Vista.creditoBD frmcreBD){
    
      this.frmcreBD = frmcreBD;
      modalBD = new Modelo.ModalidadesBD();
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
  
      if(e.getSource()== frmcreBD.CargarBtn){
      
       int valor = Integer.parseInt(frmcreBD.ModList.getSelectedItem().toString());
       modal = new Modelo.Modalidades();
       modal.setIdModalidad(valor);
       
       if(modalBD.buscar(modal)){
       
           frmcreBD.segTxt.setText(String.valueOf(modal.getModSeg_Vida()));
           frmcreBD.capTxt.setText(String.valueOf(modal.getModCapitalizacion()));
           frmcreBD.leyTxt.setText(String.valueOf(modal.getModLeyPyme()));
           frmcreBD.TazaTxt.setText(String.valueOf(modal.getModTaza()));
           frmcreBD.plazoTxt.setText(String.valueOf(modal.getModPlazo()));
           AVEliminarActualizar();
           limpiarTabla();
           
       }
       else{
          
           JOptionPane.showMessageDialog(null, "Error al modificar");
           Limpiar();
           
           
       }
               
      }
      
      
      if(e.getSource()== frmcreBD.eliminarBtn){
      
       int valor = Integer.parseInt(frmcreBD.ModList.getSelectedItem().toString());
       modal = new Modelo.Modalidades();
       modal.setIdModalidad(valor);
       
       if(modalBD.Eliminar(modal)){
       JOptionPane.showMessageDialog(null, "Registro eliminado");
        Limpiar();
        actualizarTabla();
        AVEInicio();
       }
       else{
          
           JOptionPane.showMessageDialog(null, "Error al modificar");
           Limpiar();
       }
               
      }
      
      if(e.getSource()== frmcreBD.actualizarBtn){
      
       int valor = Integer.parseInt(frmcreBD.ModList.getSelectedItem().toString());
       modal = new Modelo.Modalidades();
       modal.setIdModalidad(valor);
       modal.setModSeg_Vida(Float.parseFloat(frmcreBD.segTxt.getText()));
       modal.setModCapitalizacion(Float.parseFloat(frmcreBD.capTxt.getText()));
       modal.setModLeyPyme(Float.parseFloat(frmcreBD.leyTxt.getText()));
       modal.setModTaza(Float.parseFloat(frmcreBD.TazaTxt.getText()));
       modal.setModPlazo(Integer.parseInt(frmcreBD.plazoTxt.getText()));
       
       if(modalBD.Modificar(modal)){
       
         JOptionPane.showMessageDialog(null, "Registro actualizado");
        Limpiar();
        actualizarTabla();
        AVEInicio();
       }
       else{
          
           JOptionPane.showMessageDialog(null, "Error al modificar");
           Limpiar();
       }
               
      }
      
      if(e.getSource()== frmcreBD.InicioBtn){
          
          String a = "";
          String b = frmcreBD.segTxt.getText();
          AVCargar();
          if(a.equals(b)){
           cargarLista();
           }
          else{
          Limpiar1();
          String c = frmcreBD.ModList.getSelectedItem().toString();
          String d = "";
          if(c.equals(d)){
           
           }
          else{
          actualizarTabla();
          }
          }
          
      }
  
   }
   
   
   public void cargarLista(){
       
       List<Modelo.Modalidades> modalidades = modalBD.Listar2();
       modalidades.stream().forEach((m) -> {mostrar(m);});
    
   }
   
   private void mostrar(Modelo.Modalidades m){
      frmcreBD.ModList.addItem(String.valueOf(m.getIdModalidad()));
   }
    
   public void Limpiar(){
           
           frmcreBD.segTxt.setText(null);
           frmcreBD.capTxt.setText(null);
           frmcreBD.leyTxt.setText(null);
           frmcreBD.TazaTxt.setText(null);
           frmcreBD.plazoTxt.setText(null);
           frmcreBD.ModList.removeAllItems();
           
   }
   
   public void Limpiar1(){
           
           frmcreBD.segTxt.setText(null);
           frmcreBD.capTxt.setText(null);
           frmcreBD.leyTxt.setText(null);
           frmcreBD.TazaTxt.setText(null);
           frmcreBD.plazoTxt.setText(null);
           
   }
   
   public void AVCargar(){
   
           frmcreBD.eliminarBtn.setEnabled(false);
           frmcreBD.CargarBtn.setEnabled(true);
           frmcreBD.actualizarBtn.setEnabled(false);
           frmcreBD.InicioBtn.setEnabled(false);
           frmcreBD.segTxt.setEnabled(false);
           frmcreBD.capTxt.setEnabled(false);
           frmcreBD.leyTxt.setEnabled(false);
           frmcreBD.TazaTxt.setEnabled(false);
           frmcreBD.plazoTxt.setEnabled(false);
           frmcreBD.ModList.setEnabled(true);
          
   }
   
   public void AVEliminarActualizar(){
   
           frmcreBD.eliminarBtn.setEnabled(true);
           frmcreBD.CargarBtn.setEnabled(false);
           frmcreBD.actualizarBtn.setEnabled(true);
           frmcreBD.InicioBtn.setEnabled(true);
           frmcreBD.segTxt.setEnabled(true);
           frmcreBD.capTxt.setEnabled(true);
           frmcreBD.leyTxt.setEnabled(true);
           frmcreBD.TazaTxt.setEnabled(true);
           frmcreBD.plazoTxt.setEnabled(true);
           frmcreBD.ModList.setEnabled(false);
   }
   
   public void AVEInicio(){
   
           frmcreBD.eliminarBtn.setEnabled(false);
           frmcreBD.CargarBtn.setEnabled(false);
           frmcreBD.actualizarBtn.setEnabled(false);
           frmcreBD.InicioBtn.setEnabled(true);
           frmcreBD.segTxt.setEnabled(false);
           frmcreBD.capTxt.setEnabled(false);
           frmcreBD.leyTxt.setEnabled(false);
           frmcreBD.TazaTxt.setEnabled(false);
           frmcreBD.plazoTxt.setEnabled(false);
           frmcreBD.ModList.setEnabled(false);
   }
   
   private void mostrarTabla(Modelo.Modalidades m){
       
      String[] registro = new String[6];
      registro[0] = Integer.toString(m.getIdModalidad());
      registro[1] = String.valueOf(m.getModSeg_Vida());
      registro[2] = String.valueOf(m.getModCapitalizacion());
      registro[3] = String.valueOf(m.getModLeyPyme());
      registro[4] = String.valueOf(m.getModTaza());
      registro[5] = Integer.toString(m.getModPlazo());
      frmcreBD.getTableModel().addRow(registro);
      frmcreBD.getTableModel().fireTableStructureChanged();
  }
  
  
  public void actualizarTabla(){
      
      List<Modelo.Modalidades> modalidades = modalBD.Listar();
      modalidades.stream().forEach((m) -> {mostrarTabla(m);});
      
  }
  
  public void limpiarTabla(){
       
       int b = frmcreBD.getTableModel().getRowCount();
       int c = 0;
       for (int i=0; i<b; i++){
         frmcreBD.getTableModel().removeRow(c);
         i=i+0;

       }
   }
   
  
  public void limpiarLista(){
  
      frmcreBD.ModList.removeAllItems();
    
      
  }
   
}
