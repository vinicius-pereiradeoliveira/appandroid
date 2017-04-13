package appsind.atom.com.br.appandroidsind;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    public void getPhone(View view) {

        if (ActivityCompat.checkSelfPermission(InformationActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(InformationActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:05136324838"));
            startActivity(intent);
        }
    }

    public void getMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=Rua Apolinário de Moraes, 950 - Centro, Montenegro-RS"));
        startActivity(intent);
    }

    public void getSociety(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://apirest-sind.herokuapp.com/contract"));// localhost: http://10.99.4.55:8082
        startActivity(intent);
    }
}
