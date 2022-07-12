package model;

public class User {

    public String prenom;
    public String nom;


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User(){
        System.out.println("Vous êtes dans le constructeur");
    }
}
