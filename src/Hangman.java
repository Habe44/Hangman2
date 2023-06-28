import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static ArrayList<String> words = new ArrayList<>();
    static ArrayList<String> correctLetters = new ArrayList<>();
    static ArrayList<String> incorrectLetters = new ArrayList<>();
    String randomWord;
    String playerLetter;
    String x = "_";


   void Draw() {
        Random r = new Random();
        int randomItem = r.nextInt(Hangman.words.size());
        randomWord = Hangman.words.get(randomItem);
        //System.out.println(randomWord);
    }

    void encrypt() {
        for (int i = 0; i < randomWord.length(); i++) {
            System.out.print(x.toCharArray());
        }
    }
    void decrypt() {
        System.out.println(" ");
        while(true) {
            Scanner scan = new Scanner(System.in);
            String x = scan.nextLine();
            Player p = new Player(x);
            playerLetter = p.getPlayerChoice();
            if(correctLetters.contains(playerLetter)){
                System.out.println("Wykorzystana litera");
                continue;
            }
            if(randomWord.contains(playerLetter)){
                System.out.println("Zgadza sie !");
                correctLetters.add(playerLetter);
            }
            if(correctLetters.size() == randomWord.length()){
                System.out.println("Odgadles wszystkie litery");
                System.out.println("Wylosowane haslo to: " + randomWord);
                break;
            }
            if(!randomWord.contains(playerLetter)){
                incorrectLetters.add(playerLetter);
                if(incorrectLetters.size() == 1){
                    System.out.println("^^^^^^^");
                    System.out.println("Zle ! Pozostalo prob: 6 !");
                }
                if(incorrectLetters.size() == 2){
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("^^^^^^^");
                    System.out.println("Zle ! Pozostalo prob: 5 !");
                }
                if(incorrectLetters.size() == 3){
                    System.out.println("-----------------------");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("^^^^^^^");
                    System.out.println("Zle ! Pozostalo prob: 4 !");
                }
                if(incorrectLetters.size() == 4){
                    System.out.println("-----------------------");
                    System.out.println("|                     |");
                    System.out.println("|                     0");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("^^^^^^^");
                    System.out.println("Zle ! Pozostalo prob: 3 !");
                }
                if(incorrectLetters.size() == 5){
                    System.out.println("-----------------------");
                    System.out.println("|                     |");
                    System.out.println("|                     0");
                    System.out.println("|                     |");
                    System.out.println("|                     |");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("^^^^^^^");
                    System.out.println("Zle ! Pozostalo prob: 2 !");
                }
                if(incorrectLetters.size() == 6){
                    System.out.println("-----------------------");
                    System.out.println("|                     |");
                    System.out.println("|                     0");
                    System.out.println("|                    >|<");
                    System.out.println("|                     |");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("^^^^^^^");
                    System.out.println("Zle ! Pozostalo prob: 1 !");
                }
                if(incorrectLetters.size() == 7){
                    System.out.println("-----------------------");
                    System.out.println("|                     |");
                    System.out.println("|                     0");
                    System.out.println("|                    >|<");
                    System.out.println("|                     |");
                    System.out.println("|                    ] [");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("^^^^^^^");
                    System.out.println("Przegrales !");
                    break;
                }
            }
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

