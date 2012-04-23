
class Registro{
  String id;
  Tipo type;
  int linea; 
  public Registro(String nombre, Tipo t,int line){
    this.id = nombre;
    this.type = t;
    int linea = line;
  }

  public String toString(){
    return id + " -- "+type.toString() + "-- "+ linea;
  }
}
