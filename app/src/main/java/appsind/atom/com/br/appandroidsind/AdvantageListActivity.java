package appsind.atom.com.br.appandroidsind;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import appsind.atom.com.br.appandroidsind.adapter.AdapterListAdvantages;
import appsind.atom.com.br.appandroidsind.dto.ListAdvantageSync;
import appsind.atom.com.br.appandroidsind.model.Advantages;
import appsind.atom.com.br.appandroidsind.retrofit.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.list;


public class AdvantageListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advantage_list);
        final List list = new ArrayList<Advantages>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AdvantageService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AdvantageService service = retrofit.create(AdvantageService.class);
        Call<ListAdvantageSync> call = new RetrofitInicializador().getAdvantageService().listAdvantages();

        call.enqueue(new Callback<ListAdvantageSync>() {
            @Override
            public void onResponse(Call<ListAdvantageSync> call, Response<ListAdvantageSync> response) {
                ListAdvantageSync alunoSync = response.body();
                ArrayList<Advantages> advantages = new ArrayList<Advantages>();
                listView = (ListView) findViewById(R.id.listAdvantages);

                for (Advantages ad : alunoSync.getAdvantages()) {
                    Log.i("Name: ", String.valueOf(ad.getName()));
                    Log.i("Description: ", String.valueOf(ad.getDescription()));
                    advantages.add(ad);
                }

                AdapterListAdvantages adapter = new AdapterListAdvantages(AdvantageListActivity.this, advantages);

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListAdvantageSync> call, Throwable t) {
                Log.e("onFailure chamado", t.getMessage());
            }
        });
    }
}
