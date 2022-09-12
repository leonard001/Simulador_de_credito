
package Modelo;


public class Modalidades {
    
    private int IdModalidad ;
    private float ModSeg_Vida;
    private float ModCapitalizacion;
    private float ModLeyPyme;
    private float ModTaza;
    private int ModPlazo;
    
    public Modalidades(){
    }
    
    public Modalidades(int IdModalidad, float ModSeg_Vida, float ModCapitalizacion, float ModLeyPyme, float ModTaza, int ModPlazo) {
        this.IdModalidad = IdModalidad;
        this.ModSeg_Vida = ModSeg_Vida;
        this.ModCapitalizacion = ModCapitalizacion;
        this.ModLeyPyme = ModLeyPyme;
        this.ModTaza = ModTaza;
        this.ModPlazo = ModPlazo;
    }

    public int getIdModalidad() {
        return IdModalidad;
    }

    public void setIdModalidad(int IdModalidad) {
        this.IdModalidad = IdModalidad;
    }

    public float getModSeg_Vida() {
        return ModSeg_Vida;
    }

    public void setModSeg_Vida(float ModSeg_Vida) {
        this.ModSeg_Vida = ModSeg_Vida;
    }

    public float getModCapitalizacion() {
        return ModCapitalizacion;
    }

    public void setModCapitalizacion(float ModCapitalizacion) {
        this.ModCapitalizacion = ModCapitalizacion;
    }

    public float getModLeyPyme() {
        return ModLeyPyme;
    }

    public void setModLeyPyme(float ModLeyPyme) {
        this.ModLeyPyme = ModLeyPyme;
    }

    public float getModTaza() {
        return ModTaza;
    }

    public void setModTaza(float ModTaza) {
        this.ModTaza = ModTaza;
    }

    public int getModPlazo() {
        return ModPlazo;
    }

    public void setModPlazo(int ModPlazo) {
        this.ModPlazo = ModPlazo;
    }
    
    
}
