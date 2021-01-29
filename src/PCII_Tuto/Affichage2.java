package PCII_Tuto;

public class Affichage2 extends Thread {
    //Initialisation d'un affichage
    public Affichage affichage;
    //Initialisation d'un etat
    public Etat etat;

    /**
     * Constructeur de la classe Affichage2
     * @param affichage
     * @param etat
     */
    public Affichage2(Affichage affichage, Etat etat) {
        this.affichage = affichage;
        this.etat = etat;
    }

    /**
     * Fonction run() du Thread de la fonction Affichage2, repaint l'affichage à chaque appel du Thread
     */
    @Override
    public void run() {
        //Try and catch pour laisser un laspe de temps avant
        //le debut du jeu
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!etat.testPerdu()) {
            affichage.revalidate();
            affichage.repaint();
            try {
                  Thread.sleep(100);
            } catch (Exception e) {
                  e.printStackTrace();
            }
        }
        //Lorque le boucle while se fini
        //cela signifie qu'il y a une collision
        //On affiche la fenetre contextuelle de fin
        affichage.affichageFinPartie();
    }
}
