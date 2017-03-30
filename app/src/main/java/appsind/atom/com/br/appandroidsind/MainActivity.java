package appsind.atom.com.br.appandroidsind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getAdvantages(View view) {
        Intent intent = new Intent(this, AdvantageListActivity.class);
        startActivity(intent);
    }

    public void getNews(View view) {
        Intent intent = new Intent(this, NewsListActivity.class);
        startActivity(intent);
    }

    public void getCampaign(View view) {
        Intent intent = new Intent(this, CampaignListActivity.class);
        startActivity(intent);
    }
}
