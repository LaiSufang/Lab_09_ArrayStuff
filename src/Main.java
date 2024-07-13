import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] dataPoints = new int[100];
        int sum = 0;
        int min = 0;
        int max = 0;
        Random randomNum = new Random();
        Scanner pipe = new Scanner(System.in);

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = randomNum.nextInt(100) + 1;
            sum += dataPoints[i];
            min = dataPoints[0];
            if (min > dataPoints[i]) { min = dataPoints[i];}
            max = dataPoints[0];
            if (max < dataPoints[i]) { max = dataPoints[i];}
        }

        for (int dataPoint : dataPoints) { // for-each loop (advanced for loop without using index)
            System.out.print(dataPoint + " | ");
        }

        System.out.println("\nThere are " + dataPoints.length + " integers in the array. \nThe sum of these integers is: " + sum + ". The average is: " + getAverage(dataPoints) + "\nThe minimum number is " + min + "\nThe maximum number is " + max);

        //linear search
        int userInput = SafeInput.getRangedInt(pipe, "\nPlease enter an integer from 1 to 100: ", 1, 100);
        int userInputAccounts = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (userInput == dataPoints[i]) {
                userInputAccounts++;
                System.out.println(userInput + " is found at index " + i);
            }
        }
        System.out.println(userInput + " was found " + userInputAccounts + " times in the array.\n");

        //short-circuit search
        boolean inputFound = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (userInput == dataPoints[i]) {
                inputFound = true;
                System.out.println(userInput + " is first found at index " + i);
                break;
            }
        }
        if (!inputFound) {
            System.out.println("The number you entered is not found in the array.");
        }

    }
    //get average function
    public static double getAverage(int[] dataPoints) {

        double sum = 0;
        for (int dataPoint : dataPoints) {
            sum += dataPoint;
        }
        return sum / dataPoints.length;
    }
}