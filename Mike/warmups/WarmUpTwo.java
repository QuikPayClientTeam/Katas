package warmups;

public class WarmUpTwo {

    public static String stringTimes(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }

    public static String frontTimes(String str, int n) {
        int lengthOfFront = 3;
        if (lengthOfFront > str.length()){
            lengthOfFront = str.length();
        }
        String front = str.substring(0,lengthOfFront);
        
        String result = "";
        for (int i = 0;i < n; i++){
            result += front;
        }
        return result;
    }

    public static int countXX(String str) {
        int result = 0;
        for (int i = 0; i < str.length()-1;i++) {
            if (str.substring(i,i+2).equals("xx")){
                result += 1;
            }
        }
        return result;
    }

    public static boolean doubleX(String str) {
        int i = str.indexOf("x");
        boolean result = false;
        if (i == -1) {
            result = false;
        } else if (i + 1 >= str.length()) {
            result = false;
        } else if (str.substring(i + 1, i + 2).equals("x")) {
            result = true;
        }
        return result;
    }

    public static String stringBits(String str) {
        String result = "";
        return result;
    }

    public static String stringSplosion(String str) {
        String result = "";
        return result;
    }

    public static int last2(String str) {
        int result = 0;
        return result;
    }

    public static int arrayCount9(int[] nums) {
        int result = 0;
        return result;
    }

    public static boolean arrayFront9(int[] nums) {
        boolean result = false;
        return result;
    }

    public static boolean array123(int[] nums) {
        boolean result = false;
        return result;
    }

    public static int stringMatch(String a, String b) {
        int result = 0;
        return result;
    }

    public static String stringX(String str) {
        String result = "";
        return result;
    }

    public static String altPairs(String str) {
        String result = "";
        return result;
    }

    public static String stringYak(String str) {
        String result = "";
        return result;
    }

    public static int array667(int[] nums) {
        int result = 0;
        return result;
    }

    public static boolean noTriples(int[] nums) {
        boolean result = false;
        return result;
    }

    public static boolean has271(int[] nums) {
        boolean result = false;
        return result;
    }

}
