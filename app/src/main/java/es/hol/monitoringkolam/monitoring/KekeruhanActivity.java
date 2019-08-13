package es.hol.monitoringkolam.monitoring;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class KekeruhanActivity extends AppCompatActivity {
    @BindView(R.id.NTUset)
    RecyclerView NTUset;
    KekeruhanAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private static final String URL = "http://monitoringkolam.hol.es/get_kekeruhan.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kekeruhan);
        ButterKnife.bind(this);
        adapter = new KekeruhanAdapter(this);
        String url = "http://monitoringkolam.hol.es/get_kekeruhan.php";
        DemoAsync demoAsync = new DemoAsync();
        demoAsync.execute(url);
    }
    @SuppressLint("StaticFieldLeak")
    public class DemoAsync extends AsyncTask<String, Void, ArrayList<Kekeruhan>>{
        @Override
        protected ArrayList<Kekeruhan> doInBackground(String... strings) {
            String uri = strings[0];
            final ArrayList<Kekeruhan> kekeruhans = new ArrayList<>();
            SyncHttpClient client = new SyncHttpClient();

            client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
            client.get(uri, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        String hasil = new String(responseBody);
                        JSONObject jsonData = new JSONObject(hasil);
                        JSONArray jsonArray = jsonData.getJSONArray("Data");
                        for (int i = 0; i < jsonArray.length(); i++){
                            JSONObject kekeruhanObj = jsonArray.getJSONObject(i);
                            Kekeruhan kekeruhan = new Kekeruhan(kekeruhanObj);

                            kekeruhans.add(kekeruhan);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Log.d("Tag", "onFailure: " + statusCode);
                }
            });
            return kekeruhans;
        }

        @Override
        protected void onPostExecute (ArrayList<Kekeruhan> kekeruhan){
            super.onPostExecute(kekeruhan);
            NTUset.setLayoutManager(new LinearLayoutManager(KekeruhanActivity.this));
            adapter.setListkekeruhan(kekeruhan);
            NTUset.setAdapter(adapter);
        }
    }
}
