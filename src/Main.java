import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int NOMBRE_FACE = 6;
    private static final int NOMBRE_DES = 5;
    private static final int POINT_YAMS = 50;
    private static final int POINT_FULL = 25;
    private static final int POINT_GRANDE_SUITE = 40;
    private static final int POINT_PETITE_SUITE = 30;

    /**
     * Fonction permettant de lancer un dé
     * @return La face visible du dé
     */
    public static int lancerDes() {
        return (int) (Math.random() * NOMBRE_FACE + 1);
    }

    /**
     * Fonction permettant de relancer 5 dés
     * @return un tableau de int contenant les valeurs des dés
     */
    public static int[] lancer5Des() {
        int[] tableauDes = new int[NOMBRE_DES];

        for (int compteur = 0; compteur < NOMBRE_DES; compteur++) {
            tableauDes[compteur] = lancerDes();
        }
        return tableauDes;
    }

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
     * Fonction permettant de connaître le nombre de dés identiques
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return le nombre de dés identiques
     */
    public static int trouveDesIdentique(int[] tableauDes) {

        int nbreDesIdentique = 0;

        for (int compteur = 0; compteur < tableauDes.length; compteur++) {
            for (int compteur2 = compteur + 1; compteur2 < tableauDes.length; compteur2++) {
                if (tableauDes[compteur] == tableauDes[compteur2]) {
                    nbreDesIdentique ++;
                }
            }
        }
        return nbreDesIdentique;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un brelan
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return le nombre de dés identiques
     */
    public static boolean estBrelan(int[] tableauDes) {
        return trouveDesIdentique(tableauDes) >= 3;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un carré
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return le nombre de dés identiques
     */
    public static boolean estCarre(int[] tableauDes) {
        return trouveDesIdentique(tableauDes) >= 5;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un full
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return le nombre de dés identiques
     */
    public static boolean estFull(int[] tableauDes) {
        return trouveDesIdentique(tableauDes) >= 4;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un yams
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return le nombre de dés identiques
     */
    public static boolean estYams(int[] tableauDes) {
        return tableauDes[0] == tableauDes[1]
                && tableauDes[0] == tableauDes[2]
                && tableauDes[0] == tableauDes[3]
                && tableauDes[0] == tableauDes[4];
    }

    /**
     * Fonction permettant de reconnaître une petite suite
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return la possibilité de grande suite
     */
    public static boolean estGrandeSuite(int[] tableauDes) {

        Arrays.sort(tableauDes);

        return tableauDes[0] + 1 == tableauDes[1] &&
               tableauDes[1] + 1 == tableauDes[2] &&
               tableauDes[2] + 1 == tableauDes[3] &&
               tableauDes[3] + 1 == tableauDes[4];
    }

    /**
     * Fonction permettant de reconnaître une petite suite
     * @param tableauDes tableau de int contenant les résultats des dés
     * @return les possibilités de petite suite
     */
    public static boolean estPetiteSuite(int[] tableauDes) {

        Arrays.sort(tableauDes);

        return (tableauDes[0] + 1 == tableauDes[1] &&
                tableauDes[1] + 1 == tableauDes[2] &&
                tableauDes[2] + 1 == tableauDes[3]) ||

               (tableauDes[1] + 1 == tableauDes[2] &&
                tableauDes[2] + 1 == tableauDes[3] &&
                tableauDes[3] + 1 == tableauDes[4]) ||

               (tableauDes[0] + 1 == tableauDes[1] &&
                 tableauDes[1]  == tableauDes[2] &&
                 tableauDes[2] + 1 == tableauDes[3] &&
                 tableauDes[3] + 1 == tableauDes[4]) ||

                (tableauDes[0] + 1 == tableauDes[1] &&
                 tableauDes[1] + 1 == tableauDes[2] &&
                 tableauDes[2] == tableauDes[3] &&
                 tableauDes[3] + 1 == tableauDes[4]);
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
    public static void relancerLesDes(int[] tableauDes) {
        Scanner scanner = new Scanner(System.in);
        String reponse;

            for (int compteur = 0; compteur < 2; compteur++) {

                System.out.println("Veut-tu relancer les dés ? (oui ou non)");
                reponse = scanner.nextLine();

                if (reponse.equals("oui")) {
                    for (String element : demandeRelanceXDes()) {
                        tableauDes[Integer.parseInt(element) - 1] = lancerDes();
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

    /**
     * Fonction permettant de savoir la combinaison
     * @param tableauCombinaison tableau de bool
     * @param tableauDes tableau de int contenant les résultats des dés
     */
    public static int combinaisonResultat(boolean[] tableauCombinaison, int[] tableauDes) {

        int total = 0;

        if (estYams(tableauDes) && !tableauCombinaison[0]) {
            System.out.println("YAMS");
            System.out.println("Point : " + POINT_YAMS);
            total += POINT_YAMS;
            tableauCombinaison[0] = true;
        }
        else if (estFull(tableauDes) && !tableauCombinaison[1]) {
            System.out.println("FULL");
            System.out.println("Point : " + POINT_FULL);
            total += POINT_FULL;
            tableauCombinaison[1] = true;
        }
        else if (estCarre(tableauDes) && !tableauCombinaison[2]) {
            Arrays.sort(tableauDes);
            System.out.println("CARRE");
            System.out.println("Point : " + (4 * tableauDes[2]));
            total += (4 * tableauDes[2]);
            tableauCombinaison[2] = true;
        }
        else if (estBrelan(tableauDes) && !tableauCombinaison[3]) {
            Arrays.sort(tableauDes);
            System.out.println("BRELAN");
            System.out.println("Point : " + (3 * tableauDes[2]));
            total += (3 * tableauDes[2]);
            tableauCombinaison[3] = true;
        }
        else if (estGrandeSuite(tableauDes) && !tableauCombinaison[4]) {
            System.out.println("GRANDE SUITE");
            System.out.println("Point : " + POINT_GRANDE_SUITE);
            total += POINT_GRANDE_SUITE;
            tableauCombinaison[4] = true;
        }
        else if (estPetiteSuite(tableauDes) && !tableauCombinaison[5]) {
            System.out.println("PETITE SUITE");
            System.out.println("Point : " + POINT_PETITE_SUITE);
            total += POINT_PETITE_SUITE;
            tableauCombinaison[5] = true;
        }
        else if (!tableauCombinaison[6]) {
            System.out.println("CHANCE");
            System.out.println("Point : " + totalDes(tableauDes));
            total += totalDes(tableauDes);
            tableauCombinaison[6] = true;
        }
        else {
            System.out.println("Vous avez déjà eu cette combinaison !");
            total = 0;
        }
        return total;
    }

    public static void main(String[] args) {

        boolean[] tableauCombinaison = new boolean[7];
        int totalPoint = 0;

        for (int compteur2 = 0; compteur2 < 5; compteur2++) {
            System.out.println("MANCHE " + (compteur2 + 1));

            int[] tableauDes = lancer5Des();

            afficherDes(tableauDes);
            System.out.println("Total des dés : " + totalDes(tableauDes));

            relancerLesDes(tableauDes);
            totalPoint += combinaisonResultat(tableauCombinaison, tableauDes);
            System.out.println("Total points : " + totalPoint);
        }dscxregvtrgefc
    }
}