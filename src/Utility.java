
public class Utility {

    public static int bitToInt(String bit) {
        char[] numbers = bit.toCharArray();
        if (24 < bit.length())
            throw new IllegalArgumentException("Bit is too long");
        if (bit == "")
            return 0;
        if (!bit.matches("^[0-1_]+$"))
            throw new IllegalArgumentException("Bit contains something else than 0 or 1");

        Integer result = 0;
        int count = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '1') result += (int) Math.pow(2, count);
            count++;
        }
        return result;
    }

    public static String intToBit(int num) {

    }

    public static int hexToInt(String hex) {
        char[] numbers = hex.toCharArray();
        if (6 < hex.length())
            throw new IllegalArgumentException("Hex is too long");
        if (hex == "")
            return 0;
        if (!hex.matches("^[a-fA-F0-9_]+$"))
            throw new IllegalArgumentException("Hex contains something wrong");

        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }

    public static String intToHex(int num){
        String digits = "0123456789ABCDEF";
        if (num == 0) return "0";
        String hex = "";
        while (num > 0) {
            int digit = num % 16;
            hex = digits.charAt(digit) + hex;
            num = num / 16;
        }
        return hex;
    }


}