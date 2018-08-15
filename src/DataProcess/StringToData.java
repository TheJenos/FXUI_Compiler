/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProcess;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author TheJenos
 */
public class StringToData {

    public abstract class Process {
        public abstract Object Run(String data);
    }
    
    String DataString[];
    Object Data[];
    Class DataClass[];
    HashMap<String,Process> Processlist = new HashMap<String,Process>();

    public StringToData(String data) {
        this.DataString = data.split(",");
        Data = new Object[DataString.length];
        DataClass = new Class[DataString.length];
        Processlist.put("byte",new Process() {
            @Override
            public Object Run(String data) {
                return Byte.parseByte(data);
            }
        });
        Processlist.put("long",new Process() {
            @Override
            public Object Run(String data) {
                return Long.parseLong(data);
            }
        });
        Processlist.put("double",new Process() {
            @Override
            public Object Run(String data) {
                return Double.parseDouble(data);
            }
        });
        Processlist.put("int",new Process() {
            @Override
            public Object Run(String data) {
                return Integer.parseInt(data);
            }
        });
        Processlist.put("color",new Process() {
            @Override
            public Object Run(String data) {
                return Color.decode(data);
            }
        });
    }

    public void addCustomDataType(String selecor,Process p){
        Processlist.put(selecor.toLowerCase(), p);
    }
    
    public void process() {
        for (int i = 0; i < DataString.length; i++) {
            String string = DataString[i];
            String line[] = string.split("::");
            Data[i] = Processlist.get(line[0]).Run(line[1]);
            DataClass[i] = Data[i].getClass();
        }
    }

    public Object[] getDataArray() {
        return Data;
    }

    public Class[] getClassArray() {
        return DataClass;
    }
}
