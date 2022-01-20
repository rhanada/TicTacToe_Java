package TicTacToe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int row = 4;
    public static int column = 4;
    public static Scanner scanner = new Scanner(System.in);
    public static int num;

    public static void main(String[] args) {
        ArrayCalculator();
        System.out.println();
        System.out.print("Welcome to TicTacToe Player 1 choose your field [1-9] : ");
        DisplayArray(Number());


    }

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


    public static int[][] DisplayArray(int number) {

        int[][] array = new int[row][column];
        int[][] newArray = new int[row][column]; // empty array

        array[0][0] = 10;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column - 1; j++) {
                array[0][j + 1] = array[0][j] + 1;
                array[i][j] = array[i-1][j] - 3;
                if (number == array[i][j]) {
                    System.out.print(" X ");
                } else {
                    System.out.print("   ");
                }
                newArray[i][j] += array[i][j];
            }
            System.out.println();
        }
        return newArray;
    }


    public static int Number() {
        num = scanner.nextInt();
        return num;
    }


    public static void Display(int num, int[][] array) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (Number() == array[i][j]) {
                    System.out.print("X");
                } else
                    System.out.print(" ");
            }
        }
    }
}
