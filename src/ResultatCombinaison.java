import java.util.Arrays;

public class ResultatCombinaison {

    private static final int POINT_YAMS = 50;
    private static final int POINT_FULL = 25;
    private static final int POINT_GRANDE_SUITE = 40;
    private static final int POINT_PETITE_SUITE = 30;
    private static final int NBRE_COMBINAISON = 7;

    private MainDes mainDes = new MainDes();

    private CombinaisonDes combinaisonDes = new CombinaisonDes(mainDes);

    private boolean[] tableauCombinaison = new boolean[NBRE_COMBINAISON];

    public ResultatCombinaison(CombinaisonDes combinaisonDes, MainDes mainDes) {
        this.combinaisonDes = combinaisonDes;
        this.mainDes = mainDes;
    }

    /**
     * Fonction permettant de calculer le total des 5 dés
     * @return le total des 5 dés
     */
    public int totalDes() {
        int total = 0;
        for (int compteur = 0; compteur < mainDes.getTableauFaceVisible().length; compteur++) {
            total += mainDes.getTableauFaceVisible()[compteur];
        }
        return total;
    }

    public int combinaisonResultat() {

        int total = 0;

        if (combinaisonDes.estYams() && !tableauCombinaison[0]) {
            System.out.println("YAMS");
            System.out.println("Point : " + POINT_YAMS);
            total += POINT_YAMS;
            tableauCombinaison[0] = true;
        }
        else if (combinaisonDes.estFull() && !tableauCombinaison[1]) {
            System.out.println("FULL");
            System.out.println("Point : " + POINT_FULL);
            total += POINT_FULL;
            tableauCombinaison[1] = true;
        }
        else if (combinaisonDes.estCarre() && !tableauCombinaison[2]) {
            Arrays.sort(mainDes.getTableauFaceVisible());
            System.out.println("CARRE");
            System.out.println("Point : " + (4 * mainDes.getTableauFaceVisible()[2]));
            total += (4 * mainDes.getTableauFaceVisible()[2]);
            tableauCombinaison[2] = true;
        }
        else if (combinaisonDes.estBrelan() && !tableauCombinaison[3]) {
            Arrays.sort(mainDes.getTableauFaceVisible());
            System.out.println("BRELAN");
            System.out.println("Point : " + (3 * mainDes.getTableauFaceVisible()[2]));
            total += (3 * mainDes.getTableauFaceVisible()[2]);
            tableauCombinaison[3] = true;
        }
        else if (combinaisonDes.estGrandeSuite() && !tableauCombinaison[4]) {
            System.out.println("GRANDE SUITE");
            System.out.println("Point : " + POINT_GRANDE_SUITE);
            total += POINT_GRANDE_SUITE;
            tableauCombinaison[4] = true;
        }
        else if (combinaisonDes.estPetiteSuite() && !tableauCombinaison[5]) {
            System.out.println("PETITE SUITE");
            System.out.println("Point : " + POINT_PETITE_SUITE);
            total += POINT_PETITE_SUITE;
            tableauCombinaison[5] = true;
        }
        else if (!tableauCombinaison[6]) {
            System.out.println("CHANCE");
            System.out.println("Point : " + totalDes());
            total += totalDes();
            tableauCombinaison[6] = true;
        }
        else {
            System.out.println("Vous avez déjà eu cette combinaison !");
            total = 0;
        }
        return total;
    }
}
