import java.util.Arrays;

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