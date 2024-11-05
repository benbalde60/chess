/**
 * 
 */
package utils;

/**
 * 
 */
public class Helpers {
	public  static int[] convertToCor(String position) {
		// TODO Auto-generated method stub
		char first = position.charAt(0);
		char second = position.charAt(1);
		int col = first-'A'+1;
		int row = 8-(second-'1');
		return new int[]{row,col};
	}
	public static String convertCorToPos(int [] arr) {
		String pos1="",pos2="";
		switch(arr[1]) {
		case 1:
			pos1="A";
			break;
		case 2:
			pos1="B";
			break;
		case 3:
			pos1 ="C";
			break;
		case 4:
			pos1="D";
			break;
		case 5:
			pos1="E";
			break;
		case 6:
			pos1="F";
			break;
		case 7:
			pos1="G";
			break;
		case 8:
			pos1 = "H";
			break;
		}
		switch(arr[0]) {
		case 1:
			pos2 ="8";
			break;
		case 2:
			pos2="7";
			break;
		case 3:
			pos2="6";
			break;
		case 4:
			pos2="5";
			break;
		case 5: 
			pos2="4";
			break;
		case 6:
			pos2="3";
			break;
		case 7: 
			pos2="2";
			break;
		case 8:
			pos2="1";
			break;
		}
		String pos = pos1+pos2;
		return pos;
	  }

}
