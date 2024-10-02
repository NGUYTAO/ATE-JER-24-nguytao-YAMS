import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * Fontion permettant d'afficher les dés
     * @param tableauDes tableau de int contenant les résultats des dés
     */
    public static void afficherDes(int[] tableauDes) {
        for (int compteur = 0; compteur < tableauDes.length; compteur++) {
            System.out.println(tableauDes[compteur]);
        }
    }

    /**
     * Fonction permettant de calculer le total des 5 dés
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return le total des 5 dés
     */
    public static int totalDes(int[] tableauDes) {
        int total = 0;
        for (int compteur = 0; compteur < tableauDes.length; compteur++) {
            total += tableauDes[compteur];
        }
        return total;
    }

     /**
     * Fonction permettant de demander quel dé l'utilisateur veut relancer
     * @return Un tableau de string contenant les dés saisi par l'utilisateur
     */
    public static String[] demandeRelanceXDes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choisissez les dés que vous voulez relancer, séparez les par un espace : ");

        return scanner.nextLine().split(" ");
    }

    /**
     * Fonction permettant de demander si l'utilisateur veut relancer
     * les dés et quels dés veut t'il relancer
     * @param tableauDes tableau de int contenant les résultats des dés
     */
    public static void relancerLesDes(int[] tableauDes, MainDes mainDes) {
        Scanner scanner = new Scanner(System.in);
        String reponse;

            for (int compteur = 0; compteur < 2; compteur++) {

                System.out.println("Veut-tu relancer les dés ? (oui ou non)");
                reponse = scanner.nextLine();

                if (reponse.equals("oui")) {
                    for (String element : demandeRelanceXDes()) {
                        tableauDes[Integer.parseInt(element) - 1] = mainDes.lancerDes();
                    }

                    afficherDes(tableauDes);
                    System.out.println("Total des dés : " + totalDes(tableauDes));
                } else if (reponse.equals("non")) {
                    afficherDes(tableauDes);
                    System.out.println("Total des dés : " + totalDes(tableauDes));

                    break;
                }
            }
    }

    public static void main(String[] args) {
        MainDes mainDes = new MainDes();
        boolean[] tableauCombinaison = new boolean[7];
        int totalPoint = 0;

        for (int compteur2 = 0; compteur2 < 5; compteur2++) {
            System.out.println("MANCHE " + (compteur2 + 1));

            int[] tableauDes = mainDes.lancer5Des();

            afficherDes(tableauDes);
            System.out.println("Total des dés : " + totalDes(tableauDes));

            relancerLesDes(tableauDes, mainDes);
            totalPoint += combinaisonResultat(tableauCombinaison, tableauDes);
            System.out.println("Total points : " + totalPoint);
        }
    }
}