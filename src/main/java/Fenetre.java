import model.Balle;
import model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Fenetre extends Canvas {
    //Propriétés
    //Dimensions de la fenetre
    private int largeur;
    private int hauteur;

    public Fenetre(int largeur, int hauteur) {

        this.largeur = largeur;
        this.hauteur = hauteur;

        //fenetre principale
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(largeur, hauteur));
        setBounds(0, 0, largeur, hauteur);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);
        this.demarrer();

    }


    public void demarrer() {
        //on démarre le jeu
        int largeurBalle = 50;
        int hauteurBalle = 50;
        int i = 0;
        int vitesseHorizontal = 4;
        int vitesseVertical = 1;
        int x = 0;
        int y = 0;
        int y_rectangle = hauteur - 50;

        Balle[] tableauBalle = new Balle[5];

        for(int j = 0; j < 5; j++){
            tableauBalle[j] = new Balle(
                    (int)(Math.random() * largeur),
                    (int)(Math.random() * hauteur),
                    (int)(Math.random() + 4 + 1),
                    (int)(Math.random() + 4 + 1),
                    new Color(
                            (int)(Math.random() * 255),
                            (int)(Math.random() * 255),
                            (int)(Math.random() * 255)
                        )
                    );
        }

        //boucle infinie
        while (true) {


            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();
            Graphics2D dessin2 = (Graphics2D) getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0,largeur,hauteur);

            for(Balle balle: tableauBalle){
                System.out.println(balle);
                balle.dessiner(dessin);
                balle.mouvement(largeur, hauteur, largeurBalle, hauteurBalle);
            }

            Rectangle rect = new Rectangle(20, 50, 50);
            rect.dessiner(dessin2);
            dessin.dispose();


            getBufferStrategy().show();
            System.out.println("x = " + x);
            System.out.println("y = " + y);



//            KeyListener keylisten = new KeyListener() {
//                @Override
//                public void keyTyped(KeyEvent e) {
//
//                }
//
//                @Override
//                public void keyPressed(KeyEvent e) {
//                    int keyCode = e.getKeyCode();
//                    switch (keyCode) {
//                        case KeyEvent.VK_LEFT -> y_rectangle += -2;
//                        case KeyEvent.VK_RIGHT -> y_rectangle += 2;
//                    }
//                }
//
//                @Override
//                public void keyReleased(KeyEvent e) {
//
//                }
//            };
            //pause de quelques milisecondes afin de n'effectuer que 60 raffraichissements par seconde
            try {
                Thread.sleep(1000 / 60);
            } catch (Exception ignored) {
            }
        }
    }
}