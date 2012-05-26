import java_cup.runtime.*;
import java.util.*;
%%

%class prueba
%standalone
%line
%column
%ignorecase
%cup



%{

  ArrayList<Custom_Error> errores_flex = new ArrayList<Custom_Error>();
	
  private Symbol symbol(int type){
		return new Symbol(type,yyline,yycolumn);
	}
	
	private Symbol symbol(int type,Object value){
		return new Symbol(type,yyline,yycolumn,value);
	}
%}

fin_declar = ((("\n")+|("\r\n")+)" "*)+
coma = ","
id = [a-zA-Z]([a-zA-Z0-9]|"_")*
inic_declaracion = "Dim"
as = "As"
separador = {coma}
do = "Do"
parder = "("
parizq = ")"
to = "To"
ref = "ByVal"|"ByRef"
sub = "Sub"
function ="Function"
if = "If"
then = "Then"
elsif = "ElseIf"
else = "Else"
igual = "="
oprel = ">="|"<="|"<"|">"|"<>"|"And"|"Or"|"Xor"
not = "Not"
end = "End"
for = "For"
next = "Next"
while = "While"
write = "Write"
writeln = "Writeln"
input = "Input"
loop = "Loop"
num = [0-9]+
comilla = "\""
cadenah = ({comilla}([^\r\n]|[^\n])*{comilla})
return = "return"
cadena = {cadenah}(" "|"\t")*   
saltoCadena = "&_"
tipo = "Char"|"String"|"Integer"|"Boolean"
true = "True"
false = "False"
espacio = " "+|"\t"+
por = "*"
entre = "/"
mas = "+"
menos = "-"
comentario = (("'"([^\r\n]|[^\n])*{fin_declar})+|{fin_declar}+)+
type = "Type"
exit = "Exit"
punto = "."
%%
<YYINITIAL>{

 {write} { return symbol(sym.WRITE); }
 {writeln} { return symbol(sym.WRITELN); }
 {input} { return symbol(sym.INPUT);}
 {comentario} { return symbol(sym.FIN); }
 {not} {return symbol(sym.NOT); }
 {punto} { return symbol(sym.PUNTO);}
 {exit} { return symbol(sym.EXIT); }
 {tipo} { return symbol(sym.TIPO,yytext()); }
 {type} { return symbol(sym.TYPE); }
 {cadena} { return symbol(sym.CADENA,yytext());}
 {saltoCadena} { return symbol(sym.SALTOCADENA); }
 {return} { return symbol(sym.RETURN);}
 {igual} { return symbol(sym.IGUAL,yytext());}
 {oprel} { return symbol(sym.OPREL,yytext());}
 {true} { return symbol(sym.TRUE);}
 {por} { return symbol(sym.POR);}
 {entre} { return symbol(sym.ENTRE);}
 {mas} { return symbol(sym.MAS);}
 {menos} { return symbol(sym.MENOS); }
 {false} { return symbol(sym.FALSE);}
 {while} { return symbol(sym.WHILE);}
 {num} { return symbol(sym.NUM,yytext());}
 {loop} { return symbol(sym.LOOP);}
 {do} {return symbol(sym.DO);}
 {parder} {return symbol(sym.PARDER);}
 {parizq} {return symbol(sym.PARIZQ);}
 {as} { return symbol(sym.AS);}
 {ref} { return symbol(sym.REF, yytext());}
 {inic_declaracion} { return symbol(sym.DIM);}
 {sub} { return symbol(sym.SUB);}
 {function} { return symbol(sym.FUNCTION);}
 {if} { return symbol(sym.IF);}
 {then} { return symbol(sym.THEN);}
 {elsif} { return symbol(sym.ELSEIF);} 
 {else} { return symbol(sym.ELSE);}
 {end} { return symbol(sym.END);}
 {for}  { return symbol(sym.FOR);}
 {next} { return symbol(sym.NEXT);}
 {to} { return symbol(sym.TO);}
 {separador} { return symbol(sym.SEPARADOR);}
 {id} { return symbol(sym.NAME,yytext());}
 {espacio} { }
 . { errores_flex.add( new Custom_Error(yyline+1, "Error: Caracter ilegal -> "+ yytext() + " linea " + (yyline+1) + " columna" + (yycolumn+1))); }
}
