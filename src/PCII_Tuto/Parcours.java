package PCII_Tuto;

import java.awt.*;
import java.util.*;

public class Parcours {
    //Definition de l'ArrayList contenant les points qui serviront à initialiser la ligne brisee
    public static ArrayList<Point> point = new ArrayList<Point>();
    //Generation du random
    public static final Random rand = new Random();
    //Definition de la position qui corespond au score du joueur
    public static int POSITION;
    /** Constante : Vitesse de la ligne **/
    public static int SPEED = 5;

    /**
     * Constructeur de la classe Parcours
     */
    public Parcours() {
        InitPoint();
        POSITION = 2;
    }

    /**
     * Permet de creer un point avec un x dependant
     * du x precedent et un y random dans les bornes voulues
     * @param oldX abcisse du point precedent
     * @return un point
     */
    public static Point creatPoint(int oldX) {
        int newX = oldX + 75 + rand.nextInt(15);
        int newY = rand.nextInt(Etat.HAUTEUR_MAX_CADRE - Etat.HAUTEUR_MIN_CADRE) + Etat.HAUTEUR_MIN_CADRE;

        return new Point( newX, newY);
    }

    /**
     * Getter qui renvoie la un tableau contenant tous les points du
     * Parcours actuel et met a jour le tableau de points
     * @return Un tableau de points
     */
    public Point[] getPoints() {
        Point[] point2 = new Point[point.size()];
        //On parcours point, si l'abcisse du point - la SPEED est inferieur a la
        //taille du cadre on le supprime et on en rajoute un autre
        for(int i = 0; i < point.size(); i++) {
            if ((point.get(i).x - SPEED) < Etat.LARGEUR_MIN_CADRE) {
                point.remove(point.get(i));
                //cree un point par rapport au dernier point de point
                Point p2 = creatPoint(point.get(point.size() - 1).x);
                point.add(p2);
             }
        }
        //Rempli le tableau de point initialise plus haut que l'on va return
        for (int i = 0; i < point.size(); i++) {
            point2[i] = point.get(i);
        }
        return point2;
    }

    /**
     * Fonction qui initialise l'ArrayList de points qui serviront a faire la ligne brisee
     */
    public void InitPoint() {
        //On cree manuellement le premier point de point
        //afin qu'il soit dans le centre de notre ovale
        int x = Affichage.getCentreXOvale();
        int y = Etat.HAUTEUR + Affichage.getHauteurOvale()/2;
        Point p = new Point(x,y);
        point.add(p);

        //On cree des points et on les rajoute dans point
        //la seule condition est que x ne depasse pas le cadre
        while (x <= Etat.LARGEUR_MAX_CADRE) {
            x += 50 + rand.nextInt(15);
            y = rand.nextInt(Etat.HAUTEUR_MAX_CADRE - Etat.HAUTEUR_MIN_CADRE) + Etat.HAUTEUR_MIN_CADRE;
            Point p2 = new Point(x, y);
            point.add(p2);
        }
    }

    /**
     * Getter qui renvoie la POSITION de l'oval dans le parcours
     * @return La position
     */
    public int getScore() {
        return POSITION;
    }

    /**
     * Setter qui augmente la POSITION de 2 et qui fait
     * avancer les points de point de SPEED
     */
    public static void setPosition() {
        POSITION += 2;
        //Pour chaque points de point on lui ajoute SPEED
        for( Point p : point) {
            p.x -= SPEED;
        }

    }

}
