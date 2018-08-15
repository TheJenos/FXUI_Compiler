/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxui;

/**
 *
 * @author TheJenos
 */
public class DataTypes {

    String Datalist;
    String Data[];

    public DataTypes(String data) {
        this.Datalist = data;
        this.Data = data.split(",");
    }

}
