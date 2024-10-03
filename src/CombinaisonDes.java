import java.util.Arrays;

public class CombinaisonDes {

    private MainDes mainDes = new MainDes();

    public CombinaisonDes(MainDes mainDes) {
        this.mainDes = mainDes;
    }

    /**
     * Fonction permettant de connaître le nombre de dés identiques
     * @return le nombre de dés identiques
     */
    public int trouveDesIdentique() {

        int nbreDesIdentique = 0;

        for (int compteur = 0; compteur < mainDes.getTableauFaceVisible().length; compteur++) {
            for (int compteur2 = compteur + 1; compteur2 < mainDes.getTableauFaceVisible().length; compteur2++) {
                if (mainDes.getTableauFaceVisible()[compteur] == mainDes.getTableauFaceVisible()[compteur2]) {
                    nbreDesIdentique ++;
                }
            }
        }
        return nbreDesIdentique;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un brelan
     * @return retourne les dés identique
     */
    public boolean estBrelan() {
        return trouveDesIdentique() >= 3;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un carré
     * @return le nombre de dés identiques
     */
    public boolean estCarre() {
        return trouveDesIdentique() >= 5;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un full
     * @return le nombre de dés identiques
     */
    public boolean estFull() {
        return trouveDesIdentique() >= 4;
    }

    /**
     * Fonction permettant de reconnaître s'il y a un yams
     * @return le nombre de dés identiques
     */
    public boolean estYams() {
        return mainDes.getTableauFaceVisible()[0] == mainDes.getTableauFaceVisible()[1]
                && mainDes.getTableauFaceVisible()[0] == mainDes.getTableauFaceVisible()[2]
                && mainDes.getTableauFaceVisible()[0] == mainDes.getTableauFaceVisible()[3]
                && mainDes.getTableauFaceVisible()[0] == mainDes.getTableauFaceVisible()[4];
    }

    /**
     * Fonction permettant de reconnaître une petite suite
     * @return la possibilité de grande suite
     */
    public boolean estGrandeSuite() {

        Arrays.sort(mainDes.getTableauFaceVisible());

        return mainDes.getTableauFaceVisible()[0] + 1 == mainDes.getTableauFaceVisible()[1] &&
                mainDes.getTableauFaceVisible()[1] + 1 == mainDes.getTableauFaceVisible()[2] &&
                mainDes.getTableauFaceVisible()[2] + 1 == mainDes.getTableauFaceVisible()[3] &&
                mainDes.getTableauFaceVisible()[3] + 1 == mainDes.getTableauFaceVisible()[4];
    }

    /**
     * Fonction permettant de reconnaître une petite suite
     * @return les possibilités de petite suite
     */
    public boolean estPetiteSuite() {

        Arrays.sort(mainDes.getTableauFaceVisible());

        return (mainDes.getTableauFaceVisible()[0] + 1 == mainDes.getTableauFaceVisible()[1] &&
                mainDes.getTableauFaceVisible()[1] + 1 == mainDes.getTableauFaceVisible()[2] &&
                mainDes.getTableauFaceVisible()[2] + 1 == mainDes.getTableauFaceVisible()[3]) ||

                (mainDes.getTableauFaceVisible()[1] + 1 == mainDes.getTableauFaceVisible()[2] &&
                        mainDes.getTableauFaceVisible()[2] + 1 == mainDes.getTableauFaceVisible()[3] &&
                        mainDes.getTableauFaceVisible()[3] + 1 == mainDes.getTableauFaceVisible()[4]) ||

                (mainDes.getTableauFaceVisible()[0] + 1 == mainDes.getTableauFaceVisible()[1] &&
                        mainDes.getTableauFaceVisible()[1]  == mainDes.getTableauFaceVisible()[2] &&
                        mainDes.getTableauFaceVisible()[2] + 1 == mainDes.getTableauFaceVisible()[3] &&
                        mainDes.getTableauFaceVisible()[3] + 1 == mainDes.getTableauFaceVisible()[4]) ||

                (mainDes.getTableauFaceVisible()[0] + 1 == mainDes.getTableauFaceVisible()[1] &&
                        mainDes.getTableauFaceVisible()[1] + 1 == mainDes.getTableauFaceVisible()[2] &&
                        mainDes.getTableauFaceVisible()[2] == mainDes.getTableauFaceVisible()[3] &&
                        mainDes.getTableauFaceVisible()[3] + 1 == mainDes.getTableauFaceVisible()[4]);
    }
}
