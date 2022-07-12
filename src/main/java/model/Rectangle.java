package model;

import java.awt.*;

public class Rectangle extends Sprite implements Dessinable {

    int hauteur;

    public Rectangle(int hauteur, int x, int y, Color couleur){
        super(x, y, 30, couleur);
        this.hauteur = hauteur;
    }

    public Rectangle(int hauteur, int x, int y){
        super(x, y, 30);
        this.hauteur = hauteur;
    }
    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.fillRect(this.x,  this.y, this.largeur, this.hauteur);
        dessin.setColor(this.couleur);
        dessin.setBackground(this.couleur);
    }
}
