package Modelo;

/**
 *
 * @author LEONARD
 */
public class Descuentos {

    private int Id;
    private int AporXMM;
    private int Apor5MMa10MM;
    private int Apor10MMadelante;
    private int Afiliacion;
    private int Ahorro;
    private int Consulta;
    
    public Descuentos(){
    }

    public Descuentos(int Id, int AporXMM, int Apor5MMa10MM, int Apor10MMadelante, 
            int Afiliacion, int Ahorro, int Consulta) {
        this.Id = Id;
        this.AporXMM = AporXMM;
        this.Apor5MMa10MM = Apor5MMa10MM;
        this.Apor10MMadelante = Apor10MMadelante;
        this.Afiliacion = Afiliacion;
        this.Ahorro = Ahorro;
        this.Consulta = Consulta;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getAporXMM() {
        return AporXMM;
    }

    public void setAporXMM(int AporXMM) {
        this.AporXMM = AporXMM;
    }

    public int getApor5MMa10MM() {
        return Apor5MMa10MM;
    }

    public void setApor5MMa10MM(int Apor5MMa10MM) {
        this.Apor5MMa10MM = Apor5MMa10MM;
    }

    public int getApor10MMadelante() {
        return Apor10MMadelante;
    }

    public void setApor10MMadelante(int Apor10MMadelante) {
        this.Apor10MMadelante = Apor10MMadelante;
    }

    public int getAfiliacion() {
        return Afiliacion;
    }

    public void setAfiliacion(int Afiliacion) {
        this.Afiliacion = Afiliacion;
    }
        public int getAhorro() {
        return Ahorro;
    }

    public void setAhorro(int Ahorro) {
        this.Ahorro = Ahorro;
    }

    public int getConsulta() {
        return Consulta;
    }

    public void setConsulta(int Consulta) {
        this.Consulta = Consulta;
    }

  
}
