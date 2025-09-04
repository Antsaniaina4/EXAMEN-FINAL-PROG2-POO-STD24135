package Frais_de_scolarite;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private Instant dateEntree;
    private List<Groupe> historiqueGroupes;

    public Etudiant(int id, String nom, String prenom, Instant dateEntree) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.historiqueGroupes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Instant getDateEntree() {
        return dateEntree;
    }

    public List<Groupe> getHistoriqueGroupes() {
        return historiqueGroupes;
    }

    public void ajouterGroupe(Groupe groupe) {
        this.historiqueGroupes.add(groupe);
    }
}

