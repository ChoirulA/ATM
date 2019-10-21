/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelompok7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControllerLogin {
    private GUILogin view;
    private List<Atm> atms;
    private ModelAtm atmModel;
    private Atm user;
    
    public ControllerLogin(GUILogin view){ 
        this.view = view;
        atms = new ArrayList<Atm>();
        atmModel = new ModelAtm();
        user = new Atm();
    }
    
    public int cekLogin(String nomorRekening, String pin){
        boolean kondisi = true;
        int hasil=0;
        if(!nomorRekening.isEmpty() && !pin.isEmpty()){
            if(nomorRekening.equalsIgnoreCase("admin") 
                    && pin.equalsIgnoreCase("admin")){
                return hasil = 1;
            }else{
                try {
                    for(Atm data : atmModel.tampilObjekAtm()){
                        if(data.getNmrRekening().equalsIgnoreCase(nomorRekening)
                                && data.getPin().equals(pin)){
                            user = data;
                            kondisi = false;
                        }
                    }
                    if(kondisi){
                          return hasil=2;
                    }else{
                          return hasil=3;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUILogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUILogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hasil;
    }
}
