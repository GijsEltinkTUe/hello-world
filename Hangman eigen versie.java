// Hangman TEMPLATE
// Homework Assignment 2 2ip90 
/**
 * Hangman Game
 * Gijs Eltink
 * 12/09/2019
 */

import java.util.Scanner;

class Hangman {
  Scanner scanner = new Scanner(System.in);
  
  void play() {

    System.out.println("Which word or words do you want to play with?");
    String secret = scanner.nextLine();

    for (int b = 0; b < 50; ++b) System.out.println();

    // Declaring variables
    String progressWordString = ""; //initializing and declaring String
    char[] progressWord;  // progressword is the word shown to the player each turn
    int wordLength = secret.length();
    int i = 0; // i will be used for counting amount of mistakes
    char q = '_'; // will be used for replacing used letters
    String secretb = secret; // will be used as edited term of the secret word
    char[] secretArray; // will be used to be able to replace letters in string secretb
    progressWord = secret.toCharArray();
    char [] testWord = secret.toCharArray();
    String letters = "              ";
    char [] lettersChar = letters.toCharArray();
    int r = 0;

    // Changing the progressword to underscores
    for (int n = 0; n < wordLength; n++) {
      progressWord[n] = '_';
      if (testWord[n] == ' ') {
        progressWord[n] = ' ';
      }
    }

    // from here the player can choose letters
    while (i < 10){
      System.out.println(progressWord); // prints current progress
      char x = scanner.next().charAt(0); // char x = input of player
      if (secretb.indexOf(x) >= 0) { // tests if the string secretb (which = secret on the first run) contains x
        for (int k = 0; k < wordLength; k++) { // this line and the line below search which index = input
          if (secretb.charAt(k) == x) {
            progressWord[k] = secret.charAt(k); // replaces _ with (correct) input
            secretArray = secretb.toCharArray(); // this line and the 2 following replace the input in secretb
            secretArray[k] = q;
            secretb = String.valueOf(secretArray);
          }
        }
      } else {
        int letterlength = letters.length();
        i++;
        int z;
        for (z = 0; z < (letterlength-1); z++) {
          if (letters.charAt(z) == x) {
            break;
          }
          if (z == 12) {
            r++;
            lettersChar[r] = x;
          }
        }
        letters = String.valueOf(lettersChar);
        lettersChar = letters.toCharArray();
        System.out.println("That's wrong! mistake "+i+"/10");
        System.out.println("You have tried the letters:"+letters);
      }

      // following 4 lines print out the complete word and break loop if progressword = guessword
      progressWordString = String.valueOf(progressWord);
      if (progressWordString.equals(secret)) {
        System.out.println(progressWord);
        break;
      }
    }
    // following 5 lines declare the result of the game
    if (progressWordString.equals(secret)) {
      System.out.println("Well done, you won!");
    } else {
      System.out.println("Unlucky, you lost!");
      System.out.println("The secret word was: "+secret);
    }
  }
  
  public static void main(String[] args) { 
    new Hangman().play();
  }
}