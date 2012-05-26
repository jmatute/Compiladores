//package compi;

import java.util.*;

public class Cuadrupla {

    private String Operador; 
    private String Argumento1;
    private String Argumento2;   
    private String Resultado;
    
    public Cuadrupla(String Operador, String Argumento1, String Argumento2, String Resultado){
        this.Operador = Operador;
        this.Argumento1 = Argumento1;
        this.Argumento2 = Argumento2;
        this.Resultado = Resultado;        
    }
    
    public String getOperador(){ 
		return Operador; 
	}
    
    public String getArgumento1(){ 
		return Argumento1; 
	}
    
    public String getArgumento2(){ 
		return Argumento2; 
	}
    
    public String getResultado(){ 
		return Resultado; 
	}
    
	public void setOperador(String Operador){ 
		this.Operador=Operador; 
	}
    
    public void setArgumento1(String Argumento1){ 
		this.Argumento1 = Argumento1; 
	}
    
    public void setArgumento2(String Argumento2){ 
		this.Argumento2 = Argumento2; 
	}
    
    public void setResultado(String Resultado){ 
		this.Resultado = Resultado; 
	}

}
