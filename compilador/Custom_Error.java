import java.util.*;

class Custom_Error implements Comparable<Custom_Error>{
  int linea;
  String msg;
  public Custom_Error(int l,String s){
    this.linea = l;
    this.msg = s;
  }

  public int compareTo(Custom_Error o2){
     Integer otro = (Integer)o2.linea;
    int resp= ((Integer)this.linea).compareTo(otro);
    return resp;
  }
  
}
