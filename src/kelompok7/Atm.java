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
public class Atm implements java.io.Serializable{
    String nmrRekening, nmNasabah, bank, pin;
    String histori;
    int saldo;
    
    Atm(){}
    
    Atm(String nmrRekening, String nmNasabah, String bank,
        String pin, int saldo){
        this.nmrRekening = nmrRekening;
        this.nmNasabah = nmNasabah;
        this.bank = bank;
        this.pin = pin;
        this.saldo = saldo;
    }
    
    Atm(String nmrRekening, String nmNasabah, String bank,
        String pin, int saldo, String histori){
        this.nmrRekening = nmrRekening;
        this.nmNasabah = nmNasabah;
        this.bank = bank;
        this.pin = pin;
        this.saldo = saldo;
        this.histori = histori;
    }

    public String getNmrRekening() {
        return nmrRekening;
    }

    public void setNmrRekening(String nmrRekening) {
        this.nmrRekening = nmrRekening;
    }

    public String getNmNasabah() {
        return nmNasabah;
    }

    public void setNmNasabah(String nmNasabah) {
        this.nmNasabah = nmNasabah;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getHistori() {
        return histori;
    }

    public void setHistori(String histori) {
        this.histori = histori;
    }
    
    public boolean validasiSaldo(String saldo){
        for(char c: saldo.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nomor Rekening :"+nmrRekening+"\n"
                + "Nama Nasabah :"+nmNasabah+"\n"
                + "bank : "+bank+"\n"
                + "pin : "+pin+"\n"
                + "saldo : "+saldo+"\n";
    }
    
    
}
