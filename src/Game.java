import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    private static String luckyMovie;
    private static String output = "";


    public static int generateRandomNumber(int maxExclusive) {
        int number = (int) (Math.random() * maxExclusive);
        return number;
    }


    public static void displayRandomGame() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner sc = new Scanner((file));

        while(sc.hasNext()) {
            String[] line = sc.next().split((","));
            int length = line.length;
            int index = Game.generateRandomNumber(length);
            String movie = line[index];
            //System.out.println(movie);
            luckyMovie = movie;

            for(int i = 0; i < movie.length(); i++) {
                output +=  "*";
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
       Game.displayRandomGame();
       String movie = Game.luckyMovie;
       System.out.println(movie);

       Scanner sc = new Scanner(System.in);
       System.out.println("State your Guess");
       String input = sc.next();
       int guess = luckyMovie.length();
       while (guess > 0) {

           if(movie.indexOf(input) < 0) {
               System.out.println("Wrong guess. Try more you have " + guess + " left");
               System.out.println(Game.output);
               input = sc.next();
           } else {

               System.out.println("good");
               System.out.println(Game.output);
               System.out.println(movie.indexOf(input));

           }
           guess--;
       }

    }

}

