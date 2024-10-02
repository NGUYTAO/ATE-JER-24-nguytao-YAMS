public class MainDes {
    private int nbreFace = 6;
    private int nbreDes = 5;

    private int[] tableauFaceVisible = new int[nbreDes];

    public MainDes() {}

    public int getNbreFace() {
        return nbreFace;
    }

    public int getNbreDes() {
        return nbreDes;
    }

    public int[] getTableauFaceVisible() {
        return tableauFaceVisible;
    }

    /**
     * Fonction permettant de lancer 1 dé
     * @return un lancer de dé
     */
    public int lancerDes() {
        return (int) (Math.random() * nbreFace + 1);
    }

    /**
     * Fonction permettant de relancer 5 dés
     * @return un tableau de int contenant les valeurs des dés
     */
    public int[] lancer5Des() {
        int[] tableauDes = new int[nbreDes];

        for (int compteur = 0; compteur < nbreDes; compteur++) {
            tableauDes[compteur] = lancerDes();
        }
        tableauFaceVisible = tableauDes;
        return tableauFaceVisible;
    }
}
