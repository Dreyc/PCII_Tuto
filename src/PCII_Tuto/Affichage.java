package PCII_Tuto;

import javax.swing.*;
import java.awt.*;

/**
 * Classe d'affichage, sert à dessiner la fenetre ainsi que ce qui s'y trouve
 */
public class Affichage extends JPanel {

    //Definition de l'etat que nous allons utiliser
    public static Etat etat;

    //Dimensions utilisees pour la fenetre
    public static final int width = 600;
    public static final int height = 400;

    //Dimensions Ovale
    public static int largeur = 20;
    public static int hauteur = 30;
    public static int centreX = 50;

    /**
     * Initialise un affichage, cree une fenetre ainsi que tous ses parametres et cree le MouseListener
     * @param e un etat
     */
    public Affichage( Etat e) {

        this.etat = e;
        //Initialisation d'un nouveau JFrame
        JFrame test = new JFrame("Test Dessin");
        //Initialise la valeur par defaut du JFrame a EXIT_ON_CLOSE
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Defini la taille de notre fenetre
        setPreferredSize(new Dimension(width, height));
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
        //Nettoie l'affichage
        super.paint(g);
        //Dessine l'ovale
        g.drawOval(centreX, etat.get_hauteur(), largeur, hauteur);
    }

}
