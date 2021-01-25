package PCII_Tuto;

public class Affichage2 extends Thread {
    //Initialise un affichage
    public static Affichage affichage;

    /**
     * Constructeur de la classe Affichage2
     * @param affichage
     */
    public Affichage2(Affichage affichage) {
        this.affichage = affichage;
    }

    /**
     * Fonction run() du Thread de la fonction Affichage2, repaint l'affichage à chaque appel du Thread
     */
    @Override
    public void run() {
      while (true) {
          affichage.revalidate();
          affichage.repaint();
          try {
              Thread.sleep(100);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    }
}
