package PCII_Tuto;

import javax.swing.*;
import java.awt.*;

/**
 * Classe d'affichage, sert à dessiner la fenetre ainsi que ce qui s'y trouve
 */
public class Affichage extends JPanel {

    //Definition de l'etat que nous allons utiliser
    public static Etat etat;

    /*** Constante : Largeur de la fenetre ***/
    public static final int WIDTH_WINDOW = 600;
    /*** Constante : Hauteur de la fenetre ***/
    public static final int HEIGHT_WINDOW = 400;

    /*** Constante : Largeur de l'ovale ***/
    public static int LARGEUR_OVALE = 20;
    /*** Constante : Hauteur de l'ovale ***/
    public static int HAUTEUR_OVALE = 60;
    /*** Constante : Coordonnée X du centre de l'ovale ***/
    public static int CENTRE_X_OVALE = 50;

    /**
     * Initialise un affichage, cree une fenetre ainsi que tous ses parametres et cree le MouseListener
     * @param e un etat
     */
    public Affichage( Etat e) {
        (new Affichage2(this)).start();
        this.etat = e;
        //Initialisation d'un nouveau JFrame
        JFrame test = new JFrame("Test Dessin");
        //Initialise la valeur par defaut du JFrame a EXIT_ON_CLOSE
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Defini la taille de notre fenetre
        setPreferredSize(new Dimension(WIDTH_WINDOW, HEIGHT_WINDOW));
        //Ajoute un composant au JFrame, ici l'etat
        test.add( this);
        //Initialise le MouseListener
        test.addMouseListener(new Control(this.etat, this));
        //Met toutes les frames a la bonne taille
        test.pack();
        //Rend visible le JFrame
        test.setVisible(true);
    }

    /**
     * Dessine l'ovale dans la fenetre et nettoie l'affichage avant de le dessiner
     * @param g un graphic
     */
    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH_WINDOW, HEIGHT_WINDOW);
        //Nettoie l'affichage
        super.paint(g);
        //Dessine l'ovale
        g.drawOval(CENTRE_X_OVALE, etat.get_hauteur(), LARGEUR_OVALE, HAUTEUR_OVALE);

        Point[] point = etat.getParcours();
        System.out.println(point[0].x);
        for (int i = 1; i < point.length; i++) {
            Point previous_point = point[i-1];
            Point current_point = point[i];
            g.drawLine(previous_point.x, previous_point.y, current_point.x, current_point.y);
        }

    }

}
