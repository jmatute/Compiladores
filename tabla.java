import java.util.ArrayList;

class tabla{
  tabla parent;
  String ambito;
  ArrayList<Registro> filas = new ArrayList<Registro>();

  public tabla(tabla padre,String ambi){
    this.parent = padre;
    this.ambito = ambi;
  }

  public void agregartabla(String id,Tipo t){
    filas.add(new Registro(id,t) );    
  }

  
}
