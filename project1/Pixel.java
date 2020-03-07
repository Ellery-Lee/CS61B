/* Pixel.java */

/**
 *  A Pixel is a node in a Piximage.
 */

public class Pixel{
	private short red;
	private short green;
	private short blue;
	
	public Pixel(){
		red = 0;
		green = 0;
		blue = 0;
	}
	
	public short getRed(){
		return red;
	}
	public short getGreen(){
		return green;
	}
	public short getBlue(){
		return blue;
	}
	
	
	public void setRed(short i){
		red = i;
	}
	public void setGreen(short i){
		green = i;
	}
	public void setBlue(short i){
		blue = i;
	}
}