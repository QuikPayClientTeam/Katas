package leapyear;

public class LeapYear {

    public static void main(String[] args){

    }

    public static boolean divisibleBy4(int year){
        return (year % 4 == 0);
    }

    public static boolean divisibleBy100(int year){
        return (year % 100 == 0);
    }

    public static boolean divisibleBy400(int year){
        return (year % 400 == 0);
    }

    public static boolean isLeapYear(int year) {
        if(divisibleBy4(year)){
            if(divisibleBy100(year)){
                if(divisibleBy400(year)){
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /*
    //doesn't work since it filters largest.
    public static boolean isLeapYear(int year) {
        if(divisibleBy400(year)){
            if(divisibleBy100(year)){
                if(divisibleBy4(year)){
                    return true;
                } else {
                    return false;
                }
            } else {
            return true;
            }
        } else {
            return false;
        }
    }
    */

}

