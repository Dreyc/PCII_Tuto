package PCII_Tuto;

public class Avancer extends Thread {
    //initialisation d'un parcours
    public Parcours parcours;
    //Initialisation d'un etat
    public Etat etat;

    public Avancer(Parcours parcours, Etat etat) {
        this.parcours = parcours;
        this.etat = etat;
    }

    @Override
    public void run() {
        //Try and Catch pour faire un lapse de temps avant
        //le debut du jeu
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(!etat.testPerdu()) {
            Parcours.setPosition();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
