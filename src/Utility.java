
public class Utility {

    public static int binaryToInt(String binary) {
        char[] numbers = binary.toCharArray();
        if (24 < binary.length())
            throw new IllegalArgumentException("Bit is too long");
        if (binary.equals(""))
            return 0;
        if (!binary.matches("^[0-1_]+$"))
            throw new IllegalArgumentException("Bit contains something else than 0 or 1");

        Integer result = 0;
        int count = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '1') result += (int) Math.pow(2, count);
            count++;
        }
        return result;
    }

    public static String intToBinary(int num) {
        String binary = "";


        for ( int i = 0; i < 24; i++) {
            binary += num % 2;
            num /= 2;
        }

        return new StringBuilder(binary).reverse().toString();
    }

    public static int hexToInt(String hex) {
        if (6 < hex.length())
            throw new IllegalArgumentException("Hex is too long");
        if (hex.equals(""))
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

    public static String bitwiseAnd(String first, String second) {
        String result = "";
        for (int i = 0; i < 24; i++){
            if (String.valueOf(first.charAt(i)).equals("1") && String.valueOf(second.charAt(i)).equals("1"))
                result += "1";
            else
                result += "0";
        }
        return result;

    }

    public static String bitwiseOr(String first, String second) {
        String result = "";
        for (int i = 0; i < 24; i++){
            if (String.valueOf(first.charAt(i)).equals("1") || String.valueOf(second.charAt(i)).equals("1"))
                result += "1";
            else
                result += "0";
        }
        return result;

    }


}