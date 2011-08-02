/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmydays.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Administrator
 */
public class Serializer {

    public static boolean serialize(Object obj, String fileName) {
        boolean retVal = false;
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            retVal = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retVal;
    }

    public static Object deserialize(String fileName) {
        Object retObj = null;
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            retObj = ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            retObj = null;
        }

        return retObj;
    }
    
}
