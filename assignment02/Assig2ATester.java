package assignment02;

public class Assig2ATester {

    public static void main(String[] args) {
        Lab02B[] arr1 = null;
        Lab02B[] arr2 = {};
        Lab02B[] arr3 = {null, null, null};
        Lab02B[] arr4 = {
                new Lab02B(new int[]{5,6,1,1}),
                new Lab02B(new int[]{3,7,2,2}),
                new Lab02B(new int[]{3,5,3,3}),
                new Lab02B(new int[]{5,9,4,4}),
        };
        Lab02B[] arr5 = {null, null,
                new Lab02B(new int[]{5,6,1,1}),
                null,
                new Lab02B(new int[]{3,7,2,2}),
                new Lab02B(new int[]{3,5,3,3}),
                null,
                new Lab02B(new int[]{5,9,4,4}),               
        };
       
        Lab02B test1 = Assig2A.topLeftMost(arr1);
        System.out.println(test1);
        Lab02B test2 = Assig2A.topLeftMost(arr2);
        System.out.println(test2);
        Lab02B test3 = Assig2A.topLeftMost(arr3);
        System.out.println(test3);
        Lab02B test4 = Assig2A.topLeftMost(arr4);
        System.out.println(test4.area());
        //Lab02B test5 = Assig2A.topLeftMost(arr5);
        //System.out.println(test5.area());
		
		int test6 = Assig2A.largestArea(arr3);
		System.out.println(test6);
		Lab02B test7= Assig2A.simpleTopLeftMost(arr4);
		System.out.println(test7.area());
		int test8 = Assig2A.simpleLargestArea(arr4);
		System.out.println(test8);
    }

}
