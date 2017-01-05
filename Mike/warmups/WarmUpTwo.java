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
        for (int i = 0; i < str.length(); i+=2){
            result += str.substring(i, i+1);
        }
        return result;
    }

    public static String stringSplosion(String str) {
        String result = "";
        if (!str.isEmpty()){
            for (int i = 0; i < str.length(); i++){
                result += str.substring(0,i+1);
            }
        }
        return result;
    }

    public static int last2(String str) {
        int result = 0;
        if (str.length() > 2) {
        String end = str.substring(str.length()-2);
            for (int i = 0; i < str.length()-2; i++) {
            String test = str.substring(i, i+2);
                if (test.equals(end)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int arrayCount9(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9) {
                result++;
            }
        }
        return result;
    }

    public static boolean arrayFront9(int[] nums) {
        boolean result = false;
        int size = 4;
        if (nums.length < size) {
            size = nums.length;
        }
        for (int i = 0; i < size; i++) {
            if (nums[i] == 9) {
                result = true;
            }
        }
        return result;
    }

    public static boolean array123(int[] nums) {
        boolean result = false;
        for (int i = 0; i < (nums.length-2); i++){
            if (nums[i]==1 && nums[i+1]==2 && nums[i+2]==3){
                result = true;
            }
        }
        return result;
    }

    public static int stringMatch(String a, String b) {
        int result = 0;
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length-1; i++){
            String first = a.substring(i, i+2);
            String second = b.substring(i, i+2);
            if (first.equals(second)) {
                result++;
            }
        }
        return result;
    }

    public static String stringX(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++){
            if (!(i > 0 && i < (str.length()-1) && str.substring(i,  i+1).equals("x"))) {
                result += str.substring(i, i+1);
            }
        }
        return result;
    }

    public static String altPairs(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 4) {
            int part = i + 2;
            if (part > str.length()) {
                part = str.length();
            }
            result += str.substring(i, part);
        }
        return result;
    }

    public static String stringYak(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i+2<str.length() && str.charAt(i) == 'y' && str.charAt(i+2) == 'k') {
                i += 2;
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static int array667(int[] nums) {
        int result = 0;
        for (int i = 0; i < (nums.length-1); i++) {
            if (nums[i] == 6) {
                if (nums[i+1] == 6 || nums[i+1] == 7) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean noTriples(int[] nums) {
        boolean result = true;
        for (int i = 0; i < (nums.length-2); i++) {
            if (nums[i]==nums[i+1] && nums[i]==nums[i+2]) {
                result = false;
            }
        }
        return result;
    }

    public static boolean has271(int[] nums) {
        boolean result = false;
        for (int i = 0; i < (nums.length-2); i++) {
            if (nums[i+1] == (nums[i]+5) && Math.abs(nums[i+2] - (nums[i]-1)) <= 2) {
                result = true;
            }
        }
        return result;
    }

}
