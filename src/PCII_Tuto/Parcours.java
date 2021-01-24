package PCII_Tuto;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

public class Parcours {

    public static ArrayList<Point> point = new ArrayList<Point>();

    public static final Random rand = new Random();

    public final int SPEED = 5;

    public int position;

    public Parcours() {
        InitPoint();
        position = 0;
    }

    public void InitPoint() {

        int x = 0, y = (Etat.HAUTEUR_MAX_CADRE)/2;
        Point p = new Point(x,y);
        point.add(p);
//        System.out.println(p.x + " " + p.y);

        while (x < Etat.LARGEUR_CADRE) {
            x += 50 + rand.nextInt(15);
            y = rand.nextInt(Etat.HAUTEUR_MAX_CADRE - Etat.HAUTEUR_MIN_CADRE) + Etat.HAUTEUR_MIN_CADRE;
            Point p2 = new Point(x, y);
            point.add(p2);
//            System.out.println(p2.x + " " + p2.y);
        }
    }

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

    public int getScore() {
        return this.position;
    }

    public void setPosition() {
        position += 2;
    }
}
