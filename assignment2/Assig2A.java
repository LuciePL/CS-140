package assignment02;

public class Assig2A{
	public static int simpleLargestArea(Lab02B[] objs){
		int largest = 0;
		for(int i = 0; i < objs.length; i++){
			if(objs[i] != null && objs[i].area() > largest){
				largest = i;
			}
		}
		return largest;
	}
	
	public static Lab02B simpleTopLeftMost(Lab02B[] objs){
		int X=0;
		int Xperm=0;
		int Y=0;
		int Yperm=0;
		Lab02B topLeft=null;
		for(int i = 0; i < objs.length; i++){
			X = objs[i].getX();
			Y = objs[i].getY();
			
			if (i==0){
				Yperm = Y;
				Xperm = X;
				topLeft = objs[i];
			}
			if(X <= Xperm){
				if(Xperm == X){
					if(Y<Yperm){
						topLeft = objs[i];
						Yperm = Y;
						Xperm = X;
					}
				}
				else{
					topLeft = objs[i];
					Yperm = Y;
					Xperm = X;
				}
			}
		}
		return topLeft;
	}
	
	public static int largestArea(Lab02B[] objs){
		int largest = 0;
		for(int i = 0; i < objs.length; i++){
			if(objs[i] != null){
				if (objs[i].area() > largest){
					largest = i;
				}
			}
			else{
				largest = -1;
			}
		}
		return largest;
	}
	
/**
	Find's the object with the smallest x-value
	@param Xperm
	
*/
	
	public static Lab02B topLeftMost(Lab02B[] objs){
		int X=0;
		int Xperm=0;
		int Y=0;
		int Yperm=0;
		int checker=0;
		Lab02B topLeft=null;
			if(objs == null){
				topLeft = null;
			}
			else{
				for(int i = 0; i < objs.length;i++){
					if(objs[i] != null){
						X = objs[i].getX();
						Y = objs[i].getY();
				
						if(checker == 0){
							Yperm = Y;
							Xperm = X;
							topLeft = objs[i];
							checker = 1;
						}
						if(X <= Xperm){
							if(Xperm == X){
								if(Y<Yperm){
									topLeft = objs[i];
									Yperm = Y;
									Xperm = X;
								}
							}
							else{
								topLeft = objs[i];
								Yperm = Y;
								Xperm = X;
							}
						}
					}
					else{
						topLeft = null;
					}
				}
			}
		return topLeft;
	}
	
}
