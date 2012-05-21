import java_cup.runtime.Symbol;
import java.io.*;
import java.util.*;
class Main {
    static boolean do_debug_parse = false;
    static HashMap<String,Tipo> seen_types; 
   
    static public void main(String[] args) throws java.io.IOException {
    tabla Tabla_simbolos = new tabla(null,"global"); 

    iniciarTipos();
    String archivo = args[0];
    String mis = Main.recovery_string(archivo);

    String arc = "tmp.txt";
    parser parser_obj = new parser(new prueba(new FileReader(archivo)));
		parser_obj.first_time = true;
    parser_obj.ambito = Tabla_simbolos;
    parser_obj.seen_types = seen_types;
    System.out.println(mis);
    Symbol parse_tree = null;

    //Primera pasada
		try {
			if (do_debug_parse)
				 parse_tree = parser_obj.debug_parse();
			else parse_tree = parser_obj.parse();
    if (!parser_obj.has_main)
			  System.out.println("No tiene main!!");    
		} catch (Exception e) {
      e.printStackTrace();
			System.out.println("Horror");
		}
    
    //Segunda pasada
    //System.out.println(Tabla_simbolos.toString());

    parser parser_obj2 = new parser(new prueba(new FileReader(archivo)));
		parser_obj2.first_time = false;
    parser_obj2.ambito = Tabla_simbolos;
    parser_obj2.seen_types = seen_types;
    System.out.println(mis);
    parse_tree = null;
		try {
			if (do_debug_parse)
				 parse_tree = parser_obj2.debug_parse();
			else parse_tree = parser_obj2.parse();
		} catch (Exception e) {
      e.printStackTrace();
			System.out.println("Horror");
		}


 
    }




  public static void iniciarTipos(){
       seen_types = new HashMap<String,Tipo>(); 
       seen_types.put("string",new Tipo("string"));
       seen_types.put("char",new Tipo("char"));
       seen_types.put("boolean",new Tipo("boolean"));
       seen_types.put("integer",new Tipo("integer"));
       seen_types.put("variant",new Tipo("variant"));
       seen_types.put("error", new Tipo("error"));
  }



  static public String recovery_string(String path){
        File file = new File(path);
        String writeTo = "";
        String errores = "";

        boolean inFunction = false;
        boolean inSub = false;

        int columna = 1;
        int fila = 1;
        try{
          Scanner scanner = new Scanner(file);
          while(scanner.hasNextLine()){
            String lin =  scanner.nextLine() + "\n";
            String linea = lin.toLowerCase();
            if (linea.contains("function") && !linea.contains("end"))
            {
               if(inSub){
                  linea = "End Sub\n" + linea; 
                  inSub = false;
                  errores += "Error en linea " + fila + " y en columna 1\n"+ "Error: se esperaba finalizacion de sub \n";
                  
               }
               inFunction = true;        
            }     
            else if (linea.contains("sub") && !linea.contains("end"))
            {
                if(inFunction){
                  linea = "end function\n" + linea; 
                  errores += "Error en linea " + fila + " y en columna 1\n"+ "Error: se esperaba finalizacion de funcion  \n";
                  inFunction = false;
                }
                inSub = true;
            }          
            else if (linea.contains("function") && linea.contains("end"))
            {
              inFunction = false;
            }         
            else if (linea.contains("sub") && linea.contains("end"))
            {
              inSub = false;
            }         

 
            char[] arreglo = linea.toCharArray();    
            for(int i = 0;i < arreglo.length;i++ ){
              char c = arreglo[i];
              if ( c == '"'){
                writeTo += c;
                i+= 1;
                while(true) {
                  if (arreglo[i] == '"'){
                      writeTo += arreglo[i];
                      break;
                  }
                  if (arreglo[i] == '\r'  || arreglo[i] == '\n'){
                      errores += "Error en linea " + fila + " y en columna " + i + "\n"+ "Error: se esperaba finalizacion de cadena \" \n";
                      writeTo += '"';
                      writeTo += arreglo[i];
                      break;
                  }
                  else
                    writeTo += arreglo[i];
                  i+=1; 
                }
              }
              else
                writeTo += arreglo[i];
              }
              fila ++;
            }
              
               if(inSub){
                  writeTo += "\nEnd Sub\n" ; 
                  inSub = false;
               }
            
                if(inFunction){
                  writeTo += "\nEnd Function\n"; 
                  inSub = false;
                }

            

        }
         catch(FileNotFoundException e){
          System.err.println("Archivo no encontrado");
          return "";
        }
        
      try{
        FileWriter outFile = new FileWriter("tmp.txt");
        PrintWriter out = new PrintWriter(outFile); 
        out.print(writeTo);
        out.close();
      } catch ( IOException e){
       e.printStackTrace();
    }
     return errores;
  }
}
