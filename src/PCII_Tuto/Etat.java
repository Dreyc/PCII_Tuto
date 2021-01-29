package PCII_Tuto;

import java.awt.*;
import java.util.ArrayList;

public class Etat {
    /** Constante : Defini un cadre que l'ovale ne devra pas depasser et qui sera utile pour la generation de la ligne **/
    public static final int HAUTEUR_MAX_CADRE = 280;
    /** Constante : Defini un cadre que l'ovale ne devra pas depasser et qui sera utile pour la generation de la ligne **/
    public static final int HAUTEUR_MIN_CADRE = 120;
    /** Constante : Defini un cadre que l'ovale ne devra pas depasser et qui sera utile pour la generation de la ligne **/
    public static final int LARGEUR_MAX_CADRE = 630;
    /** Contante : Defini un cadre que l'ovale ne devra pas depasser et qui sera utile pour la generation de la ligne **/
    public static final int LARGEUR_MIN_CADRE = -100;
    /** Constante : Hauteur du centre de l'ovale **/
    public static int HAUTEUR = HAUTEUR_MAX_CADRE/2;
    /** Constante : Taille du saut effectue par l'ovale**/
    public static int JUMP_HEIGHT = Affichage.getHauteurOvale()/2;

    /** Constante : Hauteur de la chute de l'ovale **/
    public static int DOWN = Affichage.getHauteurOvale()/10;

    //Initialise le Parcours
    public Parcours parcours;

    /**
     * Constructeur de la Classe Etat
     */
    public Etat() {
        //Initialise le Thread de la classe Voler
        (new Voler(this)).start();
        this.parcours = new Parcours();
        (new Avancer(this.parcours, this)).start();;

    }

    /**
     * Renvoie true si l'ovale entre en collision
     * avec la ligne
     * @return un boolean
     */
    public boolean testPerdu() {

        ArrayList<Point> point2 = Parcours.point;
        //Variable qui correspond a l'abcisse de notre ovale
        int centre = Affichage.getCentreXOvale();
        //2 points qui vont nous servir pour calculer l'equation de la droite
        Point previousPoint = new Point();
        Point nextPoint = new Point();

        //On cherche les deux points qui encadre notre ovale afin
        //de determiner par la suite l'equation de la droite formee
        //par ces deux point
        for(int i = 1; i < point2.size(); i++) {
            if(point2.get(i).x > centre) {
                previousPoint = point2.get(i-1);
                nextPoint = point2.get(i);
                break;
            }
        }

        //Coefficient directeur de la droite
        float a = (float) ((nextPoint.y - previousPoint.y)/(nextPoint.x - previousPoint.x));
        //Ordonnee a l'origine de la droite
        float b = (previousPoint.y - a * previousPoint.x);
        //Ordonnee du point appartenant a la droite d'abcisse X
        int y = (int) (a * centre + b);
        //On cree ce fameux point (pas oblige mais plus parlant)
        Point currentPoint = new Point(centre, y);
        //On compare les y des points le point l eplus haut de l'ovale, le plu sbas et le currentPoint
        return (get_hauteur() > currentPoint.y) ^ ((get_hauteur() + Affichage.getHauteurOvale()) < currentPoint.y);
    }

    /**
     * Fait sauter l'ovale d'une hauteur definie
     */
    public void jump() {
        if ( HAUTEUR > 0) {
            HAUTEUR -= JUMP_HEIGHT;
        }
    }

    /**
     * getter de la HAUTEUR
     * @return la hauteur de l'ovale
     */
    public int get_hauteur() {
        return HAUTEUR;
    }

    /**
     * Fonction qui augmente de DOWN la HAUTEUR afin de simuler une chute de l'ovale
     */
    public void moveDown() {
        if (HAUTEUR + DOWN <= HAUTEUR_MAX_CADRE) {
            HAUTEUR += DOWN;
        }
    }

    /**
     * Getter qui revoie le tableau de points qui constituent le parcours
     * @return Un tableau de Point
     */
    public Point[] getParcours() {
        return this.parcours.getPoints();
    }

}

