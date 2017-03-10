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

import appsind.atom.com.br.appandroidsind.model.Advantages;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.list;


public class AdvantageListActivity extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advantage_list);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(AdvantageService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AdvantageService service = retrofit.create(AdvantageService.class);
        Call<List<ListAdvantage>> requestListAdvantage = service.listAdvantages();
        requestListAdvantage.enqueue(new Callback <List<ListAdvantage>>() {
            @Override
            public void onResponse(Call<List<ListAdvantage>> call, Response<List<ListAdvantage>> response) {
                if(!response.isSuccessful()) {
                    Log.i("TAG","Erro: "+response.code());
                } else {
                    List listAdvantage = response.body();
                    ArrayList<Advantages> advs = new ArrayList<Advantages>();
                    String s = response.body().toString(); // criar um array a partir dessa string e depois jogar o array
                    // no ArrayAdapter

                    for (int i=0; i < listAdvantage.size(); i++){
                        Advantages adv = (Advantages) listAdvantage.get(i);

                        adv.getName();
                        adv.getDescription();

                        advs.add(adv);
                    }

                    listView = (ListView) findViewById(R.id.listAdvantages);

                    ArrayAdapter<Advantages> adapter = new ArrayAdapter<Advantages>(AdvantageListActivity.this,
                            android.R.layout.simple_list_item_1, advs);

                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ListAdvantage>> call, Throwable t) {
                Log.e("TAG", "Error"+t.getMessage());
            }
        });
    }
}
