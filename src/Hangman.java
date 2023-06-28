import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static ArrayList<String> words = new ArrayList<>();
    String randomWord;
    String playerLetter;
    String x = "_";
    void decrypt() {
        System.out.println(" ");
        while(true) {
            Scanner scan = new Scanner(System.in);
            String x = scan.nextLine();
            Player p = new Player(x);
            playerLetter = p.getPlayerChoice();
            System.out.println("Litera gracza: " + playerLetter);
            if(playerLetter.toCharArray().equals(randomWord.toCharArray())){
                System.out.println("Zgadza sie");
            }
            else{
                System.out.println("|");
            }
        }
    }

   void Draw() {
        Random r = new Random();
        int randomItem = r.nextInt(Hangman.words.size());
        randomWord = Hangman.words.get(randomItem);
        System.out.println(randomWord);
    }

    void encrypt() {
        for (int i = 0; i < randomWord.length(); i++) {
            System.out.print(x);
        }
    }
    public static void main(String[] args) {
        words.add("kot");
        words.add("pies");
        Hangman h = new Hangman();

        h.Draw();
        h.encrypt();
        h.decrypt();

    }
}

