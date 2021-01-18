package Main;


public class Main {

    public static void main( String[] agrs) {
        //Cree un nouvel etat
        Etat etat = new Etat();
        //Cree un nouvel affichage a partir de l'etat cree avant
        Affichage affichage = new Affichage( etat);
    }
}
