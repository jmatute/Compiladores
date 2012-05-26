
class Registro{
  String id;
  Tipo type;
  Tipo ExtraTipoVariant;
  int offset;
  public Registro(String nombre, Tipo t,int move){
    this.id = nombre;
    this.type = t;
    this.offset = move;
  }

  public String toString(){
    return id + " -- "+type.toString();
  }
}
