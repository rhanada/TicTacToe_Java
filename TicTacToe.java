package TicTacToe;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    public static int num;
    public static String[][] arrayString; // empty String array
    public static boolean isPlayerOne = true; // starting with player 1
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Integer> arr = new ArrayList<>(); // main ArrayList
    public static ArrayList<Integer> arrPlayerOne = new ArrayList<>(); // ArrayList Player One
    public static ArrayList<Integer> arrPlayerTwo = new ArrayList<>(); // ArrayList Player TWO


    public static int[][] getKeyBoard(){
        int[][] array = {
                { 7 , 8 , 9 },
                { 4 , 5 , 6 },
                { 1 , 2 , 3 },
        };
        return array;
    }

    // printing Keyboard
    public static void printArrayIntegerKeyBoard(int[][] array){

        for(int i=0; i<array.length;i++){
            for(int j=0; j< array.length;j++){
                System.out.print(" "+ array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // empty String Array
    public static String[][] getEmptyArrayString(){
        String[][] arrayString = new String[3][3];
        for(int i=0; i< arrayString.length;i++){
            for (int j=0; j< arrayString.length;j++){
                arrayString[i][j] = " ";
            }
        }
        return arrayString;
    }

    // inserting element and storing it
    public static int storeNumber(){
        num = scanner.nextInt();
        storeArray(num);
        return num;
    }

    // creating an ArrayList will store the number inserted and verify if it was used
    static int storeArray(int number){
        if(number>0 && number<10){
            if(!arr.contains(number)) {
                arr.add(number);
            } else {
                System.out.print("Number already used! Please select a number between [1-9] ");
                number = storeNumber();
            }
        } else {
            System.out.println("Please select a number between [1-9] ");
            number = storeNumber();
        }
        return number;
    }

    // formating
    private static NumberFormat nf = new DecimalFormat("00"); // format with 2 digits

    // creating a copy from ArrayCalculator using its positions
    public static String[][] getNewArray(int number, int[][] array, String[][] newArray, boolean isPlayerOne) {

        for(int i=0; i<array.length;i++){
            for(int j=0; j<array.length;j++){
                if(number == array[i][j]){
                    // add player
                    if(isPlayerOne){
                        newArray[i][j] = "X";
                    } else {
                        newArray[i][j] = "O";
                    }
                }
                System.out.print(" "+ newArray[i][j] +" ");
            }
            System.out.println();
        }
        return newArray;
    }

    public static void startGame(){
        arrayString = getNewArray(storeArray(num), getKeyBoard(), getEmptyArrayString(), isPlayerOne);
        arrPlayerOne.add(num);
    }

    // asking for insert until completes 9 numbers
    static void playGame(){
            int num1;
            int num2;
            do{

                // Player 2
                System.out.print("Player 2 choose your field [1-9] ");
                num2 = storeNumber();
                String[][] array = getNewArray(num2, getKeyBoard(),arrayString,!isPlayerOne);
                arrPlayerTwo.add(num2);
                if(isGameOverPlayer(arrPlayerTwo)){
                    System.out.println("Player 2 won!");
                    break;
                }

                // Player 1
                System.out.print("Player 1 choose your field [1-9] ");
                num1 = storeNumber();
                getNewArray(num1, getKeyBoard(),array, isPlayerOne);
                //System.out.println("Main array: "+ arr); // print the array with chosen numbers
                arrPlayerOne.add(num1);
                if(isGameOverPlayer(arrPlayerOne)){
                    System.out.println("Player 1 won!");
                    break;
                }
            } while(isGameOver(arr)); // here we set the GameOver
    }

    static boolean isGameOver(ArrayList<Integer> arr){
        if(arr.size() == 9){
            System.out.println("Game Over, nobody won!");
            return false;
        }
        return true;
    }

    static boolean isGameOverPlayer(ArrayList<Integer> arrPlayer){
        if(
                (arrPlayer.contains(4) && arrPlayer.contains(5) && arrPlayer.contains(6)) ||
                (arrPlayer.contains(1) && arrPlayer.contains(2) && arrPlayer.contains(3)) ||
                (arrPlayer.contains(7) && arrPlayer.contains(8) && arrPlayer.contains(9)) ||
                (arrPlayer.contains(7) && arrPlayer.contains(4) && arrPlayer.contains(1)) ||
                (arrPlayer.contains(8) && arrPlayer.contains(5) && arrPlayer.contains(2)) ||
                (arrPlayer.contains(9) && arrPlayer.contains(6) && arrPlayer.contains(3)) ||
                (arrPlayer.contains(7) && arrPlayer.contains(5) && arrPlayer.contains(3)) ||
                (arrPlayer.contains(9) && arrPlayer.contains(5) && arrPlayer.contains(1))
        ){ return true;}
        return false;
    }


    public static void main(String[] args){
        // displaying the keyboard
        printArrayIntegerKeyBoard(getKeyBoard());
        // the number position will be found and inserted into empty array
        startGame();
        // repeat until it has a winner or the board fully completed
        playGame();
    }

}
