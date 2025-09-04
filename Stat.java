package Frais_de_scolarite;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Stat {

    public static List<Frais> getFraisEnRetard(List<Frais> fraisList, Instant maintenant) {
        List<Frais> resultats = new ArrayList<>();
        for (Frais frais : fraisList) {
            if (frais.getStatut(maintenant) == StatFrais.LATE) {
                resultats.add(frais);
            }
        }
        return resultats;
    }

    public static double getMontantTotalFraisEnRetard(List<Frais> fraisList, Instant maintenant) {
        double total = 0;
        for (Frais frais : getFraisEnRetard(fraisList, maintenant)) {
            double paye = 0;
            for (Payement p : frais.getPayement()) {
                if (p.getDateHeure().isBefore(maintenant) || p.getDateHeure().equals(maintenant)) {
                    paye += p.getMontant();
                }
            }
            total += (frais.getMontant() - paye);
        }
        return total;
    }

    public static double getTotalPayeParEtudiant(Etudiant etudiant, List<Frais> fraisList, Instant maintenant) {
        double total = 0;
        for (Frais frais : fraisList) {
            if (frais.getEtudiant().equals(etudiant)) {
                for (Payement p : frais.getPayement()) {
                    if (p.getDateHeure().isBefore(maintenant) || p.getDateHeure().equals(maintenant)) {
                        total += p.getMontant();
                    }
                }
            }
        }
        return total;
    }
}


