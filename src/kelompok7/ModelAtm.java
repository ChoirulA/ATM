/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelompok7;

import java.io.*;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ModelAtm {
    private static String filename = "data.atm";
    
    public ModelAtm(){}
    
    public void simpanObjekAtm(List<Atm> atms) throws FileNotFoundException, IOException{         
        FileOutputStream fout;         
        fout = new FileOutputStream(filename);         
        ObjectOutputStream oout = new ObjectOutputStream(fout);         
        oout.writeObject(atms);         
    }
    
    public List<Atm> tampilObjekAtm() throws FileNotFoundException, ClassNotFoundException, IOException{
        ObjectInputStream ois;
        ois = new ObjectInputStream(new FileInputStream(filename));
        return (List<Atm>) ois.readObject();
    }
    
    public void simpanAtm(List<Atm> atms, String filename) throws FileNotFoundException, IOException{         
        FileOutputStream fout;         
        fout = new FileOutputStream(filename);         
        ObjectOutputStream oout = new ObjectOutputStream(fout);         
        oout.writeObject(atms);         
    }
    
    public List<Atm> tampilAtm(String filename) throws FileNotFoundException, ClassNotFoundException, IOException{
        ObjectInputStream ois;
        ois = new ObjectInputStream(new FileInputStream(filename));
        return (List<Atm>) ois.readObject();
    }
}
