/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelompok7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ControllerAdmin {
//    private static String filename = "data.atm";
    private GuiAdmin view;
    private List<Atm> atms;
    private ModelAtm atmModel;
    
    public ControllerAdmin(GuiAdmin view){
        this.view = view;
        atms = new ArrayList<Atm>();
        atmModel = new ModelAtm();
    }

    public List<Atm> getAtms() {
        return atms;
    }

    public void setAtms(Atm atm) {
        this.atms.add(atm);
    }
    
    public void simpanObjekAtm() throws IOException{         
        atmModel.simpanObjekAtm(atms);
    }
    
    public void loadObjekAtm() throws ClassNotFoundException, IOException{
        atms = atmModel.tampilObjekAtm();
    }
    
    public boolean atmIsExists(){
        File file = new File("data.atm");
        System.out.println(file.exists());
        return file.exists();
    }
    
    public boolean isiTunai(String nomorRekening, String nominal) throws ClassNotFoundException, IOException{
        boolean hasil = false;
        atms = atmModel.tampilObjekAtm();
        int i = 0;
        for(Atm data : atms){
            if(data.getNmrRekening().equalsIgnoreCase(nomorRekening)){
                data.setSaldo(data.getSaldo()+Integer.parseInt(nominal));
                data.setHistori(data.getHistori()+"Mengisi Tunai "
                        + "Sebesar Rp "+nominal+"\n\n");
                atms.set(i, data);
                hasil = true;
                break;
            }
            i++;
        }
        atmModel.simpanObjekAtm(atms);
        return hasil;
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
