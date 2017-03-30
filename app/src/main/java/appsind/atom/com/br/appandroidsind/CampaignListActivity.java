package appsind.atom.com.br.appandroidsind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import appsind.atom.com.br.appandroidsind.adapter.AdapterListCampaign;
import appsind.atom.com.br.appandroidsind.dto.ListCampaignSync;
import appsind.atom.com.br.appandroidsind.model.Campaigns;
import appsind.atom.com.br.appandroidsind.retrofit.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CampaignListActivity extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_list);
        final List list = new ArrayList<Campaigns>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(CampaignService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CampaignService service = retrofit.create(CampaignService.class);
        Call<ListCampaignSync> call = new RetrofitInicializador().getCampaignService().listCampaign();

        call.enqueue(new Callback<ListCampaignSync>() {
            @Override
            public void onResponse(Call<ListCampaignSync> call, Response<ListCampaignSync> response) {
                ListCampaignSync campSync = response.body();
                ArrayList<Campaigns> camps = new ArrayList<Campaigns>();
                listView = (ListView) findViewById(R.id.listCampaign);

                for (Campaigns camp : campSync.getCampaigns()) {
                    Log.i("Name: ", String.valueOf(camp.getName()));
                    Log.i("Description: ", String.valueOf(camp.getDescription()));
                    camps.add(camp);
                }

                AdapterListCampaign adapter = new AdapterListCampaign(CampaignListActivity.this, camps);

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListCampaignSync> call, Throwable t) {
                Log.e("onFailure chamado", t.getMessage());
            }
        });
    }
}
