import java.util.ArrayList;
import java.util.Map;

class Tipo{
  private tipos type;
  private tipos variant_type;
  ArrayList<Tipo> funciones_var = new ArrayList<Tipo>();
  // funciones va a estar definida de la siguiente forma
  // cada posicion en el arraylist son los tipos de parametro
  // excepto la ultima que sera el valor de retorno  
  public Tipo(tipos t){
    this.type = t;
  }
}
