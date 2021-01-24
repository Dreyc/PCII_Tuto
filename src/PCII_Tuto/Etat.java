package PCII_Tuto;

import java.awt.*;
import java.util.ArrayList;

/**
 * Classe d'etat, gere toutes les actions que l'ovale doit faire ainsi que toutes les informations concernant
 * sa position
 */
public class Etat {

    /** Constante : Defini un cadre que l'ovale ne devra pas depasser et qui sera utile pour la generation de la ligne **/
    public static final int HAUTEUR_MAX_CADRE = 340;

    public static final int HAUTEUR_MIN_CADRE = 60;

    /** Constante : Defini un cadre que l'ovale ne devra pas depasser et qui sera utile pour la generation de la ligne **/
    public static final int LARGEUR_CADRE = 630;

    /*** Constante : Hauteur du centre de l'ovale ***/
    public static int HAUTEUR = 320;
    /*** Constante : Taille du saut effectue par l'ovale***/
    public static int JUMP_HEIGHT = 30;

    /*** Constante : Hauteur de la chute de l'ovale ***/
    public static int DOWN = 3;

    public Parcours parcours;

    public Etat() {
        (new Voler(this)).start();
        this.parcours = new Parcours();

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
     * getter de la hauteur
     * @return la hauteur de l'ovale
     */
    public int get_hauteur() {
        return this.HAUTEUR;
    }

    public void moveDown() {
        if (HAUTEUR + DOWN <= HAUTEUR_MAX_CADRE) {
            HAUTEUR += DOWN;
        }
    }

    public Point[] getParcours() {
        return this.parcours.getParcours();
    }
}

