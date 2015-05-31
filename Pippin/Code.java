package pippin;

import java.util.ArrayList;

public class Code {
	public static final int CODE_MAX = 256;
	private ArrayList<IntTriple> program = new ArrayList<IntTriple>();
	
	public class IntTriple{
		private int arg;
		private int op;
		private int indirectionLevel;
		
		public IntTriple(int op, int arg, int indirectionLevel){
			this.arg = arg;
			this.op = op;
			this.indirectionLevel = indirectionLevel;
		}
	}
	
	public int getProgramSize(){
		return program.size();
	}
	
	public int getOp(int i){
		return program.get(i).op;
	}
	
	public int getArg(int i){
		return program.get(i).arg;
	}
	
	public int getIndirectionLevel(int i){
		return program.get(i).indirectionLevel;
	}
	
	void clear(){
		program.clear();
	}
	
	public void setCode(int op, int arg, int indirectionLevel){
		program.add(new IntTriple(op,arg,indirectionLevel));
	}
	
	public String getCodeText(int i) {
		 StringBuilder builder = new StringBuilder();
		 if(i < program.size()) {
			 builder.append(InstructionMap.mnemonics.get(program.get(i).op));
			 builder.append(' ');
				 for(int j = 0; j < program.get(i).indirectionLevel; j++) {
					 builder.append('[');
				 }
			 builder.append(program.get(i).arg);
		 }
		 return builder.toString();
	} 
}
