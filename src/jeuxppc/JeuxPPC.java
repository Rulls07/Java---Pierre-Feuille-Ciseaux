package jeuxppc;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rulls
 */
public class JeuxPPC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaration de variables 
        int i;
        int scoreUser = 0;
        int scorePc = 0;
        boolean newGame = true;
        String rejouer = "XXX";
        int serieFin;
        //******************        0 = pierre 1= feuille 2 = ciseau
        int selectionUser = 0;
        String selectionPC = null;
        String choiseUser = null;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Jeu de Pierre, Feuille et Ciseaux");
            do {
                System.out.println("Vous voulez jouer une série de: ");
                serieFin = scanner.nextInt();
            } while (serieFin < 0 || serieFin > 5);

            for (i = 1; i <= serieFin; i++) {

                //****************************  Selection User - Utilisateur
                do {
                    System.out.println("0 = Pierre, 1 = Feuille, 2 = Ciseaux");
                    System.out.println("[" + i + "]" + " - C'est votre tour de jouer, 1..2..3 : ");
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
                //        selectionUser == 0 ? choiseUser = "Pierre"; : selectionUser == 1 ? choiseUser = "Feuille"; : choiseUser = "Ciseau";

                //****************************  Selection PC - Ordinateur
                Random aleatoire = new Random();
                int randomNumber = aleatoire.nextInt(3);
//            int randomNumber = (int) Math.round(Math.random() * 3);
                switch (randomNumber) {
                    case 0:
                        selectionPC = "Pierre";
                        break;
                    case 1:
                        selectionPC = "Feuille";
                        break;
                    case 2:
                        selectionPC = "Ciseau";
                        break;
//                default:
//                    throw new AssertionError();
                }
                //        randomNumber == 0 ? selectionPC = "Pierre" : randomNumber == 1 ? selectionPC = "Feuille" : selectionPC = "Ciseau";
                System.out.println("L'ordinateur a sélectionné: " + selectionPC);

                //****************************  Gagnant
                // Pierre VS reste
                if (selectionUser == 0 && randomNumber == 0) {
                    System.out.println("Partie Nulle");
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                } else if (selectionUser == 0 && randomNumber == 1) {
                    System.out.println("Vous avez Perdu!, La feuille enveloppe la pierre et gagne.");
                    scorePc += 1;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                } else if (selectionUser == 0 && randomNumber == 2) {
                    System.out.println("Vous avez Gagne!!!, La pierre écrase les ciseaux et gagne. ");
                    scoreUser += 1;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                }
                // Feuille VS reste
                if (selectionUser == 1 && randomNumber == 0) {
                    System.out.println("Vous avez Gagne!!!La feuille enveloppe la pierre et gagne. ");
                    scoreUser += 1;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                } else if (selectionUser == 1 && randomNumber == 1) {
                    System.out.println("Partie Nulle");
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                } else if (selectionUser == 1 && randomNumber == 2) {
                    System.out.println("Vous avez Perdu!, Les ciseaux découpent la feuille et gagnent.");
                    scorePc += 1;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                }
                // Ciseaux VS reste
                if (selectionUser == 2 && randomNumber == 0) {
                    System.out.println("Vous avez Perdu!, La pierre écrase les ciseaux et gagne.");
                    scorePc += 1;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                } else if (selectionUser == 2 && randomNumber == 1) {
                    System.out.println("Vous avez Gagne!!!, Les ciseaux découpent la feuille et gagnent.");
                    scoreUser += 1;
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                } else if (selectionUser == 2 && randomNumber == 2) {
                    System.out.println("Partie Nulle");
                    System.out.println("SCORE UTILISATEUR: " + scoreUser + " " + "SCORE PC: " + scorePc);
                }

            }
                System.out.println("Vous voulez jouer à nouveau Y/N: ");
            do {
                rejouer = scanner.nextLine();

            } while (!"N".equals(rejouer) && !"Y".equals(rejouer) && !"XXX".equals(rejouer));  // != "N"

//            String jugar == "Y" ? newGame = true : newGame = false;
        } while (!"N".equals(rejouer));
        System.out.println("FIN");
    }
    
    public static void choixUtilisateur(){
    
    
    }

}

//while (!"N".equals(rejouer));
