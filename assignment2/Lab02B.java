package assignment02;
import java.awt.Rectangle;

public class Lab02B{
	private Rectangle rect;
		public Lab02B(int[] numbers){
			if(numbers.length >= 4){
				rect = new Rectangle(numbers[0], numbers[1], numbers[2], numbers[3]);
			}

			else{
				rect = new Rectangle(0,0,0,0);
			}
			}

		public int area(){
			int area;
			int length = rect.height;
			int width = rect.width;
			area = length*width;
			return area;
		}
		
		public int getX(){
			return rect.x;
		}
		
		public int getY(){
			return rect.y;
		}
}
