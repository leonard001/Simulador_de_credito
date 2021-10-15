

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class contSimulador implements ActionListener {
    
    Modelo.Modalidades modal;
    Modelo.ModalidadesBD modalBD;
    Modelo.Descuentos desc;
    Modelo.DescuentosBD descBD;
    Vista.simCredito frmSim;

  public contSimulador (Vista.simCredito frmSim){
    
      this.frmSim = frmSim;
      modalBD = new Modelo.ModalidadesBD();
      descBD = new Modelo.DescuentosBD();
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
  
      if(e.getSource()== frmSim.CalcularBtn){
      
          int modali = Integer.parseInt(frmSim.modaList.getSelectedItem().toString());
          String mont = frmSim.montoTxt.getText();
          String plaz = frmSim.plazoTxt.getText();
          int descun = Integer.parseInt(frmSim.descList.getSelectedItem().toString());
          float monto = Float.parseFloat(mont);
          float plazo = Float.parseFloat(plaz);
          
          modal = new Modelo.Modalidades();
          modal.setIdModalidad(modali);
       
           modalBD.buscar(modal);
           String sg = String.valueOf(modal.getModSeg_Vida());
           String cp = String.valueOf(modal.getModCapitalizacion());
           String ly = String.valueOf(modal.getModLeyPyme());
           String tz = String.valueOf(modal.getModTaza());
           String pl = String.valueOf(modal.getModPlazo());
           
           float plaso = Float.valueOf(pl);
           float seguro = Float.valueOf(sg);
           float capita = Float.valueOf(cp);
           float ley = Float.valueOf(ly);
           float taza = Float.valueOf(tz);
           
           float seguros = seguro/100;
           float capitas = capita/100;
           float leys = ley/100;
           float tazas = taza/100;
           
           float mulMonto = monto * tazas;
           float sumTaza = tazas + 1;
           
           float pot = sumTaza;
           for (float i=1; i<plazo; i++){
           pot = pot * sumTaza;
           }
           
           float totalP = 1 / pot;
           float cuota = mulMonto / (1 - totalP);
           float porCapit = (monto * capitas) / plazo;
           float cuotaTotal = cuota + porCapit;
           
           float segur = (monto * seguros) * plazo;
           float leym = monto * leys;
           float segTotal = segur + leym;
           
           frmSim.cuotaTxt.setText(String.valueOf(cuotaTotal));
           frmSim.cNetaTxt.setText(String.valueOf(cuota));
           frmSim.tazaTxt.setText(String.valueOf(taza));
           frmSim.capitTxt.setText(String.valueOf(porCapit));
           frmSim.SegLeyTxt.setText(String.valueOf(segTotal));
           
           desc = new Modelo.Descuentos();
           desc.setId(descun);
       
           descBD.buscar(desc);
           int MM = desc.getAporXMM();
           int MMM = desc.getApor5MMa10MM();
           int MMMM = desc.getApor10MMadelante();
           int Af = desc.getAfiliacion();
           String Ah = String.valueOf(desc.getAhorro());
           String cn = String.valueOf(desc.getConsulta());
           
           String v = frmSim.aportesTxt.getText();
           String va = frmSim.Ahorrotxt.getText();
           String vb = frmSim.consultaTxt.getText();
           String vc= frmSim.otrosTxt.getText();
           String vd = frmSim.sCreditoTxt.getText();
           String ve = "0";
           
           float apor = MM * (monto / 1000000);
           
           if(ve.equals(v)&& ve.equals(va) && ve.equals(vb)&& ve.equals(vc)&& ve.equals(vd)){
            
            frmSim.Ahorrotxt.setText(Ah);
            frmSim.consultaTxt.setText(cn);
            float vl = 5000000;
            float v2 = 10000000;
            float afil = Af;
            if(monto<=vl){
            frmSim.aportesTxt.setText(String.valueOf(apor + afil));
            sumar();
            }
           else if(monto<v2){
           frmSim.aportesTxt.setText(Integer.toString(MMM+Af));
           sumar();
           }
           else if(monto >= v2){
           frmSim.aportesTxt.setText(Integer.toString(MMMM+Af));
           sumar();
           }
           }
           else{
               sumar();
           }
           
           
       }
      
       if(e.getSource()== frmSim.LimpiarBtn){
       
           limpiar();
       }
      
    }
    
    
    public void cargarLista(){
       
       List<Modelo.Modalidades> modalidades = modalBD.Listar2();
       modalidades.stream().forEach((m) -> {mostrar(m);});
    
   }
   
   private void mostrar(Modelo.Modalidades m){
      frmSim.modaList.addItem(String.valueOf(m.getIdModalidad()));
   }
   
   public void cargarListaDes(){
       
       List<Modelo.Descuentos> descuentos = descBD.Listar2();
       descuentos.stream().forEach((d) -> {mostrarDes(d);});
    
   }
   
   private void mostrarDes(Modelo.Descuentos d){
      frmSim.descList.addItem(String.valueOf(d.getId()));
   }
   
   public void DesBtn(){
   
       frmSim.cuotaTxt.setEditable(false);
       frmSim.cNetaTxt.setEditable(false);
       frmSim.tazaTxt.setEditable(false);
       frmSim.capitTxt.setEditable(false);
       frmSim.totalDedTxt.setEditable(false);
       frmSim.diaponibleTxt.setEditable(false);
       frmSim.SegLeyTxt.setEditable(false);
   
   }
   
   public void sumar(){
       
       float mont = Float.valueOf(frmSim.montoTxt.getText());
       float valor = Float.valueOf(frmSim.SegLeyTxt.getText());
       float valora = Float.valueOf(frmSim.aportesTxt.getText());
       float valorb = Float.valueOf(frmSim.Ahorrotxt.getText());
       float valorc = Float.valueOf(frmSim.consultaTxt.getText());
       float valord = Float.valueOf(frmSim.sCreditoTxt.getText());
       float valore = Float.valueOf(frmSim.otrosTxt.getText());
       
       float vTotal = valor + valora + valorb + valorc + valord + valore;
       float dispon = mont - vTotal;
       
       frmSim.totalDedTxt.setText(String.valueOf(vTotal));
       frmSim.diaponibleTxt.setText(String.valueOf(dispon));
   }
   
   public void limpiar(){
       String a = "0";
       frmSim.aportesTxt.setText(a);
       frmSim.Ahorrotxt.setText(a);
       frmSim.consultaTxt.setText(a);
       frmSim.sCreditoTxt.setText(a);
       frmSim.otrosTxt.setText(a);
   }
}
    

