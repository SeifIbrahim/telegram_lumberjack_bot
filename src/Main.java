import java.awt.*;

public class Main {
	public static void main(String[] args) {
		Robot robot = null;
		boolean left = true;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		int counter = 0;
		int delay = 70;
		int ycoord = 365;
		while (true) {
			if (counter == 200) {
				delay = 50;
				ycoord = 343;
			}
			if (counter == 400){
				delay = 40;
				ycoord = 335;
			}
			counter++;
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			int x = (int) b.getX();
			int y = (int) b.getY();
			// System.out.println(x + ", " + y);
			if (!robot.getPixelColor(610, ycoord).equals(new Color(202, 245, 253))) {
				robot.keyPress(39);
				left = false;
			} else if (!robot.getPixelColor(780, ycoord).equals(new Color(202, 245, 253))) {
				robot.keyPress(37);
				left = true;
			} else if (left) {
				robot.keyPress(37);
			} else {
				robot.keyPress(39);
			}
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
