package jeuxppc;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rulls
 */
public class pierreFeuilleCiseaux {

    static int scoreUser = 0;
    static int scorePC = 0;
    static int scores[] = new int[2];
    static String rejouer = "XXX";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int resultUser;
        int resultPC;
        String result;
        int serieFin;
        String rejouerResult;
//        int resultScores[] = new int[2];

        do {
            showMenuGame();
            serieFin = setChoice();
            for (int i = 0; i < serieFin; i++) {

                resultUser = userChoice();
                resultPC = computerChoice();
                result = showResult(resultUser, resultPC);
                scoreResult(result);
            }
            rejouerResult = rejouer();
            if(rejouerResult.equals("Y")){
                scorePC = 0;
                scoreUser=0;
            }
        } while (!"N".equals(rejouerResult));
        
        System.out.println("**************** FIN DE LA PARTIE ****************");
    }

    /**
     * Afficher le Menu
     */
    public static void showMenuGame() {
        System.out.println("Jeu de Pierre, Feuille et Ciseaux");
        System.out.println("[0] = Pierre, [1] = Feuille, [2] = Ciseaux");
    }

    /**
     * @return Le choix de la serie à jouer
     */
    public static int setChoice() {
        int serieFin;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Vous voulez jouer une série de: ");
            serieFin = scanner.nextInt();
        } while (serieFin < 0 || serieFin > 5);
        return serieFin;
    }

    /**
     * @return Le choix d'un utilisateur
     */
    public static int userChoice() {
        int selectionUser;
        String choiseUser = null;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(" - C'est votre tour de jouer, 1..2..3 : ");
            selectionUser = scanner.nextInt();
            switch (selectionUser) {
                case 0:
                    choiseUser = "Pierre";
                    break;
                case 1:
                    choiseUser = "Feuille";
                    break;
                case 2:
                    choiseUser = "Ciseaux";
                    break;
            }
            System.out.println("Vous avez joué: " + choiseUser);
        } while (selectionUser < 0 || selectionUser > 2);
        return selectionUser;
    }

    /**
     * @return Le choix de l'ordinateur
     */
    public static int computerChoice() {
        String textPC = null;
        Random aleatoire = new Random();
        int selectionPC = aleatoire.nextInt(3);
        //int randomNumber = (int) Math.round(Math.random() * 3);
        switch (selectionPC) {
            case 0:
                textPC = "Pierre";
                break;
            case 1:
                textPC = "Feuille";
                break;
            case 2:
                textPC = "Ciseaux";
                break;
        }
        System.out.println("L'ordinateur a sélectionné: " + textPC);
        return selectionPC;
    }

    public static int[] scoreResult(String result) {

        if (null == result) {
            System.out.println("ERROR - NULL");
        } else {
            switch (result) {
                case "WIN":
                    scoreUser += 1;
                    scores[0] = scoreUser;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePC);
                    break;
                case "LOSE":
                    scorePC += 1;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePC);
                    scores[1] = scorePC;
                    break;
                default:
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePC);
                    break;
            }
        }
        return scores;
    }

    public static String showResult(int selectionUser, int selectionPC) {
        String result;
        if (selectionUser == selectionPC) {
            System.out.println("Partie Nulle");
            result = "TIE";
        } else if ((selectionUser == 0 && selectionPC == 2) || (selectionUser == 1 && selectionPC == 0) || (selectionUser == 2 && selectionPC == 1)) {
            System.out.println("Bravo!!!! - Vous avez Gagne!!!! SOLIDE!!!!");
            result = "WIN";
        } else {
            System.out.println("Quel dommage!!!! - Vous avez Perdu!!!!");
            result = "LOSE";
        }
        return result;
    }
/**
 * 
 * @return un String avec la réponse de l'utilisateur pour rejouer ou pas
 */
    public static String rejouer() {
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("Vous voulez jouer à nouveau Y/N: ");
            rejouer = sc.nextLine();
        } while (!"N".equals(rejouer) && !"Y".equals(rejouer) && !"XXX".equals(rejouer));
        return rejouer;
    }

}







//((selectionUser == 0 && selectionPC == 1) || (selectionUser == 1 && selectionPC == 2) || (selectionUser == 2 && selectionPC == 0) )
