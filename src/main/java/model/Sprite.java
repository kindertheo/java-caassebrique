package model;

import java.awt.*;

public class Sprite{

    public int x;
    public int y;
    public int largeur;
    public Color couleur;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Sprite(int x, int y, int largeur, Color couleur){
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.couleur = couleur;
    }

    public Sprite(int x, int y, int largeur){
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.couleur = Color.BLACK;
    }
}
