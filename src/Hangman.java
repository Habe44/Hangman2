import java.io.IOException;
import java.util.*;


public class Hangman {
    static ArrayList<String> words = new ArrayList<>();
    static ArrayList<String> usedWords = new ArrayList<>();
    static ArrayList<String> correctLetters = new ArrayList<>();
    static ArrayList<String> incorrectLetters = new ArrayList<>();
    String randomWord;
    String playerLetter;
    String x = "_";
    int win = 0;
    int lose = 0;


   void Draw() {
        Random r = new Random();
        int randomItem = r.nextInt(Hangman.words.size());
        randomWord = Hangman.words.get(randomItem);

    }
    void Hint(){
        if(randomWord.equals("Puszka")){
            System.out.println("Podpowiedz: blaszane opakowanie np. napoju.");
        }
        if(randomWord.equals("Pies")){
            System.out.println("Podpowiedz: mowia, ze jest to najlepszy przyjaciel czlowieka.");
        }
        if(randomWord.equals("Obraz")){
            System.out.println("Podpowiedz: podziwia sie go na wystawie.");
        }
        if(randomWord.equals("Drewno")){
            System.out.println("Podpowiedz: surowiec dla ciesli.");
        }
        if(randomWord.equals("Butelka")) {
            System.out.println("Podpowiedz: szklane opakowanie");
        }
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
            if(randomWord.toLowerCase().contains(playerLetter)){
                correctLetters.add(playerLetter);
            }
            if(correctLetters.size() == randomWord.length()){
                System.out.println("");
                System.out.println("Odgadles wszystkie litery");
                win++;
                System.out.println("Wylosowane haslo to: " + randomWord);
                System.out.println("");
                correctLetters.clear();
                System.out.println("Wygrane: " + win);
                System.out.println("Przegrane: " + lose);
                System.out.println("");
                usedWords.add(randomWord);
                correctLetters.clear();
                break;
            }
            if(!randomWord.toLowerCase().contains(playerLetter)){
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
                    System.out.println("Wylosowane haslo to: " + randomWord);
                    System.out.println("");
                    incorrectLetters.clear();
                    lose++;
                    System.out.println("Wygrane: " + win);
                    System.out.println("Przegrane: " + lose);
                    System.out.println("");
                    break;
                    }
                }
            }
        }

    public static void main(String[] args) throws IOException {
        words.add("Puszka");
        words.add("Pies");
        words.add("Obraz");
        words.add("Drewno");
        words.add("Butelka");
        Scanner scn = new Scanner(System.in);
        Hangman h = new Hangman();
        boolean game = true;
        System.out.println("Zasady gry:");
        System.out.println("Program losuje jedno z pieciu slow do odgadniecia. Zadaniem jest odgadnac wszystkie wylosowane slowa w 3 rundy.");
        System.out.println("Nalezy wpisywac po jednej malej literze.");
        System.out.println(" Prob na odgadniecie hasla jest 6.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        do {
            h.Draw();
            while(usedWords.contains(h.randomWord)){
                h.Draw();
            }
            h.Hint();
            h.encrypt();
            h.decrypt();
            if (h.win + h.lose == 3) {
                if (h.win > h.lose) {
                    System.out.println("Wygrales gre! Wynik:");
                    System.out.println("Wygrane: " + h.win + "   " + "Przegrane: " + h.lose);
                    usedWords.clear();
                }
                if (h.win < h.lose) {
                    System.out.println("Przegrales gre!");
                    System.out.println("-----------------------");
                    System.out.println("|                     |");
                    System.out.println("|                     0");
                    System.out.println("|                     >|<");
                    System.out.println("|                     |");
                    System.out.println("|                    ] [");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("^^^^^^^");
                    System.out.println("Wynik:");
                    System.out.println("Wygrane: " + h.win + "   " + "Przegrane: " + h.lose);
                    usedWords.clear();
                }
                System.out.println("Czy chcesz zagrac jeszcze raz?");
                System.out.println("1 - zagraj jeszcze raz\n2 - zakoncz gre");
                int tryAgain = scn.nextInt();
                if (tryAgain == 1) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    h.win = 0;
                    h.lose = 0;
                    correctLetters.clear();
                    incorrectLetters.clear();
                }
                if (tryAgain == 2) {
                    break;
                }
            }
        }
        while (game);

    }
}

