package appsind.atom.com.br.appandroidsind;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

import appsind.atom.com.br.appandroidsind.model.Partner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormPartnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_partner);

        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText cpf = (EditText) findViewById(R.id.editText2);
        final EditText celular = (EditText) findViewById(R.id.editText3);
        final EditText empresa = (EditText) findViewById(R.id.editText4);
        final EditText dt_nascimento = (EditText) findViewById(R.id.editText5);
        final EditText password = (EditText) findViewById(R.id.editText6);

        Button createPartnerButton = (Button) findViewById(R.id.button7);
        createPartnerButton.setOnClickListener((view) -> {
            Partner partner = new Partner(
                    name.getText().toString(),
                    cpf.getText().toString(),
                    celular.getText().toString(),
                    empresa.getText().toString(),
                    dt_nascimento.getText().toString(),
                    password.getText().toString()
            );

            sendNetworkPostRequest(partner);
        });

    }

    private void sendNetworkPostRequest(Partner partner) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://162.243.245.197:8082/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        PartnerService partnerService = retrofit.create(PartnerService.class);
        Call<Partner> call = partnerService.createPartner(partner);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Context context = getApplicationContext();
                CharSequence text = "Ocorreu um erro de acesso com a internet ou servidor! Tente novamente mais tarde!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        Intent intent = new Intent(this, MainActivity.class);

        Context context = getApplicationContext();
        CharSequence text = "Voce agora faz parte dos associados do Sindicato!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        startActivity(intent);
    }


}
