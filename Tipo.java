import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

class Tipo{
  private String name;
  private int TipoFinal;
  public TipoExtraVariant:  

  ArrayList<Tipo> metodo_var = new ArrayList<Tipo>();
  
  HashMap<String,Tipo> atributos = new HashMap<String,Tipo>();
  
  // funciones va a estar definida de la siguiente forma
  // cada posicion en el arraylist son los tipos de parametro
  // excepto la ultima que sera el valor de retorno  
  public Tipo(String nombre){
    this.name = nombre;
  }

  public String getName(){
    return this.name;
  }
  public void setTipoFinal(int tipo){
    //0 no es funcion ni sub
    //1 es funcion
    //2 es sub  
    //3 es estructura
    if (tipo > 3 || tipo < 0)
      return;
    this.TipoFinal = tipo;
  }


  public int getTipoFinal(){
     return TipoFinal;
  }

  

  public String toString(){
    if ( atributos.size() == 0 && this.TipoFinal == 0)
      return name;
    else if( this.TipoFinal == 1){
      StringBuffer sb = new StringBuffer();
      sb.append(name + ":");
      for( int i = 0; i < this.metodo_var.size() - 1; i++){
        sb.append( this.metodo_var.get(i).toString());
        sb.append("x");
      }
      String tmp = sb.toString();
      tmp = tmp.substring(0,tmp.length()-1);
      tmp +=   "---->" + this.metodo_var.get( metodo_var.size() -1).toString() ;
      return tmp;
    }
    else{
        String cad = name + ": record(" ;
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String,Tipo> entry : atributos.entrySet()) {
            sb.append("(" + entry.getKey() );
            sb.append("x");
            sb.append( entry.getValue().toString() + ")x");
           }
        String tmp = sb.toString();
        tmp = tmp.substring(0,tmp.length()-1);
        cad += tmp + ")";
        return cad;   
    }
  }

  public boolean agregar_atributos(String s,Tipo t){
      boolean agregado = false;
      if( atributos.get(s) == null)
        agregado = true;
      if(agregado)
        atributos.put(s,t);
      return agregado;
    }


}
