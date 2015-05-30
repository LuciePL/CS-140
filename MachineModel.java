package pippin;
import java.util.TreeMap;
import java.util.Map;

public class MachineModel {
	public final Map<Integer,Instruction> INSTRUCTION_MAP = new TreeMap<>();
	private Registers cpu = new Registers();
	private Memory memory = new Memory();
	private boolean withGUI = false;
	private Code code;
	private boolean running = false;
	
	public class Registers{
		private int accumulator;
		private int programCounter;
	}
	
	public MachineModel(){
		this(false);
	}
	
	public MachineModel(boolean withGUI){
		this.withGUI = withGUI;
		//ADD
		INSTRUCTION_MAP.put(0x3,(arg, level) -> {
			if(level <0 || level >2){
				throw new IllegalArgumentException("Illegal indirection level in ADD instruction");
			}
			if (level >0){
				INSTRUCTION_MAP.get(0x3).execute(memory.getData(arg), level-1);
			}
			else{
				cpu.accumulator += arg;
				cpu.programCounter++;
			}
		});
		
		//NOP
		INSTRUCTION_MAP.put(0x0,(arg,level) ->{
			if(level != 0){
				throw new IllegalArgumentException("The value of level must be 0");
			}
			else{
				cpu.programCounter++;
			}
		});
		
		//LOD
		INSTRUCTION_MAP.put(0x1,(arg, level)->{
			if(level <0 || level > 2){
				throw new IllegalArgumentException("The value of level is not 0,1, or 2");
			}
			if (level >0){
				INSTRUCTION_MAP.get(0x1).execute(memory.getData(arg), level-1);
			}
			else{
				cpu.accumulator = arg;
				cpu.programCounter++;
			}
			
		});
		
		//STO
		INSTRUCTION_MAP.put(0x2,(arg, level)->{
			if(level <1 || level > 2){
				throw new IllegalArgumentException("The value of level is not 0,1, or 2");
			}
			if(level ==1){
				memory.setData(arg, cpu.accumulator);
				cpu.programCounter++;
			}
			else if(level ==2){
				INSTRUCTION_MAP.get(0x2).execute(memory.getData(arg), level-1);
			}
		});
		
		//SUB
		INSTRUCTION_MAP.put(0x4,(arg, level)->{
			if(level <0 || level > 2){
				throw new IllegalArgumentException("The value of level is not 0,1, or 2");
			}
			if(level == 0){
				cpu.accumulator -= arg;
				cpu.programCounter ++;
			}
			else{
				INSTRUCTION_MAP.get(0x4).execute(memory.getData(arg), level-1);
			}
		});
		
		//MUL
		INSTRUCTION_MAP.put(0x5,(arg, level)->{
			if(level <0 || level > 2){
				throw new IllegalArgumentException("The value of level is not 0,1, or 2");
			}
			if(level == 0){
				cpu.accumulator = cpu.accumulator * arg;
				cpu.programCounter++;
			}
			else{
				INSTRUCTION_MAP.get(0x5).execute(memory.getData(arg), level-1);
			}
		});
		
		//DIV
		INSTRUCTION_MAP.put(0x6,(arg, level)->{
			if(level <0 || level > 2){
				throw new IllegalArgumentException("The value of level is not 0,1, or 2");
			}
			if(level == 0){
				if(arg != 0){
					cpu.accumulator = cpu.accumulator/arg;
					cpu.programCounter++;
				}
				else{
					throw new DivideByZeroException("Divison by Zero");
				}
				
			}
			else{
				INSTRUCTION_MAP.get(0x6).execute(memory.getData(arg), level-1);
			}
		});
		
		//AND
		INSTRUCTION_MAP.put(0x7,(arg, level)->{
			if(level <0 || level > 1){
				throw new IllegalArgumentException("The value of level is not 0 or 1");
			}
			if(level == 0){
				if(arg != 0 && cpu.accumulator != 0){
					cpu.accumulator = 1;
					cpu.programCounter ++;
				}
				else{
					cpu.accumulator =0;
					cpu.programCounter ++;
				}
			}
			else{
				INSTRUCTION_MAP.get(0x7).execute(memory.getData(arg), level-1);
			}
		});
		
		//NOT
		INSTRUCTION_MAP.put(0x8,(arg, level)->{
			if(level !=0){
				throw new IllegalArgumentException("The value of level is not 0");
			}
			if(cpu.accumulator == 0){
				cpu.accumulator = 1;
				cpu.programCounter++;
			}
			else{
				cpu.accumulator = 0;
				cpu.programCounter++;
			}
		});
		
		//CMPZ
		INSTRUCTION_MAP.put(0x9,(arg, level)->{
			if(level !=1){
				throw new IllegalArgumentException("The value of level is not 0");
			}
			else{
				if(memory.getData(arg)==0){
					cpu.accumulator = 1;
					cpu.programCounter++;
				}
				else{
					cpu.accumulator = 0;
					cpu.programCounter++;
				}
			}
		});
		
		//CMPL
		INSTRUCTION_MAP.put(0xA,(arg, level)->{
			if(level !=1){
				throw new IllegalArgumentException("The value of level is not 0");
			}
			else{
				if(memory.getData(arg)<0){
					cpu.accumulator = 1;
					cpu.programCounter++;
				}
				else{
					cpu.accumulator = 0;
					cpu.programCounter++;
				}
			}
		});
		
		//JUMP
		INSTRUCTION_MAP.put(0xB,(arg, level)->{
			if(level <0 || level > 1){
				throw new IllegalArgumentException("The value of level is not 0 or 1");
			}
			if(level == 0){
				cpu.programCounter = arg;
			}
			else{
				INSTRUCTION_MAP.get(0xB).execute(memory.getData(arg), level-1);
			}
		});
		
		//JMPZ
		INSTRUCTION_MAP.put(0xC,(arg, level)->{
			if(level <0 || level > 1){
				throw new IllegalArgumentException("The value of level is not 0 or 1");
			}
			if(level == 0){
				if(cpu.accumulator == 0){
					cpu.programCounter = arg;
				}
				else{
					cpu.programCounter++;
				}
			}
			else{
				INSTRUCTION_MAP.get(0xC).execute(memory.getData(arg), level-1);
			}
		});
		INSTRUCTION_MAP.put(0xF,(arg, level)->{
			halt();
		});
		
		/**
		 * ROT
		 * Rotates the memory at start for the length given
		 * @param arg argument, the number that ROT will start with
		 * @param level level must be 1 
		 */		
		INSTRUCTION_MAP.put(0x14 ,(arg, level)->{
			if(level!=1){
				throw new IllegalArgumentException("Level is not 1");
			}
			else{
				int start = memory.getData(arg);
				int length = memory.getData(arg+1);
				int move = memory.getData(arg+2);
				if(start<0 || length <0 || start+length-1 >= Memory.DATA_SIZE){
					throw new IllegalArgumentException("Exception");
				}
				else if(start <= arg + 2 && start + length -1 <= arg){
					throw new IllegalArgumentException("Arguments are part of memory");
				}
				else{
					if(move < 0){
						for(int j =0; j<move*-1; j++){
							cpu.accumulator = memory.getData(start);
							for(int i =1; i< length; i++){
								memory.setData(start+i-1,memory.getData(start+i));
							}
							memory.setData(start+length-1, cpu.accumulator);
						}
						
					}
					else if(move >0){
						for(int j= 0; j<move; j++){
							cpu.accumulator = memory.getData(start+length-1);
							for(int i =length-1; i> -1; i--){
								memory.setData(start+i+1,memory.getData(start+i));
							}
							memory.setData(start, cpu.accumulator);
						}
						 
					}
				}
			}
		});
		
	}
	
	public void step(){
		try{
			int pc = cpu.programCounter;
			get(code.getOp(pc)).execute(code.getArg(pc), code.getIndirectionLevel(pc));
		}
		catch(Exception e){
			halt();
			throw e;
		}
	}
	
	public void clear(){
		memory.clear();
		if(code != null){
			code.clear();
		}
		cpu.programCounter = 0;
		cpu.accumulator = 0;
	}
	
	public void setCode(Code code) {
		this.code = code;
	}
	
	public Code getCode(){
		return code;
	}

	public int getData(int index){
		return memory.getData(index);
	}
	
	public void setData(int index, int value){
		memory.setData(index,value);
	}
	
	public Instruction get(Object key){
		return INSTRUCTION_MAP.get(key);
	}
	
	int[] getData(){
		return memory.getData();
	}
	
	int getProgramCounter(){
		return cpu.programCounter;
	}
	
	int getAccumulator(){
		return cpu.accumulator;
	}
	
	void setAccumulator(int i){
		cpu.accumulator = i;
	}
	
	public void setProgramCounter(int i) {
		cpu.programCounter = i;
	}
	
	public int getChangedIndex(){
		return memory.getChangedIndex();
	}
	
	public void halt(){
		if(withGUI){
			running = false;
		}
		else{
			System.exit(0);
		}
	}
	
	public void clearMemory(){
		memory.clear();
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	
}
