/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXUI;

import DataProcess.StringToData;
import Utils.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

/**
 *
 * @author TheJenos
 */
public class FXUICompiler {

    public void compileJSON(Stage primaryStage, JSONObject jo) {
        if (jo.has("stage")) {
            JSONObject stage = (JSONObject) jo.getJSONObject("stage");
            Set<String> methods = stage.keySet();
            for (String method : methods) {
                try {
                    Class<Stage> stageclass = (Class<Stage>) primaryStage.getClass();
                    StringToData datasource = new StringToData(stage.getString(method));
                    Method method1 = stageclass.getMethod(method, datasource.getClassArray());
                    method1.invoke(primaryStage, datasource.getDataArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
