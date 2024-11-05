package fr.caensup.licsts.sites;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvVilles;
    private Button btnClock;
    private TextView tvClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Recup du ListView
        lvVilles = findViewById( R.id.lvSites );


        // Creation du Modèle d'objets
        List<Ville> lesVilles =
                CsvReader.chargerVilles( this , "villes.csv");

        // Creation de l'adapter qui connait le context et le modèle
        VilleAdapter villeAdapter = new VilleAdapter( this );
        villeAdapter.setModele( lesVilles );

        // Liason entre l'adapter et le listview
        lvVilles.setAdapter( villeAdapter );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnClock = findViewById(R.id.btnClock);
        tvClock = findViewById(R.id.tvClock);
        btnClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while( true ) {
                            try {
                                Thread.sleep(1000);
                                tvClock.setText( new Date().toString());
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }).start();
            }
        });


    }
}