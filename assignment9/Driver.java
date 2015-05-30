package assignment09;
import java.util.TreeSet;
import java.util.function.BinaryOperator;

public class Driver<T> {
	public boolean check(Group<T> g, Set<T> s){
		boolean checker = true;
		for(T i: g.getSet()){
			for(T j: g.getSet()){
				try{
					if(!s.contains(g.combine(i,j))){
						checker = false;
						break;
					}
				}
				catch(NotInException n){
					break;
				}
			}
		}
		return checker;
	}
	
	public boolean check2(Group<T> g){
		return check(g,g);
	}
	
	public Ring<T> generateRing(BinaryOperator<T> combine, BinaryOperator<T> mult, T start){
		Ring<T> ringer = new Ring<T>(combine,mult);
		ringer.getSet().add(start);
		T ret = combine.apply(start,start);
		ringer.getSet().add(ret);
		
		
		T ret2 = mult.apply(start, ret);
		ringer.getSet().add(ret2);
		T mRet = combine.apply(ret, ret2);
		ringer.getSet().add(mRet);
		for(int i=0;i<15;i++){
			ret2 = mult.apply(ret2, mRet);
			ringer.getSet().add(ret2);
			mRet = combine.apply(mRet,ret2);
			ringer.getSet().add(mRet);
			System.out.println(ringer);
		}
		return ringer;
	}
	
}
