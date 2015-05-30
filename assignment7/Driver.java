package assignment07;
//
public class Driver {
	public static int[] retArray = new int[97];
	public static int counterE = 0;
	public static int counterO = 0;
	public static int countPrime = 0;
	public static int by1 = 0;
	public static int countR1 = 0;
	
	public static int[] getArray(int max){
			
		//1st problem
			for(int i = 0; i<max; i++){
				if(i%2 == 0){
					counterE++;
				}
				else{
					counterO++;
					if(i%2 ==1){
						countR1++;
					}
				}
				
				//2nd problem
				if(isPrime(i) ==true){
					countPrime++;
				}
				
				//problem divided by 1
				if(i%1 ==0){
					by1++;
				}
				//problem divided by3
				
				
			}
			
		//Put everything in the array	
		retArray[0]= counterE;
		retArray[1]= counterO;
		retArray[2] = countPrime;
		retArray[3] = divider1(max);
		retArray[4] = divider2(max);
		retArray[5] = divider3(max);
		retArray[6] = divider4(max);
		retArray[7] = divider5(max);
		retArray[8] = divider6(max);
		retArray[9] = divider7(max);
		retArray[10] = divider8(max);
		retArray[11] = divider9(max);
		retArray[12] = divider10(max);
		retArray[13] = divider11(max);
		retArray[14] = divider12(max);
		retArray[15] = divider13(max);
		retArray[16] = divider14(max);
		retArray[17] = divider15(max);
		retArray[18] = divider16(max);
		retArray[19] = divider17(max);
		retArray[20] = divider18(max);
		retArray[21] = divider19(max);
		retArray[22] = divider20(max);
		retArray[23] = by1;
		retArray[24] = countR1;
		retArray[25] = counterE;
		retArray[28] = byThree2(max);
		retArray[27] = byThree1(max);
		retArray[26] = divider3(max);
		retArray[29] = byFour3(max);
		retArray[30] = byFour1(max);
		retArray[32] = divider4(max);
		retArray[31] = byFour2(max);
		retArray[33] = byFive4(max);
		retArray[34] = byFive3(max);
		retArray[35] = byFive2(max);
		retArray[36] = byFive1(max);
		retArray[37] = divider5(max);
		retArray[38] = bySix1(max);
		retArray[39] = divider6(max);
		retArray[40] = bySix3(max);
		retArray[41] = bySix2(max);
		retArray[42] = bySix4(max);
		retArray[43] = bySix5(max);
		retArray[44] = divider7(max);
		retArray[45] = bySeven1(max);
		retArray[46] = bySeven2(max);
		retArray[47] = bySeven3(max);
		retArray[48] = bySeven4(max);
		retArray[49] = bySeven5(max);
		retArray[50] = bySeven6(max);
		retArray[51] = divider8(max);
		retArray[52] = byEight1(max);
		retArray[53] = byEight2(max);
		retArray[54] = byEight3(max);
		retArray[55] = byEight4(max);
		retArray[56] = byEight5(max);
		retArray[57] = byEight6(max);
		retArray[58] = byEight7(max);
		retArray[59] = divider9(max);
		retArray[60] = byNine1(max);
		retArray[61] = byNine2(max);
		retArray[62] = byNine3(max);
		retArray[63] = byNine4(max);
		retArray[64] = byNine5(max);
		retArray[65] = byNine6(max);
		retArray[66] = byNine7(max);
		retArray[67] = byNine8(max);
		retArray[68] = divider10(max);
		retArray[69] = byTen1(max);
		retArray[70] = byTen2(max);
		retArray[71] = byTen3(max);
		retArray[72] = byTen4(max);
		retArray[73] = byTen5(max);
		retArray[74] = byTen6(max);
		retArray[75] = byTen7(max);
		retArray[76] = byTen8(max);
		retArray[77] = byTen9(max);
		retArray[78] = first1(max);
		retArray[79] = first2(max);
		retArray[80] = first3(max);
		retArray[81] = first4(max);
		retArray[82] = first5(max);
		retArray[83] = first6(max);
		retArray[84] = first7(max);
		retArray[85] = first8(max);
		retArray[86] = first9(max);
		retArray[87] = digits0(max);
		retArray[88] = digits1(max);
		retArray[89] = digits2(max);
		retArray[90] = digits3(max);
		retArray[91] = digits4(max);
		retArray[92] = digits5(max);
		retArray[93] = digits6(max);
		retArray[94] = digits7(max);
		retArray[95] = digits8(max);
		retArray[96] = digits9(max);
		return retArray;
	}
	public static boolean isPrime(int q){
		boolean prime = true;
		if(q==2 ){
			prime = true;
		}
		else if(q ==1 || q==0){
			prime = false;
		}
		else{
			for(int a=2; a<q; a++){
				if(q%a == 0){
					prime = false;
				}
			}
		}
		
		return prime;
	}
	
	
	public static int divider1(int num){
		int dividedBy1 = 0;
		for(int b=0;b<num;b++){
			if(b%1 == 0){
				dividedBy1++;
			}
		}
		return dividedBy1;
	}
	public static int divider2(int num){
		int dividedBy2 = 0;
		for(int b=0;b<num;b++){
			if(b%2 == 0){
				dividedBy2++;
				
			}
		}
		return dividedBy2;
	}
	public static int divider3(int num){
		int dividedBy3 = 0;
		for(int b=0;b<num;b++){
			if(b%3 == 0){
				dividedBy3++;
				
			}
		}
		return dividedBy3;
	}
	public static int divider4(int num){
		int dividedBy4 = 0;
		for(int b=0;b<num;b++){
			if(b%4 == 0){
				dividedBy4++;
				
			}
		}
		return dividedBy4;
	}
	public static int divider5(int num){
		int dividedBy5 = 0;
		for(int b=0;b<num;b++){
			if(b%5 == 0){
				dividedBy5++;
				
			}
		}
		return dividedBy5;
	}
	public static int divider6(int num){
		int dividedBy6 = 0;
		for(int b=0;b<num;b++){
			if(b%6 == 0){
				dividedBy6++;
				
			}
		}
		return dividedBy6;
	}
	public static int divider7(int num){
		int dividedBy7 = 0;
		for(int b=0;b<num;b++){
			if(b%7 == 0){
				dividedBy7++;
				
			}
		}
		return dividedBy7;
	}
	public static int divider8(int num){
		int dividedBy8 = 0;
		for(int b=0;b<num;b++){
			if(b%8 == 0){
				dividedBy8++;
				
			}
		}
		return dividedBy8;
	}
	public static int divider9(int num){
		int dividedBy9 = 0;
		for(int b=0;b<num;b++){
			if(b%9 == 0){
				dividedBy9++;
				
			}
		}
		return dividedBy9;
	}
	public static int divider10(int num){
		int dividedBy10 = 0;
		for(int b=0;b<num;b++){
			if(b%10 == 0){
				dividedBy10++;
				
			}
		}
		return dividedBy10;
	}
	public static int divider11(int num){
		int dividedBy11 = 0;
		for(int b=0;b<num;b++){
			if(b%11 == 0){
				dividedBy11++;
				
			}
		}
		return dividedBy11;
	}
	public static int divider12(int num){
		int dividedBy12 = 0;
		for(int b=0;b<num;b++){
			if(b%12 == 0){
				dividedBy12++;
				
			}
		}
		return dividedBy12;
	}
	public static int divider13(int num){
		int dividedBy13 = 0;
		for(int b=0;b<num;b++){
			if(b%13 == 0){
				dividedBy13++;
				
			}
		}
		return dividedBy13;
	}
	public static int divider14(int num){
		int dividedBy14 = 0;
		for(int b=0;b<num;b++){
			if(b%14 == 0){
				dividedBy14++;
				
			}
		}
		return dividedBy14;
	}
	public static int divider15(int num){
		int dividedBy15 = 0;
		for(int b=0;b<num;b++){
			if(b%15 == 0){
				dividedBy15++;
				
			}
		}
		return dividedBy15;
	}
	public static int divider16(int num){
		int dividedBy16 = 0;
		for(int b=0;b<num;b++){
			if(b%16 == 0){
				dividedBy16++;
				
			}
		}
		return dividedBy16;
	}
	public static int divider17(int num){
		int dividedBy17 = 0;
		for(int b=0;b<num;b++){
			if(b%17 == 0){
				dividedBy17++;
				
			}
		}
		return dividedBy17;
	}
	public static int divider18(int num){
		int dividedBy18 = 0;
		for(int b=0;b<num;b++){
			if(b%18 == 0){
				dividedBy18++;
				
			}
		}
		return dividedBy18;
	}
	public static int divider19(int num){
		int dividedBy19 = 0;
		for(int b=0;b<num;b++){
			if(b%19 == 0){
				dividedBy19++;
				
			}
		}
		return dividedBy19;
	}
	public static int divider20(int num){
		int dividedBy20 = 0;
		for(int b=0;b<num;b++){
			if(b%20 == 0){
				dividedBy20++;
				
			}
		}
		return dividedBy20;
	}
	
	public static int byThree1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%3==1){
				count++;
			}
		}
		return count;
	}
	
	public static int byThree2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%3==2){
				count++;
			}
		}
		return count;
	}
	
	public static int byFour1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%4==1){
				count++;
			}
		}
		return count;
	}
	
	public static int byFour2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%4==2){
				count++;
			}
		}
		return count;
	}
	
	public static int byFour3(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%4==3){
				count++;
			}
		}
		return count;
	}
	public static int byFive1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%5==1){
				count++;
			}
		}
		return count;
	}
	public static int byFive2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%5==2){
				count++;
			}
		}
		return count;
	}
	public static int byFive3(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%5==3){
				count++;
			}
		}
		return count;
	}
	public static int byFive4(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%5==4){
				count++;
			}
		}
		return count;
	}
	public static int bySix1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%6==1){
				count++;
			}
		}
		return count;
	}
	public static int bySix2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%6==2){
				count++;
			}
		}
		return count;
	}
	public static int bySix3(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%6==3){
				count++;
			}
		}
		return count;
	}
	public static int bySix4(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%6==4){
				count++;
			}
		}
		return count;
	}
	public static int bySix5(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%6==5){
				count++;
			}
		}
		return count;
	}
	
	public static int bySeven1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%7==1){
				count++;
			}
		}
		return count;
	}
	public static int bySeven2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%7==2){
				count++;
			}
		}
		return count;
	}
	public static int bySeven3(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%7==3){
				count++;
			}
		}
		return count;
	}
	public static int bySeven4(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%7==4){
				count++;
			}
		}
		return count;
	}
	public static int bySeven5(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%7==5){
				count++;
			}
		}
		return count;
	}
	public static int bySeven6(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%7==6){
				count++;
			}
		}
		return count;
	}
	
	public static int byEight1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%8==1){
				count++;
			}
		}
		return count;
	}
	public static int byEight2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%8==2){
				count++;
			}
		}
		return count;
	}
	public static int byEight3(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%8==3){
				count++;
			}
		}
		return count;
	}
	public static int byEight4(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%8==4){
				count++;
			}
		}
		return count;
	}
	public static int byEight5(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%8==5){
				count++;
			}
		}
		return count;
	}
	public static int byEight6(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%8==6){
				count++;
			}
		}
		return count;
	}
	public static int byEight7(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%8==7){
				count++;
			}
		}
		return count;
	}
	
	public static int byNine1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==1){
				count++;
			}
		}
		return count;
	}
	public static int byNine2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==2){
				count++;
			}
		}
		return count;
	}
	public static int byNine3(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==3){
				count++;
			}
		}
		return count;
	}
	public static int byNine4(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==4){
				count++;
			}
		}
		return count;
	}
	public static int byNine5(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==5){
				count++;
			}
		}
		return count;
	}
	public static int byNine6(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==6){
				count++;
			}
		}
		return count;
	}
	public static int byNine7(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==7){
				count++;
			}
		}
		return count;
	}
	public static int byNine8(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%9==8){
				count++;
			}
		}
		return count;
	}
	
	public static int byTen1(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==1){
				count++;
			}
		}
		return count;
	}
	public static int byTen2(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==2){
				count++;
			}
		}
		return count;
	}
	public static int byTen3(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==3){
				count++;
			}
		}
		return count;
	}
	public static int byTen4(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==4){
				count++;
			}
		}
		return count;
	}
	public static int byTen5(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==5){
				count++;
			}
		}
		return count;
	}
	public static int byTen6(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==6){
				count++;
			}
		}
		return count;
	}
	public static int byTen7(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==7){
				count++;
			}
		}
		return count;
	}
	public static int byTen8(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==8){
				count++;
			}
		}
		return count;
	}
	public static int byTen9(int byNum){
		int count=0;
		for(int c=0; c<byNum; c++){
			if(c%10==9){
				count++;
			}
		}
		return count;
	}
	
	public static int first1(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==1){
				count++;
			}
		}
		return count;
	}
	public static int first2(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==2){
				count++;
			}
		}
		return count;
	}
	public static int first3(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==3){
				count++;
			}
		}
		return count;
	}
	public static int first4(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==4){
				count++;
			}
		}
		return count;
	}
	public static int first5(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==5){
				count++;
			}
		}
		return count;
	}
	public static int first6(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==6){
				count++;
			}
		}
		return count;
	}
	public static int first7(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==7){
				count++;
			}
		}
		return count;
	}
	public static int first8(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==8){
				count++;
			}
		}
		return count;
	}
	public static int first9(int num){
		int count =0;
		for(int d = 0; d <num; d++){
			int hold = d;
			while(hold>9){
				hold = hold/10;
			}
			if(hold ==9){
				count++;
			}
		}
		return count;
	}
	
	public static int digits0(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("0") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits1(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("1") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits2(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("2") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits3(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("3") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits4(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("4") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits5(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("5") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits6(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("6") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits7(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("7") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits8(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("8") != -1){
				count++;
			}
		}
		return count;
	}
	public static int digits9(int num){
		int count =0;
		for (int f =0; f < num; f++){
			String hold = Integer.toString(f);
			if(hold.indexOf("9") != -1){
				count++;
			}
		}
		return count;
	}
}
	


	
