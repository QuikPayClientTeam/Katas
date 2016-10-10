import java.util.Random;
import java.util.Scanner;

public class diceRoll {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        Random rand = new Random();
        int quantity;
        int sides;
        int die;
        int total = 0;
        
        System.out.println ("How many sides should the dice have?");
        sides = input.nextInt();
        System.out.println ("How many dice would you like to roll?");
        quantity = input.nextInt();
        int [] dice = new int[quantity];

        for(int i=0;i<quantity;i++){
            die = rand.nextInt(sides)+1;
            dice[i] = die;
        }
        
        System.out.println("Dice and Totals");
        for(int i=0;i<dice.length;i++) {
            System.out.println("Die "+(i+1)+" = " + dice[i]);
            total = total + dice[i];
        }
        System.out.println("Total = " + total);
    }

}