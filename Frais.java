package Frais_de_scolarite;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Frais  {
    private int id;
    private String label;
    private double montant;
    private Instant deadline;
    private Etudiant etudiant;
    private List<Payement> payement;

    public Frais(int id, String label, double montant, Instant deadline, Etudiant etudiant) {
        this.id = id;
        this.label = label;
        this.montant = montant;
        this.deadline = deadline;
        this.etudiant = etudiant;
        this.payement = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public double getMontant() {
        return montant;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public List<Payement> getPayement() {
        return payement;
    }

    public void ajouterPayement(Payement payement) {
        this.payement.add(payement);
    }

    public StatFrais getStatut(Instant maintenant) {
        double total = 0;
        for (Payement p : payement) {
            if (p.getDateHeure().isBefore(maintenant) || p.getDateHeure().equals(maintenant)) {
                total += p.getMontant();
            }
        }
        if (total == 0) {
            return StatFrais.NUL;
        } else if (total == montant) {
            return StatFrais.PAID;
        } else if (total > montant) {
            return StatFrais.OVERPAID;
        } else if (maintenant.isBefore(deadline)) {
            return StatFrais.IN_PROGRESS;
        } else {
            return StatFrais.LATE;
        }
    }
}

