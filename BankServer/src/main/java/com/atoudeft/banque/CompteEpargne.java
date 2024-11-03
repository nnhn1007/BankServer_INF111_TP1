package com.atoudeft.banque;

public class CompteEpargne extends CompteBancaire {
    private final int ZERO = 0;
    private final double tauxInteret; //En pourcentage !
    private final double LIMITE = 1000.00;
    private final double FRAIS = 2.00;

    /**
     * Fait par Nancy Nguyen
     * Crée un compte épargne.
     *
     * @param numero numéro du compte
     * @param type   type du compte
     */
    public CompteEpargne(String numero, TypeCompte type, double tauxInteret) {
        super(numero, type);
        this.tauxInteret = tauxInteret;
    }

    /**
     * Fait par Nancy Nguyen
     * Ajoute le montant au solde s'il est strictement positif
     *
     * @param montant Montant à créditer au solde
     * @return true, si le montant est positif
     * false, si le montant est négatif
     */
    @Override
    public boolean crediter(double montant) {
        if (montant > ZERO) { //Strictement positif
            setSolde(getSolde() + montant);
            return true;
        }

        return false;
    }

    /**
     * Fait par Nancy Nguyen et Mathis Odjo'o Ada
     * Débite le montant du solde s'il est positif, et s'il y a assez de fonds au solde
     *
     * @param montant Montant à retirer
     * @return True si le solde initial était strictement positif et qu'il
     * est plus grand ou égal au montant à retirer, sinon retourne false.
     */
    @Override
    public boolean debiter(double montant) { // À tester
        double soldeInitial = getSolde();
        if (montant > ZERO && getSolde() >= montant) {
            setSolde(getSolde() - montant); //Débite le montant du solde
            if (soldeInitial < LIMITE) {
                setSolde(getSolde() - FRAIS); //Débite les frais si getSolde()<1000
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean payerFacture(String numeroFacture, double montant, String description) {
        return false;
    }

    @Override
    public boolean transferer(double montant, String numeroCompteDestinataire) {
        return false;
    }

    /**
     * Fait par Nancy Nguyen
     * Calcule les intérêts et les ajoute au solde
     */
    public void ajouterInterets() {
        double interets = getSolde() * tauxInteret;
        setSolde(getSolde() + interets);
    }
}