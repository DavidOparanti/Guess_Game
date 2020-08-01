import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static String luckyMovie;
    private static int size;
    private static String[] output = new String[size];


    public static int generateRandomNumber(int maxExclusive) {
        return (int) (Math.random() * maxExclusive);

    }



    public static void displayRandomGame() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner sc = new Scanner((file));

        while(sc.hasNext()) {
            String[] line = sc.next().split((","));
            int length = line.length;
            int index = Game.generateRandomNumber(length);
            String movie = line[index];
            size = movie.length();
            //System.out.println(movie);
            luckyMovie = movie;

            for(int i = 0; i < movie.length(); i++) {
                Game.output[i] = "*";
            }
            System.out.println();
        }
    }


    public static String printArrayList(ArrayList<String> arrayList) {
        StringBuilder output = new StringBuilder();
        for(Object ar : arrayList) {
            output.append(ar);
        }
        return output.toString();
    }


    public static void main(String[] args) throws FileNotFoundException {
       Game.displayRandomGame();
       String movie = Game.luckyMovie;
       System.out.println(movie);

       Scanner sc = new Scanner(System.in);
       System.out.println("State your Guess");

       System.out.println(Arrays.toString(Game.output));
       String input = sc.next();
       int guess = luckyMovie.length();

       while (guess > 0) {

           if(movie.indexOf(input) < 0) {
               System.out.println("Wrong guess. Try more you have " + guess + " left");
               System.out.println(Arrays.toString(Game.output));
               input = sc.next();
           } else {
               //System.out.println("good");
              for(int i = 0; i < Game.luckyMovie.length(); i++) {
                  if(Game.luckyMovie.equals(input)) {
                      Game.output[i] = input;
                  }
              }
               System.out.println(Arrays.toString(Game.output));
               input = sc.next();


           }
           guess--;
       }

    }

}

