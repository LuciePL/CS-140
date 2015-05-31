package pippin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Assembler {
	/**
	 * lists the mnemonics of the instructions that do not have arguments
	 */
	public static Set<String> noArgument = new TreeSet<String>();
	/**
	 * lists the mnemonics of the instructions that allow immediate addressing
	 */
	public static Set<String> allowsImmediate = new TreeSet<String>();
	/**
	 * lists the mnemonics of the instructions that allow indirect addressing
	 */
	public static Set<String> allowsIndirect = new TreeSet<String>();
	
	static {
		noArgument.add("HALT");
		noArgument.add("NOP");
		noArgument.add("NOT");
		allowsImmediate.add("LOD");
		allowsImmediate.add("AND");
		allowsImmediate.add("ADD");
		allowsImmediate.add("JMPZ");
		allowsImmediate.add("DIV");
		allowsImmediate.add("SUB");
		allowsImmediate.add("MUL");
		allowsImmediate.add("JUMP");
		// seven more lines needed
		allowsIndirect.add("LOD");
		allowsIndirect.add("DIV");
		allowsIndirect.add("MUL");
		allowsIndirect.add("SUB");
		allowsIndirect.add("STO");
		allowsIndirect.add("ADD");
		// five more lines needed
		}
	
	/**
	* Method to assemble a file to its binary representation. If the input has errors
	* a list of errors will be written to the errors map. If there are errors,
	* they appear as a map with the line number as the key and the description of the error
	* as the value. If the input or output cannot be opened, the "line number" key is 0.
	* @param input the source assembly language file
	* @param output the binary version of the program if the souce program is
	* correctly formatted
	* @param errors the errors map
	* @return
	*/
	public static boolean assemble(File input, File output, Map<Integer, String> errors) {
		ArrayList<String> inputText = new ArrayList<>();
		ArrayList<String> inCode = new ArrayList<String>();
		ArrayList<String> inData = new ArrayList<String>();
		ArrayList<String> outCode = new ArrayList<String>();
		try (Scanner inp = new Scanner(input)) {
				while(inp.hasNextLine()){
					inputText.add(inp.nextLine());
				}
			} 
		catch (FileNotFoundException e) {
			errors.put(0, "Error: Unable to open the input file");
		}
		
		boolean blank = false;
		int blankLnNum = 0;
		for(int i =0; i<inputText.size(); i++){
			if(inputText.get(i).trim().length() == 0){
				blankLnNum = i;
				System.out.println("Run");
				blank = true;
			}
			else if(blank == true){
				System.out.println("yo");
				errors.put((blankLnNum+1), "Error on line " + (blankLnNum+1) + ": illegal blank line");
			}
			else if (inputText.get(i).trim().length() > 0){
				if(inputText.get(i).charAt(0) == ' ' || inputText.get(i).charAt(0) == '\t'){
					errors.put(i+1, "Error on line " + (i+1) + ": starts with white space");
				}
			}
			
		}
		
		boolean codeDone = false;
		for(int i= 0; i<inputText.size(); i++){
			if(codeDone == false){
				if(inputText.get(i).trim().equalsIgnoreCase("DATA")){
					if(inputText.get(i).trim().equals("DATA")){
						codeDone = true;
					}
					else{
						errors.put(i+1,"DATA must be capitalized");
					}
				}
				else{
					String line = inputText.get(i).trim();
					inCode.add(line);
				}
			}
			else{
				String line = inputText.get(i).trim();
				inData.add(line);
			}
		}
		if(codeDone == true){
		for(int i = 0; i<inCode.size(); i++){
			String[] parts = inCode.get(i).split("\\s+");
			if(!InstructionMap.opcode.containsKey(parts[0].toUpperCase())){
				errors.put(i+1, "line" + (i+1)+ "has illegal mnemonic");
			}
			else if(!InstructionMap.opcode.containsKey(parts[0])){
				errors.put(i+1, "line" + (i+1)+ ":Mnemonic's must be uppercase");
			}
			else if(noArgument.contains(parts[0])){
				if(parts.length >1){
					errors.put(i+1,"line" + (i+1) +":Mnemonic does not take arguments");
				}
				else if(parts.length ==1 ){
					outCode.add(Integer.toString(InstructionMap.opcode.get(parts[0]),16) + " 0 0");
				}
			}
			else if(!(noArgument.contains(parts[0])) && parts.length >2){
				errors.put(i+1,"line " + (i+1)+":Mneumonic has too many arguments");
			}
			else{
				if(parts.length == 1){
					errors.put(i+1, "line" + i+1 + "Not a no argument");
				}
				else if(parts[1].length() >=3 && parts[1].charAt(0) == '[' && parts[1].charAt(1) == '['){
					if(allowsIndirect.contains(parts[0])){
						try{
							int arg = Integer.parseInt(parts[1].substring(2),16);
							outCode.add(Integer.toString(InstructionMap.opcode.get(parts[0]),16) + " " +
							Integer.toString(arg,16).toUpperCase() + " 2");
						}
						catch(NumberFormatException e) {
							errors.put(i+1, "Error on line "+(i+1)+ ": indirect argument is not a hex number");
						}
					}
				}
				else if(parts[1].length() >=2 && parts[1].charAt(0) == '['){
					try{
						int arg = Integer.parseInt(parts[1].substring(1),16);
						outCode.add(Integer.toString(InstructionMap.opcode.get(parts[0]),16) + " "+
						Integer.toString(arg,16).toUpperCase() + " 1");
					}
					catch(NumberFormatException e) {
						errors.put(i+1, "Error on line "+(i+1)+ ": direct argument is not a hex number");
					}
				}
				else if(parts[1].length() >=1 && parts[1].charAt(0) != '['){
					if(allowsImmediate.contains(parts[0])){
						try{
							int arg = Integer.parseInt(parts[1],16);
							outCode.add(Integer.toString(InstructionMap.opcode.get(parts[0]),16) + " "+
							Integer.toString(arg,16).toUpperCase() + " 0");
						}
						catch(NumberFormatException e) {
							errors.put(i+1, "Error on line "+(i+1)+ ": immediate argument is not a hex number");
						}
					}
					else{
						errors.put(i+1, "line"+ (i+1) + "This is not an argument");
					}
				}
				
			}
		}
		
		
		}

		int offSet = inCode.size() +1;
		ArrayList<String> outData = new ArrayList<String>();
		for(int i = 0; i<inData.size(); i++){
			String[] parts = inData.get(i).split("\\s+");
			if(parts.length != 2){
				errors.put(offSet +i,"line " + (offSet+1) +" This is not an address/value pair" );
			}
			else{
				int addr = -1;
				int val = -1;
				try{
					 addr = Integer.parseInt(parts[0],16);
					 val = Integer.parseInt(parts[1],16);
					 outData.add(Integer.toString(addr).toUpperCase() + " " + Integer.toString(val).toUpperCase());
				}
				catch(NumberFormatException e){
					errors.put(offSet+i,"Address is not a hex number on line "+offSet+1);
				}
			}
		}

		if(errors.size() == 0) {
			try (PrintWriter outp = new PrintWriter(output)){
			for(String str : outCode) outp.println(str);
			outp.println(-1); // the separator where the source has DATA
			for(String str : outData) outp.println(str);
			} catch (FileNotFoundException e) {
			errors.put(0, "Error: Unable to write the assembled program to the output file");
			}
			}
			return errors.size() == 0;
		
	}

}
