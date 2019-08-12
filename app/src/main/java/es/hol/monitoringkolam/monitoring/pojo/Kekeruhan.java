package es.hol.monitoringkolam.monitoring.pojo;

import org.json.JSONException;
import org.json.JSONObject;

public class Kekeruhan {
    private String ntu = "ntu";
    private String status = "status";

    public String getNtu() {return ntu;}
    public void setNtu(String ntu) {this.ntu = ntu;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}


    public Kekeruhan(JSONObject obj) {
        try {
            String ntu = obj.getString("ntu");
            String Status = obj.getString("Status");

            this.ntu = ntu;
            this.status = Status;
        } catch (JSONException e){
            e.printStackTrace();
        }

    }
}
