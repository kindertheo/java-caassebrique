package model;

import java.awt.*;
public class Balle extends Sprite implements Dessinable {

    private int vitesseVertical;
    private int vitesseHorizontal;
    private Color couleur;

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    private int hauteur = 30;

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int largeur = 30;

    public Balle(int x, int y, int vitesseVertical, int vitesseHorizontal, Color couleur) {
        super(x, y, 30, couleur);
        this.vitesseVertical = vitesseVertical;
        this.vitesseHorizontal = vitesseHorizontal;
//        this.couleur = couleur;
    }

    public Balle(int x, int y, int vitesseVertical, int vitesseHorizontal) {
        super(x, y, 30);
        this.vitesseVertical = vitesseVertical;
        this.vitesseHorizontal = vitesseHorizontal;
        this.couleur = Color.RED;
    }

    @Override
    public void dessiner(Graphics2D dessin){
        dessin.setColor(this.getCouleur());
        dessin.fillOval(this.getX(), this.getY(), this.getHauteur(), this.getLargeur());
    }

    public void mouvement(int largeur, int hauteur, int largeurBalle, int hauteurBalle){
        this.collision(largeur, hauteur, largeurBalle, hauteurBalle);
        this.x += this.vitesseHorizontal;
        this.y += this.vitesseVertical;
        System.out.println(this.x);
        System.out.println(this.y);
    }

    public void collision(int largeur,int hauteur,int largeurBalle,int hauteurBalle){
        if(x > (largeur - largeurBalle) || x < 0) {
            vitesseHorizontal *= -1;
        }

        if(y > (hauteur - hauteurBalle) || y < 0){
            vitesseVertical *= -1;
        }
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }
}