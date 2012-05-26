import java.util.ArrayList;

class tabla{
  tabla parent;
  String ambito;
  ArrayList<Registro> filas = new ArrayList<Registro>();
  ArrayList<tabla> hijos = new ArrayList<tabla>();
  int offset;
  public tabla(tabla padre,String ambi){
    this.parent = padre;
    this.ambito = ambi;
    offset = 0;
  }

  public boolean agregarATabla(String id,Tipo t){
    
    boolean meter = true;
    for(Registro r:filas) 
      if (r.id.equals(id))
        meter = false;
    if(meter)
    {   filas.add(new Registro(id,t,offset) );
        offset += t.getSize();
    }
    
    return meter;    
  }

  public void CambiarExtraTipo(String id,Tipo nv_tipo){
    tabla tmp;
    tmp = this;
    
    while(true){
      for(Registro r:tmp.filas){
        if(r.id.equals(id))
        {
              r.ExtraTipoVariant = nv_tipo;            
              return;
        } 
      }
      if ( tmp.parent == null)
        break;
      tmp = tmp.parent;
    }
  }

  public Tipo BuscarExtraTipo(String id){
    tabla tmp;
    tmp = this;
    
    while(true){
      for(Registro r:tmp.filas){
        if(r.id.equals(id))
        {
          return r.ExtraTipoVariant;
        } 
      }
      if ( tmp.parent == null)
        break;
      tmp = tmp.parent;
    }
    
    return new Tipo("error");


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
