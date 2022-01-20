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


// trial

// static boolean GameOver(ArrayList<Integer> arr, ArrayList<Integer> arrPlayerOne, ArrayList<Integer> arrPlayerTwo){
// one of the players reach the sequence
// Sequences: 7,8,9 / 4,5,6 / 1,2,3 / 7,4,1 / 8,5,2 / 9,6,3 / 7,5,3
//        int[] arrOne = new int[]{7,8,9};
//        int[] arrTwo = new int[]{4,5,6};
//        int[] arrThree = new int[]{1,2,3};
//        int[] arrFour = new int[]{7,4,1};
//        int[] arrFive = new int[]{8,5,2};
//        int[] arrSix = new int[]{9,6,3};
//        int[] arrSeven = new int[]{7,5,3};
// completes 9 numbers

    /*
    public static String[][] array;

    static ArrayList<Integer> Player(int number, String[][] arr, boolean player){
        System.out.print("Player choose your field [1-9] ");
        number = NumberScannerStored();// stores in the main array
        array = NewArray(number,KeyBoard(),arrayString,player); // print in the string array
        //Player(number,!player);
        return arrPlayer;
    }


    // asking for insert until completes 9 numbers
    static void Play(int number, boolean player){

        do{
            if(player){
                Player(number, arrayString, player);
                arrPlayerOne.add(number); // only for player 1
                player = false;
            } else if(!player){
                Player(number,array,!player);
                arrPlayerTwo.add(number);
                player = true;
            }

            //System.out.println("Main array: "+ arr);
            //System.out.println("Player 1: "+ arrPlayerOne);
            //System.out.println("Player 2: "+ arrPlayerTwo);
        } while(GameOver(arr,arrPlayerOne,arrPlayerTwo)); // here we set the GameOver
    }
    */



// static void Players(int number){
//            if(playerOne){
//                number = scanner.nextInt();
//                if ( ) {
//                    System.out.print(" X ");
//                }
//            } else {
//                number = scanner.nextInt();
//                //if (number == array[i][j]) {
//                    System.out.print(" O ");
//                }
//            }

/*

public static int[][] EmptyArrayInitial(){
        int[][] emptyArray = {
                { 0 , 0 , 0 },
                { 0 , 0 , 0 },
                { 0 , 0 , 0 },
        };
        return emptyArray;
    }

public static ArrayList CopyArray(int[][] array){

        ArrayList<ArrayList<Integer>> copyArray = new ArrayList<ArrayList<Integer>>();
        copyArray.add(new ArrayList<Integer>());

        for(int i=0; i<array.length;i++){
            for(int j=0; j<array.length; j++){
                copyArray.get(i).add(j,array[i][j]);
            }
        }

        for (ArrayList<Integer> i: copyArray) {
            System.out.print(copyArray);
        }

        return copyArray;
    }
*/

/*
    public static int[][] ArrayCalculator() {

        int[][] array = new int[row][column];

        array[0][0] = 10;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column - 1; j++) {
                array[0][j + 1] = array[0][j] + 1;
                array[i][j] = array[i - 1][j] - 3;
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }
*/



/*static void Players(int number, ArrayList<Integer> array){
        if(array.contains(number)){
            array.set(number,2);
            System.out.print(array);
        }
    }*/

/*
public static String[][] ArrayStringKeyBoard(){
        String[][] array = {
                {" 7 ", "8 ", "9 "},
                {" 4 ", "5 ", "6 "},
                {" 1 ", "2 ", "3 "},
        };
        for(int i=0; i<array.length;i++){
            for(int j=0; j< array.length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public static void CopyStringArray(String[][] array){
        String[][] copyArray = new String[array.length][array.length];

        for(int i=0; i<copyArray.length; i++){
            for(int j=0; j<copyArray.length;j++){
                copyArray[i][j] = array[i][j];
            }
        }
    }

    public static void EmptyStringArray(String num){
        String[][] emptyArray = new String[3][3];
        for(int i=0; i<emptyArray.length; i++){
            for(int j=0; j<emptyArray.length;j++){
                if(num.equalsIgnoreCase(emptyArray[i][j])) {
                    emptyArray[i][j] = " X ";
                    System.out.print(emptyArray[i][j]);
                } else {
                    emptyArray[i][j] = "   ";
                    System.out.print(emptyArray[i][j]);
                }
            }
            System.out.println();
        }
    }


static int PlayerShift(boolean player){
        if(!player){
            System.out.print("Player 2 choose your field [1-9] ");
            num = scanner.nextInt();
            num = StoredArray(num);
            PlayerShift(player);
        } else {
            System.out.print("Player 1 choose your field [1-9] ");
            num = scanner.nextInt();
            num = StoredArray(num);
            PlayerShift(!player);
        }
        return num;
    }
*/