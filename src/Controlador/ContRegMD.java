
package Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ContRegMD implements ActionListener {
    
    Modelo.Modalidades modal;
    Modelo.ModalidadesBD modalBD;
    Vista.regModalidad frmRM;

  public ContRegMD (Vista.regModalidad frmRM){
    
      this.frmRM = frmRM;
      modalBD = new Modelo.ModalidadesBD();
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
  
      if(e.getSource()== frmRM.guardarBtn){
      
          modal = new Modelo.Modalidades();
          modal.setIdModalidad(Integer.parseInt(frmRM.modtxt.getText()));
          modal.setModSeg_Vida(Float.parseFloat(frmRM.segtxt.getText()));
          modal.setModCapitalizacion(Float.parseFloat(frmRM.captxt.getText()));
          modal.setModLeyPyme(Float.parseFloat(frmRM.leytxt.getText()));
          modal.setModTaza(Float.parseFloat(frmRM.tazatxt.getText()));
          modal.setModPlazo(Integer.parseInt(frmRM.plazotxt.getText()));
          
             if(modalBD.registrar(modal)){
       
             JOptionPane.showMessageDialog(null, "Registro guardado");
             Limpiar();

             }
              else{
          
              JOptionPane.showMessageDialog(null, "Error al guardar");
           
              }
      
      }
  
  }
  
  public void Limpiar(){
          frmRM.modtxt.setText(null);
          frmRM.segtxt.setText(null);
          frmRM.captxt.setText(null);
          frmRM.leytxt.setText(null);
          frmRM.tazatxt.setText(null);
          frmRM.plazotxt.setText(null);
      
  }
   
   
}
