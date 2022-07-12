package model;

import javax.swing.*;

public class ProgressBar extends JPanel {

    JProgressBar progress;

    public void ProgressBarTest()
    {
        // Créer le progressBar
        progress = new JProgressBar(0,1000);
//        // Définir la position du progressBar
//        progress.setBounds(35,40,165,30);
        // Initialiser le progressBar à 0
        progress.setValue(0);
        // Afficher la chaîne de progression
        progress.setStringPainted(true);
        // Ajouter le progressBar au frame
        add(progress);
        setSize(250,150);
//        setLayout(null);
    }

    // fonction pour augmenter le progressBar
    public void loop()
    {
        int i=0;
        while(i <= 1000)
        {
            // remplit la barre
            progress.setValue(i);
            i = i + 10;
            try
            {
                // retarder le thread
                Thread.sleep(120);
            }
            catch(Exception ignored){}
        }
    }
}
