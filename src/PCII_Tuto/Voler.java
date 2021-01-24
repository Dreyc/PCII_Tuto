package PCII_Tuto;

public class Voler extends Thread {

    //Initialisation d'un Etat
    public static Etat etat;

    /**
     * Constructeur de la classe Voler
     * @param etat un etat
     */
    public Voler( Etat etat) {
        this.etat = etat;
    }

    /**
     * Fonction run() du Thread de la classe Voler, Initialise en utilisant un Thread le mouvement vers le bas de l'oval de facon perpetuelle
     */
    @Override
    public void run() {
        //Boucle infinie pour faire en sorte que l'ovale descende tout le temps
         while (true) {
            etat.moveDown();
            //Try and catch pour faire en sorte que le cercle ne descende pas tout le temps
             try {
                 Thread.sleep(100);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
    }
}
