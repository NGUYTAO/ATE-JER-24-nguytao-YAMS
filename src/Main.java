import java.util.Scanner;

public class Main {
    private static final int nbreface = 6;
    private static final int nbrelancesmax = 3;

    /**
     * Fonction permettant de lancer un dé
     * @return La face visible du dé
     */
    public static int lancer() {
        return (int) (Math.random() * nbreface + 1);
    }

    /**
     * Fonction permettant de lancer 5 dés
     * @return La face visible des 5 dés
     */
    public static int[] lancerCinqDe() {
        int[] resultats = new int[5];

        for (int index = 0; index < 5; index++) {
            resultats[index] = lancer();
        }
        return resultats;
    }

    /**
     * Fonction qui calcule la somme des dés
     * @param resultats c'est un tableau de int
     * @return le total des dés
     */
    private static int totalDé(int[] resultats) {
        int total = 0;
        for (int somme : resultats) {
            total += somme;
        }
        return total;
    }

    /**
     * Fonction permettant de relancer X dés
     * @param resultats c'est un tableau de int
     */
    public static void relancerDes(int[] resultats) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez les numéros des dés à relancer (1-5) séparés par un espace : ");
        String[] numeros = scanner.nextLine().split(" ");

        for (int compteur = 0; compteur < numeros.length; compteur++) {
            int index = Integer.parseInt(numeros[compteur]) - 1;
            if (index >= 0 && index < resultats.length) {
                resultats[index] = lancer();
            }
        }
    }

    public static void main(String[] args) {
        int[] resultats = lancerCinqDe();
        int total = totalDé(resultats);
        int nbRelances = 0;

        Scanner scanner = new Scanner(System.in);

        while (nbRelances < nbrelancesmax) {
            System.out.println("Résultats des cinq dés : ");
            for (int index = 0; index < resultats.length; index++) {
                System.out.println("Dé " + (index + 1) + ": " + resultats[index]);
            }

            System.out.println("Souhaitez-vous relancer les dés? (o/n) ");
            String reponse = scanner.nextLine();

            if (reponse.equalsIgnoreCase("o")) {
                nbRelances++;
                relancerDes(resultats);
                total = totalDé(resultats);
            } else {
                break;
            }
        }
        System.out.println("Total des dés : " + total);
        System.out.println("Nombre de relances effectuées : " + nbRelances);
    }
}