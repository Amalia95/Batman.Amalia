package amalia.pitta.parcial.facitec.edu.pitta.op2final;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    ListView BatmanListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BatmanListView = (ListView) findViewById(R.id.listViewMovie);


        RestAdapter resAdatAdapter = new RestAdapter.Builder().setEndpoint("http://www.omdbapi.com").build();


        BatmanService servicio = resAdatAdapter.create(BatmanService.class);


        servicio.obtenerBatman(new Callback<Result>() {


            @Override
            public void success(Result result, Response response) {
                BatmanAdapter adapter = new BatmanAdapter(result.Search,getApplicationContext());
                BatmanListView.setAdapter(adapter);

            }

            @Override
            public void failure(RetrofitError error) {

                Toast.makeText(getApplicationContext(),
                        error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }


        } );

    }
}