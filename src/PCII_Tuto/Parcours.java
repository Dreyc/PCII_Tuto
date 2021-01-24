package PCII_Tuto;

import java.awt.*;
import java.util.*;

public class Parcours {
    //Definition de l'ArrayList contenant les points qui serviront à initialiser la ligne brisee
    public static ArrayList<Point> point = new ArrayList<Point>();
    //Generation du random
    public static final Random rand = new Random();
    /** Constante : Vitesse a laquelle la ligne brisee avance **/
    public final int SPEED = 5;
    //Definition de la position qui corespond au score du joueur
    public int POSITION;

    /**
     * Constructeur de la classe Parcours
     */
    public Parcours() {
        InitPoint();
        POSITION = 0;
    }

    /**
     * Fonction qui initialise l'ArrayList de points qui serviront a faire la ligne brisee
     */
    public void InitPoint() {
        int x = 0, y = (Etat.HAUTEUR_MAX_CADRE)/2;
        Point p = new Point(x,y);
        point.add(p);

        while (x < Etat.LARGEUR_CADRE) {
            x += 50 + rand.nextInt(15);
            y = rand.nextInt(Etat.HAUTEUR_MAX_CADRE - Etat.HAUTEUR_MIN_CADRE) + Etat.HAUTEUR_MIN_CADRE;
            Point p2 = new Point(x, y);
            point.add(p2);
        }
    }

    /**
     * Getter qui renvoie la un tableau contenant tous les points du Parcours actuel en changeant les x pour faire avanacer la ligne
     * @return Un tableau de points
     */
    public Point[] getParcours() {
        Point[] point2 = new Point[this.point.size()];
        int i = 0;
        for(Point p : point){
            p.x -= SPEED;
            point2[i] = p;
            i = i + 1;
        }
        return point2;
    }

    /**
     * Getter qui renvoie la POSITION de l'oval dans le parcours
     * @return La position
     */
    public int getScore() {
        return this.POSITION;
    }

    /**
     * Setter qui augmente la POSITION de 2
     */
    public void setPosition() {
        POSITION += 2;
    }
}
