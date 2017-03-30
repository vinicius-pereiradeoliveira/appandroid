package appsind.atom.com.br.appandroidsind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import appsind.atom.com.br.appandroidsind.adapter.AdapterListNews;
import appsind.atom.com.br.appandroidsind.dto.ListNewSync;
import appsind.atom.com.br.appandroidsind.model.News;
import appsind.atom.com.br.appandroidsind.retrofit.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsListActivity extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        final List list = new ArrayList<News>();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(NewService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CampaignService service = retrofit.create(CampaignService.class);
        Call<ListNewSync> call = new RetrofitInicializador().getNewService().listNews();

        call.enqueue(new Callback<ListNewSync>() {
            @Override
            public void onResponse(Call<ListNewSync> call, Response<ListNewSync> response) {
                ListNewSync newSync = response.body();
                ArrayList<News> advantages = new ArrayList<News>();
                listView = (ListView) findViewById(R.id.listNews);

                for (News nw : newSync.getNews()) {
                    Log.i("Name: ", String.valueOf(nw.getName()));
                    Log.i("Description: ", String.valueOf(nw.getDescription()));
                    advantages.add(nw);
                }

                AdapterListNews adapter = new AdapterListNews(NewsListActivity.this, advantages);

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListNewSync> call, Throwable t) {
                Log.e("onFailure chamado", t.getMessage());
            }
        });
    }
}
