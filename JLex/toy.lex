class Token {
	private int type;
	private String name;
	Token(String n, int t){name = n; type = t;}
	public int getType() { return type;}
	public String getName() { return name;}
}
%%
%unicode
%type Token
%eofval{
	return null;
%eofval}

%{
public static final int BOOLEAN = 1000;
public static final int BREAK = 1001;
public static final int CLASS = 1002;
public static final int DOUBLE = 1003;
public static final int ELSE = 1004;
public static final int EXTENDS = 1005;
public static final int FALSE = 1006;
public static final int FOR = 1007;
public static final int IF = 1008;
public static final int IMPLEMENTS = 1009;
public static final int INT = 1010;
public static final int INTERFACE = 1011;
public static final int NEWARRAY = 1012;
public static final int PRINTLN = 1013;
public static final int READLN = 1014;
public static final int RETURN = 1015;
public static final int STRING = 1016;
public static final int TRUE = 1017;
public static final int VOID = 1018;
public static final int WHILE = 1019;
public static final int ID = 1020;
public static final int PLUS = 1021;
public static final int MINUS = 1022;
public static final int MUL = 1023;
public static final int DIV = 1024;
public static final int MOD = 1025;
public static final int LESS = 1026;
public static final int LESSEQ = 1027;
public static final int GREATER = 1028;
public static final int GREATEREQ = 1029;
public static final int EQUAL = 1030;
public static final int NOTEQ = 1031;
public static final int AND = 1032;
public static final int OR = 1033;
public static final int NOT = 1034;
public static final int ASSIGNOP = 1035;
public static final int SEMICOLON= 1036;
public static final int COMMA = 1037;
public static final int PERIOD = 1038;
public static final int LEFTPAREN = 1039;
public static final int RIGHTPAREN = 1040;
public static final int LEFTBRACKET = 1041;
public static final int RIGHTBRACKET = 1042;
public static final int LEFTBRACE = 1043;
public static final int RIGHTBRACE = 1044;
public static final int INTCONST = 1045;
public static final int DOUBLECONST = 1046;
public static final int STRINGCONST = 1047;
public static final int BOOLCONST = 1048;
%}
Digit=[0-9]
Letter=[A-Za-z]
DandL=[0-9A-Za-z]
WhiteSpace=[\t \n\r]
%%
"boolean" {return new Token("boolean", BOOLEAN);}
"break" {return new Token("break", BREAK);}
"class" {return new Token("class", CLASS);}
"double" {return new Token("double", DOUBLE);}
"else" {return new Token("else", ELSE);}
"extends" {return new Token("extends", EXTENDS);}
"false" {return new Token("false", FALSE);}
"for" {return new Token("for", FOR);}
"if" {return new Token("if", IF);}
"implements" {return new Token("implements", IMPLEMENTS);}
"int" {return new Token("int", INT);}
"interface" {return new Token("interface", INTERFACE);}
"newarray" {return new Token("newarray", NEWARRAY);}
"println" {return new Token("println", PRINTLN);}
"readln" {return new Token("readln", READLN);}
"return" {return new Token("return", RETURN);}
"string" {return new Token("string", STRING);}
"true" {return new Token("true", TRUE);}
"void" {return new Token("void", VOID);}
"while" {return new Token("while", WHILE);}
{Letter}({DandL}|_)* {return new Token(yytext(), ID);}
{WhiteSpace} {}
{Digit}+|0[xX][0-9A-Fa-f]+ {return new Token("intconstant", INTCONST);}
{Digit}+\.{Digit}*|{Digit}+\.{Digit}*[Ee][+-]?{Digit}+ {return new Token("doubleconstant", DOUBLECONST);}
\"[^\n\r\"]*\" {return new Token("stringconstant", STRINGCONST);}
"true"|"false" {return new Token("booleanconstant", BOOLCONST);}
"+" {return new Token("plus", PLUS);}
"-" {return new Token("minus", MINUS);}
"*" {return new Token("multiplication", MUL);}
"/" {return new Token("division", DIV);}
"%" {return new Token("mod", MOD);}
"<" {return new Token("less", LESS);}
"<=" {return new Token("lessequal", LESSEQ);}
">" {return new Token("greater", GREATER);}
">=" {return new Token("greaterequal", GREATEREQ);}
"==" {return new Token("equal", EQUAL);}
"!=" {return new Token("notequal", NOTEQ);}
"&&" {return new Token("and", AND);}
"||" {return new Token("or", OR);}
"!" {return new Token("not", NOT);}
"=" {return new Token("assignop", ASSIGNOP);}
";" {return new Token("semicolon", SEMICOLON);}
"," {return new Token("comma", COMMA);}
"." {return new Token("period", PERIOD);}
"(" {return new Token("leftparen", LEFTPAREN);}
")" {return new Token("rightparen", RIGHTPAREN);}
"[" {return new Token("leftbracket", LEFTBRACKET);}
"]" {return new Token("rightbracket", RIGHTBRACKET);}
"{" {return new Token("leftbrace", LEFTBRACE);}
"}" {return new Token("rightbrace", RIGHTBRACE);}
//.* {}
/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/ {}
. {return new Token("illegalToken", -1);}
