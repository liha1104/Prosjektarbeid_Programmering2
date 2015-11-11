
public class Utility {

	public static int bitToInt(String bit) {
		char[] numbers = bit.toCharArray();
		if(24 < bit.length()) 
			throw new IllegalArgumentException("Bit is too long");
		if (den inneholder noe som ikke er en eller null)
			throw new IllegalArgumentException("Bit contains something else than 0 and 1");
		 
		    Integer result = 0;
		    int count = 0;
		    for(int i=numbers.length-1;i>=0;i--){
		         if(numbers[i]=='1')result+=(int)Math.pow(2, count);
		         count++;
		    }
		    return result;
	}

	public static int hexToInt(String bit) {
		char[] numbers = bit.toCharArray();
		if(6 < bit.length()) 
			throw new IllegalArgumentException("Hex is too long");
		if (den inneholder noe som ikke er en eller null)
			throw new IllegalArgumentException("Hex contains something else than 0 and 1");
		 
		    Integer result = 0;
		    int count = 0;
		    for(int i=numbers.length-1;i>=0;i--){
		         if(numbers[i]=='1')result+=(int)Math.pow(2, count);
		         count++;
		    }
		    return result;
	}
	
	
}
