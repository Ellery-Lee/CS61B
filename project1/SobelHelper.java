/* SobelHelper.java */

/**
 *  The purpose of this class is to provide a shorthand for writing and testing
 *  Sobel.
 **/

public class SobelHelper {

  /**
   *  Pixel_Energy() helps returning the energy of a specific pixel.
   *
   *  @param array  the array which is going to execute sobel function.
   *  @param x the x-coordinate of the pixel.
   *  @param y the y-coordinate of the pixel.
   **/

  static long Pixel_Energy(Pixel[][] array, int i, int j) {        //warning! :Pixel[][] array rather than int[][] array
	short[][] x_factor = { {1, 0 ,-1},
						   {2, 0, -2},
						   {1, 0, -1} };
	short[][] y_factor = { {1, 2, 1},
						   {0, 0, 0},
						   {-1, -2, -1} };
	
	long Scolor_red_Energy_gx = 0;
	long Scolor_red_Energy_gy = 0;
	long Scolor_green_Energy_gx = 0;
	long Scolor_green_Energy_gy = 0;
	long Scolor_blue_Energy_gx = 0;
	long Scolor_blue_Energy_gy = 0;
	long Whole_Energy = 0;
	
	short[][] Red_Array;           //create these three array is for store the color_9Array,bacause they will disappear after if() function.
	short[][] Green_Array;
	short[][] Blue_Array;
	  
    if(i != 0 && j != 0 && i != array.length - 1 && j != array[0].length - 1){
		short[][] Red_9Array = {{array[i-1][j-1].getRed(), array[i-1][j].getRed(), array[i-1][j+1].getRed()},             //take red color array from original array
								{array[i][j-1].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},
								{array[i+1][j-1].getRed(), array[i+1][j].getRed(), array[i+1][j+1].getRed()}};
		short[][] Green_9Array = {{array[i-1][j-1].getGreen(), array[i-1][j].getGreen(), array[i-1][j+1].getGreen()},     //take green color array from original array
								  {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},
								  {array[i+1][j-1].getGreen(), array[i+1][j].getGreen(), array[i+1][j+1].getGreen()}};
		short[][] Blue_9Array = {{array[i-1][j-1].getBlue(), array[i-1][j].getBlue(), array[i-1][j+1].getBlue()},         //take blue color array from original array
							     {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},
								 {array[i+1][j-1].getBlue(), array[i+1][j].getBlue(), array[i+1][j+1].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	
	}else if(i == 0 && j != 0 && j != array[0].length - 1){
		short[][] Red_9Array = {{array[i][j-1].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},             //take red color array from original array
										 {array[i][j-1].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},
										 {array[i+1][j-1].getRed(), array[i+1][j].getRed(), array[i+1][j+1].getRed()}};
		short[][] Green_9Array = {{array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},     //take green color array from original array
										   {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},
										   {array[i+1][j-1].getGreen(), array[i+1][j].getGreen(), array[i+1][j+1].getGreen()}};
		short[][] Blue_9Array = {{array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},         //take blue color array from original array
										  {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},
										  {array[i+1][j-1].getBlue(), array[i+1][j].getBlue(), array[i+1][j+1].getBlue()}};							  
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
		
	}else if(i == array.length - 1 && j != 0 && j != array[0].length - 1){
		short[][] Red_9Array = {{array[i-1][j-1].getRed(), array[i-1][j].getRed(), array[i-1][j+1].getRed()},             //take red color array from original array
										 {array[i][j-1].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},
										 {array[i][j-1].getRed(), array[i][j].getRed(), array[i][j+1].getRed()}};
		short[][] Green_9Array = {{array[i-1][j-1].getGreen(), array[i-1][j].getGreen(), array[i-1][j+1].getGreen()},     //take green color array from original array
										   {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},
										   {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()}};
		short[][] Blue_9Array = {{array[i-1][j-1].getBlue(), array[i-1][j].getBlue(), array[i-1][j+1].getBlue()},         //take blue color array from original array
										  {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},
										  {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	}else if(i != 0 && j == 0 && i != array.length - 1){
		short[][] Red_9Array = {{array[i-1][j].getRed(), array[i-1][j].getRed(), array[i-1][j+1].getRed()},             //take red color array from original array
										 {array[i][j].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},
										 {array[i+1][j].getRed(), array[i+1][j].getRed(), array[i+1][j+1].getRed()}};
		short[][] Green_9Array = {{array[i-1][j].getGreen(), array[i-1][j].getGreen(), array[i-1][j+1].getGreen()},     //take green color array from original array
										   {array[i][j].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},
										   {array[i+1][j].getGreen(), array[i+1][j].getGreen(), array[i+1][j+1].getGreen()}};
		short[][] Blue_9Array = {{array[i-1][j].getBlue(), array[i-1][j].getBlue(), array[i-1][j+1].getBlue()},         //take blue color array from original array
										  {array[i][j].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},
										  {array[i+1][j].getBlue(), array[i+1][j].getBlue(), array[i+1][j+1].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	}else if(i != 0 && j == array[0].length - 1 && i !=array.length - 1){
		short[][] Red_9Array = {{array[i-1][j-1].getRed(), array[i-1][j].getRed(), array[i-1][j].getRed()},             //take red color array from original array
										 {array[i][j-1].getRed(), array[i][j].getRed(), array[i][j].getRed()},
										 {array[i+1][j-1].getRed(), array[i+1][j].getRed(), array[i+1][j].getRed()}};
		short[][] Green_9Array = {{array[i-1][j-1].getGreen(), array[i-1][j].getGreen(), array[i-1][j].getGreen()},     //take green color array from original array
										   {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j].getGreen()},
										   {array[i+1][j-1].getGreen(), array[i+1][j].getGreen(), array[i+1][j].getGreen()}};
		short[][] Blue_9Array = {{array[i-1][j-1].getBlue(), array[i-1][j].getBlue(), array[i-1][j].getBlue()},         //take blue color array from original array
										  {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j].getBlue()},
										  {array[i+1][j-1].getBlue(), array[i+1][j].getBlue(), array[i+1][j].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	}else if(i == 0 && j == 0){
		short[][] Red_9Array = {{array[i][j].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},             //take red color array from original array
										 {array[i][j].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},
										 {array[i+1][j].getRed(), array[i+1][j].getRed(), array[i+1][j+1].getRed()}};
		short[][] Green_9Array = {{array[i][j].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},     //take green color array from original array
										   {array[i][j].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},
										   {array[i+1][j].getGreen(), array[i+1][j].getGreen(), array[i+1][j+1].getGreen()}};
		short[][] Blue_9Array = {{array[i][j].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},         //take blue color array from original array
										  {array[i][j].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},
										  {array[i+1][j].getBlue(), array[i+1][j].getBlue(), array[i+1][j+1].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	}else if(i == 0 && j == array[0].length - 1){
		short[][] Red_9Array = {{array[i][j-1].getRed(), array[i][j].getRed(), array[i][j].getRed()},             //take red color array from original array
										 {array[i][j-1].getRed(), array[i][j].getRed(), array[i][j].getRed()},
										 {array[i+1][j-1].getRed(), array[i+1][j].getRed(), array[i+1][j].getRed()}};
		short[][] Green_9Array = {{array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j].getGreen()},     //take green color array from original array
										   {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j].getGreen()},
										   {array[i+1][j-1].getGreen(), array[i+1][j].getGreen(), array[i+1][j].getGreen()}};
		short[][] Blue_9Array = {{array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j].getBlue()},         //take blue color array from original array
										  {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j].getBlue()},
										  {array[i+1][j-1].getBlue(), array[i+1][j].getBlue(), array[i+1][j].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	}else if(i == array.length - 1 && j == 0){
		short[][] Red_9Array = {{array[i-1][j].getRed(), array[i-1][j].getRed(), array[i-1][j+1].getRed()},             //take red color array from original array
										 {array[i][j].getRed(), array[i][j].getRed(), array[i][j+1].getRed()},
										 {array[i][j].getRed(), array[i][j].getRed(), array[i][j+1].getRed()}};
		short[][] Green_9Array = {{array[i-1][j].getGreen(), array[i-1][j].getGreen(), array[i-1][j+1].getGreen()},     //take green color array from original array
										   {array[i][j].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()},
										   {array[i][j].getGreen(), array[i][j].getGreen(), array[i][j+1].getGreen()}};
		short[][] Blue_9Array = {{array[i-1][j].getBlue(), array[i-1][j].getBlue(), array[i-1][j+1].getBlue()},         //take blue color array from original array
										  {array[i][j].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()},
										  {array[i][j].getBlue(), array[i][j].getBlue(), array[i][j+1].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	}else {
		short[][] Red_9Array = {{array[i-1][j-1].getRed(), array[i-1][j].getRed(), array[i-1][j].getRed()},             //take red color array from original array
										 {array[i][j-1].getRed(), array[i][j].getRed(), array[i][j].getRed()},
										 {array[i][j-1].getRed(), array[i][j].getRed(), array[i][j].getRed()}};
		short[][] Green_9Array = {{array[i-1][j-1].getGreen(), array[i-1][j].getGreen(), array[i-1][j].getGreen()},     //take green color array from original array
										   {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j].getGreen()},
										   {array[i][j-1].getGreen(), array[i][j].getGreen(), array[i][j].getGreen()}};
		short[][] Blue_9Array = {{array[i-1][j-1].getBlue(), array[i-1][j].getBlue(), array[i-1][j].getBlue()},         //take blue color array from original array
										  {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j].getBlue()},
										  {array[i][j-1].getBlue(), array[i][j].getBlue(), array[i][j].getBlue()}};
		Red_Array = Red_9Array;          
		Green_Array = Green_9Array;
		Blue_Array = Blue_9Array;
	}
	
	for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				Scolor_red_Energy_gx += (long)(x_factor[x][y] * Red_Array[x][y]);
				Scolor_red_Energy_gy += (long)(y_factor[x][y] * Red_Array[x][y]);
				Scolor_green_Energy_gx += (long)(x_factor[x][y] * Green_Array[x][y]);
				Scolor_green_Energy_gy += (long)(y_factor[x][y] * Green_Array[x][y]);
				Scolor_blue_Energy_gx += (long)(x_factor[x][y] * Blue_Array[x][y]);
				Scolor_blue_Energy_gy += (long)(y_factor[x][y] * Blue_Array[x][y]);
			}
		}
	Whole_Energy = (long)(Math.pow(Scolor_red_Energy_gx, 2) + Math.pow(Scolor_red_Energy_gy, 2) + Math.pow(Scolor_green_Energy_gx, 2) + Math.pow(Scolor_green_Energy_gy, 2) + Math.pow(Scolor_blue_Energy_gx, 2) + Math.pow(Scolor_blue_Energy_gy, 2));
	return Whole_Energy;
  }
}