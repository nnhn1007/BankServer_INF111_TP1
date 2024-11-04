package com.atoudeft.banque.Operation;

import com.atoudeft.banque.TypeOperation;

public class OperationTransfer extends Operation{
    private double montantTransfer;
    private String numeroCompteDestinataire;
    /**
     *
     * @param montantTransfer
     * @param numeroCompteDestinataire
     */
    public OperationTransfer(double montantTransfer, String numeroCompteDestinataire) {
        super(TypeOperation.TRANSFER); // Je pense pcq on veut pas de TypeOperation dans le constructeur.
        this.montantTransfer=montantTransfer;
        this.numeroCompteDestinataire=numeroCompteDestinataire;
    }
}