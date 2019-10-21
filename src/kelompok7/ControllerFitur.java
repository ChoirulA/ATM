/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelompok7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ASUS
 */
public class ControllerFitur {
    private GuiFitur view;
    private GuiTransfer view2;
    private GuiTarik view3;
    private GuiCekSaldo view4;
    private GuiTransaksi view5;
    private Atm user;
    private ModelAtm atmModel;
    private ModelTransfer tModel;
    private List<Transfer> transfer;
    
    public ControllerFitur(GuiFitur view, GuiTransfer view2, GuiTarik view3, GuiCekSaldo view4, GuiTransaksi view5){
        this.view = view;
        this.view2 = view2;
        this.view3 = view3;
        this.view4 = view4;
        this.view5 = view5;
        user = new Atm();
        atmModel = new ModelAtm();
        tModel = new ModelTransfer();
        transfer = new ArrayList<Transfer>();
    }
    
    public Atm getDataUser(String nomorRekening) throws ClassNotFoundException, IOException{
        List<Atm> atms = atmModel.tampilObjekAtm();
        for(Atm data : atms){
            if(data.getNmrRekening().equalsIgnoreCase(nomorRekening)){
                user = data;
            }
        }
        return user;
    }
    
    public void cekTarikTunai(String nomorRekening, String nominal) throws ClassNotFoundException, IOException{
        List<Atm> atms = atmModel.tampilObjekAtm();
        int i = 0;
        for(Atm data : atms){
            if(data.getNmrRekening().equalsIgnoreCase(nomorRekening)){
                data.setSaldo(data.getSaldo()-Integer.parseInt(nominal));
                data.setHistori(data.getHistori()+"Mengambil tunai "
                        + "sebesar Rp."+nominal+"\n\n");
                atms.set(i, data);
                break;
            }
            i++;
        }
        atmModel.simpanObjekAtm(atms);
    }
    
    public void cekTransfer(String nomorRekening, int nominal, 
            String nomorRekeningTujuan, String bankPengirim, 
            String bankPenerima, String namaPengirim, String namaPenerima) 
            throws ClassNotFoundException, IOException{
        List<Atm> atms = atmModel.tampilObjekAtm();
        int hasil = 0;
        if(bankPenerima.equalsIgnoreCase(bankPenerima)){
            hasil = nominal;
        }else{
            hasil = nominal + 5000;
        }
        int i = 0;
        for(Atm data : atms){
            if(data.getNmrRekening().equalsIgnoreCase(nomorRekening)){
                data.setSaldo(data.getSaldo()-nominal);
                data.setHistori(data.getHistori()+"Mentransfer saldo ke "
                        + nomorRekeningTujuan +" dengan nama penerima "
                        + namaPenerima+" sebesar Rp."+hasil+"\n\n");
            }else if(data.getNmrRekening().equalsIgnoreCase(nomorRekeningTujuan)){
                data.setSaldo(data.getSaldo()+nominal);
                data.setHistori(data.getHistori()+"Menerima transfer saldo dari "
                        + nomorRekening +" dengan nama pengirim "
                        + namaPengirim+" sebesar Rp."+nominal+"\n\n");
            }
            i++;
        }
        atmModel.simpanObjekAtm(atms);
        
        if(tModel.transferFileIsExists()){            
            setTransfer(new Transfer(bankPengirim, namaPengirim, bankPenerima, 
                    namaPenerima));
            tModel.simpanObjekTransfer(transfer);
        }else{
            transfer = tModel.tampilObjekTransfer();
            setTransfer(new Transfer(bankPengirim, namaPengirim, bankPenerima, 
                    namaPenerima));
            tModel.simpanObjekTransfer(transfer);
        }
    }
    
    public boolean cekNomorRekening(String nomorRekening) throws ClassNotFoundException, IOException{
        List<Atm> atms = atmModel.tampilObjekAtm();
        for(Atm data : atms){
            if(data.getNmrRekening().equalsIgnoreCase(nomorRekening)){
                return true;
            }
        }
        return false;
    }
    
    public Atm getDataTujuan(String nomorRekening) throws ClassNotFoundException, IOException{
        List<Atm> atms = atmModel.tampilObjekAtm();
        Atm temp = new Atm();
        for(Atm data : atms){
            if(data.getNmrRekening().equalsIgnoreCase(nomorRekening)){
                temp = data;
            }
        }
        Atm hasil = new Atm(temp.getNmrRekening(), temp.getNmNasabah(), temp.getBank(), "", 0);
        return hasil;
    }
    
    private void setTransfer(Transfer transfer){
        this.transfer.add(transfer);
    }

    public boolean isNumber(String nominal){
        for(char a : nominal.toCharArray()){
            if(!Character.isDigit(a)){
               return false; 
            }
        }
        return true;
    }
}
