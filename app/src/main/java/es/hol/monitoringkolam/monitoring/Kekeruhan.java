package es.hol.monitoringkolam.monitoring;

import org.json.JSONException;
import org.json.JSONObject;

public class Kekeruhan {
    private String Ntu = "ntu";
    private String Status = "status";

    public String getNtu() {return Ntu;}
    public void setNtu(String ntu) {this.Ntu = ntu;}

    public String getStatus() {return Status;}
    public void setStatus(String status) {this.Status = status;}


   public Kekeruhan(JSONObject obj) {
        try {
            String ntu = obj.getString("ntu");
            String Status = obj.getString("Status");

            this.Ntu = ntu;
            this.Status = Status;

        } catch (JSONException e){
            e.printStackTrace();
        }

    }
}
