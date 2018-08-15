/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxui;

import java.util.Set;
import javafx.stage.Stage;

/**
 *
 * @author TheJenos
 */
public class FXUICompiler {
    public void compileJSON(Stage primaryStage,JSONObject jo){
        JSONObject stage = (JSONObject) jo.getJSONObject("Stage");
        Set<String> methods = stage.keySet();
        for (String method : methods) {
            Class<Stage> stageclass = (Class<Stage>) primaryStage.getClass();
            stageclass.getMethod(method, parameterTypes)
        }
    }
}
