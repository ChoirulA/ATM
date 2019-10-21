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
public class ModelTransfer {
    private static String filename = "transfer.atm";
    
    public ModelTransfer(){}
    
    public void simpanObjekTransfer(List<Transfer> trans) throws
            FileNotFoundException, IOException{         
        FileOutputStream fout;         
        fout = new FileOutputStream(filename);         
        ObjectOutputStream oout = new ObjectOutputStream(fout);         
        oout.writeObject(trans);
    }
    
    public List<Transfer> tampilObjekTransfer() throws 
            FileNotFoundException, ClassNotFoundException, IOException{
        ObjectInputStream ois;
        ois = new ObjectInputStream(new FileInputStream(filename));
        return (List<Transfer>) ois.readObject();
    }
    
    public boolean transferFileIsExists(){
        File file = new File("data.atm");
        System.out.println(file.exists());
        return file.exists();
    }
}
