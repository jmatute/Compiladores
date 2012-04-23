import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

class Tipo{
  private String name;
  private int esFuncion;
  //0 no es funcion ni sub
  //1 es funcion
  //2 es sub  


  ArrayList<Tipo> metodo_var = new ArrayList<Tipo>();
  
  HashMap<String,Tipo> atributos = new HashMap<String,Tipo>();
  // funciones va a estar definida de la siguiente forma
  // cada posicion en el arraylist son los tipos de parametro
  // excepto la ultima que sera el valor de retorno  
  public Tipo(String nombre){
    this.name = nombre;
  }
  public String toString(){
    if ( atributos.size() == 0)
      return name;
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

  public void agregar_atributos(String s,Tipo t){
      atributos.put(s,t);
  }


}
