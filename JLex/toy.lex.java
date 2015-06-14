class Token {
	private int type;
	private String name;
	Token(String n, int t){name = n; type = t;}
	public int getType() { return type;}
	public String getName() { return name;}
}


class Yylex {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

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
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NOT_ACCEPT,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NOT_ACCEPT,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NOT_ACCEPT,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NOT_ACCEPT,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NOT_ACCEPT,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NOT_ACCEPT,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NOT_ACCEPT,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NOT_ACCEPT,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NO_ANCHOR,
		/* 151 */ YY_NO_ANCHOR,
		/* 152 */ YY_NO_ANCHOR,
		/* 153 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"32:9,33,27,32:2,27,32:18,33,44,36,32:2,40,45,32,49,50,38,37,48,35,31,39,28," +
"25:9,32,47,41,42,43,32:2,30:4,34,30,24:17,29,24:2,51,32,52,32,26,32,5,1,9,1" +
"1,4,15,21,23,16,24,8,3,17,6,2,18,24,7,10,14,12,22,19,13,20,24,53,46,54,32:6" +
"5410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,154,
"0,1,2,3,1:6,4,1,5,6,7,8,1:8,9,10,1,11,1:6,9,12,9:3,1,9:14,13,14,15,16,17,18" +
",19,20,21,16,22,18,23,24,25,26,27,28,29,30,31,17,32,33,34,35,36,37,38,39,40" +
",41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65" +
",66,67,68,9,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89," +
"90,91,92,93,94,95,96,97,9,98,99,100,101,102,103,104,105,106,107")[0];

	private int yy_nxt[][] = unpackFromString(108,55,
"1,2,143:2,109,143,146,147,143,148,149,150,143:2,110,89,55,143,151,152,143:2" +
",111,143:2,3,4,5,90,143:2,6,4,5,143,7,57,8,9,10,11,12,13,14,15,62,66,16,17," +
"18,19,20,21,22,23,-1:56,143,153,143:4,112,143:18,113,-1,143:3,-1:3,143,-1:2" +
"1,54:24,92,54,-1,92,54:2,25,54:23,-1:38,67,27,-1:57,28,-1:54,29,-1:54,30,-1" +
":54,31,-1:13,143:25,113,-1,143:3,-1:3,143,-1:24,69,-1:20,25,-1:2,25,-1:5,69" +
",-1:21,27:26,-1,27:27,-1,143:3,145,143:21,113,-1,143:3,-1:3,143,-1:24,69,-1" +
":20,54,-1:2,54,-1:5,69,-1:21,143:5,64,143:8,24,143,121,143:8,113,-1,143:3,-" +
"1:3,143,-1:21,56,-1:2,56:2,-1:3,56,-1,56,-1:3,56,-1:9,56,-1:2,56,-1,56,-1:3" +
",56,-1:21,63:26,-1,63:8,26,63:18,-1:25,58,-1:2,58,-1:27,56,-1:2,61,56,-1:3," +
"56,-1,56,-1:3,56,-1:9,65,-1:2,65,-1,56,-1:3,61,-1:21,143:6,34,143:18,113,-1" +
",143:3,-1:3,143,-1:21,56,-1:2,56:2,-1:3,56,-1,56,-1:3,56,-1:9,56,-1:2,56,-1" +
",56,-1:3,56,75,-1,75,-1:62,32,-1:10,143:13,35,143:11,113,-1,143:3,-1:3,143," +
"-1:66,33,-1:9,67:37,73,67:16,-1,143:3,36,143:21,113,-1,143:3,-1:3,143,-1:45" +
",58,-1:2,58,-1:6,75,-1,75,-1:18,143:3,37,143:21,113,-1,143:3,-1:3,143,-1:24" +
",69,-1:20,25,-1:2,25,-1:5,69,75,-1,75,-1:18,143:10,38,143:14,113,-1,143:3,-" +
"1:3,143,-1:21,67:37,73,39,67:15,-1,143:7,40,143:17,113,-1,143:3,-1:3,143,-1" +
":21,143:9,41,143:15,113,-1,143:3,-1:3,143,-1:21,143:3,42,143:21,113,-1,143:" +
"3,-1:3,143,-1:21,143:3,43,143:21,113,-1,143:3,-1:3,143,-1:21,143:5,44,143:1" +
"9,113,-1,143:3,-1:3,143,-1:21,143:5,45,143:19,113,-1,143:3,-1:3,143,-1:21,1" +
"43:20,46,143:4,113,-1,143:3,-1:3,143,-1:21,143:3,47,143:21,113,-1,143:3,-1:" +
"3,143,-1:21,143:5,48,143:19,113,-1,143:3,-1:3,143,-1:21,143:9,49,143:15,113" +
",-1,143:3,-1:3,143,-1:21,143:5,50,143:19,113,-1,143:3,-1:3,143,-1:21,143:19" +
",51,143:5,113,-1,143:3,-1:3,143,-1:21,143:3,52,143:21,113,-1,143:3,-1:3,143" +
",-1:21,143:9,53,143:15,113,-1,143:3,-1:3,143,-1:21,143,60,143:2,120,143:20," +
"113,-1,143:3,-1:3,143,-1:21,54:12,59,54:11,92,54,-1,92,59,54,25,54:23,-1,14" +
"3:9,68,143:15,113,-1,143:3,-1:3,143,-1:21,54:3,71,54:20,92,54,-1,92,54:2,25" +
",54:2,71,54:20,-1,143:11,70,143:13,113,-1,143:3,-1:3,143,-1:21,143:15,72,14" +
"3:9,113,-1,143:3,-1:3,143,-1:21,143:4,74,143:20,113,-1,143:3,-1:3,143,-1:21" +
",143:9,76,143:15,113,-1,143:3,-1:3,143,-1:21,143:9,77,143:15,113,-1,143:3,-" +
"1:3,143,-1:21,143:2,78,143:22,113,-1,143:3,-1:3,143,-1:21,143:2,79,143:22,1" +
"13,-1,143:3,-1:3,143,-1:21,143:6,80,143:18,113,-1,143:3,-1:3,143,-1:21,143:" +
"5,81,143:19,113,-1,143:3,-1:3,143,-1:21,143:2,82,143:22,113,-1,143:3,-1:3,1" +
"43,-1:21,143:4,83,143:20,113,-1,143:3,-1:3,143,-1:21,143:10,84,143:14,113,-" +
"1,143:3,-1:3,143,-1:21,143:2,85,143:22,113,-1,143:3,-1:3,143,-1:21,143:4,86" +
",143:20,113,-1,143:3,-1:3,143,-1:21,143:8,87,143:16,113,-1,143:3,-1:3,143,-" +
"1:21,143:13,88,143:11,113,-1,143:3,-1:3,143,-1:21,143:2,91,143:9,114,143:12" +
",113,-1,143:3,-1:3,143,-1:21,143:6,93,143:18,113,-1,143:3,-1:3,143,-1:21,14" +
"3,94,143:23,113,-1,143:3,-1:3,143,-1:21,143:3,95,143:21,113,-1,143:3,-1:3,1" +
"43,-1:21,143:13,125,143:11,113,-1,143:3,-1:3,143,-1:21,143:18,126,143:6,113" +
",-1,143:3,-1:3,143,-1:21,143:4,127,143:8,128,143:11,113,-1,143:3,-1:3,143,-" +
"1:21,143:4,96,143:20,113,-1,143:3,-1:3,143,-1:21,143:6,129,143:18,113,-1,14" +
"3:3,-1:3,143,-1:21,143:11,130,143:13,113,-1,143:3,-1:3,143,-1:21,143:2,97,1" +
"43:22,113,-1,143:3,-1:3,143,-1:21,143:17,144,143:7,113,-1,143:3,-1:3,143,-1" +
":21,143:15,131,143:9,113,-1,143:3,-1:3,143,-1:21,143:15,98,143:9,113,-1,143" +
":3,-1:3,143,-1:21,143:2,132,143:22,113,-1,143:3,-1:3,143,-1:21,143:3,133,14" +
"3:21,113,-1,143:3,-1:3,143,-1:21,143:4,134,143:20,113,-1,143:3,-1:3,143,-1:" +
"21,143:10,99,143:14,113,-1,143:3,-1:3,143,-1:21,143:11,100,143:13,113,-1,14" +
"3:3,-1:3,143,-1:21,143:15,101,143:9,113,-1,143:3,-1:3,143,-1:21,102,143:24," +
"113,-1,143:3,-1:3,143,-1:21,143:5,136,143:19,113,-1,143:3,-1:3,143,-1:21,14" +
"3:3,103,143:21,113,-1,143:3,-1:3,143,-1:21,143:5,104,143:19,113,-1,143:3,-1" +
":3,143,-1:21,143:6,137,143:18,113,-1,143:3,-1:3,143,-1:21,143:3,139,143:21," +
"113,-1,143:3,-1:3,143,-1:21,143:13,105,143:11,113,-1,143:3,-1:3,143,-1:21,1" +
"43:6,106,143:18,113,-1,143:3,-1:3,143,-1:21,143:14,140,143:10,113,-1,143:3," +
"-1:3,143,-1:21,143:16,141,143:8,113,-1,143:3,-1:3,143,-1:21,143:4,107,143:2" +
"0,113,-1,143:3,-1:3,143,-1:21,143:3,142,143:21,113,-1,143:3,-1:3,143,-1:21," +
"143:5,108,143:19,113,-1,143:3,-1:3,143,-1:21,143:2,135,143:22,113,-1,143:3," +
"-1:3,143,-1:21,143:6,138,143:18,113,-1,143:3,-1:3,143,-1:21,143:3,115,143:2" +
"1,113,-1,143:3,-1:3,143,-1:21,143:3,116,143:21,113,-1,143:3,-1:3,143,-1:21," +
"143:2,117,143:22,113,-1,143:3,-1:3,143,-1:21,143:13,118,143:11,113,-1,143:3" +
",-1:3,143,-1:21,143,119,143:23,113,-1,143:3,-1:3,143,-1:21,143:6,122,143:18" +
",113,-1,143:3,-1:3,143,-1:21,143:22,123,143:2,113,-1,143:3,-1:3,143,-1:21,1" +
"43,124,143:23,113,-1,143:3,-1:3,143,-1:20");

	public Token yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

	return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					if(yy_at_bol)
						System.out.println();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{return new Token(yytext(), ID);}
					case -3:
						break;
					case 3:
						{return new Token("intconstant", INTCONST);}
					case -4:
						break;
					case 4:
						{return new Token("illegalToken", -1);}
					case -5:
						break;
					case 5:
						{}
					case -6:
						break;
					case 6:
						{return new Token("period", PERIOD);}
					case -7:
						break;
					case 7:
						{return new Token("minus", MINUS);}
					case -8:
						break;
					case 8:
						{return new Token("plus", PLUS);}
					case -9:
						break;
					case 9:
						{return new Token("multiplication", MUL);}
					case -10:
						break;
					case 10:
						{return new Token("division", DIV);}
					case -11:
						break;
					case 11:
						{return new Token("mod", MOD);}
					case -12:
						break;
					case 12:
						{return new Token("less", LESS);}
					case -13:
						break;
					case 13:
						{return new Token("assignop", ASSIGNOP);}
					case -14:
						break;
					case 14:
						{return new Token("greater", GREATER);}
					case -15:
						break;
					case 15:
						{return new Token("not", NOT);}
					case -16:
						break;
					case 16:
						{return new Token("semicolon", SEMICOLON);}
					case -17:
						break;
					case 17:
						{return new Token("comma", COMMA);}
					case -18:
						break;
					case 18:
						{return new Token("leftparen", LEFTPAREN);}
					case -19:
						break;
					case 19:
						{return new Token("rightparen", RIGHTPAREN);}
					case -20:
						break;
					case 20:
						{return new Token("leftbracket", LEFTBRACKET);}
					case -21:
						break;
					case 21:
						{return new Token("rightbracket", RIGHTBRACKET);}
					case -22:
						break;
					case 22:
						{return new Token("leftbrace", LEFTBRACE);}
					case -23:
						break;
					case 23:
						{return new Token("rightbrace", RIGHTBRACE);}
					case -24:
						break;
					case 24:
						{return new Token("if", IF);}
					case -25:
						break;
					case 25:
						{return new Token("doubleconstant", DOUBLECONST);}
					case -26:
						break;
					case 26:
						{return new Token("stringconstant", STRINGCONST);}
					case -27:
						break;
					case 27:
						{}
					case -28:
						break;
					case 28:
						{return new Token("lessequal", LESSEQ);}
					case -29:
						break;
					case 29:
						{return new Token("equal", EQUAL);}
					case -30:
						break;
					case 30:
						{return new Token("greaterequal", GREATEREQ);}
					case -31:
						break;
					case 31:
						{return new Token("notequal", NOTEQ);}
					case -32:
						break;
					case 32:
						{return new Token("and", AND);}
					case -33:
						break;
					case 33:
						{return new Token("or", OR);}
					case -34:
						break;
					case 34:
						{return new Token("for", FOR);}
					case -35:
						break;
					case 35:
						{return new Token("int", INT);}
					case -36:
						break;
					case 36:
						{return new Token("else", ELSE);}
					case -37:
						break;
					case 37:
						{return new Token("true", TRUE);}
					case -38:
						break;
					case 38:
						{return new Token("void", VOID);}
					case -39:
						break;
					case 39:
						{}
					case -40:
						break;
					case 40:
						{return new Token("break", BREAK);}
					case -41:
						break;
					case 41:
						{return new Token("class", CLASS);}
					case -42:
						break;
					case 42:
						{return new Token("false", FALSE);}
					case -43:
						break;
					case 43:
						{return new Token("while", WHILE);}
					case -44:
						break;
					case 44:
						{return new Token("readln", READLN);}
					case -45:
						break;
					case 45:
						{return new Token("return", RETURN);}
					case -46:
						break;
					case 46:
						{return new Token("string", STRING);}
					case -47:
						break;
					case 47:
						{return new Token("double", DOUBLE);}
					case -48:
						break;
					case 48:
						{return new Token("boolean", BOOLEAN);}
					case -49:
						break;
					case 49:
						{return new Token("extends", EXTENDS);}
					case -50:
						break;
					case 50:
						{return new Token("println", PRINTLN);}
					case -51:
						break;
					case 51:
						{return new Token("newarray", NEWARRAY);}
					case -52:
						break;
					case 52:
						{return new Token("interface", INTERFACE);}
					case -53:
						break;
					case 53:
						{return new Token("implements", IMPLEMENTS);}
					case -54:
						break;
					case 55:
						{return new Token(yytext(), ID);}
					case -55:
						break;
					case 56:
						{return new Token("intconstant", INTCONST);}
					case -56:
						break;
					case 57:
						{return new Token("illegalToken", -1);}
					case -57:
						break;
					case 58:
						{return new Token("doubleconstant", DOUBLECONST);}
					case -58:
						break;
					case 60:
						{return new Token(yytext(), ID);}
					case -59:
						break;
					case 61:
						{return new Token("intconstant", INTCONST);}
					case -60:
						break;
					case 62:
						{return new Token("illegalToken", -1);}
					case -61:
						break;
					case 64:
						{return new Token(yytext(), ID);}
					case -62:
						break;
					case 65:
						{return new Token("intconstant", INTCONST);}
					case -63:
						break;
					case 66:
						{return new Token("illegalToken", -1);}
					case -64:
						break;
					case 68:
						{return new Token(yytext(), ID);}
					case -65:
						break;
					case 70:
						{return new Token(yytext(), ID);}
					case -66:
						break;
					case 72:
						{return new Token(yytext(), ID);}
					case -67:
						break;
					case 74:
						{return new Token(yytext(), ID);}
					case -68:
						break;
					case 76:
						{return new Token(yytext(), ID);}
					case -69:
						break;
					case 77:
						{return new Token(yytext(), ID);}
					case -70:
						break;
					case 78:
						{return new Token(yytext(), ID);}
					case -71:
						break;
					case 79:
						{return new Token(yytext(), ID);}
					case -72:
						break;
					case 80:
						{return new Token(yytext(), ID);}
					case -73:
						break;
					case 81:
						{return new Token(yytext(), ID);}
					case -74:
						break;
					case 82:
						{return new Token(yytext(), ID);}
					case -75:
						break;
					case 83:
						{return new Token(yytext(), ID);}
					case -76:
						break;
					case 84:
						{return new Token(yytext(), ID);}
					case -77:
						break;
					case 85:
						{return new Token(yytext(), ID);}
					case -78:
						break;
					case 86:
						{return new Token(yytext(), ID);}
					case -79:
						break;
					case 87:
						{return new Token(yytext(), ID);}
					case -80:
						break;
					case 88:
						{return new Token(yytext(), ID);}
					case -81:
						break;
					case 89:
						{return new Token(yytext(), ID);}
					case -82:
						break;
					case 90:
						{return new Token("intconstant", INTCONST);}
					case -83:
						break;
					case 91:
						{return new Token(yytext(), ID);}
					case -84:
						break;
					case 92:
						{return new Token("intconstant", INTCONST);}
					case -85:
						break;
					case 93:
						{return new Token(yytext(), ID);}
					case -86:
						break;
					case 94:
						{return new Token(yytext(), ID);}
					case -87:
						break;
					case 95:
						{return new Token(yytext(), ID);}
					case -88:
						break;
					case 96:
						{return new Token(yytext(), ID);}
					case -89:
						break;
					case 97:
						{return new Token(yytext(), ID);}
					case -90:
						break;
					case 98:
						{return new Token(yytext(), ID);}
					case -91:
						break;
					case 99:
						{return new Token(yytext(), ID);}
					case -92:
						break;
					case 100:
						{return new Token(yytext(), ID);}
					case -93:
						break;
					case 101:
						{return new Token(yytext(), ID);}
					case -94:
						break;
					case 102:
						{return new Token(yytext(), ID);}
					case -95:
						break;
					case 103:
						{return new Token(yytext(), ID);}
					case -96:
						break;
					case 104:
						{return new Token(yytext(), ID);}
					case -97:
						break;
					case 105:
						{return new Token(yytext(), ID);}
					case -98:
						break;
					case 106:
						{return new Token(yytext(), ID);}
					case -99:
						break;
					case 107:
						{return new Token(yytext(), ID);}
					case -100:
						break;
					case 108:
						{return new Token(yytext(), ID);}
					case -101:
						break;
					case 109:
						{return new Token(yytext(), ID);}
					case -102:
						break;
					case 110:
						{return new Token(yytext(), ID);}
					case -103:
						break;
					case 111:
						{return new Token(yytext(), ID);}
					case -104:
						break;
					case 112:
						{return new Token(yytext(), ID);}
					case -105:
						break;
					case 113:
						{return new Token(yytext(), ID);}
					case -106:
						break;
					case 114:
						{return new Token(yytext(), ID);}
					case -107:
						break;
					case 115:
						{return new Token(yytext(), ID);}
					case -108:
						break;
					case 116:
						{return new Token(yytext(), ID);}
					case -109:
						break;
					case 117:
						{return new Token(yytext(), ID);}
					case -110:
						break;
					case 118:
						{return new Token(yytext(), ID);}
					case -111:
						break;
					case 119:
						{return new Token(yytext(), ID);}
					case -112:
						break;
					case 120:
						{return new Token(yytext(), ID);}
					case -113:
						break;
					case 121:
						{return new Token(yytext(), ID);}
					case -114:
						break;
					case 122:
						{return new Token(yytext(), ID);}
					case -115:
						break;
					case 123:
						{return new Token(yytext(), ID);}
					case -116:
						break;
					case 124:
						{return new Token(yytext(), ID);}
					case -117:
						break;
					case 125:
						{return new Token(yytext(), ID);}
					case -118:
						break;
					case 126:
						{return new Token(yytext(), ID);}
					case -119:
						break;
					case 127:
						{return new Token(yytext(), ID);}
					case -120:
						break;
					case 128:
						{return new Token(yytext(), ID);}
					case -121:
						break;
					case 129:
						{return new Token(yytext(), ID);}
					case -122:
						break;
					case 130:
						{return new Token(yytext(), ID);}
					case -123:
						break;
					case 131:
						{return new Token(yytext(), ID);}
					case -124:
						break;
					case 132:
						{return new Token(yytext(), ID);}
					case -125:
						break;
					case 133:
						{return new Token(yytext(), ID);}
					case -126:
						break;
					case 134:
						{return new Token(yytext(), ID);}
					case -127:
						break;
					case 135:
						{return new Token(yytext(), ID);}
					case -128:
						break;
					case 136:
						{return new Token(yytext(), ID);}
					case -129:
						break;
					case 137:
						{return new Token(yytext(), ID);}
					case -130:
						break;
					case 138:
						{return new Token(yytext(), ID);}
					case -131:
						break;
					case 139:
						{return new Token(yytext(), ID);}
					case -132:
						break;
					case 140:
						{return new Token(yytext(), ID);}
					case -133:
						break;
					case 141:
						{return new Token(yytext(), ID);}
					case -134:
						break;
					case 142:
						{return new Token(yytext(), ID);}
					case -135:
						break;
					case 143:
						{return new Token(yytext(), ID);}
					case -136:
						break;
					case 144:
						{return new Token(yytext(), ID);}
					case -137:
						break;
					case 145:
						{return new Token(yytext(), ID);}
					case -138:
						break;
					case 146:
						{return new Token(yytext(), ID);}
					case -139:
						break;
					case 147:
						{return new Token(yytext(), ID);}
					case -140:
						break;
					case 148:
						{return new Token(yytext(), ID);}
					case -141:
						break;
					case 149:
						{return new Token(yytext(), ID);}
					case -142:
						break;
					case 150:
						{return new Token(yytext(), ID);}
					case -143:
						break;
					case 151:
						{return new Token(yytext(), ID);}
					case -144:
						break;
					case 152:
						{return new Token(yytext(), ID);}
					case -145:
						break;
					case 153:
						{return new Token(yytext(), ID);}
					case -146:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
