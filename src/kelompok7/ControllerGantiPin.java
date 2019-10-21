/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelompok7;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class ControllerGantiPin {
    private GuiGantiPin view;
    private Atm user;
    private ModelAtm atmModel;
    private List<Atm> atms;
    
    public ControllerGantiPin(GuiGantiPin view){
        this.view = view;
        user = new Atm();
        atmModel = new ModelAtm();
        atms = new ArrayList<Atm>();
    }
    
    public boolean ubahPin(String pinLm, String pinBr, String nmrRekening) throws ClassNotFoundException, IOException{
        boolean hsl = false;
        atms = atmModel.tampilObjekAtm();
        int i = 0;
        for(Atm data : atms){
            if(data.getNmrRekening().equalsIgnoreCase(nmrRekening)&&data.getPin().equals(pinLm)){
                data.setPin(pinBr);
                atms.set(i, data);
                hsl = true;
                break;
            }
            i++;
        }
        atmModel.simpanObjekAtm(atms);
        return hsl;
    }
}
