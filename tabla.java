import java.util.ArrayList;

class tabla{
  tabla parent;
  String ambito;
  ArrayList<Registro> filas = new ArrayList<Registro>();

  public tabla(tabla padre,String ambi){
    this.parent = padre;
    this.ambito = ambi;
    
  }

  public void agregarATabla(String id,Tipo t,int line){
    filas.add(new Registro(id,t,line) );    
  }

  
}
