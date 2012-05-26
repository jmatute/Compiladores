

public class Objeto {

  Tipo t;
  Tipo TipoExtraVariant; 
  int SizeChain;
  String id = "";
  String error_msg = null;
  int line = 0;
  int column = 0;
  int offset; 
  private String lugar = "";  
  public Objeto(Tipo enviado){
    t = enviado;
    SizeChain = 0;
    offset = -1;
  }

  public void setLugar(String s){
    this.lugar = s;
  }
  public String getLugar(){
    return this.lugar;
  }
}
