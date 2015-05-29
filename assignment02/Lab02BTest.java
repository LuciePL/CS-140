package assignment02;

public class Lab02BTest{
	public static void main(String[] args){
		int[] nums = new int[args.length];
		try{
			for(int i =0; i <args.length; i++){
				nums[i] = Integer.parseInt(args[i]);
				if(nums[i] < 0){
					throw new IllegalArgumentException("Negative numbers not accepted");
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("You must supply integers as command line arguments");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	Lab02B rectangles = new Lab02B(nums);
	System.out.println(rectangles.area());
	}
}
