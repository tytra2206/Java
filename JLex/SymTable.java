import java.util.ArrayList;
import java.util.HashMap;

public class SymTable {
	private HashMap<Character, Integer> switchArray;
	private ArrayList<Character> symbolArray;
	private ArrayList<Integer> nextArray;
	
	public SymTable() {
		switchArray = new HashMap<Character, Integer>();
		symbolArray = new ArrayList<Character>();
		nextArray = new ArrayList<Integer>();
		
		//Initializing alphabet in switch array
		char c = 'A';
		int i;
		for(i = 0; i < 26; i++) {
			switchArray.put(c, -1);
			c++;
		}
		c = 'a';
		for(; i < 52; i++) {
			switchArray.put(c, -1);
			c++;
		}
		switchArray.put('_', -1);
	}

	public HashMap<Character, Integer> getSwitchArray() {
		return switchArray;
	}

	public void setSwitchArray(HashMap<Character, Integer> switchArray) {
		this.switchArray = switchArray;
	}

	public ArrayList<Character> getSymbolArray() {
		return symbolArray;
	}

	public void setSymbolArray(ArrayList<Character> symbolArray) {
		this.symbolArray = symbolArray;
	}

	public ArrayList<Integer> getNextArray() {
		return nextArray;
	}

	public void setNextArray(ArrayList<Integer> nextArray) {
		this.nextArray = nextArray;
	}
	
	public void insert(String token) {
		char symbol = token.charAt(0);
		int ptr = switchArray.get(symbol);
		
		//If token is completely new, then create without searching.
		if(ptr == -1) {
			//Create new
			switchArray.put(symbol, symbolArray.size());
			int i = 1;
			while(i < token.length()) {
				symbolArray.add(token.charAt(i));
				nextArray.add(-1);
				i++;
			}
			markEnd();
		} 
		//Handle case token length = 1.
		else if(ptr != -1 && token.length() == 1) {
			while(true) {
				if(symbolArray.get(ptr) == '*')
					return;
				else {
					if(nextArray.get(ptr) == -1) {
						nextArray.set(ptr, symbolArray.size());
						markEnd();
						return;
					}else {
						ptr = nextArray.get(ptr);
					}
				}
			}
		}
		//If the first symbol of token has already been used, then start searching.
		else {
			int i = 1;
			boolean exit = false;
			symbol = token.charAt(i);
			while(!exit) {
				if(symbol == symbolArray.get(ptr)) {
					i++;
					if(i < token.length()) {					
						symbol = token.charAt(i);
						ptr++;
					}else {
						//Accept
						if(symbolArray.get(ptr+1) != '*' && nextArray.get(ptr+1) == -1) {
							nextArray.set(ptr+1, symbolArray.size());
							markEnd();							
						}
						exit = true;
					}
				}else {
					if(nextArray.get(ptr) != -1) {
						ptr = nextArray.get(ptr);
					}else {
						//Create
						create(i, ptr, token);
						markEnd();
						exit = true;
					}
				}
			}
		}
	}
	
	private void create(int startIndex, int ptr, String token) {
		nextArray.set(ptr, symbolArray.size());
		while(startIndex < token.length()) {
			symbolArray.add(token.charAt(startIndex));
			nextArray.add(-1);
			startIndex++;
		}
	}
	
	private void markEnd() {
		symbolArray.add('*');
		nextArray.add(-1);
	}	
}
