package PCII_Tuto;

/**
 * Classe d'etat, gere toutes les actions que l'ovale doit faire ainsi que toutes les informations concernant
 * sa position
 */
public class Etat {
    //Hauteur ou est dessine l'ovale dans la fenetre
    public static int hauteur = 350;
    //Taille du saut qu'effectue l'ovale a chaque click
    public static int jump_height = 10;

    /**
     * Fait sauter l'ovale d'une hauteur definie
     */
    public void jump() {
        if ( hauteur > 0) {
            hauteur -= jump_height;
        }
    }

    /**
     * getter de la hauteur
     * @return la hauteur de l'ovale
     */
    public int get_hauteur() {
        return this.hauteur;
    }
}
