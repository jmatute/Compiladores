

public class Objeto {

  Tipo t;
  Tipo TipoExtraVariant; 
  int SizeChain;
  String id = "";
  String error_msg = null;
  int line = 0;
  int column = 0;
  public Objeto(Tipo enviado){
    t = enviado;
    SizeChain = 0;
  }
}
