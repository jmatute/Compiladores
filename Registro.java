
class Registro{
  String id;
  Tipo type;
  Tipo ExtraTipoVariant;
  public Registro(String nombre, Tipo t){
    this.id = nombre;
    this.type = t;
  }

  public String toString(){
    return id + " -- "+type.toString();
  }
}
