package PCII_Tuto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
        //Initialise un Etat
        public static Etat etat;
        //Initialise un Affichage
        public static Affichage affichage;

        public Control (Etat etat, Affichage affichage) {
            this.etat = etat;
            this.affichage = affichage;
        }



        /**
         * Quand un click est fait dans la fenetre, on fait sauter l'oval et on repaint l'affichage
         * @param e un MouseEvent, ici un click de souris
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            etat.jump();
            affichage.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
}


