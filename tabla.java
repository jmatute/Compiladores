import java.util.ArrayList;

class tabla{
  tabla parent;
  String ambito;
  ArrayList<Registro> filas = new ArrayList<Registro>();
  ArrayList<tabla> hijos = new ArrayList<tabla>();

  public tabla(tabla padre,String ambi){
    this.parent = padre;
    this.ambito = ambi;
    
  }

  public boolean agregarATabla(String id,Tipo t){
    boolean meter = true;
    for(Registro r:filas) 
      if (r.id.equals(id))
        meter = false;
    
    if(meter)
       filas.add(new Registro(id,t) );
    
    return meter;    
  }


  public Tipo BuscarEnTabla(String id){
    tabla tmp;
    tmp = this;
    
    while(true){
      for(Registro r:tmp.filas){
        if(r.id.equals(id))
        {
          return r.type;
        } 
      }
      if ( tmp.parent == null)
        break;
      tmp = tmp.parent;
    }
    
    return new Tipo("error");
  }

  public Tipo BuscarEnAmbito(String id){
      for(Registro r:filas){
        if(r.id.equals(id))
        {
          return r.type;
        } 
      }
    return new Tipo("error");
  }

  public String toString(){
    String cad = ambito + "\n";
    for(Registro r:filas)
      cad += r.toString() + "\n";
    return cad;

  }
  
}
