package tr.gov.teias.monday;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardActivity extends AppCompatActivity {

    private final String AUTHORIZED_USER = "user";
    private final String AUTHORIZED_EMAIL = "email";
    private final String RECEIVED_TOKEN = "token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final TextView tvDashboard = (TextView) findViewById(R.id.tvDashboard);
        final ProgressBar pbLoadingIndicator = (ProgressBar) findViewById(R.id.pbLoadingIndicator);

        final SharedPreferences prefs = getApplicationContext().getSharedPreferences(AUTHORIZED_USER, Context.MODE_PRIVATE);
        pbLoadingIndicator.setVisibility(View.VISIBLE);

        Retrofit builder = new Retrofit.Builder()
                .baseUrl("http://35.192.7.139/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        UserClient userClient = builder.create(UserClient.class);
        Call<Dashboard> call = userClient.getDashboard(prefs.getString(RECEIVED_TOKEN, null));

        call.enqueue(new Callback<Dashboard>() {
            @Override
            public void onResponse(Call<Dashboard> call, Response<Dashboard> response) {
                if(response.body().getSuccess()){
                    pbLoadingIndicator.setVisibility(View.INVISIBLE);
                    List<String> titles = Helper.parseProjects(response.body().getProjects());
                    for(String title: titles){
                        tvDashboard.append(title + "\n\n\n");
                    }
                }
                else {
                    Toast.makeText(DashboardActivity.this,"Dashboard loading failed!", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Dashboard> call, Throwable t) {
                Toast.makeText(DashboardActivity.this,"Network Error!", Toast.LENGTH_LONG).show();
            }
        });


    }
}
