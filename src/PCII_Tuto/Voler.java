package PCII_Tuto;

public class Voler extends Thread {

    public static Etat etat;

    public Voler( Etat etat) {
        this.etat = etat;
    }
    @Override
    public void run() {
      while (true) {
          etat.moveDown();
          try {
              Thread.sleep(100);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    }
}
