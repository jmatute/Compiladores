//package compi;

/*
ASIG argumento1  hacia resultado 
ASIG_OFFSET
GET_OFFSET
GOTO resultado
NEG argumento1 resultado
IF< argumento1 < argumento2 hacia resultado
IF<= argumento1 <= argumento2 hacia resultado
IF> argumento1 > argumento2 hacia resultado
IF>= argumento1 >= argumento2 hacia resultado
IF= argumento1 = argumento2 hacia resultado
+ ( MAS )
- ( MENOS )
* ( POR  )
/ ( DIV  )
ETIQ argumento1   genera etiqueta de argumento1
PARAM  argumento1 genera el parametro de llamada a funcion
CALL argumento1 llama a funcion
RET argumentos vacios, genera retorno de funcion
NOT argumento1 resultado

*/

import java.util.*;

public class CodigoIntermedioTools{
	
	private int tempActual;
	private int etiqActual;
	private ArrayList<Cuadrupla> cuadruplaArrayList = new ArrayList<Cuadrupla>();
	
  public CodigoIntermedioTools(){
    tempActual = 0;
    etiqActual = 0;
  }
	public String nuevaTemp() {
		return "_t"+(++tempActual);
	}
	
		public String nuevaEtiq() {
		return "_etiq"+(++etiqActual);
	}
		
	public int siguienteCuad(){
		return cuadruplaArrayList.size();
	}
	
	public ArrayList<Cuadrupla> getCuadruplaArrayList(){
		return cuadruplaArrayList;
	}
    
	public void gen(Object Operador, Object Argumento1, Object Argumento2, Object Resultado){
		String oprdr = Operador.toString();
		String rgmnt1 = Argumento1.toString();
		String rgmnt2 = Argumento2.toString();
		String rsltd = Resultado.toString();
		Cuadrupla cuad = new Cuadrupla(oprdr, rgmnt1, rgmnt2, rsltd);
		cuadruplaArrayList.add(cuad);
	}
	
	public String imprimir(){
    String resp = "";
		for(int i=0;i<cuadruplaArrayList.size();i++){
			Cuadrupla cuad = cuadruplaArrayList.get(i);
			resp += "Instruccion " + i + ": "+ cuad.getOperador() + "\t" + cuad.getArgumento1() + "\t" + cuad.getArgumento2() + "\t" + cuad.getResultado() + "\n";
		}
    return resp;
	}	
}
