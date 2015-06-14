// Written by Hoang Nguyen and Huy Phu.
// CS411-Project 1, Winter 2015.

/***Instruction to compile and run this program***
* 
import java.util.ArrayList;
import java.io.*;
public class Project1 {
	public static void main(String args[]) throws java.io.IOException {
	
	   //Check for input file in command line.
   	if (args.length != 1) {
			System.out.println("Error: Input file not found on command line." );
			System.exit(-1);
		}
		
		
		//If input file exists, create input stream to start reading.
		FileInputStream inputStream = null;
		try {
			inputStream = new java.io.FileInputStream(args[0]);
		} catch (FileNotFoundException notFound){
			System.out.println("Error: unable to open input file.");
			System.exit(-1);
		} 
		
		//Create symbol table and a set of keywords.
		SymTable symTable = new SymTable();
		String[] keywords = {"boolean", "break", "class", "double", "else", "extends",
				"false", "for", "if", "implements", "int", "interface", "newarray", "println", 
				"readln", "return", "string", "void", "while"};
		
		//Insert keywords.
		for(int i = 0; i < keywords.length; i++) {
			symTable.insert(keywords[i]);
		} 
		
		//Create lexical analyzer to read input stream and create tokens.
		Yylex lex = new Yylex(inputStream);
		Token token = lex.yylex();
		String tokenName = "";
		while ( token != null ) {
			tokenName = token.getName();
			//If token is an identifier, insert token into symbol table.
			if(token.getType() == Yylex.ID) {
				symTable.insert(tokenName);
				System.out.print("id ");
			}else{
				//Print out token name.			
				System.out.print(tokenName + " ");
			}
			token = lex.yylex(); //get next token
		}
		System.out.println(); 
		
		//Print out list of alphabet and index values in switch array
		int i = 0;
		int j = 0;
		int k = 0;
		char c = 'A';
		ArrayList<Character> alphabet = new ArrayList<Character>();
		while(i < 53) {
			if(i == 26)
				c = 'a';
			if(i == 52)
				c = '_';
			if(i % 20 == 0)
				System.out.print("     ");
			System.out.printf("%5s", c);
			alphabet.add(c);
			c++;
			i++;
			if(i % 20 == 0) {
				System.out.print("\nswitch: ");
				while(k < 20) {
					System.out.printf("%-5s", symTable.getSwitchArray().get(alphabet.get(j)));
					k++;
					j++;
				}
				System.out.println("\n");
				k = 0;
			}
		}
		System.out.print("\nswitch: ");
		while(j < alphabet.size()) {
			System.out.printf("%-5s", symTable.getSwitchArray().get(alphabet.get(j)));
			j++;
		}
		System.out.println("\n");
		
		//Print out the content of symbol and next arrays.
		i = 0;
		j = 0;
		k = 0;
		while(i < symTable.getSymbolArray().size()) {
			if(i % 20 == 0)
				System.out.print("    ");
			System.out.printf("%5d", i);
			i++;
			if(i % 20 == 0) {
				System.out.print("\nsymbol: ");
				while(k < i) {
					System.out.printf("%-5s", symTable.getSymbolArray().get(k));
					k++;
					if(k % 20 == 0) {
						System.out.print("\nnext:  ");
						while(j < i) {
							int index = symTable.getNextArray().get(j);
							if(index >= 0)
								System.out.printf("%-5d", index);
							else
								System.out.printf("%-5s", " ");
							j++;
						}
					}
				}
				System.out.println("\n");
			}
		}
		System.out.print("\nsymbol: ");
		while(k < symTable.getSymbolArray().size()) {
			System.out.printf("%-5s", symTable.getSymbolArray().get(k));
			k++;
			if(k == symTable.getSymbolArray().size()) {
				System.out.print("\nnext:   ");
				while(j < k) {
					int index = symTable.getNextArray().get(j);
					if(index >= 0)
						System.out.printf("%-5d", index);
					else
						System.out.printf("%-5s", " ");
					j++;
				}
			}
		}
		System.out.println("\n");
	}
}