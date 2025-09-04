package Frais_de_scolarite;

import java.time.Instant;

public class Payement {
    private int id;
    private double montant;
    private Instant dateHeure;

    public Payement(int id, double montant, Instant dateHeure) {
        this.id = id;
        this.montant = montant;
        this.dateHeure = dateHeure;
    }

    public int getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public Instant getDateHeure() {
        return dateHeure;
    }
}
