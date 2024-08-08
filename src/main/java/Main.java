import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        //generate random number
        int randomNumber = ThreadLocalRandom.current().nextInt(1,17);
        String biRandomNumber = Integer.toBinaryString(randomNumber);

        //with answers
        // System.out.println(randomNumber);
        // System.out.println(biRandomNumber);

        //init board
        char[] board = initBoard(biRandomNumber);
        printBoard(board);

        //user guess
        int guessCounter = 0;
        System.out.println("Enter your binary number guess: ");

        //valid input
        String input = generateValidInput();
        guessCounter++;

        System.out.println(input);
        boolean isGameOver= false;


        while (!isGameOver){
            if (input.equals(biRandomNumber)){
                System.out.println("That's Right ! you win !");
                System.out.println("\tthe number is: "+ randomNumber+"\n\tin binary: "+biRandomNumber);
                isGameOver = true;
            } else if (guessCounter == board.length){
                System.out.println("That's Wrong ! you lost !");
                System.out.println("\tthe number was: "+ randomNumber+"\n\tin binary: "+biRandomNumber);
                isGameOver = true;
            }
            else{
                char[] biArray = biRandomNumber.toCharArray();
                board[board.length-(guessCounter)] = biArray[board.length-guessCounter];
                System.out.println("That's wrong.. Try again");
                printBoard(board);
                input = generateValidInput();
                guessCounter++;
            }
        }
        System.out.println("Thank you for playing !");

    }

    public static String generateValidInput(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        boolean isvalid = false;
        while (!isvalid){
            if (input % 10 == 0 ||  input % 10 == 1){

                isvalid = true;
            } else{
                System.out.println("invalid guess");
                System.out.println("Enter your guess: ");
                input = scanner.nextInt();

            }
        } return String.valueOf(input);
    }



    public static char[] initBoard(String biRandomNumber){
        char[] board = new char[biRandomNumber.length()];
        for (int i = 0; i < board.length; i++){
            board[i] = '_';
        }
        return board;
    }

    public static void printBoard(char[] board){
        for (int i = 0; i<board.length; i++){
            System.out.print(board[i]);
        }
        System.out.println(" ");
    }


}
