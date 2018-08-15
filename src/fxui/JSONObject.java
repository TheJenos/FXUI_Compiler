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
public class JSONObject extends org.json.JSONObject {

     public Object getFromPath(String path) {
        String[] split = path.split("\\.");
        org.json.JSONObject current = this;
        for (int i = 0; i < split.length - 1; i++) {
            String string = split[i];
            if (current.has(string) && !(current.get(string) instanceof org.json.JSONObject)) {
                throw new RuntimeException("Path is blocked");
            }
            current = current.getJSONObject(string);
        }
        return (current.has(split[split.length - 1])) ? current.get(split[split.length - 1]) : null;
    }

    public void setToPath(String path, Object obj) {
        String[] split = path.split("\\.");
        org.json.JSONObject current = this;
        for (int i = 0; i < split.length - 1; i++) {
            String string = split[i];
            if (current.has(string) && !(current.get(string) instanceof org.json.JSONObject)) {
                throw new RuntimeException("Path is blocked");
            } else if (!current.has(string)) {
                current.put(string, new org.json.JSONObject());
            }
            current = current.getJSONObject(string);
        }
        current.put(split[split.length - 1], obj);
    }


}
