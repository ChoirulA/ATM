/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelompok7;

/**
 *
 * @author ASUS
 */
public class Transfer implements java.io.Serializable{
    String bankPngrm, nmPngrm, bankPnrma, nmPnrma;
    int nom;
    
    Transfer(){}
    
    Transfer(String bankPngrm, String nmPngrm, 
            String bankPnrma, String namaPenerima){
        this.bankPngrm = bankPngrm;
        this.nmPngrm = nmPngrm;
        this.bankPnrma = bankPnrma;
        this.nmPnrma = nmPnrma;
        this.nom = nom;
    }

    public String getBankPngrm() {
        return bankPngrm;
    }

    public void setBankPngrm(String bankPngrm) {
        this.bankPngrm = bankPngrm;
    }

    public String getNmPngrm() {
        return nmPngrm;
    }

    public void setNmPngrm(String nmPngrm) {
        this.nmPngrm = nmPngrm;
    }

    public String getBankPnrma() {
        return bankPnrma;
    }

    public void setBankPnrma(String bankPnrma) {
        this.bankPnrma = bankPnrma;
    }

    public String getNmPnrma() {
        return nmPnrma;
    }

    public void setNmPnrma(String nmPnrma) {
        this.nmPnrma = nmPnrma;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }
}
